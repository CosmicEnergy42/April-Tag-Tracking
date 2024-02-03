// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
// import frc.robot.commands.Autos;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.MotorTesting;
import frc.robot.subsystems.VisionSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;




/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final MotorTesting m_MotorTesting = new MotorTesting();
  private final VisionSubsystem v_VisionSubsystem = new VisionSubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final XboxController m_driverController =
      new XboxController(OperatorConstants.kDriverControllerPort);

  private final JoystickButton ZeroPos = new JoystickButton(m_driverController, XboxController.Button.kX.value);
  private final JoystickButton IncreasePos = new JoystickButton(m_driverController, XboxController.Button.kA.value);
  private final JoystickButton DecreasePos = new JoystickButton(m_driverController, XboxController.Button.kY.value);
  private final JoystickButton trackFour = new JoystickButton(m_driverController, XboxController.Button.kB.value);
  private final JoystickButton getDist = new JoystickButton(m_driverController, XboxController.Button.kLeftBumper.value);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_MotorTesting.configMotor();
    // Configure the trigger bindings
    configureBindings();
    // m_driveSubsystem.setDefaultCommand(
    //   new RunCommand(
    //     () -> 
    //       m_driveSubsystem.arcadeDrive(
    //         -m_driverController.getLeftY(), 
    //         m_driverController.getRightX()), 
    //     m_driveSubsystem)
    // );
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
      ZeroPos.onTrue(new InstantCommand(() -> m_MotorTesting.changePos(180)));
      IncreasePos.onTrue(new InstantCommand(() -> m_MotorTesting.changePos(10))).onFalse(new InstantCommand(() -> m_MotorTesting.changePos(0)));
      DecreasePos.onTrue(new InstantCommand(() -> m_MotorTesting.changePos(-10))).onFalse(new InstantCommand(() -> m_MotorTesting.changePos(0)));
      trackFour.whileTrue(v_VisionSubsystem.AimAtApril(m_MotorTesting, Constants.VisionConstants.SpeakerID, 0));
      getDist.onTrue(new InstantCommand(() -> v_VisionSubsystem.getDist()));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new Autos(Constants.kAutoSelected, m_driveSubsystem);
  }
}
