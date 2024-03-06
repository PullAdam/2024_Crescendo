// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants.k_Drive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  private Spark m_leftMotors, m_rightMotors;
  private DifferentialDrive m_drive;

  public DriveSubsystem() {
    m_leftMotors = new Spark(k_Drive.leftMotors);
    m_rightMotors = new Spark(k_Drive.rightMotors);
    m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);
    m_leftMotors.setInverted(false);
    m_rightMotors.setInverted(true);
  }

  public void arcadeDrive(double speed, double rot) {
    m_drive.arcadeDrive(speed, rot);
  }

  @Override
  public void periodic() {
  }
}
