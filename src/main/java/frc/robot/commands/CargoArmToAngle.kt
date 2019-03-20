/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands

import kotlin.comparisons.minOf
import kotlin.math.abs

import edu.wpi.first.wpilibj.command.Command
import frc.robot.Robot

/**
 * An example command. You can replace me with your own command.
 */
class CargoArmToAngle(val targetAngle: Int): Command() {
  init {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_intakeSubsystem)
    requires(Robot.m_sensorSubsystem)
  }
  val maxArmPower: Double = 0.4
  var robotPower: Double = 0.0

  // Called just before this Command runs the first time
  override fun initialize () {}

  // Called repeatedly when this Command is scheduled to run
  override fun execute () {
    // println(Robot.m_sensorSubsystem.cargoNavX.pitch)
    robotPower = 0.0
    if (Robot.m_sensorSubsystem.cargoNavX.pitch < targetAngle) {
      robotPower = -minOf(maxArmPower, (abs(Robot.m_sensorSubsystem.cargoNavX.pitch - targetAngle)/10).toDouble())
      // Robot.m_intakeSubsystem.IntakeHinge.set(-minOf(maxArmPower, (abs(Robot.m_sensorSubsystem.cargoNavX.pitch - targetAngle)/10).toDouble()))
    } else if (Robot.m_sensorSubsystem.cargoNavX.pitch > targetAngle) {
      // robotPower = minOf(maxArmPower, (abs(Robot.m_sensorSubsystem.cargoNavX.pitch - targetAngle)/10).toDouble())
      // Robot.m_intakeSubsystem.IntakeHinge.set(minOf(maxArmPower, (abs(Robot.m_sensorSubsystem.cargoNavX.pitch - targetAngle)/10).toDouble()))
      robotPower = 0.0
    } else {
      // Robot.m_intakeSubsystem.IntakeHinge.set(0.0)
      robotPower = 0.0
    }
    println(robotPower)
    Robot.m_intakeSubsystem.IntakeHinge.set(robotPower)
    println("Executed")
  }

  // Make this return true when this Command no longer needs to run execute()
  override fun isFinished (): Boolean {
    return false
  }

  // Called once after isFinished returns true
  override fun end () {}

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  override fun interrupted () {}
}
