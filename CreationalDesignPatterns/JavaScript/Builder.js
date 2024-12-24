// Product
class House {
    constructor() {
        this.parts = [];
    }

    addPart(part) {
        this.parts.push(part);
    }

    showParts() {
        console.log("House Parts:", this.parts.join(", "));
    }
}

// Builder
class HouseBuilder {
    constructor() {
        this.house = new House();
    }

    buildWalls() {
        this.house.addPart("Walls");
        return this;
    }

    buildRoof() {
        this.house.addPart("Roof");
        return this;
    }

    
    buildDoors() {
        this.house.addPart("Doors");
        return this;
    }

    getResult() {
        return this.house;
    }
}

// Director
class HouseDirector {
    construct(builder) {
        builder.buildWalls().buildRoof().buildDoors();
    }
}

// Client Code
const builder = new HouseBuilder();
const director = new HouseDirector();

director.construct(builder);
const house = builder.getResult();
house.showParts(); // Output: House Parts: Walls, Roof, Doors
