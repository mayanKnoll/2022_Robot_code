// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import frc.robot.Constants;
import frc.robot.commands.collect.DefueltsCollectCommand;
import frc.util.OutputSystem;
import frc.util.SuperSolenoid;

public class CollectSystem extends OutputSystem {
  private VictorSP motor = new VictorSP(Constants.PWM_COLLECT_MOTOR);

  public CollectSystem() {
    super("Collecting");
  }

  @Override
  public void periodic() {
    getTab().putInDashboard("power", motor.get(), true);
    // This method will be called once per scheduler run
  }

  @Override
  public void setOutput(double output) {
    motor.set(output);
  }
}
