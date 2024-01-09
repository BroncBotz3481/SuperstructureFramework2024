package frc.robot.subsystems.Shooter;

public class ShooterState {
    public enum Shooter {
        HIGHPOWER,
        MIDPOWER,
        LOWPOWER,
        REVERSEDINTAKE,
        OFF;
    }
    private Shooter currentState;
    public ShooterState() {
        currentState = Shooter.OFF;
    }
    public Shooter getCurrentState() {
        return currentState;
    }
    public void setCurrentState(Shooter state) {
        this.currentState = state;
    }
}
