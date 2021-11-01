// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.subsystems;

// import com.revrobotics.CANSparkMax.IdleMode;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// import edu.wpi.first.wpilibj.DriverStation;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import frc.robot.RobotButtons;
// import frc.robot.Constants;
// import frc.util.PID.Gains;
// import frc.util.motor.SuperSparkMax;
// import frc.util.dashboard.SuperSystem;
// import frc.util.commands.drive.DriveWithJoysticksAccCommand;
// // import frc.util.vision.Limelight;

// public class DriveSystem extends SuperSystem {
//   private SuperSparkMax RM = new SuperSparkMax(Constants.CAN_DRIVE_RM_MOTOR, MotorType.kBrushless, 60, true, IdleMode.kBrake);
//   private SuperSparkMax RS = new SuperSparkMax(Constants.CAN_DRIVE_RS_MOTOR, MotorType.kBrushless, 60, true, IdleMode.kBrake);
//   private SuperSparkMax LM = new SuperSparkMax(Constants.CAN_DRIVE_LM_MOTOR, MotorType.kBrushless, 60, false, IdleMode.kBrake);
//   private SuperSparkMax LS = new SuperSparkMax(Constants.CAN_DRIVE_LS_MOTOR, MotorType.kBrushless, 60, false, IdleMode.kBrake);

//   private final double ENCODER_2_METER = 0.06349206349206349206349206349206;

//   public static Gains visionGains = new Gains("visionGains",0.07, 0, 0.14);
//   public static Gains autoGains = new Gains("autoGains",0.195, 0.0525, 2, 0, 0);

//   public DriveSystem(/*Limelight limelight*/) {
//     super("Drive");


//     LS.follow(LM);
//     RS.follow(RM);

//     setDefaultCommand(new DriveWithJoysticksAccCommand(this));
//   }

//   @Override
//   public void periodic() {
//     changeNeoMode();

//     putInDashboard("left encoder position", getLeftEncoderDistance());
//     putInDashboard("right encoder position", getRightEncoderDistance());
//     putInDashboard("average position", getPosition());

//     SmartDashboard.putBoolean("Is high gear", shifter.isOff());
//   }

//   public void tank(double left, double right) {
//     LM.set(left);
//     RM.set(right);
//   }

//   @Override
//   public void setOutput(double setOutput) {
//     LM.set(setOutput);
//     RM.set(setOutput);
//   }

//   @Override
//   public void resetSensors() {
//     RM.hardReset();
//     LM.hardReset();
//   }

//   @Override
//   public Gains getGains() {
//     return visionGains;
//   }

//   public Gains getAutoGains() {
//     return autoGains;
//   }

//   @Override
//   public double getOutput() {
//     return Double.NaN;
//   }

//   @Override
//   public double getPosition() {
//     return (Math.abs(RM.getEncoder().getPosition() * ENCODER_2_METER) +
//      Math.abs(LM.getEncoder().getPosition() * ENCODER_2_METER)) / 2;
//   }

//   public double getRightEncoderDistance() {
//     return RM.getEncoder().getPosition() * ENCODER_2_METER;
//   }

//   public double getLeftEncoderDistance() {
//     return LM.getEncoder().getPosition() * ENCODER_2_METER;
//   }

//   public void changeNeoMode() {
//     if (DriverStation.getInstance().isDisabled()) {
//       RM.setIdleMode(IdleMode.kCoast);
//       RS.setIdleMode(IdleMode.kCoast);
//       LM.setIdleMode(IdleMode.kCoast);
//       LS.setIdleMode(IdleMode.kCoast);
//     } else {
//       RM.setIdleMode(IdleMode.kBrake);
//       RS.setIdleMode(IdleMode.kBrake);
//       LM.setIdleMode(IdleMode.kBrake);
//       LS.setIdleMode(IdleMode.kBrake);
//     }
//   }

//   @Override
//   public void stopOutput() {
//     LM.set(0);
//     RM.set(0);
//   }
// }