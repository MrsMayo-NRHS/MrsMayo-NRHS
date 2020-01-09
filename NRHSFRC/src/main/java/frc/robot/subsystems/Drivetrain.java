/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;
import edu.wpi.first.wpilibj.PWMVictorSPX;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	// Vicotrs
    private PWMVictorSPX leftLead;
    private PWMVictorSPX leftFollow;
    private PWMVictorSPX rightLead;
    private PWMVictorSPX rightFollow;

	DifferentialDrive differentialDrive = null;

	// Encoders
	Encoder driveEncoder = null;

	public Drivetrain() {
		// Talons
		leftLead = new PWMVictorSPX(0);
		leftFollow = new PWMVictorSPX(0);
		rightLead = new PWMVictorSPX(0);
		rightFollow = new PWMVictorSPX(0);

		SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftLead, leftFollow);
		SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightLead, rightFollow);

		differentialDrive = new DifferentialDrive(leftMotors, rightMotors);

		// Encoders
		driveEncoder = new Encoder(RobotMap.DRIVETRAIN_DRIVE_ENCODER_A, RobotMap.DRIVETRAIN_DRIVE_ENCODER_B);
	}

	public void arcadeDrive(double moveSpeed, double rotateSpeed) {
		differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
	}

	public double getDriveEncoderCount() {
		return driveEncoder.get();
	}

	public void resetDriveEncoderCount() {
		driveEncoder.reset();
	}

	public double getDriveEncoderDistance() {
		double driveEncoderCountsPerFoot = 1;
		return (getDriveEncoderCount() / (driveEncoderCountsPerFoot)) * 12;
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DriveArcade());
	}

    @Override
    public void periodic() {
        // Put code here to be run every loop
        differentialDrive.arcadeDrive(Robot.m_oi.getDriverJoystick().getY(), Robot.m_oi.getDriverJoystick().getX());
    }	
}
