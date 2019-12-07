const obj = {};
obj.username = getCookie("user");
const jsonStr = JSON.stringify(obj);
var json1 = JSON.parse(jsonStr);

$.ajax({
    url: "http://127.0.0.1:8080/user/getUserInfo",
    method: 'get',
    data: json1,
    dataType: "json",
    beforeSend: function (request) {
        request.setRequestHeader("authorization", "Bearer "+ getCookie("token"));
    },
    success: function (data) {
        console.log(data);
        console.log(data.data.id);
        console.log(data.data.name);
        console.log(data.data.signature);
        document.getElementById("ID").innerHTML = data.data.id;
        document.getElementById("name").innerHTML = data.data.name;
        document.getElementById("signature").innerHTML = data.data.signature;

    }
});


document.getElementById("edit").addEventListener("click", function () {
    window.location.href = "./editInfo.html"
});



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