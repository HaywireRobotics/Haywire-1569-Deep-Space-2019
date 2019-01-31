/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems
import edu.wpi.first.wpilibj.Spark
import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.Compressor
import edu.wpi.first.wpilibj.command.Subsystem
import frc.robot.RobotMap
/**
 * Add your docs here.
 */
class HatchPanelSubsystem : Subsystem() {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  var hatchArm = Spark(RobotMap.hatchMotorPort)
  private val hatchPanelSolenoid = DoubleSolenoid(RobotMap.hatchPanelPort1, RobotMap.hatchPanelPort2)

  val compressor: Compressor = Compressor()

  override fun initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  fun extendPistons  () = this.hatchPanelSolenoid.set(DoubleSolenoid.Value.kForward)
  fun retractPistons () = this.hatchPanelSolenoid.set(DoubleSolenoid.Value.kReverse)
  
  fun stopPistons() = this.hatchPanelSolenoid.set(DoubleSolenoid.Value.kOff)

  fun setHatchArm(speed: Double) = this.hatchArm.set(speed)
  
}
