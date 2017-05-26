$(document).ready(function() {

    $("#carsbytrading").empty();
    $("#car").hide();
    $("#trading").hide();
    $("#carsbytrading").show();

    $.ajax({
        url: "/car",
        type: "get",
        data: {"tradingId" : getIdFromUrl()},
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
            $("#cars").append(htmlString);
        }

    })

    function getIdFromUrl() {
        var id = window.location.search.substring(11);
        console.log("id: " + id);
        return id;
    }
});




