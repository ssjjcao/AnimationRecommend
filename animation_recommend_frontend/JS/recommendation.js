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

function deleteRecommendation(animationName, row, hr) {
    $.ajax({
        url: "http://127.0.0.1:8080/user/deleteRecommend",
        method: 'post',
        data: {username: username, animationName: animationName},
        dataType: "json",
        beforeSend: function (request) {
            request.setRequestHeader("authorization", "Bearer " + getCookie("token"));
        },
        success: function (result) {
            if (result.result) {
                swal("删除成功", "", "success");
                document.getElementById("recommendations").removeChild(row);
                document.getElementById("recommendations").removeChild(hr);
            } else {
                swal("删除失败", result.message, "error");
            }
        }
    });
}

var username = getCookie("user");
var nowPage = 1;
var totalPage;
if (!username) {
    window.location = "../html/login.html";
}
document.getElementById("userName").innerHTML = username;

getRecommendationsByPageNum();

function getRecommendationsByPageNum() {
    $.ajax({
        url: "http://127.0.0.1:8080/animation/getRecommendationsByUsernameAndPageNum",
        method: 'get',
        data: {pageNum: nowPage, username: username},
        dataType: "json",
        beforeSend: function (request) {
            request.setRequestHeader("authorization", "Bearer " + getCookie("token"));
        },
        success: function (result) {
            console.log(result);
            var recommendations = result.recommendations;
            totalPage = result.totalPage;
            var recommendations_container = document.getElementById("recommendations");

            for (var i = 0; i < recommendations.length; i++) {
                var recommendation = recommendations[i];

                var row = document.createElement("div");
                row.classList.add("row");
                var div_img = document.createElement("div");

                div_img.classList.add("col-md-2");
                div_img.classList.add("col-md-offset-1");

                var a_img = document.createElement("a");
                a_img.href = "../html/details.html?animationName=" + recommendation.name;

                var img = document.createElement("img");
                img.setAttribute("style", "width:100%;height: auto");
                img.src = recommendation.cover;

                a_img.appendChild(img);

                div_img.appendChild(a_img);

                row.appendChild(div_img);

                var div_message = document.createElement("div");

                div_message.classList.add("col-md-6");
                div_message.classList.add("col-md-offset-1");

                var div_name = document.createElement("div");
                div_name.classList.add("row");

                var b = document.createElement("b");
                b.setAttribute("style", "color: white;font-size: 20px");
                var a_name = document.createElement("a");
                a_name.href = "../html/details.html?animationName=" + recommendation.name;
                a_name.innerText = recommendation.name;
                b.appendChild(a_name);


                div_name.appendChild(b);

                div_message.appendChild(div_name);

                var div_detail = document.createElement("div");
                div_detail.classList.add("row");
                div_detail.setAttribute("style", "margin-top: 4%");

                var div_textarea = document.createElement("div");
                div_textarea.setAttribute("style", "overflow: hidden");

                var textarea = document.createElement("textarea");
                textarea.setAttribute("style", "overflow-y: auto;height: 100px;width: 105%;padding-right:5%;border: none;background: none;color: white");
                textarea.setAttribute("readonly", "readonly");
                textarea.innerText = recommendation.detail;

                div_textarea.appendChild(textarea);
                div_detail.appendChild(div_textarea);
                div_message.appendChild(div_detail);

                row.appendChild(div_message);

                var div_button = document.createElement("div");
                div_button.classList.add("col-md-1");
                div_button.setAttribute("style", "float: right");

                var button = document.createElement("button");
                button.classList.add("btn");
                button.classList.add("btn-warning");
                button.innerText = "删除推荐";

                div_button.appendChild(button);
                row.appendChild(div_button);

                recommendations_container.appendChild(row);

                var hr = document.createElement("hr");
                hr.classList.add("divider");
                recommendations_container.appendChild(hr);

                (function (animationName, row, hr) {
                    button.addEventListener("click", function (ev) {
                        deleteRecommendation(animationName, row, hr);
                    })
                })(recommendation.name, row, hr);

            }

            if (nowPage === 1 && !document.getElementById("last").classList.contains("disabled")) {
                document.getElementById("last").classList.add("disabled");
            } else if (nowPage > 1 && document.getElementById("last").classList.contains("disabled")) {
                document.getElementById("last").classList.remove("disabled");
            }

            if (nowPage === totalPage && !document.getElementById("next").classList.contains("disabled")) {
                document.getElementById("next").classList.add("disabled");
            } else if (nowPage < totalPage && document.getElementById("next").classList.contains("disabled")) {
                document.getElementById("next").classList.remove("disabled");
            }
        }
    });
}

function lastPage() {
    if (document.getElementById("last").classList.contains("disabled"))
        return;
    nowPage = nowPage - 1;
    var recommendations = document.getElementById("recommendations");
    while (recommendations.firstChild) {
        recommendations.removeChild(recommendations.firstChild);
    }
    getRecommendationsByPageNum();
}

function nextPage() {
    if (document.getElementById("next").classList.contains("disabled"))
        return;
    nowPage = nowPage + 1;
    var recommendations = document.getElementById("recommendations");
    while (recommendations.firstChild) {
        recommendations.removeChild(recommendations.firstChild);
    }
    getRecommendationsByPageNum();
}
