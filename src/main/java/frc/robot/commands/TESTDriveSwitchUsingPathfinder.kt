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

class TESTDriveSwitchUsingPathfinder() : CommandGroup() {
  /**
   * Add your docs here.
   */
  init {
    var waypoints = arrayOf(
      Waypoint(1.0, 13.0, 0.0),
      Waypoint(6.0, 18.0, 0.0)
    )
    // The generateTankMotionProfile method returns a TankTrajectoryContainer which holds the left and right
    // trajectories so that they can be passed easily. It is possible to read pre-generated trajectories by 
    // doing the following:
    //  Binary file:
    //    var leftFile: File = File("/home/lvuser/deploy/myFileLeft.traj")
    //    var rightFile: File = File("/home/lvuser/deploy/myFileRight.traj")
    //    var leftTrajectory: Trajectory = Pathfinder.readFromFile(leftFile)
    //    var rightTrajectory: Trajectory = Pathfinder.readFromFile(rightFile)
    //    val container: TankTrajectoryContainer = TankTrajectoryContainer(leftTrajectory, rightTrajectory)
    //
    //  CSV file:
    //    var leftFile: File = File("/home/lvuser/deploy/myFileLeft.csv")
    //    var rightFile: File = File("/home/lvuser/deploy/myFileRight.csv")
    //    var leftTrajectory: Trajectory = Pathfinder.readFromCSV(leftFile)
    //    var rightTrajectory: Trajectory = Pathfinder.readFromCSV(rightFile)
    //    val container: TankTrajectoryContainer = TankTrajectoryContainer(leftTrajectory, rightTrajectory)
    //
    // The container can then be passed to the MotionExecutor
    val motionExecutor = MotionExecutor(Robot.m_motionProfiler.generateTankMotionProfile(waypoints))
    addSequential(TriggerMotionExecution(motionExecutor))
  }
}
