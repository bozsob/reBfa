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

            var htmlString = "<table id='table'><tr>" +
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

    $("#add").click(function () {

        var brand = $("#brand").val();
        var year = $("#year").val();
        var color = $("#color").val();
        var tradingId = getIdFromUrl();

        $.ajax({
            url: "/car",
            type: "post",
            data: {"brand":brand, "year":year, "color":color, "tradingId":tradingId},
            success: function (data) {
                console.log(data);

                var newLine = "<tr><td>" + data.id + "</td>" +
                    "<td>" + data.brand + "</td>" +
                    "<td>" + data.year + "</td>" +
                    "<td>" + data.color + "</td>" +
                    "<td>" + data.tradingId + "</td>" +
                    "</tr>";
                $("#table").append(newLine);
            }
        })

    })

    function getIdFromUrl() {
        var id = window.location.search.substring(11);
        console.log("id: " + id);
        return id;
    }
});




