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
class StabilizeLiftV2: Command() {
  var theyaw = 0.0f
  var startyaw = 0.0f
  val upperGuard = 2.0f
  val lowerGuard = 2.0f
  var count = 0
  var state = 0
  var hystAngle = 0
  init {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_sensorSubsystem)
    requires(Robot.m_liftRobotSubsystem)
  }

  // Called just before this Command runs the first time
  override fun initialize () {
    println("Start stabilize lift")
    theyaw = Robot.m_sensorSubsystem.navXMXP.yaw
    startyaw = theyaw
    Robot.m_liftRobotSubsystem.extendFrontPistons()
    Robot.m_liftRobotSubsystem.extendBackPistons()
    count = 0
  }

  // Called repeatedly when this Command is scheduled to run
  override fun execute () {
    if (state % 4 == 0 || state % 4 == 1) {
      theyaw = Robot.m_sensorSubsystem.navXMXP.yaw
      println(theyaw)
      if (theyaw > (startyaw + upperGuard - hystAngle)) {
        Robot.m_liftRobotSubsystem.extendFrontPistons()
        Robot.m_liftRobotSubsystem.stopBackPistons()
        print('.')
        hystAngle = 2
      }
      else if (theyaw < (startyaw - lowerGuard + hystAngle)) {
        print('+')
        Robot.m_liftRobotSubsystem.extendBackPistons()
        Robot.m_liftRobotSubsystem.stopFrontPistons()
        hystAngle = 2
      }
      else {
        Robot.m_liftRobotSubsystem.extendFrontPistons()
        Robot.m_liftRobotSubsystem.extendBackPistons()
        hystAngle = 0
      }
    } else {
      Robot.m_liftRobotSubsystem.stopBackPistons()
      Robot.m_liftRobotSubsystem.stopFrontPistons()
    }
    state = state + 1
  }

  // Make this return true when this Command no longer needs to run execute()
  override fun isFinished (): Boolean {
    // count++
    // return (theyaw < -2)
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
