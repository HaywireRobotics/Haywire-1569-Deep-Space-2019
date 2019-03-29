/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
      
package frc.robot.subsystems
      
import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.Spark

import frc.robot.RobotMap
import frc.robot.commands.ApplyLEDColor
import frc.robot.subsystems.Color
      
/**
 * Add your docs here.
 */
class LEDSubsystem: Subsystem() {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  var ledController: Spark = Spark(RobotMap.ledPort)
  var currentLEDValue: Double = 0.0
      
  override fun initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(ApplyLEDColor());
  }

  // To make this more "kotliny", setColor() wouldn't exist and code would interface with currentLEDValue directly, but I'm lazy
  fun setColor(pwm: Double) {
    currentLEDValue = pwm
  }

  fun applyColor() = ledController.set(currentLEDValue)
}
