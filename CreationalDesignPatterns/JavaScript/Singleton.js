class Singleton {
    constructor() {
        if (Singleton.instance) {
            return Singleton.instance; // আগের ইনস্ট্যান্স রিটার্ন করবে
        }
        Singleton.instance = this; // নতুন ইনস্ট্যান্স তৈরি
        this.data = "This is Singleton Instance";
    }

    getData() {
        return this.data;
    }
}

// Singleton ক্লাসের ইনস্ট্যান্স তৈরি
const instance1 = new Singleton();
console.log(instance1.getData()); // Output: This is Singleton Instance

const instance2 = new Singleton();
console.log(instance2.getData()); // Output: This is Singleton Instance

// ইনস্ট্যান্স দুটি একই কি না পরীক্ষা
console.log(instance1 === instance2); // Output: true
