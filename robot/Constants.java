// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {
  public static class OperatorConstants {
    
    public static final int kDriverControllerPort = 0;
    public static final int kSystemControllerPort = 1;
  }

  public static class k_Drive{
    public static final int leftMotors = 1; // PWM channel for Left
    public static final int rightMotors = 0; // and Right motors
    public static final int leftEncoderChannelA = 2; // and Right motors
    public static final int leftEncoderChannelB = 3; // and Right motors
    public static final int rightEncoderChannelA = 0; // and Right motors
    public static final int rightEncoderChannelB = 1; // and Right motors
    public static final double AccelerationSlewRateLimiterValue = 0.5; // limits acceleration changes - may need adjusting.
    
    public static final int nDrivingModesAvaiable = 4; // Set to the number of functioning modes
  }

  public static class k_arm{
    public static final double ArmUpPosition = 118;
    public static final double NegativeArmUpPosition = -118;
    public static final double ArmDownPosition = 0;

    public static final int LeftCANMaxId = 2;
    public static final int RightCANMaxId = 5;
    public static final double ArmMaxSpeed = 0.5;
    public static final double kArmAngleP = 0.004;    // Make changes here
    public static final double kArmAngleI = 0;
    public static final double kArmAngleD = 0;
    public static final double kArmAngleIz = 0;
    public static final double kArmAngleFF = 0.0014;    // and here
    public static final double ArmAngleMinimumOutput = -1;
    public static final double ArmAngleMaximumOutput = 1;
  }

  public static class k_intake{
    public static final int CANMaxId = 6;
    public static final double IntakeMaxSpeed = 0.5;
    public static final int rangeFinderDIOTriggerPin = 6;
    public static final int rangeFinderDIOEchoPin = 7;
    public static final double rangeToStopMotionInInches = 2;
    public static final double ejectSpeed = -0.2;
    public static final double ejectTimeMilliseconds = 1000;  
  }

  public final class k_climber {
    public static final int LeftCanID = 8;
    public static final int RightCanID = 9;
  }

  public final class k_xbox {
    public static final int buttonX = 1;
    public static final int buttonY = 4;
    public static final int buttonA = 2;
    public static final int buttonB = 3;
    public static final int buttonLeftBumper = 5;
    public static final int buttonRightBumber = 6;
    public static final int buttonLeftLowerBumper = 7;
    public static final int buttonRightLowerBumber = 8;
    public static final int buttonBack = 9;
    public static final int buttonStart = 10;
    public static final int leftXaxis = 0;
    public static final int leftYaxis = 1;
    public static final int rightXaxis = 2;
    public static final int rightYaxis = 3;
  }

  public final class k_trigger {
    public static final int triggerButton = 1;
    public static final int thumbButton = 2;
  }
}
