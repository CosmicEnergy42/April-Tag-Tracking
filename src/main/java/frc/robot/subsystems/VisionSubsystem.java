package frc.robot.subsystems;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
// import frc.robot.commands.TeleopSwerve;
import frc.robot.commands.MoveMotorCommand;

public class VisionSubsystem extends SubsystemBase {
    // double angle;
    double x ;
    double id ;
    double y ;
    double area ;
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");
    NetworkTableEntry tid = table.getEntry("tid");
    NetworkTableEntry pipeline = table.getEntry("pipeline");
    public VisionSubsystem(){

    }
    @Override
    public void periodic() {
        x = tx.getDouble(0.0);
        id = tid.getDouble(0.0);
        y = ty.getDouble(0.0);
        area = ta.getDouble(0.0);
        SmartDashboard.putNumber("distance", getDistance());
        SmartDashboard.putNumber("limelightx", x);
        SmartDashboard.putNumber("limelighty", y);
        SmartDashboard.putNumber("limelighta", area);
        SmartDashboard.putNumber("limelightid", id);
        if (getDistance() > 7){
            if (Constants.VisionConstants.SpeakerID == 4){
                Constants.VisionConstants.SpeakerID = 1;
            } else if (Constants.VisionConstants.SpeakerID == 7) {
                Constants.VisionConstants.SpeakerID = 2;
            }
        } else if (getDistance() < 7){
            if (Constants.VisionConstants.SpeakerID == 1){
                Constants.VisionConstants.SpeakerID = 4;
            } else  if (Constants.VisionConstants.SpeakerID == 2) {
                Constants.VisionConstants.SpeakerID = 7;
            }

        }
    }
    
    public Command AimAtApril(MotorTesting m_Motor, int id, int offset)
    {
        
        Command setPipelineCommand = this.run(
            () -> pipeline.setDouble(Constants.VisionConstants.SpeakerID)
            );
            setPipelineCommand.addRequirements(this);
            // angle = getRotation(offset);
            Command rotateMotorCommand = new MoveMotorCommand(m_Motor, () -> getRotation(offset));
            
        // System.out.println("Rotation: " + getRotation(offset));
        return setPipelineCommand.alongWith(rotateMotorCommand);
    }
    
    public double getDistance(){
        double area = ta.getDouble(0.0);
        double oneSide = Math.sqrt(area);
        double distance = 5.37/oneSide;
        return distance;
    }

    public double getTranslation(double targetDistance){
        double distance = getDistance();
        if (Double.isInfinite(distance)){
            return 0;
        }
        else{
            return targetDistance-distance;
        }
    }

    public double getRotation(double targetAngle){
        // System.out.println("id: " + id);
        if (id <= 0){
            System.out.println("id is 0");
            return 0;
        }
        else{
        //return (tx.getDouble(0.0)-targetAngle)*-0.1;
        System.out.println(rateOfChange((tx.getDouble(0.0)-targetAngle)*-0.04));

        // return rateOfChange((tx.getDouble(0.0) - targetAngle)*-0.04);
        return (tx.getDouble(0.0)-targetAngle)*-0.05;

        }
    }

    public static double rateOfChange(double x) {
        final double increaseRate = 1.1; // Adjust as needed

        // Calculate the distance from origin
        double distance = Math.abs(x);

        // Calculate rate of change
        double rate = distance * increaseRate;

        return rate;
    }

    public void getDist(){
        System.out.println(getDistance());
    }
    // public Command DriveToDistanceFromApril(Swerve swerve, int id, int distance)
    
    //  {
    //     Command setPipelineCommand = this.runOnce(
    //         () -> pipeline.setDouble(id)
    //     );
    //     setPipelineCommand.addRequirements(this);
    //     Command rotateSwerveCommand = new TeleopSwerve(
    //         swerve, 
    //         false, 
    //         () -> getTranslation(distance)*-1, //translation
    //         () -> 0,//strafe
    //         () -> 0,//rotate
    //         () -> true//robotCentric.getAsBoolean()
    //         //.8=6ft 1.73=4ft .45=8ft
            
    //     );
        
    //     return setPipelineCommand.andThen(rotateSwerveCommand);
    // }
    //  public Command DriveAndAimAtApril(Swerve swerve, int id, int offset, DoubleSupplier translationSupplier, DoubleSupplier strafeSupplier, BooleanSupplier robotCentricSupplier)
    // {
    //     Command setPipelineCommand = this.runOnce(
    //         () -> pipeline.setDouble(id)
    //     );
    //     setPipelineCommand.addRequirements(this);
    //     Command rotateSwerveCommand = new TeleopSwerve(
    //         swerve, 
    //         false, 
    //         translationSupplier, 
    //         strafeSupplier,
    //         () -> getRotation(offset),//rotate
    //         robotCentricSupplier
            
    //     );
        
    //     return setPipelineCommand.andThen(rotateSwerveCommand);
    // }
    
}
