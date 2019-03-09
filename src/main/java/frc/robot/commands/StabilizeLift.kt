/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands

import edu.wpi.first.wpilibj.command.Command
import frc.robot.Robot

/**
 * An example command. You can replace me with your own command.
 */
class StabilizeLift: Command() {
  var thepitch = 0.0f;
  var count = 0;
  init {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_sensorSubsystem)
    requires(Robot.m_liftRobotSubsystem)
  }

  // Called just before this Command runs the first time
  override fun initialize () {
    println("Start stabilize lift")
    thepitch = 0f;//Robot.m_sensorSubsystem.navXMicro.pitch
    Robot.m_liftRobotSubsystem.extendFrontPistons()
    Robot.m_liftRobotSubsystem.extendBackPistons()
    count = 0
  }

  // Called repeatedly when this Command is scheduled to run
  override fun execute () {
    thepitch = 0f;//Robot.m_sensorSubsystem.navXMicro.pitch
    println(thepitch)
    if (thepitch > 5) {
      Robot.m_liftRobotSubsystem.stopBackPistons()
      print('.')
    }
    else if (thepitch < 0) {
      print('+')
      Robot.m_liftRobotSubsystem.stopFrontPistons()
    }
    else {
      Robot.m_liftRobotSubsystem.extendFrontPistons()
      Robot.m_liftRobotSubsystem.extendBackPistons()
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  override fun isFinished (): Boolean {
    // count++
    // return (thepitch < -2)
    // return (count >= 5)
    return false
  }

  // Called once after isFinished returns true
  override fun end () {
   // Robot.m_liftRobotSubsystem.extendBackPistons()
   // Robot.m_liftRobotSubsystem.extendFrontPistons()
   println("End stabilize lift")
    Robot.m_liftRobotSubsystem.stopFrontPistons()
    Robot.m_liftRobotSubsystem.stopBackPistons()
    
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  override fun interrupted () {
    end()
  }
}
