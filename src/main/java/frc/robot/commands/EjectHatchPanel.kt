/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands

import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.Timer
import frc.robot.Robot

/**
 * An example command. You can replace me with your own command.
 */
class EjectHatchPanel : Command() {
  init {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_hatchPanelSubsystem)
    
  }
  private val time: Timer = Timer()

  // Called just before this Command runs the first time
  override fun initialize() {
    this.time.reset()
    this.time.start()
  }

  // Called repeatedly when this Command is scheduled to run
  override fun execute () {
    when (this.time.get() > (1.0)) {  
      true -> Robot.m_hatchPanelSubsystem.retractPistons()
      false -> Robot.m_hatchPanelSubsystem.extendPistons()
    
    }
  }

  // Make this return true when this Command no longer needs to run execute()

  override fun isFinished(): Boolean {
    return this.time.hasPeriodPassed(1.1)
  }

  // Called once after isFinished returns true
  override fun end() {
    println("Hatch Released!")
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  override fun interrupted() {}
}
