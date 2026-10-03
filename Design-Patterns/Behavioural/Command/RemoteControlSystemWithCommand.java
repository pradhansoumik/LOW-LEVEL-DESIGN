/**
 * The issues in the previous implementation can be addressed by using the Command Pattern.
 * By applying this pattern, it becomes easier to encapsulate requests as objects, allowing for flexible and reusable command handling.
 * The command pattern decouples the request sender (Invoker) from the receiver (Light/AC) and provides a unified way to handle multiple commands and actions.
 */
import java.util.*;

// ========= Receiver classes ===========
// Light and AC with basic on/off methods
class Light
{
    public void on()
    {
        System.out.println("Light turned ON");
    }

    public void off()
    {
        System.out.println("Light turned OFF");
    }
}

class AC
{
    public void on()
    {
        System.out.println("AC turned ON");
    }

    public void off()
    {
        System.out.println("AC turned OFF");
    }
}

// ========= Command interface ===========
//    defines the command structure
interface Command
{
    void execute();
    void undo();
}

// Concrete commands for Light ON and OFF
class LightOnCommand implements Command
{
    private Light light;

    public LightOnCommand(Light light)
    {
        this.light = light;
    }

    public void execute()
    {
        light.on();
    }

    public void undo()
    {
        light.off();
    }
}

class LightOffCommand implements Command
{
    private Light light;

    public LightOffCommand(Light light)
    {
        this.light = light;
    }

    public void execute()
    {
        light.off();
    }

    public void undo()
    {
        light.on();
    }
}

// Concrete commands for AC ON and OFF
class AConCommand implements Command
{
    private AC ac;

    public AConCommand(AC ac)
    {
        this.ac = ac;
    }

    public void execute()
    {
        ac.on();
    }

    public void undo()
    {
        ac.off();
    }
}

class ACOffCommand implements Command
{
    private AC ac;

    public ACOffCommand(AC ac)
    {
        this.ac = ac;
    }

    public void execute()
    {
        ac.off();
    }

    public void undo()
    {
        ac.on();
    }
}

// ========== Remote control class (Invoker) ==========
class RemoteControl
{
    private Command[] buttons = new Command[4];  // Assigning 4 slots for commands
    private Stack<Command> commandHistory = new Stack<>();

    // Assign command to slot
    public void setCommand(int slot, Command command)
    {
        buttons[slot] = command;
    }

    // Press the button to execute the command
    public void pressButton(int slot)
    {
        if (buttons[slot] != null)
        {
            buttons[slot].execute();
            commandHistory.push(buttons[slot]);
        }
        else
        {
            System.out.println("No command assigned to slot " + slot);
        }
    }

    // Undo the last action
    public void pressUndo()
    {
        if (!commandHistory.isEmpty())
        {
            commandHistory.pop().undo();
        }
        else
        {
            System.out.println("No commands to undo.");
        }
    }
}

// ========= Client code ===========
public class Main
{
    public static void main(String[] args)
    {
        Light light = new Light();
        AC ac = new AC();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command acOn = new AConCommand(ac);
        Command acOff = new ACOffCommand(ac);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(0, lightOn);
        remote.setCommand(1, lightOff);
        remote.setCommand(2, acOn);
        remote.setCommand(3, acOff);

        remote.pressButton(0); // Light ON
        remote.pressButton(2); // AC ON
        remote.pressButton(1); // Light OFF
        remote.pressUndo();    // Undo Light OFF -> Light ON
        remote.pressUndo();    // Undo AC ON -> AC OFF
    }
}
/**
 * Tight Coupling:	By using the Command Pattern, the RemoteControl class no longer directly interacts with the devices. It now interacts with command objects (e.g., LightOnCommand, ACOffCommand), which decouples the logic.
 * Lack of Flexibility:	With the Command Pattern, new commands (e.g., for new devices or actions) can be created as new Command implementations without changing the RemoteControl class. This allows for easy extension.
 * Undo Functionality:	The Command Pattern provides a consistent structure for undoing commands. Each concrete command (e.g., LightOnCommand, ACOffCommand) has its own undo() method, which allows easy reversal of actions.
 * Hardcoded Commands:	The Command Pattern uses an interface for commands, which allows dynamic assignment of different commands to slots in the remote. This makes the command assignments flexible and customizable.
 * Maintaining Command History:	The Command Pattern introduces a stack (commandHistory) in the RemoteControl class, which tracks previously executed commands. This makes the undo functionality centralized and easier to manage.
 */