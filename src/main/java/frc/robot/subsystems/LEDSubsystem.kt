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
      
/**
 * Add your docs here.
 */
class LEDSubsystem: Subsystem() {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  var ledController: Spark = Spark(RobotMap.ledPort)
  
  init {
    ledController.setSafetyEnabled(false)
  }
      
  override fun initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  // fun <E: Enum<E>> setColor(color: E) = ledController.set(color.value)
  fun <E: Enum<E>> setColor(color: E) = println(color.name)
}

enum class Color(val pwm: Double) {
  RAINBOW(-0.99),
  FIRE(-0.57),
  HOT_PINK(0.57),
  DARK_RED(0.59),
  RED(0.61),
  RED_ORANGE(0.63),
  ORANGE(0.65),
  GOLD(0.67),
  YELLOW(0.69),
  LAWN_GREEN(0.71),
  LIME(0.73),
  DARK_GREEN(0.75),
  GREEN(0.77),
  BLUE_GREEN(0.79),
  AQUA(0.81),
  SKY_BLUE(0.83),
  DARK_BLUE(0.85),
  BLUE(0.87),
  BLUE_VIOLET(0.89),
  VIOLET(0.91),
  WHITE(0.93),
  GRAY(0.95),
  DARK_GRAY(0.97),
  BLACK(0.99)
}
