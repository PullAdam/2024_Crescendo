// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.LeftArm;

public class MoveLeftArmToPosition extends Command {
  private final LeftArm m_leftarm;
  private final double m_desiredAngle;
  
  public MoveLeftArmToPosition(double desiredAngle, LeftArm arm) {
    m_leftarm = arm;
    m_desiredAngle = desiredAngle;
    
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Set Left Arm to " + m_desiredAngle);
    m_leftarm.LeftArmDownPosition(m_desiredAngle);
  }

  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}