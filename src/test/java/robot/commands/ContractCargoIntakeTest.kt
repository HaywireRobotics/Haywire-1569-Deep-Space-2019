package frc.robot.commands

import org.junit.Before
import org.junit.Test
import com.nhaarman.mockitokotlin2.*

import frc.robot.Robot
import frc.robot.commands.ContractCargoIntake


class ContractCargoIntakeTest {
    val command: ContractCargoIntake = ContractCargoIntake()

    @Before
    fun setup() {
       Robot.m_intakeSubsystem = mock()
       Robot.m_intakeSubsystem.piston = mock()
    }

    @Test
    fun test_contract_cargo_intake() {
        command.initialize()

        verify(Robot.m_intakeSubsystem).contractPiston()
    }
}