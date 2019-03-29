/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands

import frc.robot.Robot

import edu.wpi.first.wpilibj.command.InstantCommand

/**
 * Add your docs here.
 */
class SwitchCompressorPower() : InstantCommand() {
    /**
     * Add your docs here.
     */
    init {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called once when the command executes
    override fun initialize() {
        if (Robot.m_liftRobotSubsystem.compressor.getClosedLoopControl()) {
            Robot.m_liftRobotSubsystem.compressor.setClosedLoopControl(false)
        } else {
            Robot.m_liftRobotSubsystem.compressor.setClosedLoopControl(true)
        }
    }
}
