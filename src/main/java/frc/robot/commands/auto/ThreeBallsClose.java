package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import frc.robot.Constants;
import frc.robot.commands.collect.changeSelenoidCommand;
import frc.robot.commands.ShootingCommand;
import frc.robot.commands.collect.CollectCommand;
import frc.util.SuperNavX;
import frc.util.commands.SetOutputCommand;
import frc.util.commands.TimeCommand;
import frc.util.commands.TurnInPlace;
import frc.util.pathGenerator.commandAuto.AutoGenerator;
import frc.util.pathGenerator.drive_controls.EncoderAndNavxDriveControl;
import frc.util.pathGenerator.drive_controls.EncoderDriveControl;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.CartridgeSystem;
import frc.robot.subsystems.CollectSystem;
import frc.robot.subsystems.ShootingSystem;
import frc.robot.subsystems.collectSelnoid;

public class ThreeBallsClose extends AutoGenerator {
    public ThreeBallsClose(DriveSystem driveSystem, SuperNavX navX, CollectSystem collectSystem,
            EncoderAndNavxDriveControl navxDriveControl, collectSelnoid collectSelnoid,
            CartridgeSystem cartridgeSystem, ShootingSystem shootingSystem) {
        super("ThreeBallsClose", driveSystem.getAutoGains(), driveSystem, navX, 110);
        
        Constants.ThreeC1.inReverse();
        Constants.ThreeC2.inReverse();
        Constants.ThreeC3.inReverse();
        addCommands(new ParallelDeadlineGroup(new TimeCommand(1000), new changeSelenoidCommand(collectSelnoid, false), new ShootingCommand(shootingSystem, cartridgeSystem, driveSystem ,true)));
        addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.ThreeC1, new EncoderAndNavxDriveControl(driveSystem, navX)), new changeSelenoidCommand(collectSelnoid, true)));
        addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.ThreeC2, new EncoderAndNavxDriveControl(driveSystem, navX)),new CollectCommand(cartridgeSystem, collectSystem)));
        addCommands(new ParallelRaceGroup(new TimeCommand(2000), new TurnInPlace(driveSystem, navX, 180, 0.7), new changeSelenoidCommand(collectSelnoid, false)));
        addCommands(new ParallelDeadlineGroup(addFollowPathCommand(Constants.ThreeC3, new EncoderAndNavxDriveControl(driveSystem, navX, 90)), new changeSelenoidCommand(collectSelnoid, true)));
        addCommands(new ParallelDeadlineGroup(new TimeCommand(1000), new changeSelenoidCommand(collectSelnoid, false), new ShootingCommand(shootingSystem, cartridgeSystem, driveSystem ,true)));

    }
}
