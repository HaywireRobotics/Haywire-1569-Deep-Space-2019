package frc.robot.pathfinder.util

import jaci.pathfinder.Pathfinder
import jaci.pathfinder.Trajectory
import jaci.pathfinder.Waypoint
import jaci.pathfinder.modifiers.TankModifier

import frc.robot.RobotMap

class MotionProfiler () {
    fun generateTankMotionProfile(waypoints: Array<Waypoint>): TankTrajectoryContainer {
        var config: Trajectory.Config = Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, RobotMap.deltaTime, RobotMap.maxVelocity, RobotMap.maxAcceleration, RobotMap.maxJerk)
        var modifier: TankModifier = TankModifier(Pathfinder.generate(waypoints, config))
        modifier.modify(RobotMap.wheelbaseWidth)
        return TankTrajectoryContainer(modifier)
    }
}