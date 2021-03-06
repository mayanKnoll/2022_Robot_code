// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CartridgeSystem;

public class CartridgeCommand extends CommandBase {
  /** Creates a new CartridgeCommand. */
  CartridgeSystem cartridgeSystem;
  public CartridgeCommand(CartridgeSystem cartridgeSystem) {
    addRequirements(cartridgeSystem);
    this.cartridgeSystem = cartridgeSystem;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    cartridgeSystem.setMotorsOutput(0.1, 0.1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    cartridgeSystem.setOutput(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
