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
  var cargoLiftState = "hold"
  var holdAngle = -90f
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
      holdAngle = Robot.m_sensorSubsystem.cargoNavX.pitch
     // println("Hold!!")
    } else if(Robot.m_oi?.intakeJoystick?.getY()!! < -0.05) {
      cargoLiftState = "free"
     // println("Free!")
    }
    if (cargoLiftState == "free") {
      var joyInput =  Robot.m_oi?.intakeJoystick?.getY()!!.toDouble()
      if (Robot.m_sensorSubsystem.cargoNavX.pitch > 20 && joyInput < -0.2) {
        joyInput = -0.2
      }
      Robot.m_intakeSubsystem.IntakeHinge.set(joyInput / 4.0)
    }  else {
      var holdDrive = 0.3
      if (holdAngle < -50f) {
        holdDrive = 0.15
      }
      var joySpeed = Robot.m_oi?.intakeJoystick?.getY()!!.toDouble()/2
      if (Robot.m_sensorSubsystem.cargoNavX.pitch < -85) {
        joySpeed = maxOf(joySpeed, 0.2)
      }
      var motSpeed = maxOf(joySpeed, holdDrive)
     // println(motSpeed)
      Robot.m_intakeSubsystem.IntakeHinge.set(motSpeed)
    }
    if (Robot.climbing) {
      // Robot.m_liftRobotSubsystem.johnsonMotor.set(Robot.m_oi?.manipulatorJoystick!!.getZ().toDouble())
      Robot.m_liftRobotSubsystem.johnsonMotor.set(-0.25)
      println("Troy Philip JOHNSON!!!!")
    } else {
      Robot.m_liftRobotSubsystem.johnsonMotor.set(0.0)
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
