// Subsystem 1
class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

// Subsystem 2
class AirConditioner {
    public void turnOn() {
        System.out.println("Air Conditioner is ON");
    }

    public void turnOff() {
        System.out.println("Air Conditioner is OFF");
    }
}

// Subsystem 3
class Speaker {
    public void turnOn() {
        System.out.println("Speaker is ON");
    }

    public void turnOff() {
        System.out.println("Speaker is OFF");
    }
}

// Facade
class HomeAutomationFacade {
    private Light light;
    private AirConditioner ac;
    private Speaker speaker;

    public HomeAutomationFacade(Light light, AirConditioner ac, Speaker speaker) {
        this.light = light;
        this.ac = ac;
        this.speaker = speaker;
    }

    public void startMovieNight() {
        System.out.println("Starting Movie Night...");
        light.turnOff();
        ac.turnOn();
        speaker.turnOn();
    }

    public void endMovieNight() {
        System.out.println("Ending Movie Night...");
        light.turnOn();
        ac.turnOff();
        speaker.turnOff();
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        AirConditioner ac = new AirConditioner();
        Speaker speaker = new Speaker();
        HomeAutomationFacade homeAutomation = new HomeAutomationFacade(light, ac, speaker);

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
    }
}
