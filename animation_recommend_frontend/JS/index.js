document.getElementById("userName").innerHTML = getCookie("user");

$.ajax({
    url: "http://127.0.0.1:8080/type/getAllTypes",
    method: 'get',
    dataType: "json",
    success: function (types) {
        console.log(types);
        var primary = document.getElementById("primary");
        for (var i = 0; i < types.length; i++) {
            var type = types[i].name;
            getAnimationsByType(type, primary);
        }
    }
});
//
// $.ajax({
//     url: "http://127.0.0.1:8080/type/getAnimationByType",
//     method: 'get',
//     data: {typeName: "青春"},
//     dataType: "json",
//     success: function (data) {
//         document.getElementById("young1").innerHTML = "<p style='color: white'>" + data[0].name + "</p>" + "<img src=\"" + data[0].cover + "\" width='50' height='300'>";
//         document.getElementById("young2").innerHTML = "<p style='color: white'>" + data[1].name + "</p>" + "<img src=\"" + data[1].cover + "\" width='50' height='300'>";
//         document.getElementById("young3").innerHTML = "<p style='color: white'>" + data[2].name + "</p>" + "<img src=\"" + data[2].cover + "\" width='50' height='300'>";
//     }
// });
//
// $.ajax({
//     url: "http://127.0.0.1:8080/type/getAnimationByType",
//     method: 'get',
//     data: {typeName: "校园"},
//     dataType: "json",
//     success: function (data) {
//         document.getElementById("campus1").innerHTML = "<p style='color: white'>" + data[0].name + "</p>" + "<img src=\"" + data[0].cover + "\" width='50px' height='300px'>";
//         document.getElementById("campus2").innerHTML = "<p style='color: white'>" + data[1].name + "</p>" + "<img src=\"" + data[1].cover + "\" width='50px' height='300px'>";
//         document.getElementById("campus3").innerHTML = "<p style='color: white'>" + data[2].name + "</p>" + "<img src=\"" + data[2].cover + "\" width='50px' height='300px'>";
//     }
// });
//
// $.ajax({
//     url: "http://127.0.0.1:8080/type/getAnimationByType",
//     method: 'get',
//     data: {typeName: "治愈"},
//     dataType: "json",
//     success: function (data) {
//         document.getElementById("cure1").innerHTML = "<p style='color: white'>" + data[0].name + "</p>" + "<img src=\"" + data[0].cover + "\" width='50px' height='300px'>";
//         document.getElementById("cure2").innerHTML = "<p style='color: white'>" + data[1].name + "</p>" + "<img src=\"" + data[1].cover + "\" width='50px' height='300px'>";
//         document.getElementById("cure3").innerHTML = "<p style='color: white'>" + data[2].name + "</p>" + "<img src=\"" + data[2].cover + "\" width='50px' height='300px'>";
//     }
// });
//
// $.ajax({
//     url: "http://127.0.0.1:8080/type/getAnimationByType",
//     method: 'get',
//     data: {typeName: "热血"},
//     dataType: "json",
//     success: function (data) {
//         document.getElementById("blood1").innerHTML = "<p style='color: white'>" + data[0].name + "</p>" + "<img src=\"" + data[0].cover + "\" width='50px' height='300px'>";
//         document.getElementById("blood2").innerHTML = "<p style='color: white'>" + data[1].name + "</p>" + "<img src=\"" + data[1].cover + "\" width='50px' height='300px'>";
//         document.getElementById("blood3").innerHTML = "<p style='color: white'>" + data[2].name + "</p>" + "<img src=\"" + data[2].cover + "\" width='50px' height='300px'>";
//     }
// });


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
                while (table_body.hasChildNodes()) {
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
                // td3.innerHTML = "<input type='button' value='查看详情'/>";

                var button = document.createElement("button");
                button.classList.add("btn");
                button.classList.add("btn-info");
                button.innerText = "查看详情";

                (function (name) {
                    button.addEventListener("click", function (ev) {
                        window.location = "../html/details.html?animationName=" + name;
                    });
                })(data[i].name);

                td3.appendChild(button);

                tr.appendChild(td0);
                tr.appendChild(td1);
                tr.appendChild(td2);
                tr.appendChild(td3);
                editTable.appendChild(tr);
            }
        }
    });

});

function getAnimationsByType(type, primary) {
    $.ajax({
        url: "http://127.0.0.1:8080/type/getAnimationByType",
        method: 'get',
        data: {typeName: type},
        dataType: "json",
        success: function (animations) {
            var num = animations.length > 3 ? 3 : animations.length;
            if (num === 3) {
                console.log(animations);
                var article = document.createElement("article");
                var header = document.createElement("header");
                header.classList.add("text-center");
                header.classList.add("text-muted");
                header.setAttribute('style', 'font-size: x-large;margin-left: 30%; color: white');
                header.innerText = type;
                article.appendChild(header);
                var div = document.createElement("div");
                div.classList.add("imgBox");
                div.setAttribute('style', 'margin-left: 30%; display: flex; position: relative; width: 900px');

                for (var j = 0; j < num; j++) {
                    var div_animation = document.createElement("div");
                    div_animation.setAttribute('style', 'width: 300px');
                    div_animation.innerHTML = "<p style='color: white;position:center'>" + "<a href='../html/details.html?animationName=" + animations[j].name + "'>" + animations[j].name + "</a>" + "</p>"
                        + "<a href='../html/details.html?animationName=" + animations[j].name + "'>" + "<img src=\"" + animations[j].cover + "\" width='50' height='300'>" + "</a>";
                    div.appendChild(div_animation);
                }
                article.appendChild(div);
                primary.appendChild(article);
            }
        }
    });
}

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

var index = 0;

//改变图片
function ChangeImg() {
    index++;
    var a = document.getElementsByClassName("img-slide");
    if (index >= a.length) index = 0;
    for (var i = 0; i < a.length; i++) {
        a[i].style.display = 'none';
    }
    a[index].style.display = 'block';
}

//设置定时器，每隔两秒切换一张图片
setInterval(ChangeImg, 2000);