// Mediator Interface
class Mediator {
    send(message, colleague) {
        throw new Error("This method must be overridden.");
    }
}

// ConcreteMediator for managing communication
class ConcreteMediator extends Mediator {
    constructor() {
        super();
        this.colleague1 = null;
        this.colleague2 = null;
    }

    setColleague1(colleague) {
        this.colleague1 = colleague;
    }

    setColleague2(colleague) {
        this.colleague2 = colleague;
    }

    send(message, colleague) {
        if (colleague === this.colleague1) {
            this.colleague2.receive(message);
        } else {
            this.colleague1.receive(message);
        }
    }
}

// Colleague 1 Class
class Colleague1 {
    constructor(mediator) {
        this.mediator = mediator;
        this.mediator.setColleague1(this);
    }

    send(message) {
        console.log("Colleague1 sends message: " + message);
        this.mediator.send(message, this);
    }

    receive(message) {
        console.log("Colleague1 receives message: " + message);
    }
}

// Colleague 2 Class
class Colleague2 {
    constructor(mediator) {
        this.mediator = mediator;
        this.mediator.setColleague2(this);
    }

    send(message) {
        console.log("Colleague2 sends message: " + message);
        this.mediator.send(message, this);
    }

    receive(message) {
        console.log("Colleague2 receives message: " + message);
    }
}

// Client Code
const mediator = new ConcreteMediator();
const colleague1 = new Colleague1(mediator);
const colleague2 = new Colleague2(mediator);

colleague1.send("Hello, Colleague2!");  // Output: Colleague1 sends message: Hello, Colleague2!
                                       //         Colleague2 receives message: Hello, Colleague2!

colleague2.send("Hi, Colleague1!");    // Output: Colleague2 sends message: Hi, Colleague1!
                                       //         Colleague1 receives message: Hi, Colleague1!
