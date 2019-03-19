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
class SwitchDriveDirection() : InstantCommand() {
    /**
     * Add your docs here.
     */
    companion object {
        val forwardColor = Color.BLUE.pwm
        val backwardColor = Color.RED.pwm
    }
    init {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.m_ledSubsystem)
    }

    // Called once when the command executes
    override fun initialize() {
        println("Switching Direction")
        if (Robot.robotDirectionInverted) {
            Robot.m_ledSubsystem.setColor(forwardColor)
            Robot.robotDirectionInverted = false;
        }
        else {
            Robot.m_ledSubsystem.setColor(backwardColor)
            Robot.robotDirectionInverted = true;
        }
    }
}
