// Component
interface Graphic {
    void draw();
}

// Leaf
class Circle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// Composite
class GraphicGroup implements Graphic {
    private List<Graphic> graphics = new ArrayList<>();

    public void add(Graphic graphic) {
        graphics.add(graphic);
    }

    public void remove(Graphic graphic) {
        graphics.remove(graphic);
    }

    @Override
    public void draw() {
        for (Graphic graphic : graphics) {
            graphic.draw();
        }
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        Graphic circle = new Circle();
        Graphic rectangle = new Rectangle();

        GraphicGroup group = new GraphicGroup();
        group.add(circle);
        group.add(rectangle);

        group.draw();  
        // Output:
        // Drawing a Circle
        // Drawing a Rectangle

        GraphicGroup anotherGroup = new GraphicGroup();
        anotherGroup.add(group);
        anotherGroup.add(new Circle());

        anotherGroup.draw();
        // Output:
        // Drawing a Circle
        // Drawing a Rectangle
        // Drawing a Circle
    }
}
