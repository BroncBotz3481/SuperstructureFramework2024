package frc.robot.subsystems.superstructure;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Climber.ClimberSubsystem;
import frc.robot.subsystems.Feeder.FeederSubsystem;
import frc.robot.subsystems.Intake.IntakeState;
import frc.robot.subsystems.Intake.IntakeSubsystem;
import frc.robot.subsystems.LED.LEDSubsystem;
import frc.robot.subsystems.Shooter.ShooterSubsystem;

import java.util.function.BooleanSupplier;

public class SuperstructureToState extends SequentialCommandGroup {
    private final Superstructure m_superstructure;
    private final SuperState m_targetState;

    private BooleanSupplier m_climberWait = () -> true;
    private BooleanSupplier m_feederWait = () -> true;
    private BooleanSupplier m_intakeWait = () -> true;

    private BooleanSupplier m_shooterWait = () -> true;

    public SuperstructureToState(Superstructure superstructure,SuperState targetState){
        m_superstructure = superstructure;
        m_targetState = targetState;

        ClimberSubsystem climber = superstructure.m_climber;
        FeederSubsystem feeder = superstructure.m_feeder;
        IntakeSubsystem intake = superstructure.m_intake;
        LEDSubsystem LED = superstructure.m_LED;
        ShooterSubsystem shooter = superstructure.m_shooter;


        CommandBase initCmd = Commands.runOnce(() -> {
            m_superstructure.updateState(m_targetState);
        });

        determineWaitConditions();

        CommandBase shooterCmd = Commands.waitUntil(m_shooterWait).andThen(superstructure.m_shooter.shootIt(m_targetState.shoot.speed));



        CommandBase feederCmd = Commands.waitUntil(m_feederWait).andThen(superstructure.m_feeder.setAngle(m_targetState.feed.angle));



        CommandBase intakeCmd = Commands.waitUntil(m_intakeWait).andThen(superstructure.m_intake.positionIntake((m_targetState.intake.position)));
    }

    void determineWaitConditions() {
        ClimberSubsystem climber = m_superstructure.m_climber;
        FeederSubsystem feeder = m_superstructure.m_feeder;
        IntakeSubsystem intake = m_superstructure.m_intake;
        ShooterSubsystem shooter = m_superstructure.m_shooter;

        if (m_targetState == SuperState.SCORE_SPEAKER) {
            m_shooterWait = () -> (feeder.getAngle() >= (m_targetState.feed.angle) && feeder.getBeamBrakeState()==true);
            m_feederWait = () -> (shooter.getSpeed() >= (m_targetState.shoot.speed));
        }
        if (m_targetState == SuperState.SCORE_AMP) {
            m_shooterWait = () -> (feeder.getAngle() >= (m_targetState.feed.angle) && feeder.getBeamBrakeState()==true);
            m_feederWait = () -> (shooter.getSpeed() >= (m_targetState.shoot.speed));
        }

        if (m_targetState == SuperState.SCORE_STAGE_PROTECTED) {
            m_shooterWait = () -> (feeder.getAngle() >= (m_targetState.feed.angle) && feeder.getBeamBrakeState()==true);
            m_feederWait = () -> (shooter.getSpeed() >= (m_targetState.shoot.speed));
        }

        if (m_targetState == SuperState.SOURCE_INTAKE) {
            m_shooterWait = () -> (feeder.getAngle() >= (m_targetState.feed.angle));
        }
        if (m_targetState == SuperState.GROUND_INTAKE) {
            m_intakeWait = () -> true;
        }

        if (m_targetState == SuperState.SAFE) {
            m_feederWait = () -> true;
            m_intakeWait = () ->  true;
            m_climberWait = () -> true;
        }

        if (m_targetState == SuperState.CLIMB_REACH) {
            m_climberWait = () -> (feeder.getAngle() >= (m_targetState.feed.angle)) && (intake.getIntakePistonPosition() == DoubleSolenoid.Value.kOff);
        }

    }

}
