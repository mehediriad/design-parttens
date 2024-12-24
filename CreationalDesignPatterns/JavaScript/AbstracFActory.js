// Abstract Product
class Button {
    render() {
        throw new Error("This method should be overridden!");
    }
}

class Checkbox {
    render() {
        throw new Error("This method should be overridden!");
    }
}

// Concrete Product
class WindowsButton extends Button {
    render() {
        console.log("Rendering Windows Button");
    }
}

class MacButton extends Button {
    render() {
        console.log("Rendering Mac Button");
    }
}

class WindowsCheckbox extends Checkbox {
    render() {
        console.log("Rendering Windows Checkbox");
    }
}

class MacCheckbox extends Checkbox {
    render() {
        console.log("Rendering Mac Checkbox");
    }
}

// Abstract Factory
class GUIFactory {
    createButton() {
        throw new Error("This method should be overridden!");
    }
    createCheckbox() {
        throw new Error("This method should be overridden!");
    }
}

// Concrete Factory
class WindowsFactory extends GUIFactory {
    createButton() {
        return new WindowsButton();
    }
    createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory extends GUIFactory {
    createButton() {
        return new MacButton();
    }
    createCheckbox() {
        return new MacCheckbox();
    }
}

// Client Code
function createUI(factory) {
    const button = factory.createButton();
    const checkbox = factory.createCheckbox();

    button.render(); // ফ্যাক্টরি অনুযায়ী বাটন রেন্ডার হবে
    checkbox.render(); // ফ্যাক্টরি অনুযায়ী চেকবক্স রেন্ডার হবে
}

// Windows UI তৈরি
const windowsFactory = new WindowsFactory();
createUI(windowsFactory);

// Mac UI তৈরি
const macFactory = new MacFactory();
createUI(macFactory);
