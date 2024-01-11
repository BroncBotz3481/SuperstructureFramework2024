package frc.robot.subsystems.Intake;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DigitalInput;

public class IntakeSubsystem extends SubsystemBase {

    private final CANSparkMax intakeMotor;

    private final DoubleSolenoid intakePiston;

    public static final DoubleSolenoid.Value intakePistonDownPosition = Value.kReverse;

    public static final DoubleSolenoid.Value intakePistonUpPosition = Value.kForward;


    public IntakeSubsystem() {
        intakeMotor = new CANSparkMax(Constants.IntakeConstants.intakeMotorID, CANSparkMaxLowLevel.MotorType.kBrushless);
        intakeMotor.restoreFactoryDefaults();
        intakeMotor.setIdleMode(CANSparkMax.IdleMode.kBrake);
        intakeMotor.setInverted(false);
        intakePiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,Constants.IntakeConstants.forwardChannelID, Constants.IntakeConstants.reverseChannelID);
    }

    public void run(double power){
        intakeMotor.set(power);
    }
    public void stop() {
        intakeMotor.set(0);
    }

    public enum IntakeState{
        RETRACTED,
        EXTENDED
    }

    public void drop() {
        intakePiston.set(intakePistonDownPosition);
    }

    public void raise() {
        intakePiston.set(intakePistonUpPosition);

    }

    public void toggle() {
        intakePiston.toggle();
    }

    public DoubleSolenoid.Value getIntakePistonPosition(){
        return intakePiston.get();
    }

    @Override
    public void periodic()
    {

    }
}

