// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.k_arm;
import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.SparkPIDController;


public class LeftArm extends SubsystemBase {
  private CANSparkMax m_armMotorLeft;
  private RelativeEncoder m_angleEncoderLeft;
  private SparkPIDController m_armPIDController; 
  
  /** Constructs a new Arm */
  public LeftArm() {
    m_armMotorLeft = new CANSparkMax(k_arm.LeftCANMaxId, MotorType.kBrushless);

    m_angleEncoderLeft = m_armMotorLeft.getEncoder();
    m_armPIDController = m_armMotorLeft.getPIDController();
    
    // PID Constants 
    m_armPIDController.setP(k_arm.kArmAngleP);
    m_armPIDController.setI(k_arm.kArmAngleI);
    m_armPIDController.setD(k_arm.kArmAngleD);
    m_armPIDController.setIZone(k_arm.kArmAngleIz);
    m_armPIDController.setFF(k_arm.kArmAngleFF);
    m_armPIDController.setOutputRange(k_arm.ArmAngleMinimumOutput, k_arm.ArmAngleMaximumOutput);
    m_armMotorLeft.burnFlash();

    resetEncoder();
  }

  public void resetEncoder(){
    m_angleEncoderLeft.setPosition(0);
  }

  public void LeftArmDownPosition(double leftdesiredAngle) {
    System.out.println("SettingLeftArmDown");
    m_armPIDController.setReference(leftdesiredAngle, CANSparkBase.ControlType.kPosition);
  }

  public void ArmUpPosition(double leftdesiredAngle) {
    System.out.println("SettingLeftArmUp");
    m_armPIDController.setReference(leftdesiredAngle, CANSparkBase.ControlType.kPosition);
  }

  public void halt() {
    System.out.println("haltArm");
    m_armMotorLeft.set(0);
  }
  
  public double getPosition() {
    return m_angleEncoderLeft.getPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left Arm Encoder", m_angleEncoderLeft.getPosition());
  }


  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
