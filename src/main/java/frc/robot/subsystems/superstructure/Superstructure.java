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

    /**
     * The Singleton instance of this swerevSubsystem. Code should use the {@link #getInstance()} method to get the single
     * instance (rather than trying to construct an instance of this class.)
     */
    private static Superstructure INSTANCE;

    /**
     * Returns the Singleton instance of this swerevSubsystem. This static method should be used, rather than the
     * constructor, to get the single instance of this class. For example: {@code swerevSubsystem.getInstance();}
     */
    @SuppressWarnings("WeakerAccess")
    public static Superstructure getInstance()
    {
        if (INSTANCE == null)
        {
            SwerveSubsystem drivebase = SwerveSubsystem.getInstance();
            ClimberSubsystem climber = new ClimberSubsystem();
            FeederSubsystem feeder = new FeederSubsystem();
            IntakeSubsystem intake = new IntakeSubsystem();
            ShooterSubsystem shooter = new ShooterSubsystem();
            ElevatorSubsystem elevator = new ElevatorSubsystem();
            LEDSubsystem LED = new LEDSubsystem();
            INSTANCE = new Superstructure(climber, feeder, intake, shooter, elevator, LED, drivebase);
        }
        return INSTANCE;
    }
    public final ClimberSubsystem m_climber;

    public final FeederSubsystem m_feeder;

    public final IntakeSubsystem m_intake;

    public final ShooterSubsystem m_shooter;

    public final ElevatorSubsystem m_elevator;

    public final SwerveSubsystem m_drivebase;

    public final LEDSubsystem m_LED;

    public SuperState m_prevState = SuperState.SAFE;

    private SuperState m_curState = SuperState.SAFE;



    private Superstructure(ClimberSubsystem climber, FeederSubsystem feeder, IntakeSubsystem intake, ShooterSubsystem shooter, ElevatorSubsystem elevator, LEDSubsystem LED, SwerveSubsystem drivebase) {
        m_climber = climber;
        m_feeder = feeder;
        m_intake = intake;
        m_shooter = shooter;
        m_elevator = elevator;
        m_LED= LED;
        m_drivebase = drivebase;

        m_climber.setDefaultCommand(m_climber.setHeight(ClimberSubsystem.ClimberState.EXTENDED.height));
        m_feeder.setDefaultCommand(m_feeder.setSpeed(FeederSubsystem.FeederState.OFF.power));
        m_intake.setDefaultCommand(m_intake.positionIntake(IntakeSubsystem.IntakeState.RETRACTED.position));
        m_shooter.setDefaultCommand(m_shooter.shootIt(ShooterSubsystem.ShooterState.OFF.speed));
        m_elevator.setDefaultCommand(m_elevator.setAngle(ElevatorSubsystem.ElevatorState.MINANGLE.angle));
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

    public static Command toSuperState(SuperState state)
    {
        return Commands.deferredProxy(() -> new SuperstructureToState(Superstructure.INSTANCE, state));
    }


}



