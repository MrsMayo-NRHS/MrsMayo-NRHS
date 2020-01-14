package org.usfirst.frc7913.Test1;
import org.usfirst.frc7913.Test1.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc7913.Test1.subsystems.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    public JoystickButton button1;
    public JoystickButton button2;
    public JoystickButton button3;
    public JoystickButton button4;
    public JoystickButton button5;
    public JoystickButton button6;
    public JoystickButton button7;
    public Joystick joystickx30;
    public Joystick xboxController;
    boolean status = true;

    public OI() {
        xboxController = new Joystick(1);
        joystickx30 = new Joystick(0); 

        button2 = new JoystickButton(xboxController, 1);
        button2.whenPressed(new retractPiston());

        button3 = new JoystickButton(xboxController, 2);
        button3.whenPressed(new extendPiston());

        button5 = new JoystickButton(xboxController, 3);
        button5.whenPressed(new openGripper());

        button6 = new JoystickButton(xboxController, 4);
        button6.whenPressed(new closeGripper());

        button4 = new JoystickButton(xboxController, 8);
        button4.whenPressed(new toggleCompressor());



        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("drive", new drive());
        SmartDashboard.putData("extendPiston", new extendPiston());
        SmartDashboard.putData("retractPiston", new retractPiston());

    }

    public Joystick getjoystickx30() {
        return joystickx30;
    }
    public Joystick getXboxController() {
        return xboxController;
    }
}