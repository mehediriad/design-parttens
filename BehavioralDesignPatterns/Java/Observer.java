// Observer Interface
interface Observer {
    void update(String message);
}

// Subject Interface
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

// ConcreteSubject
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers(state);
    }
}

// ConcreteObserver
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer1 = new ConcreteObserver("Observer 1");
        ConcreteObserver observer2 = new ConcreteObserver("Observer 2");

        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.setState("State 1");
        // Output:
        // Observer 1 received message: State 1
        // Observer 2 received message: State 1

        subject.setState("State 2");
        // Output:
        // Observer 1 received message: State 2
        // Observer 2 received message: State 2
    }
}
