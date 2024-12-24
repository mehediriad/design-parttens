// Abstract Product
interface Button {
    void render();
}

interface Checkbox {
    void render();
}

// Concrete Product
class WindowsButton implements Button {
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}

class MacButton implements Button {
    public void render() {
        System.out.println("Rendering Mac Button");
    }
}

class WindowsCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering Windows Checkbox");
    }
}

class MacCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering Mac Checkbox");
    }
}

// Abstract Factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factory
class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        GUIFactory factory;

        // Windows UI তৈরি
        factory = new WindowsFactory();
        Button windowsButton = factory.createButton();
        Checkbox windowsCheckbox = factory.createCheckbox();
        windowsButton.render(); // Output: Rendering Windows Button
        windowsCheckbox.render(); // Output: Rendering Windows Checkbox

        // Mac UI তৈরি
        factory = new MacFactory();
        Button macButton = factory.createButton();
        Checkbox macCheckbox = factory.createCheckbox();
        macButton.render(); // Output: Rendering Mac Button
        macCheckbox.render(); // Output: Rendering Mac Checkbox
    }
}
