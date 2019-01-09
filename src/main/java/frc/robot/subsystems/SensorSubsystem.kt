package frc.robot.subsystems

import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.Encoder
import edu.wpi.first.wpilibj.SerialPort
import com.kauailabs.navx.frc.*

/**
 *
 */
class SensorSubsystem: Subsystem() {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  // Left: encoder1
  // Right: encoder2
  val encoder1: Encoder = Encoder(0, 1)
  val encoder2: Encoder = Encoder(8, 9)
  val navXMicroBoard: AHRS = AHRS(SerialPort.Port.kUSB)

  override fun initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}