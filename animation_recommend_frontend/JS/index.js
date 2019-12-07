document.getElementById("userName").innerHTML = getCookie("user");

$.ajax({
    url: "http://127.0.0.1:8080/type/getAnimationByType",
    method: 'get',
    data: {typeName: "青春"},
    dataType: "json",
    success: function (data) {
        document.getElementById("young1").innerHTML = "<p style='color: white'>"+data[0].name+"</p>"+"<img src=\""+data[0].cover+"\">";
        document.getElementById("young2").innerHTML = "<p style='color: white'>"+data[1].name+"</p>"+"<img src=\""+data[1].cover+"\">";
        document.getElementById("young3").innerHTML = "<p style='color: white'>"+data[2].name+"</p>"+"<img src=\""+data[2].cover+"\">";
    }
});

$.ajax({
    url: "http://127.0.0.1:8080/type/getAnimationByType",
    method: 'get',
    data: {typeName: "校园"},
    dataType: "json",
    success: function (data) {
        document.getElementById("campus1").innerHTML = "<p style='color: white'>"+data[0].name+"</p>"+"<img src=\""+data[0].cover+"\">";
        document.getElementById("campus2").innerHTML = "<p style='color: white'>"+data[1].name+"</p>"+"<img src=\""+data[1].cover+"\">";
        document.getElementById("campus3").innerHTML = "<p style='color: white'>"+data[2].name+"</p>"+"<img src=\""+data[2].cover+"\">";
    }
});

$.ajax({
    url: "http://127.0.0.1:8080/type/getAnimationByType",
    method: 'get',
    data: {typeName: "治愈"},
    dataType: "json",
    success: function (data) {
        document.getElementById("cure1").innerHTML = "<p style='color: white'>"+data[0].name+"</p>"+"<img src=\""+data[0].cover+"\">";
        document.getElementById("cure2").innerHTML = "<p style='color: white'>"+data[1].name+"</p>"+"<img src=\""+data[1].cover+"\">";
        document.getElementById("cure3").innerHTML = "<p style='color: white'>"+data[2].name+"</p>"+"<img src=\""+data[2].cover+"\">";
    }
});

$.ajax({
    url: "http://127.0.0.1:8080/type/getAnimationByType",
    method: 'get',
    data: {typeName: "热血"},
    dataType: "json",
    success: function (data) {
        document.getElementById("blood1").innerHTML = "<p style='color: white'>"+data[0].name+"</p>"+"<img src=\""+data[0].cover+"\">";
        document.getElementById("blood2").innerHTML = "<p style='color: white'>"+data[1].name+"</p>"+"<img src=\""+data[1].cover+"\">";
        document.getElementById("blood3").innerHTML = "<p style='color: white'>"+data[2].name+"</p>"+"<img src=\""+data[2].cover+"\">";
    }
});


document.getElementById("search").addEventListener("click", function () {
    var name = document.getElementById("aniName").value;
    const obj = {};
    obj.name = name;
    const jsonStr = JSON.stringify(obj);
    var json1 = JSON.parse(jsonStr);


    $.ajax({
        url: "http://127.0.0.1:8080/animation/searchByName",
        method: 'get',
        data: json1,
        dataType: "json",
        success: function (data) {
            var table_body = document.getElementById("tbody");
            if (table_body !== "undefined") {
                while(table_body .hasChildNodes()){
                    table_body.removeChild(table_body.lastChild);
                }
            }
            for (let i = 0; i < data.length; i++) {
                var editTable = document.getElementById("tbody");
                var tr = document.createElement("tr");
                var td0 = document.createElement("td");
                td0.innerHTML = data[i].name;
                var td1 = document.createElement("td");
                td1.innerHTML = data[i].like_num;
                var td2 = document.createElement("td");
                td2.innerHTML = data[i].unlike_num;
                var td3 = document.createElement("td");
                td3.innerHTML="<input type='button' value='查看详情' />";
                tr.appendChild(td0);
                tr.appendChild(td1);
                tr.appendChild(td2);
                tr.appendChild(td3);
                editTable.appendChild(tr);
            }
        }
    });

});

function checkDetails() {
    
}


function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toGMTString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name) === 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}