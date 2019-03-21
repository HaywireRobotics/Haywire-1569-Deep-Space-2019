package frc.robot.raspiserver

/*
Distance Command = d {id} {value in mm}
Angle Command = a {angle in degrees}
 */

class Commands {
    companion object {
        val commands: List<ICommand> = listOf<ICommand>(Quit())
    }

    class Distance: ICommand() {
        override val helpMessage: String = "Send distance to the server."
        override val commandString: String = "d"
        override val commandArgs: String = "{id} {distance in mm}"
        override fun run(args: List<String>): CommandResponse = CommandResponse("NuLl", false)
    }

    class Angle: ICommand() {
        override val helpMessage: String = "Send an angle to track"
        override val commandString: String = "a"
        override val commandArgs: String = "{angle in degrees}"
        override fun run(args: List<String>): CommandResponse = CommandResponse("NuLl", false)
    }

    class Quit: ICommand() {
        override val helpMessage: String = "Safely disconnect from the server."
        override val commandString: String = "quit"
        override fun run(args: List<String>): CommandResponse = CommandResponse("NuLl", true)
    }

    class Help: ICommand() {
        override val helpMessage: String = "Shows this message."
        override val commandString: String = "help"
        override fun run(args: List<String>): CommandResponse {
            var response: String = ""
            for (obj in Commands.commands) {
                response += "${obj.commandString} ${obj.commandArgs}|| ${obj.helpMessage}\n"
            }
            return CommandResponse(response, false)
        }
    }
}

class CommandResponse(val responseString: String, val breakBool: Boolean)

open class ICommand {
    open val helpMessage: String = "null"
    open val commandString: String = "null"
    open val commandArgs: String = ""
    // Run function must return a CommandResponse object. "NuLl" is preferred as the responseString for no special action by client loop.
    open fun run(args: List<String>): CommandResponse = CommandResponse("NuLl", false)
}
