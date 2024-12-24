// Subject
class RealSubject {
    request() {
        console.log("RealSubject: Handling request.");
    }
}

// Proxy
class Proxy {
    constructor(realSubject) {
        this.realSubject = realSubject;
    }

    request() {
        console.log("Proxy: Checking access before forwarding the request.");
        this.realSubject.request();
    }
}

// Client Code
const realSubject = new RealSubject();
const proxy = new Proxy(realSubject);
proxy.request();
// Output:
// Proxy: Checking access before forwarding the request.
// RealSubject: Handling request.
