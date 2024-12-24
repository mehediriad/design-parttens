// Subject
interface Subject {
    void request();
}

// RealSubject
class RealSubject implements Subject {
    public void request() {
        System.out.println("RealSubject: Handling request.");
    }
}

// Proxy
class Proxy implements Subject {
    private RealSubject realSubject;

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    public void request() {
        System.out.println("Proxy: Checking access before forwarding the request.");
        realSubject.request();
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Proxy proxy = new Proxy(realSubject);
        proxy.request();
        // Output:
        // Proxy: Checking access before forwarding the request.
        // RealSubject: Handling request.
    }
}
