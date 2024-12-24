// State Interface
interface State {
    void handleRequest();
}

// ConcreteState for handling "Start" state
class StartState implements State {
    public void handleRequest() {
        System.out.println("Handling Start State");
    }
}

// ConcreteState for handling "Stop" state
class StopState implements State {
    public void handleRequest() {
        System.out.println("Handling Stop State");
    }
}

// Context Class
class Context {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handleRequest();
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        Context context = new Context();

        State startState = new StartState();
        State stopState = new StopState();

        context.setState(startState);
        context.request();  // Output: Handling Start State

        context.setState(stopState);
        context.request();  // Output: Handling Stop State
    }
}
