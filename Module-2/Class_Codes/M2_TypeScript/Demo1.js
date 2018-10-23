var myname = "Rishav Halder";
console.log(myname);
//document.write("<h1>"+myname+"</h1>);
//for(let i=1; i<=5; i++)  here scope of i is inside for loop only
for (var i = 1; i <= 5; i++) //here scope of i is outside for loop also
 {
    console.log("i=" + i);
}
console.log("At the end i is " + i);
//****Arrow Function********************
var myFun1 = function (x) { return x * x; };
var myFun2 = function (x, y) { return (x.length * y); };
console.log("x * x = " + myFun1(5) + "\t\t where x=5");
console.log("x.length * y = " + myFun2("CapG", 5) + "\t where x='CapG' & y=5");
//****User Function********************
function fun1(x, y) {
    return x * y + y;
}
console.log("x * y + y = " + fun1(5, 6) + "\t\t where x=5 & y=6 \n");
//****User n-Array args****************
function sumOfNumbers() {
    var nums = [];
    for (var _i = 0; _i < arguments.length; _i++) {
        nums[_i] = arguments[_i];
    }
    var sum = 0;
    for (var _a = 0, nums_1 = nums; _a < nums_1.length; _a++) {
        var i_1 = nums_1[_a];
        sum += i_1;
    }
    return sum;
}
console.log("10+20=" + sumOfNumbers(10, 20));
console.log("10+20+30=" + sumOfNumbers(10, 20, 30));
console.log("10+20+30+40=" + sumOfNumbers(10, 20, 30, 40));
//****Template string Demo ***************
var n1 = 10;
var n2 = 20;
var result = "Sum of " + n1 + " and " + n2 + " is " + (n1 + n2);
console.log(result);
