package frc.robot.pathfinder.util

import jaci.pathfinder.Pathfinder
import jaci.pathfinder.followers.EncoderFollower

import java.util.Timer
import java.util.TimerTask

import frc.robot.Robot
import frc.robot.RobotMap

class MotionExecutor(val trajectoryContainer: TankTrajectoryContainer) {
    val leftFollower: EncoderFollower = EncoderFollower(trajectoryContainer.leftTrajectory)
    val rightFollower: EncoderFollower = EncoderFollower(trajectoryContainer.rightTrajectory)
    var runTrajFollower: Boolean = false

    init { // Encoder configuration
        leftFollower.configureEncoder(Robot.m_sensorSubsystem.leftEncoder.raw, RobotMap.encoderTicksPerRevolution, RobotMap.wheelbaseWidth)
        rightFollower.configureEncoder(Robot.m_sensorSubsystem.rightEncoder.raw, RobotMap.encoderTicksPerRevolution, RobotMap.wheelbaseWidth)
    }

    init { // PIDVA configuration
        leftFollower.configurePIDVA(RobotMap.proportionalGain, RobotMap.integralGain, RobotMap.derivativeGain, 1 / RobotMap.maxVelocity, RobotMap.accelerationGain)
        rightFollower.configurePIDVA(RobotMap.proportionalGain, RobotMap.integralGain, RobotMap.derivativeGain, 1 / RobotMap.maxVelocity, RobotMap.accelerationGain)
    }

    val timer: Timer = Timer()
    val followerObject = TankTrajectoryFollower(this, leftFollower, rightFollower)
    init {
        timer.schedule(followerObject, 0.0.toLong(), (RobotMap.deltaTime * 1000).toLong())
    }

    fun start() {
        this.runTrajFollower = true
    }

    fun stop() {
        followerObject.cancel()
    }
}

class TankTrajectoryFollower(val parentObject: MotionExecutor, val leftFollower: EncoderFollower, val rightFollower: EncoderFollower) : TimerTask() {
    var leftPower: Double = 0.0
    var rightPower: Double = 0.0
    var gyroHeading: Float = 0.0f
    var desiredHeading: Double = 0.0
    var angleDifference: Double = 0.0
    var turn: Double = 0.0

    override fun run() {
        if (parentObject.runTrajFollower) {
            this.follow()
        }
        // parentObject.timer.cancel()
    }

    fun follow() {
        leftPower = leftFollower.calculate(Robot.m_sensorSubsystem.leftEncoder.raw)
        rightPower = rightFollower.calculate(Robot.m_sensorSubsystem.rightEncoder.raw)

        // Gyro correction
        gyroHeading = 0f //Robot.m_sensorSubsystem.navXMicro.rawAccelZ
        desiredHeading = Pathfinder.r2d(leftFollower.heading)

        angleDifference = Pathfinder.boundHalfDegrees(desiredHeading - gyroHeading)
        turn = 0.8 * (-1.0 / 80.0) * angleDifference

        // Move the motors
        Robot.m_driveTrainSubsystem.tankDrive(leftPower + turn, rightPower - turn)
    }
}