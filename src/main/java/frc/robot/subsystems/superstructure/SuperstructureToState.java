package frc.robot.subsystems.superstructure;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class SuperstructureToState extends SequentialCommandGroup {
    private final Superstructure m_superstructure;
    private final SuperState m_targetState;
    public SuperstructureToState(Superstructure superstructure,SuperState targetState){
        m_superstructure = superstructure;
        m_targetState = targetState;
    }


}
