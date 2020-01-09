/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Pneumatics extends Subsystem {
  // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Compressor compressor;
    private DoubleSolenoid hatchPiston;

    public Pneumatics(){
        compressor = new Compressor(0);
        addChild("compressor",compressor);
        
        
        hatchPiston = new DoubleSolenoid(0, 0, 1);
        addChild("hatchPiston",hatchPiston);       
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void extend(){
        this.hatchPiston.set(Value.kForward);
    }

    public void retract(){
        this.hatchPiston.set(Value.kReverse);
    }    

    public void toggleCompressor(){
        if (this.compressor.enabled()){
            this.compressor.setClosedLoopControl(false);
        } else {
            this.compressor.setClosedLoopControl(true);
        }
    }
}
