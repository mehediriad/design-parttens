// Handler Interface
class Handler {
    constructor() {
        this.nextHandler = null;
    }

    setNext(handler) {
        this.nextHandler = handler;
        return handler;
    }

    handleRequest(request) {
        if (this.nextHandler) {
            this.nextHandler.handleRequest(request);
        }
    }
}

// ConcreteHandler 1
class ConcreteHandlerA extends Handler {
    handleRequest(request) {
        if (request === 'A') {
            console.log("Handler A is processing the request");
        } else {
            super.handleRequest(request);
        }
    }
}

// ConcreteHandler 2
class ConcreteHandlerB extends Handler {
    handleRequest(request) {
        if (request === 'B') {
            console.log("Handler B is processing the request");
        } else {
            super.handleRequest(request);
        }
    }
}
// ConcreteHandler 3
class ConcreteHandlerC extends Handler {
    handleRequest(request) {
        if (request === 'C') {
            console.log("Handler C is processing the request");
        } else {
            super.handleRequest(request);
        }
    }
}
// Client Code
const handlerA = new ConcreteHandlerA();
const handlerB = new ConcreteHandlerB();
const handlerC = new ConcreteHandlerC();

handlerA.setNext(handlerB).setNext(handlerC);

handlerA.handleRequest('B');  // Output: Handler B is processing the request
handlerA.handleRequest('C');  // Output: Handler C is processing the request
handlerA.handleRequest('A');  // Output: Handler A is processing the request
