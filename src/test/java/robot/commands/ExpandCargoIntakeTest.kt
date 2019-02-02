package frc.robot.commands

import org.junit.Before
import org.junit.Test
import com.nhaarman.mockitokotlin2.*

import frc.robot.Robot

class ExpandCargoIntakeTest {
    val command: ExpandCargoIntake = ExpandCargoIntake()

    @Before
    fun setup() {
       Robot.m_intakeSubsystem = mock()
       Robot.m_intakeSubsystem.piston = mock()
    }

    @Test
    fun test_expand_cargo_intake() {
        command.initialize()

        verify(Robot.m_intakeSubsystem).expandPiston()
    }
}