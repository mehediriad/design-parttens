// Subsystem 1
class Light {
    turnOn() {
        console.log("Light is ON");
    }

    turnOff() {
        console.log("Light is OFF");
    }
}

// Subsystem 2
class AirConditioner {
    turnOn() {
        console.log("Air Conditioner is ON");
    }

    turnOff() {
        console.log("Air Conditioner is OFF");
    }
}
// Subsystem 3
class Speaker {
    turnOn() {
        console.log("Speaker is ON");
    }

    turnOff() {
        console.log("Speaker is OFF");
    }
}

// Facade
class HomeAutomationFacade {
    constructor(light, ac, speaker) {
        this.light = light;
        this.ac = ac;
        this.speaker = speaker;
    }

    startMovieNight() {
        console.log("Starting Movie Night...");
        this.light.turnOff();
        this.ac.turnOn();
        this.speaker.turnOn();
    }

    endMovieNight() {
        console.log("Ending Movie Night...");
        this.light.turnOn();
        this.ac.turnOff();
        this.speaker.turnOff();
    }
}

// Client Code
const light = new Light();
const ac = new AirConditioner();
const speaker = new Speaker();
const homeAutomation = new HomeAutomationFacade(light, ac, speaker);

homeAutomation.startMovieNight();
// Output:
// Starting Movie Night...
// Light is OFF
// Air Conditioner is ON
// Speaker is ON

homeAutomation.endMovieNight();
// Output:
// Ending Movie Night...
// Light is ON
// Air Conditioner is OFF
// Speaker is OFF
