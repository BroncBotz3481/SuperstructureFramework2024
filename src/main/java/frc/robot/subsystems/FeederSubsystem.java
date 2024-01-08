package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FeederSubsystem extends SubsystemBase {


    private final CANSparkMax leftLift;

    private final CANSparkMax rightLift;

    private final CANSparkMax leftFeeder;

    private final CANSparkMax rightFeeder;


    public FeederSubsystem() {

        leftLift = new CANSparkMax(Constants.FeederIDs.leftLiftID, CANSparkMaxLowLevel.MotorType.kBrushless);
        rightLift = new CANSparkMax(Constants.FeederIDs.rightLiftID, CANSparkMaxLowLevel.MotorType.kBrushless);
        leftLift.restoreFactoryDefaults();
        rightLift.restoreFactoryDefaults();
        leftLift.follow(rightLift);
        rightLift.setInverted(true);
        leftLift.setIdleMode(CANSparkMax.IdleMode.kBrake);
        rightLift.setIdleMode(CANSparkMax.IdleMode.kBrake);
        leftFeeder = new CANSparkMax(Constants.FeederIDs.leftFeederID, CANSparkMaxLowLevel.MotorType.kBrushless);
        rightFeeder = new CANSparkMax(Constants.FeederIDs.rightFeederID, CANSparkMaxLowLevel.MotorType.kBrushless);
        leftFeeder.restoreFactoryDefaults();
        rightFeeder.restoreFactoryDefaults();
        leftFeeder.follow(rightFeeder);
        rightFeeder.setInverted(true);
    }


    public void changeAngle(double power){
        rightLift.set(power);
    }

    public void run(double power){
        rightFeeder.set(power);
    }

    public enum FeederState{
        MAXANGLE,
        MIDANGLE,
        MINANGLE

    }


}

