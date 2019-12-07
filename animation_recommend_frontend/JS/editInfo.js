document.getElementById("editInfo").addEventListener("click",function () {
    const obj = {};
    obj.username = getCookie("user");
    obj.newUsername = document.getElementById("name").value;
    obj.signature = document.getElementById("signature").value;
    var tag = document.getElementsByName("tag");
    var tags = [];
    for (var i = 0; i < tag.length; i++) {
        if (tag[i].checked) {
            tags = tag[i].value;
        }
    }
    obj.myTypes = tags;
    const jsonStr = JSON.stringify(obj);
    var json1 = JSON.parse(jsonStr);


    $.ajax({
        url: "http://127.0.0.1:8080/user/modifyUserInfo",
        method: 'post',
        data: json1,
        dataType: "json",
        beforeSend: function (request) {
            request.setRequestHeader("authorization", "Bearer "+ getCookie("token"));
        },
        success: function (data) {
            alert(data.hasOwnProperty("message") + data.message);

        }
    });
});


document.getElementById("editPass").addEventListener("click", function () {
    const obj = {};
    obj.username = getCookie("user");
    obj.oldPassword = document.getElementById("oldPass").value;
    obj.newPassword = document.getElementById("newPass").value;
    const jsonStr = JSON.stringify(obj);
    var json1 = JSON.parse(jsonStr);

    $.ajax({
        url: "http://127.0.0.1:8080/user/modifyPassword",
        method: 'post',
        data: json1,
        dataType: "json",
        beforeSend: function (request) {
            request.setRequestHeader("authorization", "Bearer "+ getCookie("token"));
        },
        success: function (data) {
            alert(data.hasOwnProperty("message") + data.message);
            window.location.href = "./login.html"
        }
    });
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