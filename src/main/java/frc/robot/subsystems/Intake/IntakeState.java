package frc.robot.subsystems.Intake;

public class IntakeState {
    public enum Intake {
        RETRACTED,
        EXTENDED;
    }
    private Intake currentState;
    public IntakeState() {
        currentState = Intake.RETRACTED;
    }
    public Intake getCurrentState() {
        return currentState;
    }
    public void setCurrentState(Intake state) {
        this.currentState = state;
    }
}
