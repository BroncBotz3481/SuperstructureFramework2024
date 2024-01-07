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

public class ClimberSubsystem extends SubsystemBase {

    // With eager singleton initialization, any static variables/fields used in the 
    // constructor must appear before the "INSTANCE" variable so that they are initialized 
    // before the constructor is called when the "INSTANCE" variable initializes.

    /**
     * The Singleton instance of this ClimberSubsystem. Code should use
     * the {@link #getInstance()} method to get the single instance (rather
     * than trying to construct an instance of this class.)
     */
    private final static ClimberSubsystem INSTANCE = new ClimberSubsystem();

    /**
     * Returns the Singleton instance of this ClimberSubsystem. This static method
     * should be used, rather than the constructor, to get the single instance
     * of this class. For example: {@code ClimberSubsystem.getInstance();}
     */
    @SuppressWarnings("WeakerAccess")
    public static ClimberSubsystem getInstance() {
        return INSTANCE;
    }

    /**
     * Creates a new instance of this ClimberSubsystem. This constructor
     * is private since this class is a Singleton. Code should use
     * the {@link #getInstance()} method to get the singleton instance.
     */
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
        leftClimberMotor = new CANSparkMax(0, MotorType.kBrushless);
        rightClimberMotor = new CANSparkMax(1, MotorType.kBrushless);
        leftClimberMotor.restoreFactoryDefaults();
        rightClimberMotor.restoreFactoryDefaults();
        PIDController = rightClimberMotor.getPIDController();
        leftClimberMotor.follow(rightClimberMotor);
        leftClimberMotor.setInverted(true);
        leftClimberMotor.setIdleMode(IdleMode.kBrake);
        rightClimberMotor.setIdleMode(IdleMode.kBrake);
        rightEncoder = rightClimberMotor.getEncoder();
        leftEncoder = leftClimberMotor.getEncoder();
    }
}

