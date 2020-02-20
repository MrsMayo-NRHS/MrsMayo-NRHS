package org.usfirst.frc7913.Test1;
import org.usfirst.frc7913.Test1.commands.*;
//import org.usfirst.frc7913.Test1.subsystems.driveTrain;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
//import org.usfirst.frc7913.Test1.subsystems.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    public Joystick driverController = new Joystick(0);
    public JoystickButton button1 = new JoystickButton(driverController, 1);
    public JoystickButton button2 = new JoystickButton(driverController, 2);
    public JoystickButton button3 = new JoystickButton(driverController, 3);
    public JoystickButton button4 = new JoystickButton(driverController, 4);
    public JoystickButton button5 = new JoystickButton(driverController, 5);
    public JoystickButton button6 = new JoystickButton(driverController, 6);
    public JoystickButton button7 = new JoystickButton(driverController, 7);
    boolean status = true;

    public OI() {
        button1.whenPressed(new upPivotMotor());
        button2.whenPressed(new downPivotMotor());
        button1.whenReleased(new stopPivotMotor());
        button2.whenReleased(new stopPivotMotor());
        button3.whenPressed(new upIntakeMotor());
        button4.whenPressed(new downIntakeMotor());
        button3.whenReleased(new stopIntakeMotor());
        button4.whenReleased(new stopIntakeMotor());        
        button5.whileHeld(new leftPivot());
        button6.whileHeld(new rightPivot());
        button7.whileHeld(new speedChange());
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("drive", new drive());

    }

    public Joystick getDriverController() {
        return driverController;
    }
}