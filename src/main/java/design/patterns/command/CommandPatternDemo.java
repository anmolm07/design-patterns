package design.patterns.command;

import design.patterns.command.invoker.RemoteControl;
import design.patterns.command.reciever.Light;

public class CommandPatternDemo {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        // Create concrete commands
        LightOnCommand lightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand lightOff = new LightOffCommand(livingRoomLight);

        // Create invoker
        RemoteControl remote = new RemoteControl();

        // Turn on the light
        remote.setCommand(lightOn);
        remote.pressButton(); // Output: Light is ON

        // Turn off the light
        remote.setCommand(lightOff);
        remote.pressButton(); // Output: Light is OFF

        // Demonstrate undo (optional)
        remote.setCommand(lightOn); // Set to turn on
        remote.pressButton();       // Light is ON
        remote.pressUndo();         // Light is OFF (undoes the last 'on' command)
    }
}