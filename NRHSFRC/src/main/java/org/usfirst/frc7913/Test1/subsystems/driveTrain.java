package org.usfirst.frc7913.Test1.subsystems;
import org.usfirst.frc7913.Test1.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class driveTrain extends Subsystem {
    //Victors
    private PWMVictorSPX leftLead;
    private PWMVictorSPX leftFollow;
    private PWMVictorSPX rightLead;
    private PWMVictorSPX rightFollow;

    private SpeedControllerGroup leftSide;
    private SpeedControllerGroup rightSide;
    private DifferentialDrive driveTrain;

    public boolean isSlow = false;

    public driveTrain() {
        //Left motors
        leftLead = new PWMVictorSPX(0);
        addChild("leftLead",leftLead);
        leftLead.setInverted(true);
        leftFollow = new PWMVictorSPX(2);
        addChild("leftFollow",leftFollow);
        leftFollow.setInverted(true);
        leftSide = new SpeedControllerGroup(leftLead, leftFollow);

        //Right motors
        rightLead = new PWMVictorSPX(1);
        addChild("rightLead",rightLead);
        rightLead.setInverted(true);
        rightFollow = new PWMVictorSPX(3);
        addChild("rightFollow",rightFollow);
        rightFollow.setInverted(true);
        rightSide = new SpeedControllerGroup(rightLead, rightFollow);
        
        driveTrain = new DifferentialDrive(leftSide, rightSide);
        
        driveTrain.setSafetyEnabled(true);
        driveTrain.setExpiration(0.1);
        driveTrain.setMaxOutput(1.0);
    }

    //Drive type for one joystick/automated driving
	public void arcadeDrive(double moveSpeed, double rotateSpeed) {
		driveTrain.arcadeDrive(moveSpeed, rotateSpeed);
    }
    
    //Drive type for two joysticks/manual driving
    public void tankDrive(double leftSpeed, double rightSpeed) {
        if(this.isSlow){
            driveTrain.tankDrive(leftSpeed, rightSpeed);
        } else {
            driveTrain.tankDrive(leftSpeed, rightSpeed);
        }
        
    }
    
    public void switchIsSlow(){
        if(this.isSlow){
            this.isSlow = false;
        } else {
            this.isSlow = true;
        }
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new drive());
    }  

    @Override
    public void periodic() {
    }
}