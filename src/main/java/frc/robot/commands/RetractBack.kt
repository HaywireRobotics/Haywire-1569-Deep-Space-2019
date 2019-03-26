/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands

import edu.wpi.first.wpilibj.command.InstantCommand
import frc.robot.Robot

/**
 * Add your docs here.
 */
class RetractBack() : InstantCommand() {
    /**
     * Add your docs here.
     */
    init {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.m_liftRobotSubsystem)
    }
   
    // Called once when the command executes
    override fun initialize() {
        Robot.m_liftRobotSubsystem.retractBackPistons()
    }

    // Make this return true when this Command no longer needs to run execute()
  override fun isFinished (): Boolean {
    return false
  }
     // Called once after isFinished returns true
  override fun end () {
   Robot.m_liftRobotSubsystem.stopBackPistons()
   //Robot.m_liftRobotSubsystem.stopFrontPistons()
   Robot.climbing = false
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  override fun interrupted() = end()
}

