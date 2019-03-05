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
class TeleopCommand : Command() {
  var cargoLiftState = "hold"; 
  init {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_driveTrainSubsystem)
  }

  // Called just before this Command runs the first time
  override fun initialize() {}

  // Called repeatedly when this Command is scheduled to run
  override fun execute() {
    // Drive based on joystick input
    // Robot.m_driveTrainSubsystem.tankDrive(Robot.m_oi?.leftJoystick?.getY()!!.toDouble(), Robot.m_oi?.rightJoystick?.getY()!!.toDouble())
    if (Robot.robotDirectionInverted) {
      Robot.m_driveTrainSubsystem.tankDrive(Robot.m_oi?.rightJoystick?.getY()!!.toDouble(), Robot.m_oi?.leftJoystick?.getY()!!.toDouble());
    }
    else {
      Robot.m_driveTrainSubsystem.tankDrive(-1 * Robot.m_oi?.leftJoystick?.getY()!!.toDouble(), -1 * Robot.m_oi?.rightJoystick?.getY()!!.toDouble());
    }
    Robot.m_hatchPanelSubsystem.HatchArm.set(-1 * (Robot.m_oi?.manipulatorJoystick?.getY()!!.toDouble()/2))
    if (Robot.m_oi?.intakeJoystick?.getY()!! > 0.05) {
      cargoLiftState = "hold"
     // println("Hold!!")
    } else if(Robot.m_oi?.intakeJoystick?.getY()!! < -0.05) {
      cargoLiftState = "free"
     // println("Free!")
    }
    if (cargoLiftState == "free") {
      Robot.m_intakeSubsystem.IntakeHinge.set(Robot.m_oi?.intakeJoystick?.getY()!!.toDouble() / 4)
    }  else {
      var motSpeed = maxOf(Robot.m_oi?.intakeJoystick?.getY()!!.toDouble()/2, 0.3)
     // println(motSpeed)
      Robot.m_intakeSubsystem.IntakeHinge.set(motSpeed)
    }
    
    // if (Robot.m_oi?.manipulatorJoystick!!.getRawButton(RobotMap.ejectorButton)) {
    //   println("Start Button!")
    //   EjectHatchPanel().start()
    // }
  }

  // Make this return true when this Command no longer needs to run execute()
  override fun isFinished(): Boolean {
    return false
  }

  // Called once after isFinished returns true
  override fun end() {}

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  override fun interrupted() {}
}
