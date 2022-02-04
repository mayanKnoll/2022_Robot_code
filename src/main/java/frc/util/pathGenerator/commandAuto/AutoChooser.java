package frc.util.pathGenerator.commandAuto;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.auto.TestAuto;

public class AutoChooser {
    private Command autoCommand = null;
    SendableChooser<Command> autoChooser = new SendableChooser<>();

    public AutoChooser(TestAuto testAuto, AutoGenerator[] autoCommands) {
        autoChooser.setDefaultOption("Test Auto", testAuto);

        for (AutoGenerator command : autoCommands) {
            autoChooser.addOption(command.getNamePath(), command);
        }

        SmartDashboard.putData("Auto Chooser", autoChooser);
    }

    public Command getAutoCommand() {
        return autoChooser.getSelected();
    }


    public void stopAuto() {
        if (autoCommand != null) {
            autoCommand.cancel();
        }
    }
}
