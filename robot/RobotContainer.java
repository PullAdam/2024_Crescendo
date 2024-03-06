// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.k_arm;
import frc.robot.Constants.k_xbox;
import frc.robot.commands.Autos;
import frc.robot.commands.MoveLeftArmToPosition;
import frc.robot.commands.MoveRightArmToPosition;
import frc.robot.subsystems.LeftArm;
import frc.robot.subsystems.RightArm;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  
  private final Joystick m_driverController;
  private final CommandXboxController m_systemController;
  private final DriveSubsystem m_Drive;
  private final LeftArm m_LeftArm;
  private final RightArm m_RightArm;
  private final Intake m_Intake;
  private final Climber m_Climber;
  private final ExampleSubsystem m_exampleSubsystem;
    
  public RobotContainer() {

    m_exampleSubsystem = new ExampleSubsystem();

    m_Drive = new DriveSubsystem();
    m_LeftArm = new LeftArm();
    m_RightArm = new RightArm();
    m_Intake = new Intake();
    m_Climber = new Climber();

    m_driverController = new Joystick(OperatorConstants.kDriverControllerPort);
    m_systemController = new CommandXboxController(OperatorConstants.kSystemControllerPort);
  
    setDefaultCommands();
    configureJoystickButtonBindings(); 
  }

  private void setDefaultCommands() {

    // set Chassis default command
    m_Drive.setDefaultCommand(new RunCommand(() -> 
      m_Drive.arcadeDrive(
        m_driverController.getRawAxis(1),
        m_driverController.getRawAxis(0)*-0.8),
      m_Drive));
    
    // set Intake default command
    m_Intake.setDefaultCommand(new RunCommand(() -> 
      m_Intake.spin(
        m_driverController.getRawAxis(3)),
      m_Intake));

    // set Climber Default command
    m_Climber.setDefaultCommand(new RunCommand(() -> 
    m_Climber.move(
      m_systemController.getRawAxis(k_xbox.leftYaxis),
      m_systemController.getRawAxis(k_xbox.rightYaxis)),
    m_Climber));
  }

  private void configureJoystickButtonBindings() {

    new Trigger(m_systemController.b()).onTrue(new MoveLeftArmToPosition(k_arm.ArmUpPosition, m_LeftArm));
    new Trigger(m_systemController.b()).onFalse(new MoveLeftArmToPosition(k_arm.ArmDownPosition, m_LeftArm));
    //new Trigger(m_systemController.b()).onTrue(new MoveRightArmToPosition(k_arm.NegativeArmUpPosition, m_RightArm));
    //new Trigger(m_systemController.b()).onFalse(new MoveRightArmToPosition(k_arm.ArmDownPosition, m_RightArm));

    //new Trigger(m_systemController.x()).onTrue(new RunIntakeTillNote(m_Intake));
    //new Trigger(m_systemController.b()).onTrue(new EjectNote(m_Intake));

  }

  public Command getAutonomousCommand() {
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
