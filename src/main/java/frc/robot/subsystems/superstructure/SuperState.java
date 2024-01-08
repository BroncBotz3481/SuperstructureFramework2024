package frc.robot.subsystems.superstructure;

import frc.robot.subsystems.IntakeSubsystem.IntakeState;
import frc.robot.subsystems.FeederSubsystem.FeederState;
import frc.robot.subsystems.ShooterSubsystem.ShooterState;
import frc.robot.subsystems.ClimberSubsystem.ClimberState;


public enum SuperState {

    /*
    States of Subsystems
    Intake - RETRACTED/EXTENDED
    Feeder - MAXANGLE/MIDANGLE/MINANGLE
    Shooter - HIGHPOWER, MIDPOWER, LOWPOWER, REVERSEDINTAKE, OFF
    Climber - RETRACTED/EXTENDED
     */
    SAFE(0,
        IntakeState.RETRACTED, FeederState.MINANGLE, ShooterState.OFF, ClimberState.RETRACTED),
    GROUND_INTAKE(1,
            IntakeState.EXTENDED, FeederState.MINANGLE, ShooterState.OFF, ClimberState.RETRACTED),
    SOURCE_INTAKE(2,
            IntakeState.RETRACTED, FeederState.MAXANGLE, ShooterState.REVERSEDINTAKE, ClimberState.RETRACTED),
    SCORE_AMP(3,
            IntakeState.RETRACTED, FeederState.MINANGLE, ShooterState.LOWPOWER, ClimberState.RETRACTED),
    SCORE_SPEAKER(4,
            IntakeState.RETRACTED, FeederState.MAXANGLE, ShooterState.MIDPOWER, ClimberState.RETRACTED),
    SCORE_STAGE_PROTECTED(5,
            IntakeState.RETRACTED, FeederState.MIDANGLE, ShooterState.HIGHPOWER, ClimberState.RETRACTED),
    CLIMB_REACH(6,
            IntakeState.RETRACTED, FeederState.MINANGLE, ShooterState.OFF, ClimberState.RETRACTED);

    public final int idx;
    public final IntakeState intake;
    public final FeederState feed;
    public final ShooterState shoot;
    public final ClimberState climb;

    private SuperState(int idx, IntakeState intake, FeederState feed, ShooterState shoot, ClimberState climb){
        this.idx = idx;
        this.intake = intake;
        this.feed = feed;
        this.shoot = shoot;
        this.climb = climb;
    }
}
