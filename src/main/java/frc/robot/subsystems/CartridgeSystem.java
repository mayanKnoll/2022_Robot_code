// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import frc.robot.Constants;
import frc.util.OutputSystem;

public class CartridgeSystem extends OutputSystem {
  private VictorSP CartridgeMotor1 = new VictorSP(Constants.PWM_CARTRIDGE1_MOTOR);
  private VictorSP CartridgeMotor2 = new VictorSP(Constants.PWM_CARTRIDGE2_MOTOR);

  public CartridgeSystem() {
    super("Cartridge");
  }

  @Override
  public void periodic() {
  }

  @Override
  public void setOutput(double output) {
    CartridgeMotor1.set(output);
    CartridgeMotor2.set(output * 0.75);
  }


  public void setMotorsOutput(double rightOutput, double leftOutput) {
    CartridgeMotor1.set(rightOutput);
    CartridgeMotor2.set(leftOutput);
  }
}
