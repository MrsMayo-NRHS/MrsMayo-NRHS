package org.usfirst.frc7913.Test1.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc7913.Test1.commands.startWinchMotor;

import edu.wpi.first.wpilibj.PWMVictorSPX;

public class winchControl extends Subsystem {
    //Victors
    private PWMVictorSPX motor;

    public winchControl() {
        //Left motors
        motor = new PWMVictorSPX(4);
    }
    
    public void setMotorSpeed(double curSpeed){
        motor.set(curSpeed);
    }

    public void forwardMotor(){
        motor.set(0.4);
    }

    public void backwardMotor(){
        motor.set(-0.4);
    }

    public void stopMotor(){
        motor.set(0);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new startWinchMotor());        
    }  

    @Override
    public void periodic() {
    }
}