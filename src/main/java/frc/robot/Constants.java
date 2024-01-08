// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;





  }
  public static class ClimberConstants {
    public static final int leftClimberMotorID = 26;
    public static final int rightClimberMotorID = 27;
  }
  public static class FeederConstants {
    public static final int leftLiftID = 0;
    public static final int rightLiftID = 1;
    public static final int leftFeederID = 25;
    public static final int rightFeederID = 24;
    public static final int limitSwitchChannel = 31;
  }

  public static class IntakeConstants {
    public static final int intakeMotorID = 23;
  }
  public static class ShooterConstants {
    public static final int leftShooterID = 20;
    public static final int rightShooterID = 21;
  }

  public static class LEDConstants {
    public static final int port = 36;
    public static final int length = 27;
  }
}
