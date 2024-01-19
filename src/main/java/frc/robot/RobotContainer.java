// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.auto.NamedCommands;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.drivebase.SwerveState;
import frc.robot.subsystems.superstructure.SuperState;
import frc.robot.subsystems.superstructure.Superstructure;
import frc.robot.subsystems.superstructure.SuperstructureToState;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a "declarative" paradigm, very
 * little robot logic should actually be handled in the {@link Robot} periodic methods (other than the scheduler calls).
 * Instead, the structure of the robot (including subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer
{

  // The robot's subsystems and commands are defined here...
  public final Superstructure superstructure;
  // Replace with CommandPS4Controller or CommandJoystick if needed

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer()
  {
    superstructure = Superstructure.getInstance();
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary predicate, or via the
   * named factories in {@link edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller PS4}
   * controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight joysticks}.
   */
  private void configureBindings()
  {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
//    new Trigger(m_exampleSubsystem::exampleCondition)
//        .onTrue(new ExampleCommand(m_exampleSubsystem));
//
//    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
//    // cancelling on release.
//    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  private static boolean pathsetup = false;

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand()
  {
    if (!pathsetup)
    {
      NamedCommands.registerCommand("Ground Intake", Commands.deferredProxy(() -> {
        System.out.println("ground intake command run autonomously");
        return new SuperstructureToState(superstructure, SuperState.AUTO_GROUND_INTAKE).withTimeout(3);
      }));
      NamedCommands.registerCommand("Shoot Speaker",
                                    Commands.deferredProxy(() -> new SuperstructureToState(Superstructure.getInstance(),
                                                                                           SuperState.AUTO_SCORE_SPEAKER)));
      superstructure.m_drivebase.setupPathPlanner();
      pathsetup = true;
    }
    System.out.println("RUNNING AUTOOOO");
    // An example command will be run in autonomous
    return superstructure.m_drivebase.getAutonomousCommand("New Auto", false); //Autos.exampleAuto(m_exampleSubsystem);
  }
}
