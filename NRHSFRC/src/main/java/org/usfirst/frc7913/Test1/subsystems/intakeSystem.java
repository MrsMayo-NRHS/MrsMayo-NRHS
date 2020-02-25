package org.usfirst.frc7913.Test1.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.PWMVictorSPX;

public class intakeSystem extends Subsystem {
    //Victors
    private PWMVictorSPX intakeMotor;
    private PWMVictorSPX pivotMotor;

    public intakeSystem() {
        //Left motors
        intakeMotor = new PWMVictorSPX(6);
        pivotMotor = new PWMVictorSPX(5);
    }

    public void upIntakeMotor(){
        intakeMotor.setSpeed(0.6);
    }

    public void downIntakeMotor(){
        intakeMotor.setSpeed(-0.6);
    }

    public void stopIntakeMotor(){
        intakeMotor.setSpeed(0);
    }

    public void upPivotMotor(){
        pivotMotor.setSpeed(0.25);
    }

    public void downPivotMotor(){
        pivotMotor.setSpeed(-0.25);
    }

    public void stopPivotMotor(){
        pivotMotor.setSpeed(0);
    }
    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new monitorPivotMotor());
    }

    @Override
    public void periodic() {
    }
}
