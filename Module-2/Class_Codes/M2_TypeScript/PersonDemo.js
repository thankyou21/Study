//****Class & Constructor **************
var Person = /** @class */ (function () {
    function Person(id, name) {
        this.id = id;
        this.name = name;
    }
    Person.prototype.showDetails = function () {
        console.log("\n\n" + this.id + "   " + this.name);
    };
    Person.showLocation = function () {
        console.log("Pune");
    };
    return Person;
}());
var p = new Person(101, " Rishav");
p.showDetails();
Person.showLocation();
