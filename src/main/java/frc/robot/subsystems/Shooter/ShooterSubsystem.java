package frc.robot.subsystems.Shooter;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj.DigitalInput;


public class ShooterSubsystem extends SubsystemBase {
    private final CANSparkMax leftShooter;
    private final CANSparkMax rightShooter;
    private final SparkMaxPIDController PIDController;
    private final RelativeEncoder rightEncoder;
    private final RelativeEncoder leftEncoder;


    public ShooterSubsystem() {
        leftShooter = new CANSparkMax(Constants.ShooterConstants.leftShooterID, CANSparkMaxLowLevel.MotorType.kBrushless);
        rightShooter = new CANSparkMax(Constants.ShooterConstants.rightShooterID, CANSparkMaxLowLevel.MotorType.kBrushless);
        leftShooter.restoreFactoryDefaults();
        rightShooter.restoreFactoryDefaults();
        leftShooter.follow(rightShooter);
        rightShooter.setInverted(true);
        leftShooter.setIdleMode(CANSparkMax.IdleMode.kBrake);
        rightShooter.setIdleMode(CANSparkMax.IdleMode.kBrake);
        rightEncoder = rightShooter.getEncoder();
        leftEncoder = leftShooter.getEncoder();
        PIDController = rightShooter.getPIDController();
        PIDController.setFeedbackDevice(rightEncoder);
        set(PIDF.PROPORTION, PIDF.INTEGRAL, PIDF.DERIVATIVE,
                PIDF.FEEDFORWARD, PIDF.INTEGRAL_ZONE);
    }

    public static class PIDF
    {

        /**
         * Feedforward constant for PID loop
         */
        public static final double FEEDFORWARD   = 0.01;
        /**
         * Proportion constant for PID loop
         */
        public static final double PROPORTION    = 0.05;
        /**
         * Integral constant for PID loop
         */
        public static final double INTEGRAL      = 0.0;
        /**
         * Derivative constant for PID loop
         */
        public static final double DERIVATIVE    = 0.0;
        /**
         * Integral zone constant for PID loop
         */
        public static final double INTEGRAL_ZONE = 0.0;
    }

    public enum ShooterState{
        HIGHPOWER,
        MIDPOWER,
        LOWPOWER,
        REVERSEDINTAKE,
        OFF
    }

    public void run(double power){
        runOnce(()-> {
            rightShooter.set(power);;
        });
    }
    public void stop() {
        runOnce(()-> {
            rightShooter.set(0);;
        });
    }

    public void set(double p, double i, double d, double f, double iz)
    {
        PIDController.setP(p);
        PIDController.setI(i);
        PIDController.setD(d);
        PIDController.setFF(f);
        PIDController.setIZone(iz);
    }

    public void runPID(double targetSpeed)
    {
        PIDController.setReference(targetSpeed, CANSparkMax.ControlType.kVelocity);
    }

    public void highPwr(){
        runOnce(()-> {
            rightShooter.set(1.0);;
        });
    }
    public void midPwr(){
        runOnce(()-> {
            rightShooter.set(0.7);;
        });
    }
    public void lowPwr(){
        runOnce(()-> {
            rightShooter.set(0.4);;
        });
    }
    public void reverse(){
        runOnce(()-> {
            rightShooter.set(-0.2);;
        });
    }
    @Override
    public void periodic()
    {
        //encoderVelocity = shooterMotorRight.getSelectedSensorVelocity(pidIdx.PRIMARY.ordinal());
    }

}

