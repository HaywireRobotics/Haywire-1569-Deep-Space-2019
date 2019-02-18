/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands

import edu.wpi.first.wpilibj.command.InstantCommand

import frc.robot.Robot
import frc.robot.subsystems.Color

/**
 * Add your docs here.
 */
class SetLEDsYellow() : InstantCommand() {
    /**
     * Add your docs here.
     */
    init {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.m_ledSubsystem);
    }

    // Called once when the command executes
    override fun initialize() {
        // println(Color.ORANGE.pwm)
        Robot.m_ledSubsystem.setColor(Color.YELLOW.pwm)
    }
}
