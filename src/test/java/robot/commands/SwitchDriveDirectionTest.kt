package frc.robot.commands

import org.junit.Before
import org.junit.Test
import org.junit.Assert
import com.nhaarman.mockitokotlin2.*

import frc.robot.Robot

class SwitchDriveDirectionTest {
    val command: SwitchDriveDirection = SwitchDriveDirection()

    @Before
    fun setup() {}

    @Test
    fun test_switch_drive_boolean_false_to_true() {
        Robot.robotDirectionInverted = false;
        
        command.initialize()

        Assert.assertEquals(Robot.robotDirectionInverted, true)

        Robot.robotDirectionInverted = false
    }

    @Test
    fun test_switch_drive_boolean_true_to_false() {
        Robot.robotDirectionInverted = true

        command.initialize()

        Assert.assertEquals(Robot.robotDirectionInverted, false)
    }
}