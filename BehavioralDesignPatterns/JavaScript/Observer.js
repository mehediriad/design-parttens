// Observer Interface
class Observer {
    update(message) {
        console.log(`Observer received message: ${message}`);
    }
}

// Subject (Observable) Interface
class Subject {
    constructor() {
        this.observers = [];
    }

    addObserver(observer) {
        this.observers.push(observer);
    }

    removeObserver(observer) {
        this.observers = this.observers.filter(obs => obs !== observer);
    }

    notifyObservers(message) {
        this.observers.forEach(observer => observer.update(message));
    }
}

// ConcreteSubject
class ConcreteSubject extends Subject {
    constructor() {
        super();
        this.state = "";
    }

    setState(state) {
        this.state = state;
        this.notifyObservers(state);
    }
}

// ConcreteObserver
class ConcreteObserver extends Observer {
    constructor(name) {
        super();
        this.name = name;
    }

    update(message) {
        console.log(`${this.name} received message: ${message}`);
    }
}

// Client Code
const subject = new ConcreteSubject();
const observer1 = new ConcreteObserver("Observer 1");
const observer2 = new ConcreteObserver("Observer 2");

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
