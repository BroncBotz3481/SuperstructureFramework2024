package frc.robot.subsystems;


import com.revrobotics.*;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberSubsystem extends SubsystemBase {

    private final CANSparkMax rightClimberMotor;
    private final SparkMaxPIDController PIDController;
    private final RelativeEncoder       rightEncoder;
    private final RelativeEncoder       leftEncoder;
    public ClimberSubsystem() {
        CANSparkMax leftClimberMotor = new CANSparkMax(Constants.ClimberIDs.leftClimberMotorID, MotorType.kBrushless);
        rightClimberMotor = new CANSparkMax(Constants.ClimberIDs.rightClimberMotorID, MotorType.kBrushless);
        leftClimberMotor.restoreFactoryDefaults();
        rightClimberMotor.restoreFactoryDefaults();
        PIDController = rightClimberMotor.getPIDController();
        rightClimberMotor.follow(leftClimberMotor);
        leftClimberMotor.setInverted(true);
        leftClimberMotor.setIdleMode(IdleMode.kBrake);
        rightClimberMotor.setIdleMode(IdleMode.kBrake);
        rightEncoder = rightClimberMotor.getEncoder();
        leftEncoder = leftClimberMotor.getEncoder();
    }

    public void run(double power){
        rightClimberMotor.set(power);
    }

    public enum ClimberState{
        RETRACTED,
        EXTENDED;
    }


}

