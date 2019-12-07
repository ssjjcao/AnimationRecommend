document.getElementById("upload").addEventListener("click",function () {
    var animationName = document.getElementById("name").value;
    console.log(animationName);
    var recommend = document.getElementById("recommend").value;
    var link = document.getElementById("link").value;
    var animationInfo = document.getElementById("details").value;
    var tag = document.getElementsByName("tag");
    var tags = [];
    for (var i = 0; i < tag.length; i++) {
        if (tag[i].checked) {
            tags[i] = tag[i].value;
        }
    }
    var formData = new FormData();
    formData.append("username",getCookie("user"));
    formData.append("animationName",animationName);
    formData.append("recommend",recommend);
    formData.append("link",link);
    formData.append("animationInfo",animationInfo);
    formData.append("animationTypes",tags);
    formData.append("image",document.getElementById("cover").files[0]);

    console.log(getCookie("token"));
    console.log(tags);



    $.ajax({
        url: "http://127.0.0.1:8080/user/update",
        method: 'post',
        data: formData,
        dataType:"json",
        mimeType:"multipart/form-data",
        cache:false,
        contentType: false,
        processData: false,
        beforeSend: function (request) {
            request.setRequestHeader("authorization", "Bearer "+ getCookie("token"));
        },
        success: function (data) {
            alert(data.hasOwnProperty("message") + data.message);
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