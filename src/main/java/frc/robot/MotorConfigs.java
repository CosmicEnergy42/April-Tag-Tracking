package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
// import com.ctre

import frc.robot.Constants.MotorConstants;

public final class MotorConfigs{

    public TalonSRXConfiguration motorConfig;
    
    public MotorConfigs(){
      motorConfig = new TalonSRXConfiguration();
      motorConfig.slot0.kP = MotorConstants.kP;
      motorConfig.slot0.kI = MotorConstants.kI;
      motorConfig.slot0.kD = MotorConstants.kD;
      motorConfig.slot0.kF = MotorConstants.kF;
    
      motorConfig.continuousCurrentLimit = MotorConstants.motorContinuousCurrentLimit;
      motorConfig.peakCurrentDuration = MotorConstants.motorPeakCurrentDuration;
      motorConfig.peakCurrentLimit = MotorConstants.motorPeakCurrentLimit;
      motorConfig.openloopRamp = MotorConstants.motorOpenloopRamp;
      motorConfig.closedloopRamp = MotorConstants.motorClosedloopRamp;
      motorConfig.motionAcceleration = 200.4;
      motorConfig.motionCruiseVelocity = 204.8;
      motorConfig.motionCurveStrength = 0;
    }
  }
