// Flyweight
class Tree {
    private String type; // Shared state

    public Tree(String type) {
        this.type = type;
    }

    public void display(int x, int y) {
        System.out.println("Tree of type " + this.type + " displayed at coordinates (" + x + ", " + y + ")");
    }
}

// FlyweightFactory
class TreeFactory {
    private Map<String, Tree> treeMap = new HashMap<>();

    public Tree getTree(String type) {
        if (!treeMap.containsKey(type)) {
            treeMap.put(type, new Tree(type)); // Create a new tree if not already created
        }
        return treeMap.get(type); // Return the shared tree
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        TreeFactory treeFactory = new TreeFactory();

        // Reusing the same tree object for different locations
        Tree oakTree = treeFactory.getTree("Oak");
        oakTree.display(1, 1); // Output: Tree of type Oak displayed at coordinates (1, 1)
        oakTree.display(2, 3); // Output: Tree of type Oak displayed at coordinates (2, 3)

        Tree pineTree = treeFactory.getTree("Pine");
        pineTree.display(4, 5); // Output: Tree of type Pine displayed at coordinates (4, 5)

        Tree anotherOakTree = treeFactory.getTree("Oak");
        anotherOakTree.display(7, 8); // Output: Tree of type Oak displayed at coordinates (7, 8)
    }
}
