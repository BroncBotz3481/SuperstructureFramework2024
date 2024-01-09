package frc.robot.subsystems.Shooter;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
    private final CANSparkMax leftShooter;
    private final CANSparkMax rightShooter;

    public ShooterSubsystem() {
        leftShooter = new CANSparkMax(Constants.ShooterConstants.leftShooterID, CANSparkMaxLowLevel.MotorType.kBrushless);
        rightShooter = new CANSparkMax(Constants.ShooterConstants.rightShooterID, CANSparkMaxLowLevel.MotorType.kBrushless);
        leftShooter.restoreFactoryDefaults();
        rightShooter.restoreFactoryDefaults();
        leftShooter.follow(rightShooter);
        rightShooter.setInverted(true);
        leftShooter.setIdleMode(CANSparkMax.IdleMode.kBrake);
        rightShooter.setIdleMode(CANSparkMax.IdleMode.kBrake);
    }


    public enum ShooterState{
        HIGHPOWER,
        MIDPOWER,
        LOWPOWER,
        REVERSEDINTAKE,
        OFF
    }
    public void run(double power){
        rightShooter.set(power);
    }
    public void stop() {
        rightShooter.set(0);
    }

    @Override
    public void periodic()
    {

    }

}
