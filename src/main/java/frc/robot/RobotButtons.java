/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonAreaLayout;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.collect.CollectCommand;
import frc.robot.commands.shooting.ShootingCommand;
import frc.robot.subsystems.CartridgeSystem;
import frc.robot.subsystems.ClimbSystem;
import frc.robot.subsystems.CollectSystem;
import frc.robot.subsystems.ExpandedClimbSystem;
import frc.robot.subsystems.ShootingSystem;
import frc.util.commands.SetOutputCommand;
import frc.util.commands.SolenoidChangePositionCommand;

public class RobotButtons {
    // all joysticks:
    public static Joystick driverJoystick = new Joystick(0);
    public static Joystick coPilotJoystick = new Joystick(1);

    public Trigger shootButton = new Trigger(() -> coPilotJoystick.getRawAxis(3) > 0.02);
    public Trigger cartridgeButton = new Trigger(() -> driverJoystick.getRawAxis(3) > 0.02);
    public Trigger cartridgeShootOutButton = new Trigger(() -> coPilotJoystick.getRawButton(3));
    public Trigger collectOutButton = new Trigger(() -> coPilotJoystick.getRawButton(2));
    public Trigger climbOpen = new Trigger(() -> coPilotJoystick.getPOV() == 0);
    public Trigger climbClose = new Trigger(() -> coPilotJoystick.getPOV() == 180);
    public Trigger climbExpandedClose = new Trigger(() -> coPilotJoystick.getRawButton(4));
    public Trigger climbExpandedOpen = new Trigger(() -> coPilotJoystick.getRawButton(1));
    // public Trigger collectButton = new Trigger(() -> driverJoystick.getRawAxis(2)
    // > 0.02);
    // public Trigger collectSolenoidButton = new Trigger(() -> driverJoystick.getRawButton(5));
    public Trigger collectButton = new Trigger(() -> coPilotJoystick.getRawButton(5));

    // public Trigger shootWithCartridgeButton = new Trigger(() -> coPilotJoystick.getRawAxis(2) > 0.05);

    public void loadButtons(ShootingSystem shoot, CartridgeSystem cartridge, CollectSystem collect, ClimbSystem climbSystem, ExpandedClimbSystem expandedClimbSystem) {
        shootButton.whileActiveOnce(new ShootingCommand(shoot, cartridge, false));// (new
        // shootButton.whileActiveOnce(new SetOutputCommand(shoot,() -> RobotContainer.RPM));
        climbOpen.whileActiveOnce(new SetOutputCommand(climbSystem, 1));
        climbClose.whileActiveOnce(new SetOutputCommand(climbSystem, -1));
        // (new
        collectOutButton.whileActiveOnce(new ParallelCommandGroup(new SetOutputCommand(collect, 1), new SolenoidChangePositionCommand(collect.SOLENOID, false)));  
        // cartridgeOutButton.whileActiveContinuous(new SetOutputCommand(cartridge, 0.2));                                                                                           
        // shootWithCartridgeButton.whileActiveContinuous(new ShootingCommand(shoot, cartridge));                                                                                           
        cartridgeShootOutButton.whileActiveOnce(new ParallelCommandGroup(new SetOutputCommand(cartridge, 0.2),new SetOutputCommand(shoot, -3000)));
        collectButton.whileActiveOnce(new CollectCommand(cartridge, collect));
        climbExpandedClose.whileActiveOnce(new SetOutputCommand(expandedClimbSystem, 0.5));
        climbExpandedOpen.whileActiveOnce(new SetOutputCommand(expandedClimbSystem, -0.5));
        // collectSolenoidButton.whenActive(new SolenoidChangePositionCommand(collect.SOLENOID));
  
    }
}
