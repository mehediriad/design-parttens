// Iterator Interface
interface Iterator {
    boolean hasNext();
    Object next();
}

// ConcreteIterator
class ConcreteIterator implements Iterator {
    private Object[] items;
    private int index;

    public ConcreteIterator(Object[] items) {
        this.items = items;
        this.index = 0;
    }

    public boolean hasNext() {
        return index < items.length;
    }

    public Object next() {
        return items[index++];
    }
}

// Aggregate Interface
interface Aggregate {
    Iterator createIterator();
}

// ConcreteAggregate
class ConcreteAggregate implements Aggregate {
    private Object[] items;

    public ConcreteAggregate() {
        items = new Object[3];
    }

    public void add(int index, Object item) {
        items[index] = item;
    }

    public Iterator createIterator() {
        return new ConcreteIterator(items);
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        ConcreteAggregate aggregate = new ConcreteAggregate();
        aggregate.add(0, "Item 1");
        aggregate.add(1, "Item 2");
        aggregate.add(2, "Item 3");

        Iterator iterator = aggregate.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());  // Output: Item 1, Item 2, Item 3
        }
    }
}
