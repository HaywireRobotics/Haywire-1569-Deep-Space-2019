/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot

import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.Scheduler
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard

import frc.robot.commands.*
import frc.robot.subsystems.*
import frc.robot.pathfinder.util.MotionProfiler
import frc.robot.raspiserver.TCPServer

class Robot : TimedRobot() {

  companion object {
    val m_intakeSubsystem: IntakeSubsystem = IntakeSubsystem()
    val m_exampleSubsystem: ExampleSubsystem = ExampleSubsystem()
    val m_driveTrainSubsystem: DriveTrainSubsystem = DriveTrainSubsystem()
    val m_sensorSubsystem: SensorSubsystem = SensorSubsystem()
    val m_motionProfiler: MotionProfiler = MotionProfiler()
    val m_hatchPanelSubsystem: HatchPanelSubsystem = HatchPanelSubsystem()
    val m_liftRobotSubsystem: LiftRobotSubsystem = LiftRobotSubsystem()
    val m_ledSubsystem: LEDSubsystem = LEDSubsystem()
    val m_raspiSubsystem: RaspiSubsystem = RaspiSubsystem()
    var m_oi: OI? = null

    val robotType: String = "Practice"
    var climbing: Boolean = true
    var robotDirectionInverted: Boolean = false
    var autonomousRun: Boolean = false

    val distanceServer: TCPServer = TCPServer(5800)
    val cameraVisionServer: TCPServer = TCPServer(5807)
  }

  var m_autonomousCommand: Command? = null
  var m_chooser: SendableChooser<Command> = SendableChooser()

  init {
    distanceServer.start()
    cameraVisionServer.start()
    RaspiDataOutputter().start()
    println("Continuing")
  }
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  override fun robotInit() {
    m_oi = OI()
    m_chooser.setDefaultOption("Default Auto", ExampleCommand())
    // m_chooser.addOption("My Auto", MyAutoCommand())
    SmartDashboard.putData("Auto mode", m_chooser)
    m_liftRobotSubsystem.retractBackPistons()
    m_liftRobotSubsystem.retractFrontPistons()
    m_ledSubsystem.setColor(SwitchDriveDirection.forwardColor)
    println("Still moving on")
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  override fun robotPeriodic() {
    m_ledSubsystem.applyColor()
    // println("Value: " + m_sensorSubsystem.lineSensor.value.toString()) 
    // println("Voltage: " + m_sensorSubsystem.lineSensor.voltage.toString()) 2(3/4") 2(2 1/4")
    // println("Boolean: " + m_sensorSubsystem.lineSensorActive().toString()) 2'3" 8'1/4"
     //println("Navx Pitch: " + m_sensorSubsystem.navXMXP.pitch)
     //println("Navx Yaw: " + m_sensorSubsystem.navXMXP.yaw)
    //println("Navx Roll: " + m_sensorSubsystem.navXMXP.roll)
    // println("Cargo Pitch: " + m_sensorSubsystem.cargoNavX.pitch)
    //println("Cargo Yaw: " + m_sensorSubsystem.cargoNavX.yaw)
    //println("Cargo Roll: " + m_sensorSubsystem.cargoNavX.roll)
    // println("Range: " + m_sensorSubsystem.rangeSensor.voltage)
    // println("Front LIDAR: ${m_raspiSubsystem.getFrontLIDAR()}")
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  override fun disabledInit() {
    // DropRobot().start()
    if (!autonomousRun) {
      Robot.robotDirectionInverted = false
      m_ledSubsystem.setColor(SwitchDriveDirection.forwardColor)
      println("Switch the drive direction in disabled")
    }
  }

  override fun disabledPeriodic() {
    // Scheduler.getInstance().run()
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  override fun autonomousInit() {
    /*
     * val autoSelected: String = SmartDashboard.getString("Auto Selector", "Default")
     * m_autonomousCommand = when (autoSelected) {
     *   "My Auto" -> MyAutoCommand()
     *   "Default Auto" -> ExampleCommand()
     *   else -> ExampleCommand()
     * }
     */

    // schedule the autonomous command (example)
    m_chooser.selected?.start()
    autonomousRun = true
    robotDirectionInverted = false
    m_ledSubsystem.setColor(SwitchDriveDirection.forwardColor)
  }

  /**
   * This function is called periodically during autonomous
   */
  override fun autonomousPeriodic() {
    Scheduler.getInstance().run()
  }

  override fun teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    m_liftRobotSubsystem.stopBackPistons()
    m_liftRobotSubsystem.stopFrontPistons()
    m_autonomousCommand?.cancel()
    TeleopCommand().start()
    // ApplyLEDColor().start()
    climbing = false
    if (!autonomousRun) {
      robotDirectionInverted = false
      m_ledSubsystem.setColor(SwitchDriveDirection.forwardColor)
    }
    autonomousRun = false
  }

  /**
   * This function is called periodically during operator control
   */
  override fun teleopPeriodic() {
    // println("Compressor Current: " + m_hatchPanelSubsystem.compressor.compressorCurrent)
    // println("Pressure Switch: " + m_hatchPanelSubsystem.compressor.getPressureSwitchValue())
    Scheduler.getInstance().run()
    
  }

  /**
   * This function is called periodically during test mode
   */
  override fun testPeriodic() {
    // println("X: " + m_sensorSubsystem.gyro.getX())
    // println("Y: " + m_sensorSubsystem.gyro.getY())
    // println("Z: " + m_sensorSubsystem.gyro.getZ())
    SmartDashboard.putData(m_liftRobotSubsystem.BackLiftSolenoid)
  }
}
