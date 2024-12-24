// State Interface
class State {
    handleRequest() {
        throw new Error("This method must be overridden.");
    }
}

// ConcreteState for handling "Start" state
class StartState extends State {
    handleRequest() {
        console.log("Handling Start State");
    }
}

// ConcreteState for handling "Stop" state
class StopState extends State {
    handleRequest() {
        console.log("Handling Stop State");
    }
}

// Context Class
class Context {
    constructor() {
        this.state = null;
    }

    setState(state) {
        this.state = state;
    }

    request() {
        this.state.handleRequest();
    }
}

// Client Code
const context = new Context();

const startState = new StartState();
const stopState = new StopState();

context.setState(startState);
context.request();  // Output: Handling Start State

context.setState(stopState);
context.request();  // Output: Handling Stop State
