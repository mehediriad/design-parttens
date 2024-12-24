// Command Interface
class Command {
    execute() {
        throw new Error("This method must be overridden.");
    }
}

// ConcreteCommand for turning on the light
class LightOnCommand extends Command {
    constructor(light) {
        super();
        this.light = light;
    }

    execute() {
        this.light.turnOn();
    }
}

// ConcreteCommand for turning off the light
class LightOffCommand extends Command {
    constructor(light) {
        super();
        this.light = light;
    }

    execute() {
        this.light.turnOff();
    }
}
// Receiver Class
class Light {
    turnOn() {
        console.log("Light is ON");
    }

    turnOff() {
        console.log("Light is OFF");
    }
}
// Invoker Class
class RemoteControl {
    setCommand(command) {
        this.command = command;
    }

    pressButton() {
        this.command.execute();
    }
}
// Client Code
const light = new Light();
const lightOn = new LightOnCommand(light);
const lightOff = new LightOffCommand(light);

const remote = new RemoteControl();
remote.setCommand(lightOn);
remote.pressButton();  // Output: Light is ON

remote.setCommand(lightOff);
remote.pressButton();  // Output: Light is OFF
