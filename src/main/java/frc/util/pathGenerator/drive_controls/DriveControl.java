package frc.util.pathGenerator.drive_controls;

import frc.robot.Constants;
import frc.util.pathGenerator.Point;
import frc.util.pathGeneratorNew.DrivePosition;
import frc.util.pathGeneratorNew.PointSegments;
import frc.robot.subsystems.DriveSystem;

/**
 * @author Matan Steinmetz
 */
public abstract class DriveControl {
    private DriveSystem driveSystem;

    public DriveControl(DriveSystem driveSystem) {
        this.driveSystem = driveSystem;
    }

    public abstract double getRobotErrorRightPosition(Point point);
    public abstract double getRobotErrorLeftPosition(Point point);

    public double getRightPosition() {
        return driveSystem.getRightPosition();
    }

    public double getLeftPosition() {
        return driveSystem.getLeftPosition();
    }

    // ----- Util ----- \\
    /**
     * @param angle
     * @return distance
     */
    public static double angle2Distance(double angle) {
        return Constants.ROBOT_WIDTH / 2 * Math.toRadians(angle);
    }

    /**
     * @param distance
     * @return angle
     */
    public static double distance2Angle(double distance) {
        return Math.toDegrees(distance / Constants.ROBOT_WIDTH * 2);
    }

    /**
     * @param distanceLeft
     * @param distanceRight
     * @return angle
     */
    public static double distance2Angle(double distanceLeft, double distanceRight) {
        return Math.toDegrees((distanceLeft - distanceRight) / Constants.ROBOT_WIDTH);
    }
}