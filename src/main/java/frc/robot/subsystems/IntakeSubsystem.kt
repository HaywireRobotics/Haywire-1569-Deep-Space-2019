/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
      
package frc.robot.subsystems
import frc.robot.RobotMap
import edu.wpi.first.wpilibj.Spark
import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.command.Subsystem
      
/**
 * Add your docs here.
 */
class IntakeSubsystem: Subsystem() {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  val LeftIntake = Spark(RobotMap.leftIntakePort)
  val RightIntake = Spark(RobotMap.rightIntakePort)

  val IntakeHinge = Spark(RobotMap.intakeLiftMotor)

  val piston: DoubleSolenoid = DoubleSolenoid(RobotMap.intakePort1, RobotMap.intakePort2)
      
  override fun initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    
  }

  fun expandPiston() = piston.set(DoubleSolenoid.Value.kForward)

  fun contractPiston() = piston.set(DoubleSolenoid.Value.kReverse)
}
