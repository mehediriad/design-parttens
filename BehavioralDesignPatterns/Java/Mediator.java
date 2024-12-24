// Mediator Interface
interface Mediator {
    void send(String message, Colleague colleague);
}

// ConcreteMediator for managing communication
class ConcreteMediator implements Mediator {
    private Colleague1 colleague1;
    private Colleague2 colleague2;

    public void setColleague1(Colleague1 colleague) {
        this.colleague1 = colleague;
    }

    public void setColleague2(Colleague2 colleague) {
        this.colleague2 = colleague;
    }

    public void send(String message, Colleague colleague) {
        if (colleague == colleague1) {
            colleague2.receive(message);
        } else {
            colleague1.receive(message);
        }
    }
}

// Colleague Class
abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}

// ConcreteColleague1 Class
class Colleague1 extends Colleague {
    public Colleague1(Mediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        System.out.println("Colleague1 sends message: " + message);
        mediator.send(message, this);
    }

    public void receive(String message) {
        System.out.println("Colleague1 receives message: " + message);
    }
}

// ConcreteColleague2 Class
class Colleague2 extends Colleague {
    public Colleague2(Mediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        System.out.println("Colleague2 sends message: " + message);
        mediator.send(message, this);
    }

    public void receive(String message) {
        System.out.println("Colleague2 receives message: " + message);
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        Colleague1 colleague1 = new Colleague1(mediator);
        Colleague2 colleague2 = new Colleague2(mediator);

        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        colleague1.send("Hello, Colleague2!");  // Output: Colleague1 sends message: Hello, Colleague2!
                                              //         Colleague2 receives message: Hello, Colleague2!

        colleague2.send("Hi, Colleague1!");    // Output: Colleague2 sends message: Hi, Colleague1!
                                              //         Colleague1 receives message: Hi, Colleague1!
    }
}
