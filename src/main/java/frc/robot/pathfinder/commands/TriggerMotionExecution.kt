/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.pathfinder.commands

import edu.wpi.first.wpilibj.command.InstantCommand

import frc.robot.pathfinder.util.MotionExecutor

/**
 * Add your docs here.
 */
class TriggerMotionExecution(val motionExecutor: MotionExecutor) : InstantCommand() {
    /**
     * Add your docs here.
     */
    init {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called once when the command executes
    override fun initialize() {
        motionExecutor.start()
    }
}
