var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    }
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
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
var Employee = /** @class */ (function (_super) {
    __extends(Employee, _super);
    function Employee(id, name, sal) {
        var _this = _super.call(this, id, name) || this;
        _this.sal = sal;
        return _this;
    }
    Employee.prototype.showDetails = function () {
        _super.prototype.showDetails.call(this);
        console.log(this.sal);
    };
    return Employee;
}(Person));
var e = new Employee(101, "Rishav", 5000);
e.showDetails();
