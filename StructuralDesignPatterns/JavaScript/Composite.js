// Component
class Graphic {
    draw() {
        throw new Error("This method should be overridden!");
    }
}

// Leaf
class Circle extends Graphic {
    draw() {
        console.log("Drawing a Circle");
    }
}

class Rectangle extends Graphic {
    draw() {
        console.log("Drawing a Rectangle");
    }
}

// Composite
class GraphicGroup extends Graphic {
    constructor() {
        super();
        this.graphics = [];
    }

    add(graphic) {
        this.graphics.push(graphic);
    }

    remove(graphic) {
        const index = this.graphics.indexOf(graphic);
        if (index > -1) {
            this.graphics.splice(index, 1);
        }
    }

    draw() {
        this.graphics.forEach(graphic => graphic.draw());
    }
}

// Client Code
const circle = new Circle();
const rectangle = new Rectangle();

const group = new GraphicGroup();
group.add(circle);
group.add(rectangle);

group.draw();  
// Output:
// Drawing a Circle
// Drawing a Rectangle

const anotherGroup = new GraphicGroup();
anotherGroup.add(group);
anotherGroup.add(new Circle());

anotherGroup.draw();
// Output:
// Drawing a Circle
// Drawing a Rectangle
// Drawing a Circle
