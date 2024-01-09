package frc.robot.commands.Climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber.ClimberSubsystem;

public class ControlClimberCmd extends CommandBase {

    private final ClimberSubsystem climberSubsystem;

    public ControlClimberCmd(ClimberSubsystem climberSubsystem) {
        this.climberSubsystem = climberSubsystem;
        addRequirements(this.climberSubsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        // Example of running the climber at a constant speed
        this.climberSubsystem.run(0.5);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        this.climberSubsystem.stop();
    }
}