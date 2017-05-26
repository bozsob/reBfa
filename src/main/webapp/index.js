$(document).ready(function() {

});

function getTradings() {

    $("#trading").empty();
    $("#car").hide();
    $("#trading").show();
    $.ajax({
        url: "/trading",
        type: "get",
        data: {"filter" : "trading"},
        success: function (data) {
            console.log(data);
            var htmlString = "<table><tr>" +
                "<th>Id</th>" +
                "<th>Name</th>" +
                "<th>City</th>" +
                "<th>Car Capacity</th></tr>";

            data.forEach(function (t) {
                htmlString += "<tr><td>" + t.id + "</td>" +
                    "<td><a href='car.html?tradingId=" + t.id + "'>" + t.name + "</a></td>" +
                    "<td>" + t.city + "</td>" +
                    "<td>" + t.carCapacity + "</td>" +
                    "</tr>";
            })
            htmlString += "</table>";
            $("#trading").append(htmlString);
        }
    })
}

function getCars() {

    $("#car").empty();
    $("#trading").hide();
    $("#car").show();
    $.ajax({
        url: "/trading",
        type: "get",
        data: {"filter" : "car"},
        success: function (data) {
            console.log(data);
            var htmlString = "<table><tr>" +
                "<th>Id</th>" +
                "<th>Brand</th>" +
                "<th>Year</th>" +
                "<th>Color</th>" +
                "<th>Trading Id</th>" +
                "</tr>";

            data.forEach(function (c) {
                htmlString += "<tr><td>" + c.id + "</td>" +
                    "<td>" + c.brand + "</td>" +
                    "<td>" + c.year + "</td>" +
                    "<td>" + c.color + "</td>" +
                    "<td>" + c.tradingId + "</td>" +
                    "</tr>";
            })
            htmlString += "</table>";
            $("#car").append(htmlString);
        }
    })
}


