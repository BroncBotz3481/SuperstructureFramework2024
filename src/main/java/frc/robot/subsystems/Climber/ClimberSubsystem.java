package frc.robot.subsystems.Climber;


import com.revrobotics.*;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.sun.org.apache.xml.internal.dtm.DTMIterator;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotBase;
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


    public ClimberSubsystem() {
        leftClimberMotor = new CANSparkMax(Constants.ClimberConstants.leftClimberMotorID, MotorType.kBrushless);
        rightClimberMotor = new CANSparkMax(Constants.ClimberConstants.rightClimberMotorID, MotorType.kBrushless);
        leftClimberMotor.restoreFactoryDefaults();
        rightClimberMotor.restoreFactoryDefaults();
//        PIDController = rightClimberMotor.getPIDController();
        leftClimberMotor.follow(rightClimberMotor);
        rightClimberMotor.setInverted(true);
        leftClimberMotor.setIdleMode(IdleMode.kBrake);
        rightClimberMotor.setIdleMode(IdleMode.kBrake);
        leftEncoder.setPosition(0.0);
        rightEncoder.setPosition(0.0);
        rightEncoder = rightClimberMotor.getEncoder();
        leftEncoder = leftClimberMotor.getEncoder();
    }


    public void run(double power){
        rightClimberMotor.set(power);
    }

    public void stop() {
        rightClimberMotor.set(0);
    }

    public void climbUp(){
        rightClimberMotor.set(1.0);
    }

    public void climbDown(){
        rightClimberMotor.set(-1.0);
    }

    public void climbAtSpeed(){
        rightClimberMotor.set(1.0);
    }

    // Adds getter methods for the encoders
    public double getLeftEncoderPosition(){
        return leftEncoder.getPosition();
    }

    public double getRightEncoderPosition(){
        return rightEncoder.getPosition();
    }

    public void driveToTarget() {

    }

    /*public void set(double p, double i, double d, double f, double iz)
    {
        PIDController.setP(p);
        PIDController.setI(i);
        PIDController.setD(d);
        PIDController.setFF(f);
        PIDController.setIZone(iz);
    }

    public void runPID(double targetPosition)
    {
        PIDController.setReference(targetPosition, ControlType.kPosition);
    }
     */

    public enum ClimberState{
        RETRACTED,
        EXTENDED;
    }

    @Override
    public void periodic()
    {

    }



}

