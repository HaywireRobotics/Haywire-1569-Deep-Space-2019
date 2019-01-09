/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
 
package frc.robot.commands

import edu.wpi.first.wpilibj.command.CommandGroup
import jaci.pathfinder.Waypoint

import frc.robot.Robot
import frc.robot.pathfinder.commands.TriggerMotionExecution
import frc.robot.pathfinder.util.MotionExecutor

class TESTDriveSwitchUsingPathfinder(): CommandGroup() {
  /**
   * Add your docs here.
   */
  init {
    var waypoints = arrayOf(
      Waypoint(1.0, 13.0, 0.0),
      Waypoint(6.0, 18.0, 0.0)
    )
    val motionExecutor = MotionExecutor(Robot.m_motionProfiler.generateTankMotionProfile(waypoints))
    addSequential(TriggerMotionExecution(motionExecutor))
  }
}   
