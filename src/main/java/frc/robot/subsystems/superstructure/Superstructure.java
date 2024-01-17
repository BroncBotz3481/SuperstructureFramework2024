package frc.robot.subsystems.superstructure;

import frc.robot.subsystems.Climber.ClimberSubsystem;
import frc.robot.subsystems.Feeder.FeederSubsystem;
import frc.robot.subsystems.Intake.IntakeSubsystem;
import frc.robot.subsystems.Shooter.ShooterSubsystem;
import frc.robot.subsystems.LED.LEDSubsystem;

public class Superstructure {

    public final ClimberSubsystem m_climber;

    public final FeederSubsystem m_feeder;

    public final IntakeSubsystem m_intake;

    public final ShooterSubsystem m_shooter;

    public final LEDSubsystem m_LED;

    public SuperState m_prevState = SuperState.SAFE;

    private SuperState m_curState = SuperState.SAFE;



    public Superstructure(ClimberSubsystem climber, FeederSubsystem feeder, IntakeSubsystem intake, ShooterSubsystem shooter, LEDSubsystem LED) {
        m_climber = climber;
        m_feeder = feeder;
        m_intake = intake;
        m_shooter = shooter;
        m_LED= LED;
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


}



