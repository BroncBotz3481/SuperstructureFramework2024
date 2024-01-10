package frc.robot.subsystems.Intake;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DigitalInput;

public class IntakeSubsystem extends SubsystemBase {

    private final CANSparkMax intakeMotor;

    public IntakeSubsystem() {
        intakeMotor = new CANSparkMax(Constants.IntakeConstants.intakeMotorID, CANSparkMaxLowLevel.MotorType.kBrushless);
        intakeMotor.restoreFactoryDefaults();
        intakeMotor.setIdleMode(CANSparkMax.IdleMode.kBrake);
        intakeMotor.setInverted(false);
    }

    public void run(double power){
        intakeMotor.set(power);
    }
    public void stop() {
        intakeMotor.set(0);
    }

    public void spin(){
        intakeMotor.set(1);
    }
    public void spit(){
        intakeMotor.set(-1);
    }

    public enum IntakeState{
        RETRACTED,
        EXTENDED
    }

    @Override
    public void periodic()
    {

    }
}

