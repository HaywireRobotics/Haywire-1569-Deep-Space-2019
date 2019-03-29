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
  val intakeJoystick: Joystick = Joystick(RobotMap.intakeJoystick)
  val manipulatorJoystick: Joystick = Joystick(RobotMap.manipulatorJoystick)
  val button1: JoystickButton = JoystickButton(manipulatorJoystick, 1)
  val button2: JoystickButton = JoystickButton(manipulatorJoystick, 2)
  val button3: JoystickButton = JoystickButton(manipulatorJoystick, 3)
  val button4: JoystickButton = JoystickButton(manipulatorJoystick, 4)
  val button6: JoystickButton = JoystickButton(manipulatorJoystick, 6)
  val button7: JoystickButton = JoystickButton(manipulatorJoystick, 7)
  val button8: JoystickButton = JoystickButton(manipulatorJoystick, 8)
  val button9: JoystickButton = JoystickButton(manipulatorJoystick, 9)
  val button10: JoystickButton = JoystickButton(manipulatorJoystick, 10)
  val button11: JoystickButton = JoystickButton(manipulatorJoystick, 11)

  val manipulate2button1: JoystickButton = JoystickButton(intakeJoystick, 1)
  val manipulate2button2: JoystickButton = JoystickButton(intakeJoystick, 2)
  val manipulate2button3: JoystickButton = JoystickButton(intakeJoystick, 3)
  val manipulate2button4: JoystickButton = JoystickButton(intakeJoystick, 4)
  val manipulate2button5: JoystickButton = JoystickButton(intakeJoystick, 5)
  val manipulate2button6: JoystickButton = JoystickButton(intakeJoystick, 6)
  val manipulate2button7: JoystickButton = JoystickButton(intakeJoystick, 7)
  
  val rightJoystickButton9: JoystickButton = JoystickButton(rightJoystick, 9)
  val rightJoystickButton1: JoystickButton = JoystickButton(rightJoystick, 1)
  val rightJoystickButton11: JoystickButton = JoystickButton(rightJoystick, 11)
  init {
    button1.whenPressed(EjectHatchPanel())
    button2.whileHeld(IntakeCargo())
    button3.whileHeld(ExtrudeCargo())

    button4.whenPressed(CargoArmToAngle(-70.0))

    button6.whenPressed(LiftRobot())
    button7.whenPressed(DropRobot())

    button8.whenPressed(StopBack())
    button9.whenPressed(ExtendBack())

    button10.whileHeld(RetractBack())
    button11.whenPressed(RetractFront())

    manipulate2button1.whenPressed(ExpandCargoIntake())
    manipulate2button2.whenPressed(ContractCargoIntake())
    manipulate2button3.whileHeld(ExtrudeCargoSlow())
    manipulate2button4.whileHeld(WrapString())
    manipulate2button5.whenPressed(WrapStringInverted())

    manipulate2button6.whileHeld(LiftFront())
    manipulate2button7.whileHeld(LiftBack())
    // manipulate2button6.whileHeld(StabilizeLiftV2())

    rightJoystickButton9.whenPressed(SwitchDriveDirection())
    rightJoystickButton1.whenPressed(SwitchDriveDirection())
    rightJoystickButton11.whenPressed(SwitchCompressorPower())
  }
}
