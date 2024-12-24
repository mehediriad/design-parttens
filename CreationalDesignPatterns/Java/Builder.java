// Product
class House {
    private String walls;
    private String roof;
    private String doors;

    public void setWalls(String walls) {
        this.walls = walls;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    public void showParts() {
        System.out.println("House Parts: Walls=" + walls + ", Roof=" + roof + ", Doors=" + doors);
    }
}

// Builder
interface HouseBuilder {
    void buildWalls();
    void buildRoof();
    void buildDoors();
    House getResult();
}

// Concrete Builder
class ConcreteHouseBuilder implements HouseBuilder {
    private House house;

    public ConcreteHouseBuilder() {
        this.house = new House();
    }

    public void buildWalls() {
        house.setWalls("Concrete Walls");
    }

    public void buildRoof() {
        house.setRoof("Concrete Roof");
    }

    public void buildDoors() {
        house.setDoors("Wooden Doors");
    }

    public House getResult() {
        return this.house;
    }
}

// Director
class HouseDirector {
    public void construct(HouseBuilder builder) {
        builder.buildWalls();
        builder.buildRoof();
        builder.buildDoors();
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        HouseBuilder builder = new ConcreteHouseBuilder();
        HouseDirector director = new HouseDirector();

        director.construct(builder);
        House house = builder.getResult();
        house.showParts(); // Output: House Parts: Walls=Concrete Walls, Roof=Concrete Roof, Doors=Wooden Doors
    }
}
