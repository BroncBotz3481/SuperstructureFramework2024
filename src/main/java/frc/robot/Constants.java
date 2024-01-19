// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final XboxController driverController =  new XboxController(0);

  public static class ClimberConstants {
    public static final int leftClimberMotorID = 26;
    public static final int rightClimberMotorID = 27;
    public static final int lowerID = 3;
  }
  public static class FeederConstants {
    public static final int leftLiftID = 13;
    public static final int rightLiftID = 14;
    public static final int feederMotorID = 15;
    public static final int limitSwitchBeanBrakeChannel = 2;

    public static final int limitSwitchLATop = 4;
    public static final int limitSwitchLABottom = 5;
  }

  public static class IntakeConstants {
    public static final int intakeMotorID = 23;
    public static final int forwardChannelID = 1;
    public static final int reverseChannelID = 2;
  }
  public static class ShooterConstants {
    public static final int leftShooterID = 20;
    public static final int rightShooterID = 21;
  }

  public static class LEDConstants {
    public static final int port = 1;
    public static final int length = 27;
  }
}
