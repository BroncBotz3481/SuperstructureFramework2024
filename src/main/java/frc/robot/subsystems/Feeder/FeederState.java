package frc.robot.subsystems.Feeder;

public class FeederState {
    public enum Feeder {
        MAXANGLE,
        MIDANGLE,
        MINANGLE;
    }
    private Feeder currentState;
    public FeederState() {
        currentState = Feeder.MINANGLE;
    }
    public Feeder getCurrentState() {
        return currentState;
    }
    public void setCurrentState(Feeder state) {
        this.currentState = state;
    }
}
