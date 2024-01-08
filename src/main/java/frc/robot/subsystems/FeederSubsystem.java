package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FeederSubsystem extends SubsystemBase {

    private final CANSparkMax leftLift;
    private final CANSparkMax rightLift;
    private final CANSparkMax feederMotor;

    public FeederSubsystem() {
        leftLift = new CANSparkMax(Constants.FeederIDs.leftLiftID, CANSparkMaxLowLevel.MotorType.kBrushless);
        rightLift = new CANSparkMax(Constants.FeederIDs.rightLiftID, CANSparkMaxLowLevel.MotorType.kBrushless);
        leftLift.restoreFactoryDefaults();
        rightLift.restoreFactoryDefaults();
        leftLift.follow(rightLift);
        rightLift.setInverted(true);
        leftLift.setIdleMode(CANSparkMax.IdleMode.kBrake);
        rightLift.setIdleMode(CANSparkMax.IdleMode.kBrake);
        feederMotor = new CANSparkMax(Constants.FeederIDs.leftFeederID, CANSparkMaxLowLevel.MotorType.kBrushless);
        feederMotor.restoreFactoryDefaults();
        feederMotor.setIdleMode(CANSparkMax.IdleMode.kBrake);
    }


    public void changeAngle(double liftPower){
        rightLift.set(liftPower);
    }

    public void run(double fPower){
        feederMotor.set(fPower);
    }
    public void stop() {
        feederMotor.set(0);
    }

    public enum FeederState{
        MAXANGLE,
        MIDANGLE,
        MINANGLE
    }


}

