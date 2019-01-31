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
    val command: TeleopCommand = TeleopCommand()
    val leftJoy: Joystick = mock()
    val rightJoy: Joystick = mock()
    val manipJoy: Joystick = mock()
    val intakeJoy: Joystick = mock()

    @Before
    fun setup() {
        // Mocking required classes
        Robot.m_oi = mock<OI>()
        Robot.m_driveTrainSubsystem = mock()
        Robot.m_hatchPanelSubsystem = mock()
        Robot.m_intakeSubsystem = mock()

        // Mapping mocked joysticks to oi
        whenever(Robot.m_oi.getLJoystick()).thenReturn(leftJoy)
        whenever(Robot.m_oi.getRJoystick()).thenReturn(rightJoy)
        whenever(Robot.m_oi.getMJoystick()).thenReturn(manipJoy)
        whenever(Robot.m_oi.getIJoystick()).thenReturn(intakeJoy)
    }

    @Test
    fun drive_forward_no_invert() {
        setJoystickReturnValues(0.8, 1.0, 0.0, 0.0)

        command.execute()

        verify(Robot.m_driveTrainSubsystem).tankDrive(-0.8, -1.0)
    }

    @Test
    fun drive_forward_invert() {
        Robot.robotDirectionInverted = true
        setJoystickReturnValues(0.78, 0.8, 0.0, 0.0)

        command.execute()

        verify(Robot.m_driveTrainSubsystem).tankDrive(0.8, 0.78)

        Robot.robotDirectionInverted = false
    }

    @Test
    fun drive_backward_no_invert() {
        setJoystickReturnValues(-1.0, -0.99, 0.0, 0.0)

        command.execute()

        verify(Robot.m_driveTrainSubsystem).tankDrive(1.0, 0.99)
    }

    @Test
    fun drive_backward_invert() {
        Robot.robotDirectionInverted = true
        setJoystickReturnValues(-0.76, -0.94, 0.0, 0.0)

        command.execute()

        verify(Robot.m_driveTrainSubsystem).tankDrive(-0.94, -0.76)

        Robot.robotDirectionInverted = false
    }

    @Test
    fun hatch_stick_up() {}

    @Test
    fun hatch_stick_down() {}

    @Test
    fun intake_stick_up() {}

    @Test
    fun intake_stick_down() {}

    fun setJoystickReturnValues(leftValue: Double, rightValue: Double, manipValue: Double, intakeValue: Double) {
        whenever(leftJoy.getY()).thenReturn(leftValue)
        whenever(rightJoy.getY()).thenReturn(rightValue)
        whenever(manipJoy.getY()).thenReturn(manipValue)
        whenever(intakeJoy.getY()).thenReturn(intakeValue)
    }
}