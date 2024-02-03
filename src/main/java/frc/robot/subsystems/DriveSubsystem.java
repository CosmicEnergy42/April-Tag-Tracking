package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
// import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  // private final WPI_TalonFX m_leftPrimaryMotor = new WPI_TalonFX(DriveConstants.kLeftPrimaryMotorPort);
  // private final WPI_TalonFX m_leftSecondaryMotor = new WPI_TalonFX(DriveConstants.kLeftSecondaryMotorPort);
  // private final WPI_TalonFX m_rightPrimaryMotor = new WPI_TalonFX(DriveConstants.kRightPrimaryMotorPort);
  // private final WPI_TalonFX m_rightSecondaryMotor = new WPI_TalonFX(DriveConstants.kRightSecondaryMotorPort);
  // // The motors on the left side of the drive.
  // private final MotorControllerGroup m_leftMotors =
  //     new MotorControllerGroup(
  //         m_leftPrimaryMotor,
  //         m_leftSecondaryMotor);

  // // The motors on the right side of the drive.
  // private final MotorControllerGroup m_rightMotors =
  //     new MotorControllerGroup(
  //         m_rightPrimaryMotor,
  //         m_rightSecondaryMotor);

  // // The robot's drive
  // private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);

  // // The left-side drive encoder
  // private final Encoder m_leftEncoder =
  //     new Encoder(
  //         DriveConstants.kLeftEncoderPorts[0],
  //         DriveConstants.kLeftEncoderPorts[1],
  //         DriveConstants.kLeftEncoderReversed);

  // // The right-side drive encoder
  // private final Encoder m_rightEncoder =
  //     new Encoder(
  //         DriveConstants.kRightEncoderPorts[0],
  //         DriveConstants.kRightEncoderPorts[1],
  //         DriveConstants.kRightEncoderReversed);

  // // The gyro sensor
  // // private final AHRS m_gyro = new AHRS(Port.kUSB);

  // // Odometry class for tracking robot pose
  // private final DifferentialDriveOdometry m_odometry;

  // /** Creates a new DriveSubsystem. */
  // public DriveSubsystem() {
  //   // We need to invert one side of the drivetrain so that positive voltages
  //   // result in both sides moving forward. Depending on how your robot's
  //   // gearbox is constructed, you might have to invert the left side instead.
  //   // m_rightMotors.setInverted(true);

  //   // Sets the distance per pulse for the encoders
  //   m_leftEncoder.setDistancePerPulse(DriveConstants.kEncoderDistancePerPulse);
  //   m_rightEncoder.setDistancePerPulse(DriveConstants.kEncoderDistancePerPulse);

  //   m_leftPrimaryMotor.setInverted(true);
  //   m_leftSecondaryMotor.setInverted(true);

  //   resetEncoders();
  //   m_odometry =
  //       new DifferentialDriveOdometry(
  //           m_gyro.getRotation2d(), m_leftEncoder.getDistance(), m_rightEncoder.getDistance());
  // }

  // @Override
  // public void periodic() {
  //   // Update the odometry in the periodic block
  //   m_odometry.update(
  //       m_gyro.getRotation2d(), m_leftEncoder.getDistance(), m_rightEncoder.getDistance());
  // }

  // /**
  //  * Returns the currently-estimated pose of the robot.
  //  *
  //  * @return The pose.
  //  */
  // public Pose2d getPose() {
  //   return m_odometry.getPoseMeters();
  // }

  // /**
  //  * Returns the current wheel speeds of the robot.
  //  *
  //  * @return The current wheel speeds.
  //  */
  // public DifferentialDriveWheelSpeeds getWheelSpeeds() {
  //   return new DifferentialDriveWheelSpeeds(m_leftEncoder.getRate(), m_rightEncoder.getRate());
  // }

  // /**
  //  * Resets the odometry to the specified pose.
  //  *
  //  * @param pose The pose to which to set the odometry.
  //  */
  // public void resetOdometry(Pose2d pose) {
  //   resetEncoders();
  //   m_odometry.resetPosition(
  //       m_gyro.getRotation2d(), m_leftEncoder.getDistance(), m_rightEncoder.getDistance(), pose);
  // }

  // /**
  //  * Drives the robot using arcade controls.
  //  *
  //  * @param fwd the commanded forward movement
  //  * @param rot the commanded rotation
  //  */
  // public void arcadeDrive(double fwd, double rot) {
  //   m_drive.arcadeDrive(fwd * Constants.kSpeedModifier, rot * Constants.kSpeedModifier);
  // }

  // /**
  //  * Controls the left and right sides of the drive directly with voltages.
  //  *
  //  * @param leftVolts the commanded left output
  //  * @param rightVolts the commanded right output
  //  */
  // public void tankDriveVolts(double leftVolts, double rightVolts) {
  //   m_leftMotors.setVoltage(leftVolts);
  //   m_rightMotors.setVoltage(rightVolts);
  //   m_drive.feed();
  // }

  // /** Resets the drive encoders to currently read a position of 0. */
  // public void resetEncoders() {
  //   m_leftEncoder.reset();
  //   m_rightEncoder.reset();
  // }

  // /**
  //  * Gets the average distance of the two encoders.
  //  *
  //  * @return the average of the two encoder readings
  //  */
  // public double getAverageEncoderDistance() {
  //   return (m_leftEncoder.getDistance() + m_rightEncoder.getDistance()) / 2.0;
  // }

  // /**
  //  * Gets the left drive encoder.
  //  *
  //  * @return the left drive encoder
  //  */
  // public Encoder getLeftEncoder() {
  //   return m_leftEncoder;
  // }

  // /**
  //  * Gets the right drive encoder.
  //  *
  //  * @return the right drive encoder
  //  */
  // public Encoder getRightEncoder() {
  //   return m_rightEncoder;
  // }

  // /**
  //  * Sets the max output of the drive. Useful for scaling the drive to drive more slowly.
  //  *
  //  * @param maxOutput the maximum output to which the drive will be constrained
  //  */
  // public void setMaxOutput(double maxOutput) {
  //   m_drive.setMaxOutput(maxOutput);
  // }

  // /** Zeroes the heading of the robot. */
  // public void zeroHeading() {
  //   m_gyro.reset();
  // }

  // /**
  //  * Returns the heading of the robot.
  //  *
  //  * @return the robot's heading in degrees, from -180 to 180
  //  */
  // public double getHeading() {
  //   return m_gyro.getRotation2d().getDegrees();
  // }

  // /**
  //  * Returns the turn rate of the robot.
  //  *
  //  * @return The turn rate of the robot, in degrees per second
  //  */
  // public double getTurnRate() {
  //   return -m_gyro.getRate();
  // }
}