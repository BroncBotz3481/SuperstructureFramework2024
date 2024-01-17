package frc.robot.subsystems.Climber;


import com.revrobotics.*;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DigitalInput;
import java.time.Instant;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

public class ClimberSubsystem extends SubsystemBase {

    private final CANSparkMax rightClimberMotor;
    private final CANSparkMax leftClimberMotor;
//    private final SparkMaxPIDController PIDController;
    private RelativeEncoder       rightEncoder;
    private RelativeEncoder       leftEncoder;
    private final DigitalInput lowerLimitSwitch;


    public ClimberSubsystem() {
        leftClimberMotor = new CANSparkMax(Constants.ClimberConstants.leftClimberMotorID, MotorType.kBrushless);
        rightClimberMotor = new CANSparkMax(Constants.ClimberConstants.rightClimberMotorID, MotorType.kBrushless);
        leftClimberMotor.restoreFactoryDefaults();
        rightClimberMotor.restoreFactoryDefaults();
//        PIDController = rightClimberMotor.getPIDController();
        leftClimberMotor.setInverted(true);
        leftClimberMotor.setIdleMode(IdleMode.kBrake);
        rightClimberMotor.setIdleMode(IdleMode.kBrake);
        leftEncoder.setPosition(0.0);
        rightEncoder.setPosition(0.0);
        rightEncoder = rightClimberMotor.getEncoder();
        leftEncoder = leftClimberMotor.getEncoder();
        lowerLimitSwitch = new DigitalInput(Constants.ClimberConstants.lowerID);
    }

    public void runRightMotor(double power) {
        runOnce(()-> {
            rightClimberMotor.set(power);
        });
    }

    public void runLeftMotor(double power) {
        runOnce(()-> {
            leftClimberMotor.set(power);
        });
    }

    public void stopRightMotor() {
        runOnce(()-> {
            rightClimberMotor.set(0);
        });
    }

    public void stopLeftMotor() {
        runOnce(()-> {
            leftClimberMotor.set(0);
        });
    }

    // Adds getter methods for the encoders
    public double getLeftEncoderPosition(){
        return leftEncoder.getPosition();
    }

    public double getRightEncoderPosition(){
        return rightEncoder.getPosition();
    }

    public enum ClimberState {
        RETRACTED(0),
        EXTENDED(100);

        public double height;

        private ClimberState(double height){
            this.height = height;
        }


    }

//    public void set(double p, double i, double d, double f, double iz)
//    {
//        PIDController.setP(p);
//        PIDController.setI(i);
//        PIDController.setD(d);
//        PIDController.setFF(f);
//        PIDController.setIZone(iz);
//    }
//
//    public void runPID(double targetPosition)
//    {
//        PIDController.setReference(targetPosition, ControlType.kPosition);
//    }

    public CommandBase setSpeed(double speed){
        return runOnce(()-> {
            rightClimberMotor.set(speed);
        });
    }

    public double getPosition(){
        return rightEncoder.getPosition();
    }


    @Override
    public void periodic()
    {

    }
}

