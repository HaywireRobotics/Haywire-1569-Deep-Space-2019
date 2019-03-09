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
  var theRoll = 0.0f
  var startRoll = 0.0f
  val upperGuard = 4.0f
  val lowerGuard = 4.0f
  var count = 0
  var state = 0
  var hystAngle = 0.0f
  var pulseDur = 12
  init {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_sensorSubsystem)
    requires(Robot.m_liftRobotSubsystem)
  }

  // Called just before this Command runs the first time
  override fun initialize () {
    println("Start stabilize lift")
    //Robot.m_sensorSubsystem.navXMXP.zeroYaw()

    theRoll = Robot.m_sensorSubsystem.navXMXP.roll
    startRoll = theRoll
    println("Roll: " + theRoll)
    theRoll = Robot.m_sensorSubsystem.navXMXP.roll
    startRoll = theRoll //+ 0.5f
   // println("UC: " + Robot.m_sensorSubsystem.navXMXP.requestedUpdateRate)
  pulseDur = 50
  hystAngle = 0f
 //   Robot.m_liftRobotSubsystem.extendFrontPistons()
 //   Robot.m_liftRobotSubsystem.extendBackPistons()
    count = 0
  }

  // Called repeatedly when this Command is scheduled to run
  override fun execute () {
    if (state % 4 < pulseDur) {
      theRoll = Robot.m_sensorSubsystem.navXMXP.roll
      println(theRoll)
      if (theRoll > (startRoll + upperGuard - hystAngle)) {
        Robot.m_liftRobotSubsystem.extendBackPistons()
        Robot.m_liftRobotSubsystem.stopFrontPistons()
        print('.')
        hystAngle = 1f
        pulseDur=4
      }
      else if (theRoll < (startRoll - lowerGuard + hystAngle)) {
        print('+')
        Robot.m_liftRobotSubsystem.extendFrontPistons()
        Robot.m_liftRobotSubsystem.stopBackPistons()
        hystAngle = 1f
        pulseDur = 4
      }
      else {
        Robot.m_liftRobotSubsystem.extendFrontPistons()
        Robot.m_liftRobotSubsystem.extendBackPistons()
        if (pulseDur != 30) {
        //  pulseDur = 10
        }
          
        hystAngle = 0f
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
    // return (theRoll < -2)
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
