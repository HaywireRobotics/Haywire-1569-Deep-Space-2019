package frc.robot.commands

import com.nhaarman.mockitokotlin2.*
import org.junit.Test
import org.junit.Before
import edu.wpi.first.wpilibj.Joystick

import frc.robot.Robot
import frc.robot.OI
import frc.robot.subsystems.DriveTrainSubsystem
import frc.robot.subsystems.HatchPanelSubsystem
import frc.robot.subsystems.IntakeSubsystem

class TeleopCommandTest {
    @Before
    fun setup() {}

    @Test
    fun drive_forward_no_invert() {}

    @Test
    fun drive_forward_invert() {}

    @Test
    fun drive_backward_no_invert() {}

    @Test
    fun drive_backward_invert() {}

    @Test
    fun hatch_stick_up() {}

    @Test
    fun hatch_stick_down() {}

    @Test
    fun intake_stick_up() {}

    @Test
    fun intake_stick_down() {}
}