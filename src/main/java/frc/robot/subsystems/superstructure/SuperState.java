package frc.robot.subsystems.superstructure;

public enum SuperState {

    /*
    States of Subsystems
    Intake - RETRACTED/EXTENDED
    Feeder - MAXANGLE/MIDANGLE/MINANGLE
    Shooter - ACTIVE/DISABLED
    Climber - RETRACTED/EXTENDED
     */
    SAFE(0,
        IntakeState.RETRACTED, FeederState.MINANGLE, ShooterState.DISABLED, ClimberState.RETRACTED),
    GROUND_INTAKE(1,
            IntakeState.EXTENDED, FeederState.MINANGLE, ShooterState.DISABLED, ClimberState.RETRACTED),
    SOURCE_INTAKE(2,
            IntakeState.RETRACTED, FeederState.MAXANGLE, ShooterState.ACTIVE, ClimberState.RETRACTED),
    SCORE_AMP(3,
            IntakeState.RETRACTED, FeederState.MINANGLE, ShooterState.ACTIVE, ClimberState.RETRACTED),
    SCORE_SPEAKER(4,
            IntakeState.RETRACTED, FeederState.MAXANGLE, ShooterState.ACTIVE, ClimberState.RETRACTED),
    SCORE_STAGE_PROTECTED(5,
            IntakeState.RETRACTED, FeederState.MIDANGLE, ShooterState.ACTIVE, ClimberState.RETRACTED),
    CLIMB_REACH(6,
            IntakeState.RETRACTED, FeederState.MINANGLE, ShooterState.DISABLED, ClimberState.RETRACTED);
}
