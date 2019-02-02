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
class ExpandCargoIntake() : InstantCommand() {
    /**
     * Add your docs here.
     */
    init {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.m_intakeSubsystem)
    }

    // Called once when the command executes
    public override fun initialize() = Robot.m_intakeSubsystem.expandPiston()
}
