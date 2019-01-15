/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
      
package frc.robot.subsystems
import edu.wpi.first.wpilibj.Spark
import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.command.Subsystem
import frc.robot.RobotMap    
/**
 * Add your docs here.
 */
class HatchPanelSubsystem: Subsystem() {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  val HatchArm = Spark(RobotMap.hatchMotorPort)
  private val HatchPanelSolenoid = DoubleSolenoid (RobotMap.hatchpanelport1, RobotMap.hatchpanelport2)
  
  override fun initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  fun extendpistons  () = this.HatchPanelSolenoid.set(DoubleSolenoid.Value.kForward)
  fun retractpistons () = this.HatchPanelSolenoid.set(DoubleSolenoid.Value.kReverse)
  
  fun stoppistions() = this.HatchPanelSolenoid.set(DoubleSolenoid.Value.kOff)
  
}
