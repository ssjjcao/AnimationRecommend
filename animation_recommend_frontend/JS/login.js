document.getElementById("register").addEventListener("click", function () {
    window.location.href = "./Register.html"
});


document.getElementById("submit").addEventListener("click", function () {
    const obj = {};
    obj.name = document.getElementById("username").value;
    setCookie("user", document.getElementById("username").value);
    obj.password = document.getElementById("password").value;
    const jsonStr = JSON.stringify(obj);
    var json1 = JSON.parse(jsonStr);

    $.ajax({
        url: "http://127.0.0.1:8080/user/signIn",
        method: 'post',
        data: json1,
        dataType: "json",
        success: function (data) {
            console.log(data);
            // alert(data.hasOwnProperty("result") + data.result);

            if (data.result) {
                alert("登陆成功");
                window.location.href = "./index.html";
                setCookie("token",data.result);
            }
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