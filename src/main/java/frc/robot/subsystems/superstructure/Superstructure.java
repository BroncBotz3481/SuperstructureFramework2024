package frc.robot.subsystems.superstructure;

import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.FeederSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.LEDSubsystem;

public class Superstructure {

    private final ClimberSubsystem m_climber;

    private final FeederSubsystem m_feeder;

    private final IntakeSubsystem m_intake;

    private final ShooterSubsystem m_shooter;

    private final LEDSubsystem m_LED;

    public Superstructure(ClimberSubsystem climber, FeederSubsystem feeder, IntakeSubsystem intake, ShooterSubsystem shooter, LEDSubsystem LED) {
        m_climber = climber;
        m_feeder = feeder;
        m_intake = intake;
        m_shooter = shooter;
        m_LED= LED;
    }




}
