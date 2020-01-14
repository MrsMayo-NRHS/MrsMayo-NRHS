package org.usfirst.frc7913.Test1.subsystems;
import org.usfirst.frc7913.Test1.Robot;
import org.usfirst.frc7913.Test1.commands.*;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.GenericHID;
//import edu.wpi.first.wpilibj.PIDOutput;
//import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
//import edu.wpi.first.wpilibj.GenericHID.Hand;

public class driveTrain extends Subsystem {
    private PWMVictorSPX leftLead;
    private PWMVictorSPX leftFollow;
    private SpeedControllerGroup leftSide;
    private PWMVictorSPX rightLead;
    private PWMVictorSPX rightFollow;
    private SpeedControllerGroup rightSide;
    private PWMVictorSPX lift;

    private DifferentialDrive driveTrain;

    public driveTrain() {
        //Left motors
        leftLead = new PWMVictorSPX(0);
        addChild("leftLead",leftLead);
        leftLead.setInverted(false);
        leftFollow = new PWMVictorSPX(2);
        addChild("leftFollow",leftFollow);
        leftFollow.setInverted(false);
        leftSide = new SpeedControllerGroup(leftLead, leftFollow);

        //Right motors
        rightLead = new PWMVictorSPX(1);
        addChild("rightLead",rightLead);
        rightLead.setInverted(false);
        rightFollow = new PWMVictorSPX(3);
        addChild("rightFollow",rightFollow);
        rightFollow.setInverted(false);
        rightSide = new SpeedControllerGroup(rightLead, rightFollow);

        lift = new PWMVictorSPX(4);
        
        driveTrain = new DifferentialDrive(leftSide, rightSide);
        //test
        driveTrain.setSafetyEnabled(true);
        driveTrain.setExpiration(0.1);
        driveTrain.setMaxOutput(1.0);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new drive());
    }

    @Override
    public void periodic() {
        //Top speed control
        double d = (Robot.oi.joystickx30.getThrottle() + 2) / 2.25;

        //Line that sets speed of motors
        driveTrain.arcadeDrive(Robot.oi.joystickx30.getY() * d, Robot.oi.joystickx30.getX() * d);
        
        //Sets speed of lift motor
        lift.setSpeed(Robot.oi.xboxController.getY(GenericHID.Hand.kLeft) / 1);
    }
}