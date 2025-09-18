package design.patterns.command;

import design.patterns.command.reciever.Light;

public class LightOnCommand implements Command {

    private final Light  light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }

}
