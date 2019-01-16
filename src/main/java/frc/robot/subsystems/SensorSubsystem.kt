package frc.robot.subsystems

import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.cscore.UsbCamera
import edu.wpi.first.wpilibj.Encoder
import edu.wpi.first.wpilibj.CameraServer
import edu.wpi.first.wpilibj.SerialPort
import edu.wpi.first.wpilibj.AnalogInput
import com.kauailabs.navx.frc.AHRS

import frc.robot.RobotMap

/**
 *
 */
class SensorSubsystem : Subsystem() {
  val leftEncoder: Encoder = Encoder(RobotMap.leftEncoderPort1, RobotMap.leftEncoderPort2)
  val rightEncoder: Encoder = Encoder(RobotMap.rightEncoderPort1, RobotMap.rightEncoderPort2)

  val navXMicro: AHRS = AHRS(SerialPort.Port.kUSB)

  val lineSensor: AnalogInput = AnalogInput(RobotMap.lineSensorPort)
  val lineSensorThreshold: Int = 1000

  // private val wideAngleCamera: UsbCamera

  init {
    // this.wideAngleCamera = CameraServer.getInstance().startAutomaticCapture()
    // this.wideAngleCamera.setResolution(480, 360)
    // this.wideAngleCamera.setFPS(60)
    // this.wideAngleCamera.setExposureAuto()
  }

  fun lineSensorActive(): Boolean = (lineSensor.value > lineSensorThreshold)

  override fun initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}