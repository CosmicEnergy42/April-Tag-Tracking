package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.MotorTesting;

public class MoveMotorCommand extends Command {
    private MotorTesting m_Motor;
    private DoubleSupplier targetAngle;

    public MoveMotorCommand(MotorTesting m_Motor, DoubleSupplier targetAngle){
        this.m_Motor = m_Motor;
        addRequirements(m_Motor);
        this.targetAngle = targetAngle;
    }

    @Override
    public void execute() {
        m_Motor.changePos(targetAngle.getAsDouble());
        System.out.println("Target angle" + targetAngle);
    }

    @Override
    public boolean isFinished(){
        if (m_Motor.getSensorPos() >= Constants.MotorConstants.MotorPos + 2.5 || m_Motor.getSensorPos() <= Constants.MotorConstants.MotorPos - 2.5){
            return false;
        } else {
            return false;
        }
    }
}
