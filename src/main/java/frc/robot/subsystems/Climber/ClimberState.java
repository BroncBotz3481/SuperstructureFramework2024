package frc.robot.subsystems.Climber;

public class ClimberState {

    public enum Climber {
        RETRACTED,
        EXTENDED;
    }

    private Climber currentState;

    public ClimberState() {
        currentState = Climber.RETRACTED;
    }

    public Climber getCurrentState() {
        return currentState;
    }

    public void setCurrentState(Climber state) {
        this.currentState = state;
    }
}