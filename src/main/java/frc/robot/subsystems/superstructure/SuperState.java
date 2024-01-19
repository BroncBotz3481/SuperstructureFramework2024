package frc.robot.subsystems.superstructure;

import frc.robot.subsystems.Elevator.ElevatorSubsystem.ElevatorState;
import frc.robot.subsystems.Intake.IntakeSubsystem.IntakeState;
import frc.robot.subsystems.Feeder.FeederSubsystem.FeederState;
import frc.robot.subsystems.Shooter.ShooterSubsystem.ShooterState;
import frc.robot.subsystems.Climber.ClimberSubsystem.ClimberState;
import frc.robot.subsystems.drivebase.SwerveSubsystem.SwerveState;


public enum SuperState {

    /*
    States of Subsystems
    Intake - RETRACTED/EXTENDED
    Elevator - MAXANGLE/MIDANGLE/MINANGLE
    Feeder - FORWARD, OFF, REVERSE
    Shooter - HIGHPOWER, MIDPOWER, LOWPOWER, REVERSEDINTAKE, OFF
    Climber - RETRACTED/EXTENDED
     */
    SAFE(0,
        IntakeState.RETRACTED, FeederState.OFF, ElevatorState.MINANGLE, ShooterState.OFF, ClimberState.RETRACTED, SwerveState.SAFE),
    GROUND_INTAKE(1,
            IntakeState.EXTENDED, FeederState.FORWARD, ElevatorState.MINANGLE, ShooterState.OFF, ClimberState.RETRACTED),
    SOURCE_INTAKE(2,
            IntakeState.RETRACTED, FeederState.OFF, ElevatorState.MAXANGLE, ShooterState.REVERSEDINTAKE, ClimberState.RETRACTED),
    SCORE_AMP(3,
            IntakeState.RETRACTED, FeederState.FORWARD, ElevatorState.MINANGLE, ShooterState.LOWPOWER, ClimberState.RETRACTED),
    SCORE_SPEAKER(4,
            IntakeState.RETRACTED, FeederState.FORWARD, ElevatorState.MAXANGLE, ShooterState.MIDPOWER, ClimberState.RETRACTED),
    SCORE_STAGE_PROTECTED(5,
            IntakeState.RETRACTED, FeederState.FORWARD, ElevatorState.MIDANGLE, ShooterState.HIGHPOWER, ClimberState.RETRACTED),

    CLIMB_REACH(6,
            IntakeState.RETRACTED, FeederState.OFF, ElevatorState.MINANGLE, ShooterState.OFF, ClimberState.EXTENDED),
    AUTO(7,         IntakeState.RETRACTED, FeederState.OFF, ElevatorState.MINANGLE, ShooterState.OFF, ClimberState.RETRACTED, SwerveState.AUTO);


    public final int idx;
    public final IntakeState intake;
    public final FeederState feed;

    public final ElevatorState elevator;
    public final ShooterState shoot;
    public final ClimberState climb;
    public final SwerveState drivebase;

    private SuperState(int idx, IntakeState intake, FeederState feed, ElevatorState elevator, ShooterState shoot, ClimberState climb, SwerveState drivebase){
        this.idx = idx;
        this.intake = intake;
        this.feed = feed;
        this.elevator = elevator;
        this.shoot = shoot;
        this.climb = climb;
        this.drivebase = drivebase;
    }

    private SuperState(int idx, IntakeState intake, FeederState feed, ElevatorState elevator, ShooterState shoot, ClimberState climb){
        this(idx, intake, feed, elevator, shoot, climb, SwerveState.SAFE);
    }
}
