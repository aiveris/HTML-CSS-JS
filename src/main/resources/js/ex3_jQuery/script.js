console.log("External JS file is being executed");

// place the script at the end, add defer or use the document ready pattern

var divElements = $("div");

// prints a collection of all div elements
console.log(divElements);

var element = $("#some-id");

// sets the new inner html
element.html("<div>new html</div>");

//Compare: it is simpler than doing this, like we did in prev. examples:
//var element = document.getElementById("some-id");
//var innerHTML = element.innerHTML;

// sets the inner text
element.text("new text");

// applies css rules
element.css({"color": "blue", "background-color": "red"});

// sets the attribute value
element.attr("id", "new-id");

// sets the attribute value
element.addClass("class-name");

// events
$('#doggo').mouseover(function(){
    $('#doggo').attr("src", "img-flipped.jpg")
});

$('#doggo').mouseout(function(){
    $('#doggo').attr("src", "img.jpg")
});