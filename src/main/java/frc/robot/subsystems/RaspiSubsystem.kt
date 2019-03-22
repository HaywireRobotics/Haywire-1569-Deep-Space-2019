/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
      
package frc.robot.subsystems
      
import java.util.concurrent.locks.ReentrantLock
import edu.wpi.first.wpilibj.command.Subsystem
import frc.robot.Robot
      
/**
 * Add your docs here.
 */
class RaspiSubsystem: Subsystem() {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public val lidarDataLock: ReentrantLock = ReentrantLock()
  public var frontLIDARInputted: Boolean = false
  public var frontLIDARValue: Int = 0
      
  override fun initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  fun getFrontLIDAR(): Int {
    // TODO: Communicate with the distance server to get the front LIDAR value
    // println("Get LIDAR")
    while (Robot.distanceServer.clientHandlers.size == 0) {}
    // println("Enough clients")
    Robot.distanceServer.initiateLIDARRequest(0)
    // TODO: Fix this while loop to implement locks so that things actually work.
    while (true) {
      try {
        lidarDataLock.lock()
        if (frontLIDARInputted) {
          break
        }
      } finally {
        lidarDataLock.unlock()
      }
    }
    // print("LIDAR value found")
    frontLIDARInputted = false
    return frontLIDARValue
  }

  fun getBackLIDAR() {}

  fun getNearestBayAngle() {}
}

class RaspiDataOutputter: Thread() {
  override fun run() {
    while (true) {
      // var frontLidarVal = Robot.m_raspiSubsystem.getFrontLIDAR()
      // if (frontLidarVal != -100) {
      // }
      println("Front LIDAR: ${Robot.m_raspiSubsystem.getFrontLIDAR()}")
      
    }
  }
}
