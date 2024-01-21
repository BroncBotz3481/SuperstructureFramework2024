package frc.robot.subsystems.superstructure;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Climber.ClimberSubsystem;
import frc.robot.subsystems.Elevator.ElevatorSubsystem;
import frc.robot.subsystems.Feeder.FeederSubsystem;
import frc.robot.subsystems.Intake.IntakeSubsystem;
import frc.robot.subsystems.Shooter.ShooterSubsystem;
import frc.robot.subsystems.LED.LEDSubsystem;
import frc.robot.subsystems.drivebase.SwerveSubsystem;
import frc.robot.subsystems.drivebase.SwerveState;

public class Superstructure {


    public final ClimberSubsystem m_climber;

    public final FeederSubsystem m_feeder;

    public final IntakeSubsystem m_intake;

    public final ShooterSubsystem m_shooter;

    public final ElevatorSubsystem m_elevator;

    public final SwerveSubsystem m_drivebase;

    public final LEDSubsystem m_LED;

    public SuperState m_prevState = SuperState.SAFE;

    private SuperState m_curState = SuperState.SAFE;



    public Superstructure() {


        m_drivebase = SwerveSubsystem.getInstance();
        m_climber = new ClimberSubsystem();
        m_feeder = new FeederSubsystem();
        m_intake = new IntakeSubsystem();
        m_shooter = new ShooterSubsystem();
        m_elevator = new ElevatorSubsystem();
        m_LED = new LEDSubsystem();
//
//        m_climber.setDefaultCommand(m_climber.setHeight(ClimberSubsystem.ClimberState.EXTENDED.height));
//        m_feeder.setDefaultCommand(m_feeder.setSpeed(FeederSubsystem.FeederState.OFF.power));
//        m_intake.setDefaultCommand(m_intake.positionIntake(IntakeSubsystem.IntakeState.RETRACTED.position));
//        m_shooter.setDefaultCommand(m_shooter.shootIt(ShooterSubsystem.ShooterState.OFF.speed));
//        m_elevator.setDefaultCommand(m_elevator.setAngle(ElevatorSubsystem.ElevatorState.MINANGLE.angle));
        m_drivebase.setDefaultCommand(SwerveState.getDriveState().command);

    }

    protected void updateState(SuperState newState) {
        System.out.println(
                "[SS] updateState - WAS " + m_prevState +
                        ", FROM " + m_curState +
                        " TO " + newState);
        m_prevState = m_curState;
        m_curState = newState;
    }

    public SuperState getPrevState() {
        return m_prevState;
    }

    public SuperState getCurState() {
        return m_curState;
    }

    //! LEAVING THIS AS AN EXAMPLE OF OMAR'S WAY TO DO IT
//    public static Command toSuperState(SuperState state)
//    {
//        return Commands.deferredProxy(() -> new SuperstructureToState(Superstructure.INSTANCE, state));
//    }

    public Command toState(SuperState state) {
        return new SuperstructureToState(this, state);
    }
}



