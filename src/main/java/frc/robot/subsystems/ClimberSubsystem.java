package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.REVPhysicsSim;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberSubsystem extends SubsystemBase {

    private final CANSparkMax leftClimberMotor;
    private final CANSparkMax rightClimberMotor;
    private final SparkMaxPIDController PIDController;
    private final RelativeEncoder       rightEncoder;
    private final RelativeEncoder       leftEncoder;
    public ClimberSubsystem() {
        // TODO: Set the default command, if any, for this subsystem by calling setDefaultCommand(command)
        //       in the constructor or in the robot coordination class, such as RobotContainer.
        //       Also, you can call addChild(name, sendableChild) to associate sendables with the subsystem
        //       such as SpeedControllers, Encoders, DigitalInputs, etc.
        leftClimberMotor = new CANSparkMax(Constants.ClimberIDs.leftClimberMotorID, MotorType.kBrushless);
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

