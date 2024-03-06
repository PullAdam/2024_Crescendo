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


public class RightArm extends SubsystemBase {
  private CANSparkMax m_armMotorRight;
  private RelativeEncoder m_angleEncoderRight;
  private SparkPIDController m_armPIDController; 
  
  /** Constructs a new Arm */
  public RightArm() {
    m_armMotorRight = new CANSparkMax(k_arm.RightCANMaxId, MotorType.kBrushless);

    m_angleEncoderRight = m_armMotorRight.getEncoder();
    m_armPIDController = m_armMotorRight.getPIDController();
    
    // PID Constants 
    m_armPIDController.setP(k_arm.kArmAngleP);
    m_armPIDController.setI(k_arm.kArmAngleI);
    m_armPIDController.setD(k_arm.kArmAngleD);
    m_armPIDController.setIZone(k_arm.kArmAngleIz);
    m_armPIDController.setFF(k_arm.kArmAngleFF);
    m_armPIDController.setOutputRange(k_arm.ArmAngleMinimumOutput, k_arm.ArmAngleMaximumOutput);
    m_armMotorRight.burnFlash();

    resetEncoder();
  }

  public void resetEncoder(){
    m_angleEncoderRight.setPosition(0);
  }

  public void RightArmDownPosition(double rightdesiredAngle) {
    System.out.println("SettingRightArmDown");
    m_armPIDController.setReference(rightdesiredAngle, CANSparkBase.ControlType.kPosition);
  }

  public void ArmUpPosition(double rightdesiredAngle) {
    System.out.println("SettingRightArmUp");
    m_armPIDController.setReference(rightdesiredAngle*-1, CANSparkBase.ControlType.kPosition);
  }

  public void halt() {
    System.out.println("haltArm");
    m_armMotorRight.set(0);

  }
  
  public double getPosition() {
    return m_angleEncoderRight.getPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Right Arm Encoder", m_angleEncoderRight.getPosition());
  }


  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
