/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
object RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // val leftMotor = 1
  // val rightMotor = 2

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // val rangefinderPort = 1
  // val rangefinderModule = 1

  // make a change

  // Drivetrain motor ports
  val driveTrainLeftFront = 4 // CAN: 4 PWM: 0
  val driveTrainLeftRear = 0 // CAN: 0 PWM: 1

  val driveTrainRightFront = 3 // CAN: 3 PWM: 2
  val driveTrainRightRear = 2 // CAN: 2 PWM: 3

  val hatchMotorPort = 9

  val leftIntakePort = 2
  val rightIntakePort = 6
  val intakeLiftMotor = 0

  var stringMotorPort = 1 // CAN: 1 PWM: 8
  val johnsonMotorPort = 5
  // Solenoid ports
  val hatchPanelPort1 = 0
  val hatchPanelPort2 = 1

  val liftRobotPort1 = 4
  val liftRobotPort2 = 5
  val liftRobotPort3 = 2 
  val liftRobotPort4 = 3 
  
  val intakePort1 = 6
  val intakePort2 = 7

  val ledPort = 8

  // Sensor Ports
  // Analog
  val lineSensorPort = 0

  // Digital
  val leftEncoderPort1 = 0
  val leftEncoderPort2 = 1

  val rightEncoderPort1 = 8
  val rightEncoderPort2 = 9

  // Joystick ports
  val leftJoystick = 1
  val rightJoystick = 0
  val manipulatorJoystick = 2
  val intakeJoystick = 3

  // Button Mappings
  val ejectorButton = 1

  // Motion Profiling
  val maxVelocity = 5.0     // Meters per second
  val maxAcceleration = 1.2 // Meters per second per second
  val maxJerk = 1.0         // Jerk is how much we can increase acceleration per iteration without jerking
  val deltaTime = 0.05      // Again not exactly sure but has probably something to do with the sampling rate that the trajectory plans for
  val wheelbaseWidth = 1.5  // Meters

  // Motion Execution
  // Encoder details
  val encoderTicksPerRevolution = 1000

  // PIDVA
  val proportionalGain = 1.0  // Jaci says that this is usually quite high
  val integralGain = 0.0      // Jaci states that this is unused for motion profiling
  val derivativeGain = 0.0    // Modify if unhappy with tracking
  val accelerationGain = 0.0  // Modify if we want to get to a higher or lower speed faster
}
