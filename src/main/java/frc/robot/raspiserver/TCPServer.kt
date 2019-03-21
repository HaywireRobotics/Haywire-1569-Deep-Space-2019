package frc.robot.raspiserver


import java.net.*
import java.io.*
import java.nio.charset.Charset

class TCPServer(val port: Int) : Thread(){
    private lateinit var serverSocket: ServerSocket

    override fun run() = loop(port)

    fun loop(port: Int) {
        try {
            serverSocket = ServerSocket(port)
            while (true) {
                println("Connecting to client")
                ClientHandler(serverSocket.accept()).start()
                println("Connected")
            }

        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            stopTheServer()
        }
    }

    fun stopTheServer() {
        try {
            serverSocket.close()
        } catch(e: IOException) {
            e.printStackTrace()
        }
    }
}

class ClientHandler(val clientSocket: Socket) : Thread() {
    lateinit var outReader: PrintWriter
    lateinit var inR: InputStreamReader
    lateinit var inReader: CustomReader

    override fun run() {
        try {
            // Setting up socket reading and writing
            this.outReader = PrintWriter(clientSocket.getOutputStream(), true)
            this.inReader = CustomReader(InputStreamReader(clientSocket.getInputStream()))
            var inputLine: String
            var response: String

            // Connection loop
            whileLoop@ while (true) {
                inputLine = this.inReader.read()
                response = ""
                forLoop@for (command in Commands.commands) {
                    var splitInput: List<String> = inputLine.split(" ")
                    if (splitInput[0] == command.commandString) {
                        println(command.commandString)
                        val commandResponse: CommandResponse = command.run(splitInput.drop(1))
                        if (commandResponse.responseString != "NuLl") {
                            response = commandResponse.responseString
                        }
                        if (commandResponse.breakBool) {
                            break@whileLoop
                        }
                        break@forLoop
                    }
                }
                this.outReader.println(response)
            }

            this.outReader.println(response)

            this.inReader.close()
            this.outReader.close()
            clientSocket.close()
            println("Closed client connection")

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}

class CustomReader(val reader: InputStreamReader) {
    val UTF8_CHARSET: Charset = Charset.forName("UTF-8");

    fun read(): String {
        var theArray: MutableList<Byte> = arrayListOf()

        // Waiting for the client to send data
        while (!reader.ready()) {}

        // Add the client's data to a MutableList to provide for differences in buffer size
        while (reader.ready()) {
            theArray.add(reader.read().toByte())
        }

        // Convert the MutableList to a decodable ByteArray
        var theByteArray: ByteArray = ByteArray(theArray.size)
        for (i in 0..(theArray.size-1)) {
            theByteArray[i] = theArray[i]
        }
        return decodeUTF8(theByteArray)
    }

    fun close() = reader.close()

    fun decodeUTF8(bytes: ByteArray) = String(bytes, UTF8_CHARSET);
}
