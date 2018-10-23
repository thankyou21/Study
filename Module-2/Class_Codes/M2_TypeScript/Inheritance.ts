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

class Employee extends Person
{
	sal:number;
	constructor(id:number, name:string, sal:number)
	{
		super(id,name);
		this.sal=sal;
	}
	
	showDetails():void
	{
		super.showDetails();
		console.log(this.sal);
	}
}

let e=new Employee(101, "Rishav", 5000);
e.showDetails();