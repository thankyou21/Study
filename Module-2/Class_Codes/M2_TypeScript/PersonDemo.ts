//****Class & Constructor **************
class Person
{
	id:number;
	name:string;
	
	constructor(id:number, name:string)
	{
		this.id=id;
		this.name=name;
	}
	
	showDetails():void
	{
		console.log("\n\n"+this.id+"   "+this.name);
	}
	
	static showLocation():void
	{
		console.log("Pune");
	}
}
let p = new Person(101, " Rishav");
p.showDetails();
Person.showLocation();