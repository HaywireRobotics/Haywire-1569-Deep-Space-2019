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
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX

import frc.robot.commands.TeleopCommand
import frc.robot.RobotMap
/**
 * Add your docs here.
 */
class DriveTrainSubsystem : Subsystem() {
  // Left drive train motors
  private val leftFront: WPI_VictorSPX = WPI_VictorSPX(RobotMap.driveTrainLeftFront)
  private val leftRear: WPI_VictorSPX = WPI_VictorSPX(RobotMap.driveTrainLeftRear)

  // Right drive train motors
  private val rightFront: WPI_VictorSPX = WPI_VictorSPX(RobotMap.driveTrainRightFront)
  private val rightRear: WPI_VictorSPX = WPI_VictorSPX(RobotMap.driveTrainRightRear)

  private val driveleftgroup = SpeedControllerGroup(leftFront, leftRear)
  private val driverightgroup = SpeedControllerGroup(rightFront, rightRear)

  private val myRobot = DifferentialDrive(driveleftgroup, driverightgroup)
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  override fun initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(TeleopCommand())
  }

  fun tankDrive(leftPower: Double, rightPower: Double) = myRobot.tankDrive(leftPower, rightPower, false)
}
