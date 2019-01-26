/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import frc.robot.commands.*

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
class OI {
  // // CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  // // joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // val stick: Joystick = Joystick(port)
  // val button: Button = JoystickButton(stick, buttonNumber)

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  // // TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(ExampleCommand())

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(ExampleCommand())

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(ExampleCommand())
  val leftJoystick: Joystick = Joystick(RobotMap.leftJoystick)
  val rightJoystick: Joystick = Joystick(RobotMap.rightJoystick)
  val IntakeJoystick: Joystick = Joystick(RobotMap.IntakeJoystick)
  val manipulatorJoystick: Joystick = Joystick(RobotMap.manipulatorJoystick)
  val button1: JoystickButton = JoystickButton(manipulatorJoystick, 1)
  val button2: JoystickButton = JoystickButton(manipulatorJoystick, 2)
  val button3: JoystickButton = JoystickButton(manipulatorJoystick, 3)
  val button4: JoystickButton = JoystickButton(manipulatorJoystick, 4)
  val button5: JoystickButton = JoystickButton(manipulatorJoystick, 5)

  init {
    button1.whenPressed(EjectHatchPanel())
    button2.whileHeld(IntakeCargo())
    button3.whileHeld(ExtrudeCargo())
    button4.whenPressed(LiftRobot())
    button5.whenPressed(DropRobot())
  }
}
