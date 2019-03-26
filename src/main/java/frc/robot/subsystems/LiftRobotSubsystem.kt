/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems
import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.Solenoid
import edu.wpi.first.wpilibj.Compressor
import edu.wpi.first.wpilibj.PWMVictorSPX
import edu.wpi.first.wpilibj.command.Subsystem
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX
import frc.robot.RobotMap
/**
 * Add your docs here.
 */
class LiftRobotSubsystem : Subsystem() {
  // Put methods for controlling this subsystem
  // here. Call these from Commands
  val FrontLiftSolenoid = DoubleSolenoid(RobotMap.liftRobotPort1, RobotMap.liftRobotPort2)
  val BackLiftSolenoid = DoubleSolenoid(RobotMap.liftRobotPort3, RobotMap.liftRobotPort4)

  var johnsonMotor: WPI_VictorSPX = WPI_VictorSPX (RobotMap.johnsonMotorPort)
  var stringMotor: WPI_VictorSPX = WPI_VictorSPX(RobotMap.stringMotorPort )

  override fun initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  
  // Front Pistons Functions
  fun extendFrontPistons  () = this.FrontLiftSolenoid.set(DoubleSolenoid.Value.kForward)

  fun retractFrontPistons () = this.FrontLiftSolenoid.set(DoubleSolenoid.Value.kReverse)
  
  fun stopFrontPistons() = this.FrontLiftSolenoid.set(DoubleSolenoid.Value.kOff)

  // Back Pistons Functions
  fun extendBackPistons  () = this.BackLiftSolenoid.set(DoubleSolenoid.Value.kForward)

  fun retractBackPistons () = this.BackLiftSolenoid.set(DoubleSolenoid.Value.kReverse)
  
  fun stopBackPistons() = this.BackLiftSolenoid.set(DoubleSolenoid.Value.kOff)
}
