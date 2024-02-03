package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MotorTesting extends SubsystemBase{
    public final static TalonSRX m_Motor = new TalonSRX(Constants.MotorConstants.kMotorTestPort);
    private double Pose = 0;

    public void configMotor(){
        m_Motor.configFactoryDefault();
        m_Motor.configAllSettings(Constants.MotorConstants.motorConfigs.motorConfig);
        m_Motor.setInverted(false);
        m_Motor.setNeutralMode(NeutralMode.Brake);
        m_Motor.setSelectedSensorPosition(0);
        m_Motor.setSensorPhase(true);
    }
    

    public void setPos(){
        // System.out.println(m_Motor.getSelectedSensorPosition(0));
    }

    public void changePos(double change){
        Pose = Constants.MotorConstants.MotorPos + change;
        // System.out.println(Pose);
        if (Pose > 360){
            Pose -= 360;
        } else if (Pose < -360){
            Pose += 360;
        }
        Constants.MotorConstants.MotorPos = Pose;
        m_Motor.set(ControlMode.MotionMagic, degreesToFalconSRX(Pose));
        // System.out.println(Pose);
    }

    double degreesToFalconSRX(double angle){
        return (angle / 360) * 4096;
    }

    double falconToDegrees(double ticks){
        return (ticks/4096) * 360;
    }

    void resetEncoder(){
        m_Motor.setSelectedSensorPosition(0.0);
    }

    public double getSensorPos(){
        return falconToDegrees(m_Motor.getSelectedSensorPosition());
    }
}
