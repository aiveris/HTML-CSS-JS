console.log("External JS file is being executed");

// getting the dom elements
var element = document.getElementById("some-id");
var elements = document.getElementsByClassName("some-class");

// accesing the HTML
var innerHTML = element.innerHTML;
console.log(innerHTML);

// changing the HTML itself
element.innerHTML = "<div><p>New inner HTML</p></div>";
console.log(innerHTML);

// getting the css properties
for (var i = 0; i < elements.length; i++) {
    console.log("Element " + i + ": " + getComputedStyle(elements[i]).color);
    console.log("Element " + i + ": " + getComputedStyle(elements[i]).textDecoration);
//    console.log("Element " + i + ": " + JSON.stringify(getComputedStyle(elements[i])));
}

// changing the css properties
for (var i = 0; i < elements.length; i++) {
    elements[i].style.color = "blue";
//    getComputedStyle(elements[i]).color = "blue"; // These styles are computed, and therefore the 'color' property is read-only.
}

// events
document.getElementById("my-button").onclick = displayDate;

function displayDate() {
    document.getElementById("date-paragraph").innerHTML = '<h1>' + Date() + '</h1>';
}

// common events:
// onchange        An HTML element has been changed
// onclick        The user clicks an HTML element
// onmouseover    The user moves the mouse over an HTML element
// onmouseout    The user moves the mouse away from an HTML element
// onkeydown    The user pushes a keyboard key
// onload        The browser has finished loading the page


// Exercise time: let's use another event and change another property using that event.

// 0. First - select the element w/ Javascript
var elemementForExcercise = document
    .getElementById("excercise-paragraph");

// 1. Attach the event handler (... which will be the changeColor function)
elemementForExcercise.onmouseover = changeColor;

function changeColor(){
    document.getElementById("excercise-paragraph").style.color = "red";
    // elemementForExcercise.style.color = "red"; // possible to use like this, since var was used
}