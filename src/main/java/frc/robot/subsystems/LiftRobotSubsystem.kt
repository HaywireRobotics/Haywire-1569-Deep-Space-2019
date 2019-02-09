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
import frc.robot.RobotMap
/**
 * Add your docs here.
 */
class LiftRobotSubsystem : Subsystem() {
  // Put methods for controlling this subsystem
  // here. Call these from Commands
  private val FrontLiftSolenoid = DoubleSolenoid(RobotMap.liftRobotPort1, RobotMap.liftRobotPort2)
  val BackLiftSolenoid = DoubleSolenoid(RobotMap.liftRobotPort3, RobotMap.liftRobotPort4)

  // private val BackLiftSolenoid1 = Solenoid(RobotMap.liftRobotPort3)
  // private val BackLiftSolenoid2 = Solenoid(RobotMap.liftRobotPort4)

  var stringMotor: PWMVictorSPX = PWMVictorSPX (RobotMap.stringMotorPort)

  //val compressor: Compressor = Compressor()

  override fun initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  fun extendFrontPistons  () = this.FrontLiftSolenoid.set(DoubleSolenoid.Value.kForward)
  fun retractFrontPistons () = this.FrontLiftSolenoid.set(DoubleSolenoid.Value.kReverse)
  
  fun stopFrontPistons() = this.FrontLiftSolenoid.set(DoubleSolenoid.Value.kOff)

  fun extendBackPistons  () = this.BackLiftSolenoid.set(DoubleSolenoid.Value.kForward)
  fun retractBackPistons () = this.BackLiftSolenoid.set(DoubleSolenoid.Value.kReverse)
  // fun extendBackPistons() {
  //   this.BackLiftSolenoid1.set(true);
  //   this.BackLiftSolenoid2.set(true);
  // }

  // fun retractBackPistons() {
  //   this.BackLiftSolenoid1.set(false);
  //   this.BackLiftSolenoid2.set(false);
  // }
  
  fun stopBackPistons() = this.BackLiftSolenoid.set(DoubleSolenoid.Value.kOff)

  // fun stopBackPistons() {

  // }

  //fun extendAllPistons  () = this.BackLiftSolenoid.set(DoubleSolenoid.Value.kForward)
  //fun retractAllPistons () = this.BackLiftSolenoid.set(DoubleSolenoid.Value.kReverse)
  
  //fun stopAllPistons() = this.BackLiftSolenoid.set(DoubleSolenoid.Value.kOff)
  
}
