package frc.robot.pathfinder.util

import jaci.pathfinder.Trajectory
import jaci.pathfinder.modifiers.TankModifier

class TankTrajectoryContainer(val leftTrajectory: Trajectory, val rightTrajectory: Trajectory) {
    constructor(modifier: TankModifier): this(modifier.getLeftTrajectory(), modifier.getRightTrajectory()) {}
}