'use strict';

// singleline comments
/* multiline comments*/
console.log("__ TOPIC: DECLARING VARIABLES __");

var text1 = "abc"; // same as in Java: private string text1 = "abc";
var text2 = 'abc';
console.log("Concatenating strings: " + text1 + "-" + text2);

var aggregate = 5 + text1 + "-" + text2 + "-something-else";
console.log(aggregate);

var number1 = 5;
var number2 = 5.012;
var number3 = 5000000000000000000000000000000000000000000.012;

console.log("Adding numbers: " + number1 + " + " + number2 + " = " + number1 + number2); // this will not work
console.log("Adding numbers: " + number1 + " + " + number2 + " = " + (number1 + number2));
console.log(number3 + 0.1);


var boolean1 = true;
var boolean2 = false;


console.log(""); console.log("__ TOPIC: BASIC OPERATORS __");
console.log(">>" + 1 % 2); // prints 1
console.log(">>" + (boolean1 && boolean2)); // prints what?

// some more advanced ways to declaring variables
var x = 5, y = 6, z = 7;

var a = 10,
    b   = 30,
    c   = 90;


// Keyword let
// Introduced in ES2015 (aka ES6), the variable type let shares a lot of similarities with var but unlike var has scope constraints.
// let is constrained to whichever scope it is declared in. Its declaration and assignment are similar to var
// ATTENTION: uncomment to see error

// let x = 20;
// let x = 50; // SyntaxError: identifier "x" has already been declared.
// compare with:
// var x = 20;
// var x = 50; // SyntaxError: identifier "x" has already been declared.


// Keyword const
// Also introduced in ES2015, const, is a variable type
// assigned to data whose value cannot and will not be changed throughout the script.
// ATTENTION: uncomment to see error
// const name = 'chris';
// name = 'john'; // Uncaught TypeError: Assignment to constant variable.


// == VS ===
// In JavaScript there are two comparison operators. If
//  we want to compare values we use == operator. If we
//  want to compare values and types we use ===.
console.log(5 == 5); // prints true
console.log("5" == 5); // prints true
console.log("5" === 5); // prints false (types differ)


console.log(""); console.log("___ TOPIC: Conditionals ___");

var first = 10;
var second = 20;
//let second = 21; // error
if(first > second){
    console.log("First is bigger than second!");
} else {
    // let second = 8; // but here we can redeclare because the scope changed
    // console.log("Second inside the if/else block: " + second)
    console.log("First is smaller than second!");
}


console.log(""); console.log("___ TOPIC: Loops ___");
for(var i = 0; i < 3; i++) {
    console.log("Inside for() loop, i is now:" + i);
}

var i = 0;
while(i < 3) {
    console.log("Inside while() loop, i is now:" + i);
    i++;
}

console.log(""); console.log("___ TOPIC: Arrays ___");

var myAwesomeArray = [1, 4, 7];

console.log(myAwesomeArray[2]); // prints 7, since arrays are 0 based
console.log(myAwesomeArray.length); // prints 3
console.log(myAwesomeArray[myAwesomeArray.length - 1]); // gets the last element

myAwesomeArray.push(9); // arrays are dynamic so we can extend them with additional elements

console.log(myAwesomeArray[2]); // prints 7
console.log(myAwesomeArray.length); // prints 4

// arrays have a lot of functionality associated, see: https://www.w3schools.com/jsref/jsref_obj_array.asp
// ... like map, filter, reduce (what JAVA's streams provide as well)
var personel = [
    {
        id: 51,
        name: "Joana",
        baseSalary: 450,
        bonus: true,
        gender: "female"
    },
    {
        id: 2,
        name: "Jonas",
        salary: 600,
        bonus: false,
        gender: "male"
    },
    {
        id: 432,
        name: "Marta",
        salary: 1005,
        bonus: true,
        gender: "female"
    },
    {
        id: 44,
        name: "Petras",
        salary: 450,
        bonus: true,
        gender: "male"
    }
];

// Can we have an array of mixed datatypes?
var mixedArray = ["A", 1, "Boo", true, ["Array", "Array"], {type: "object"}];
for(var i = 0; i < mixedArray.length; i++) {
    console.log("Type of " + mixedArray[i] + " = " + (typeof mixedArray[i]));
}

// Type of A = string
// Type of 1 = number
// Type of Boo = string
// Type of true = boolean
// Type of Array,Array = object
// Type of [object Object] = object

// TODO :: inserting at random position with .splice()

// myArr.filter(func(){});
var males = personel.filter(function (person) {
    if (person.gender === "male")
        return person;
});

console.log("Male personnel:")
console.log(males);


// let's combine them together w/ filter, map reduce
var avgMaleSalary = personel
    .filter(function (person) {
        if (person.gender === "male")
            return person;
    }).map(function (male) {
        if (male.bonus === true)
            male.salary += 105;
        return male.salary;
        // reduce(function(total, amount, index, array){});
    }).reduce(function(sum, salary, i, male){
        if(i === male.length - 1){
            sum += salary;
            return sum / male.length;
        }
        return sum += salary;
    }, 0);

console.log("Avg male salary: " + avgMaleSalary);

console.log(""); console.log("___ TOPIC: Functions ___");

// inbuilt functions:
// https://www.w3schools.com/jsref/jsref_obj_global.asp

// function declaration
function myFunction(firstParam, secondParam){
    return firstParam + secondParam;
}

// function invocation - calling the function
console.log(myFunction(1, 2))
console.log(myFunction("a", "b"))

// TODO :: varargs --> https://stackoverflow.com/questions/1959040/is-it-possible-to-send-a-variable-number-of-arguments-to-a-javascript-function

// Default parameters to functions
function greet_a_person(name = "Mindaugas"){
    console.log("Hello " + name + "!");
}

greet_a_person("Bart");
// greet_a_person();

// Arrow functions
// ES5
var multiplyES5 = function(x, y) {
    return x * y;
};

// ES6
const multiplyES6 = (x, y) => { return x * y };


console.log(""); console.log("___ TOPIC: Objects ___");
// Object literal - one way to create objects
var cat = {
    weight: 12.2,
    name: "Fluffy",
    fur: false
};

// Two ways to access the properties
console.log(cat.weight);
console.log(cat.name);
console.log(cat.fur);

// Another way to access properties. This
// way is useful because you can use valid srings
// that are NOT VALID variable names to give to your objects
// maybe you received them from user input or some file
console.log(cat["weight"]);
console.log(cat["name"]);
console.log(cat["fur"]);


// We can add a property to our object afterwards
cat.age = 4;
console.log(cat.age);

// Adding functions / behavior to our objects
// ... we can also do it after we created them
// ... this is very hard to do in java, but in
// ... dynamically typed lanaguages it is easy
cat.speak = function(){ console.log("Meow!") };
cat.speak();

// Or we can add it to our object literal
// var cat = {
//    weight: 12.2,
//    name: "Flufy",
//    fur: false,
//    speak: function(timesToSpeak) {
//        for(var i = 0; i < timesToSpeak; i++)
//            console.log("Meow!")
//    }
// };
// cat.speak(6);

// Using constructor functions to create objects - the second way
function Cat(name, color){
    this.name = name;
    this.color = color
}

var myCat = new Cat("Fluffy", "White");
console.log(myCat);

// Object.create() - the 3rd way
let car = Object.create(Object.prototype,
    {
        name: {
            value: 'Fiesta',
            configurable: true,
            writable: true,
            enumerable: false
        },
        maker: {
            value: 'Ford',
            configurable: true,
            writable: true,
            enumerable: true
        }
    });

console.log(car.name);

// Ecmascript6 Classes - the 4th way
class Dog {
    constructor(name, color){
        this.name = name
        this.color = color
    }

    speak() {
        console.log('Whoof!')
    }
}

var dog = new Dog('Floyd', 'Black');
console.log(dog);
dog.speak();


// we can have other objects as properties (composition)
var person = {
    fullname: {first: 'Mindaugas', last: 'Orange'},
    age: 28
};

// we can serialize our objects easily into json
// we can disable serialization by changing the object fields enumerable property to false
console.log(JSON.stringify(person))

// one can delete the property
delete person.age;
console.log(JSON.stringify(person))

// getters and setters
var person = {
    firstName: "John",
    lastName : "Doe",
    language : "",
    get fullName() {
        console.log("Using getter");
        return this.firstName + " " + this.lastName;
    },
    set lang(lang) {
        // as usual, setters ensure quality of data being set
        console.log("Using setter");
        this.language = lang.toUpperCase();
    }
};

// Display data from the object using a getter:
console.log(person.fullName);
person.lang = "LT";

console.log(""); console.log("___ TOPIC: Inheritence ___");

// Javascript uses what is called PROTOTYPE based inheritence, or prototypical inheritence
// ... do we use prototypes?

// How to create a new method that all arrays will have, called "last()"
var arr = ['red', 'green', 'blue'];

// to get the last element we do:
console.log(arr[arr.length - 1]);

// but what if we wanted to simplify it and use it like this:
// console.log(arr.last);

// js arrays do not have a .last property, but since JS is dynamic we can add it
// Object.defineProperty(arr, 'last', {get: function(){
//     return this[this.length - 1]
// }});

console.log("Last property using assigned property: " + arr.last);

// ... now, in order for all arrays to have this property we can add it to the array prototype
Object.defineProperty(Array.prototype, 'last', {get: function(){
        return this[this.length - 1]
    }});

var arr2 = ['red', 'green', 'blue'];
console.log(arr2.last);

// ... what is a prototype?
// var arr = [] is just a function and functions prototype is an object that will become a template
// or prototype for all objects created using the function as a constructor

function Kitty(name, color){
    this.name = name;
    this.color = color;
}

var myKitty = new Kitty("Jack", "Black");
console.log(Kitty.prototype);
console.log(myKitty.__proto__);
console.log(myKitty.__proto__ === Kitty.prototype);

// adding properties to a functions from which objects are constructed prototype changes all the objects
function Doggo(name){
    this.name = name
}

var dino = new Doggo('dino');
var maylo = new Doggo('maylo');

console.log(dino);
console.log(maylo);

Doggo.prototype.age = 5;

console.log(dino.age);
console.log(maylo.age);

// creating our own prototypical inheritence chains
//function Animal(voice){
//    this.voice = voice || 'grunt'
//}
//
//Animal.prototype.speak = function(){
//    return this.voice
//}
//
//// assign Animal as a property of Doggo class
//// Object.create()does not call the Animal constructor, so that is why we use it
//function Pooper(name, color){
//    Animal.call(this, 'Whoof!') // calling the super constructor
//    this.name = name
//    this.color = color
//}
//
//Pooper.prototype = Object.create(Animal.prototype)
//Pooper.prototype.constructor = Pooper
//var riky = new Pooper('riky')
//
//console.log("Riky says: " + riky.speak())
//console.log(riky.__proto__)
//console.log(riky.__proto__.__proto__)


// we can acomplish the same using classes
class Animal {
    constructor(voice){
        this.voice = voice || 'grunt'
    }
    speak(){
        return this.voice
    }
}

class Pooper extends Animal {
    constructor(name, color){
        super('Woof Woof!');
        this.name = name;
        this.color = color;
    }
}

var riky = new Pooper('riky')
console.log(riky.speak())

console.log(""); console.log("___ TOPIC: Algorithms ___");
// because we have functions we can write encapsulated, reusable algorithms
// for example: sort function that would sort objects returned from a backend
// and render them on screen once they are sorted.

var a = [33, 103, 3, 726, 200, 984, 198, 764, 9];

function bubbleSort(items) {
    var length = items.length;
    var swapped = false;
    for (var i = 0; i < length; i++) {
        for (var j = 0; j < (length - i - 1); j++) {
            if(items[j] > items[j+1]) {
                var tmp = items[j];
                items[j] = items[j+1];
                items[j+1] = tmp;
                swapped = true;
            }
        }
        if(!swapped)
            break;
    }
}

console.log("Before:\t" + a);
bubbleSort(a);
console.log("After:\t" + a);

// How would we sort an array of objects in JS?
// ... define a JSON string that will contain data we will use to get a some objects
// ... create an array of objects from it
// ... sort that array
// ... populate html table

console.log(""); console.log("___ TOPIC: Design patterns ___");

var Singleton = (function () {
    var instance;

    function createInstance() {
        var object = new Object("I am the instance");
        return object;
    }

    return {
        getInstance: function () {
            if (!instance) {
                instance = createInstance();
            }
            return instance;
        }
    };
})();


var instance1 = Singleton.getInstance();
var instance2 = Singleton.getInstance();

//console.log(instance1);
//console.log(instance2);

// Singleton.createInstance is not a function, we can't call it directly
//var instance2 = Singleton.createInstance();

console.log("Same instance? " + (instance1 === instance2));