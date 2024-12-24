// Flyweight
class Tree {
    constructor(type) {
        this.type = type; // Shared state
    }

    display(x, y) {
        console.log(`Tree of type ${this.type} displayed at coordinates (${x}, ${y})`);
    }
}

// FlyweightFactory
class TreeFactory {
    constructor() {
        this.trees = {};
    }

    getTree(type) {
        if (!this.trees[type]) {
            this.trees[type] = new Tree(type); // Create a new tree if not already created
        }
        return this.trees[type]; // Return the shared tree
    }
}

// Client Code
const treeFactory = new TreeFactory();

// Reusing the same tree object for different locations
const oakTree = treeFactory.getTree("Oak");
oakTree.display(1, 1); // Output: Tree of type Oak displayed at coordinates (1, 1)
oakTree.display(2, 3); // Output: Tree of type Oak displayed at coordinates (2, 3)

const pineTree = treeFactory.getTree("Pine");
pineTree.display(4, 5); // Output: Tree of type Pine displayed at coordinates (4, 5)

const anotherOakTree = treeFactory.getTree("Oak");
anotherOakTree.display(7, 8); // Output: Tree of type Oak displayed at coordinates (7, 8)
