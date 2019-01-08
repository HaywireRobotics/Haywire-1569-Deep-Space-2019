/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
      
package frc.robot.subsystems
      
import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.*
import edu.wpi.first.wpilibj.drive.DifferentialDrive
      
import frc.robot.RobotMap
/**
 * Add your docs here.
 */
class DriveTrainSubsystem: Subsystem() {
  val frontLeft: PWMVictorSPX = PWMVictorSPX(RobotMap.driveTrainLeftFront)
  val frontRight: PWMVictorSPX = PWMVictorSPX(RobotMap.driveTrainRightFront)
  val backLeft: PWMVictorSPX = PWMVictorSPX(RobotMap.driveTrainLeftBack)
  val backRight: PWMVictorSPX = PWMVictorSPX(RobotMap.driveTrainRightBack)

  private val driveleftgroup = SpeedControllerGroup(frontLeft, backLeft)
  private val driverightgroup = SpeedControllerGroup(frontRight, backRight)
  
  val myrobot = DifferentialDrive(driveleftgroup, driverightgroup)
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
      
  override fun initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
