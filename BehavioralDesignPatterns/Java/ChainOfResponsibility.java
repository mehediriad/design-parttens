// Handler Interface
abstract class Handler {
    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(String request);
}

// ConcreteHandler 1
class ConcreteHandlerA extends Handler {
    public void handleRequest(String request) {
        if (request.equals("A")) {
            System.out.println("Handler A is processing the request");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

// ConcreteHandler 2
class ConcreteHandlerB extends Handler {
    public void handleRequest(String request) {
        if (request.equals("B")) {
            System.out.println("Handler B is processing the request");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

// ConcreteHandler 3
class ConcreteHandlerC extends Handler {
    public void handleRequest(String request) {
        if (request.equals("C")) {
            System.out.println("Handler C is processing the request");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        Handler handlerC = new ConcreteHandlerC();

        handlerA.setNextHandler(handlerB);
        handlerB.setNextHandler(handlerC);

        handlerA.handleRequest("B");  // Output: Handler B is processing the request
        handlerA.handleRequest("C");  // Output: Handler C is processing the request
        handlerA.handleRequest("A");  // Output: Handler A is processing the request
    }
}
