package frc.robot.subsystems.Feeder;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter.ShooterSubsystem;

public class FeederSubsystem extends SubsystemBase {

    private final CANSparkMax leftLift;

    private final CANSparkMax rightLift;

    private final CANSparkMax feederMotor;

    private final SparkMaxPIDController PIDController;
    private final RelativeEncoder rightEncoder;
    private final RelativeEncoder leftEncoder;
    private final DigitalInput limitSwitchBeamBrake;
    private final DigitalInput limitSwitchLATop;
    private final DigitalInput limitSwitchLABottom;


    public FeederSubsystem() {
        leftLift = new CANSparkMax(Constants.FeederConstants.leftLiftID, CANSparkMaxLowLevel.MotorType.kBrushless);
        rightLift = new CANSparkMax(Constants.FeederConstants.rightLiftID, CANSparkMaxLowLevel.MotorType.kBrushless);
        leftLift.restoreFactoryDefaults();
        rightLift.restoreFactoryDefaults();
        leftLift.follow(rightLift);
        rightLift.setInverted(true);
        leftLift.setIdleMode(CANSparkMax.IdleMode.kBrake);
        rightLift.setIdleMode(CANSparkMax.IdleMode.kBrake);
        feederMotor = new CANSparkMax(Constants.FeederConstants.feederMotorID, CANSparkMaxLowLevel.MotorType.kBrushless);
        feederMotor.restoreFactoryDefaults();
        feederMotor.setIdleMode(CANSparkMax.IdleMode.kBrake);
        limitSwitchBeamBrake = new DigitalInput(Constants.FeederConstants.limitSwitchBeanBrakeChannel);
        limitSwitchLATop = new DigitalInput(Constants.FeederConstants.limitSwitchLATop);
        limitSwitchLABottom = new DigitalInput(Constants.FeederConstants.limitSwitchLABottom);
        rightEncoder = rightLift.getEncoder();
        leftEncoder = leftLift.getEncoder();
        PIDController = rightLift.getPIDController();
        PIDController.setFeedbackDevice(rightEncoder);
        set(ShooterSubsystem.PIDF.PROPORTION, ShooterSubsystem.PIDF.INTEGRAL, ShooterSubsystem.PIDF.DERIVATIVE,
                ShooterSubsystem.PIDF.FEEDFORWARD, ShooterSubsystem.PIDF.INTEGRAL_ZONE);
    }

    public static class PIDF {

        /**
         * Feedforward constant for PID loop
         */
        public static final double FEEDFORWARD = 0.01;
        /**
         * Proportion constant for PID loop
         */
        public static final double PROPORTION = 0.05;
        /**
         * Integral constant for PID loop
         */
        public static final double INTEGRAL = 0.0;
        /**
         * Derivative constant for PID loop
         */
        public static final double DERIVATIVE = 0.0;
        /**
         * Integral zone constant for PID loop
         */
        public static final double INTEGRAL_ZONE = 0.0;
    }


    public void changeAngle(double liftPower) {
        runOnce(() -> {
            rightLift.set(liftPower);
        });
    }


    public void run(double fPower) {
        runOnce(() -> {
            feederMotor.set(fPower);
        });
    }

    public void runLA(double LAPower) {
        runOnce(() -> {
            rightLift.set(LAPower);
        });
    }

    public void stopFeeder() {
        runOnce(() -> {
            feederMotor.set(0);
        });
    }

    public void reverseFeeder() {
        runOnce(() -> {
            feederMotor.set(-1);
        });
    }

    public void runPID(double targetPosition)
    {
        PIDController.setReference(targetPosition, CANSparkMax.ControlType.kPosition);
    }


    public void set(double p, double i, double d, double f, double iz)
    {
        PIDController.setP(p);
        PIDController.setI(i);
        PIDController.setD(d);
        PIDController.setFF(f);
        PIDController.setIZone(iz);
    }

    public CommandBase setAngle(double degrees){
        return runOnce(() -> {
            runPID(degrees);
        });
    }

    public enum FeederState {
        MAXANGLE(80),
        MIDANGLE(50),
        MINANGLE(30);

        public double angle;

        private FeederState(double angle){
            this.angle = angle;
        }
    }

    public double getAngle(){
        return rightEncoder.getPosition()*360;
    }

    public boolean getBeamBrakeState(){
        limitSwitchBeamBrake.get();
    }


    @Override
    public void periodic() {

    }

}

