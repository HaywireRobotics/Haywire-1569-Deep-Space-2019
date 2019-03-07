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
class LiftRobot() : InstantCommand() {
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
        Robot.m_liftRobotSubsystem.johnsonMotor.setSafetyEnabled(false)
        Robot.m_liftRobotSubsystem.johnsonMotor.set(0.1)
        Robot.m_liftRobotSubsystem.extendBackPistons()
        Robot.m_liftRobotSubsystem.extendFrontPistons()
    }
}
