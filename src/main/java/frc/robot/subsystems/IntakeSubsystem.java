package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {

    private final CANSparkMax IntakeMotor;
    private final static IntakeSubsystem INSTANCE = new IntakeSubsystem();


    @SuppressWarnings("WeakerAccess")
    public static IntakeSubsystem getInstance() {
        return INSTANCE;
    }



    public IntakeSubsystem() {
        IntakeMotor = new CANSparkMax(Constants.IntakeIDs.intakeMotorID, CANSparkMaxLowLevel.MotorType.kBrushless);
        IntakeMotor.restoreFactoryDefaults();
        IntakeMotor.setIdleMode(CANSparkMax.IdleMode.kBrake);
        IntakeMotor.setInverted(false);
    }

    public enum IntakeState{
        RETRACTED,
        EXTENDED
    }

    public void run(double power){
        IntakeMotor.set(power);
    }
    public void stop() {
        IntakeMotor.set(0);
    }
}

