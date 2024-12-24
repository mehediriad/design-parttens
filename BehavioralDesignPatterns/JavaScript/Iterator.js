// Iterator Interface
class Iterator {
    next() {
        throw new Error("This method must be overridden.");
    }

    hasNext() {
        throw new Error("This method must be overridden.");
    }
}

// ConcreteIterator
class ConcreteIterator extends Iterator {
    constructor(collection) {
        super();
        this.collection = collection;
        this.index = 0;
    }

    next() {
        return this.collection[this.index++];
    }

    hasNext() {
        return this.index < this.collection.length;
    }
}

// Aggregate (Collection Interface)
class Aggregate {
    createIterator() {
        throw new Error("This method must be overridden.");
    }
}

// ConcreteAggregate
class ConcreteAggregate extends Aggregate {
    constructor() {
        super();
        this.items = [];
    }

    add(item) {
        this.items.push(item);
    }

    createIterator() {
        return new ConcreteIterator(this.items);
    }
}

// Client Code
const aggregate = new ConcreteAggregate();
aggregate.add("Item 1");
aggregate.add("Item 2");
aggregate.add("Item 3");

const iterator = aggregate.createIterator();

while (iterator.hasNext()) {
    console.log(iterator.next());  // Output: Item 1, Item 2, Item 3
}
