var animationName = GetRequest()['animationName'];
var username = getCookie("user");
if (!animationName) {
    window.location = "../html/index.html";
}
document.getElementById("userName").innerHTML = username;
$.ajax({
    url: "http://127.0.0.1:8080/animation/updateAnimationPageViewByName",
    method: 'post',
    data: {animationName: animationName},
    dataType: "json",
    beforeSend: function (request) {
        request.setRequestHeader("authorization", "Bearer " + getCookie("token"));
    }
});

function getAnimation() {
    $.ajax({
        url: "http://127.0.0.1:8080/animation/getAnimationByName",
        method: 'get',
        data: {animationName: animationName},
        dataType: "json",
        success: function (animation) {
            var animationName = document.getElementById("animationName");
            var cover = document.getElementById("cover");
            var type = document.getElementById("type");
            var link = document.getElementById("link");
            var detail = document.getElementById("detail");
            var recommendation = document.getElementById("recommendation");
            var pageView = document.getElementById("pageView");
            var likeNum = document.getElementById("likeNum");
            var dislikeNum = document.getElementById("dislikeNum");
            animationName.innerText = animation.name;
            cover.setAttribute('src', animation.cover);
            var types = [];
            for (var i = 0; i < animation.types.length; i++) {
                types[types.length] = animation.types[i].name;
            }
            type.innerText = types.toString();
            link.innerText = animation.link;
            recommendation.innerText = animation.recommendation;
            detail.innerText = animation.detail;
            pageView.innerText = animation.page_view;
            likeNum.innerText = animation.like_num;
            dislikeNum.innerText = animation.unlike_num;
        }
    });
}

function GetRequest() {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = decodeURI(strs[i].split("=")[1]);
        }
    }
    return theRequest;
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

function getAllComments() {
    $.ajax({
        url: "http://127.0.0.1:8080/comment/getAllComments",
        method: 'get',
        data: {animationName: animationName},
        dataType: "json",
        success: function (comments) {
            console.log(comments);
            var comment_show = document.getElementById("comment_show");
            for (var i = 0; i < comments.length; i++) {
                var row = document.createElement("div");
                row.classList.add("row");
                var div = document.createElement("div");
                div.setAttribute('style', "overflow: hidden");
                div.classList.add("col-md-10");
                var label = document.createElement("label");
                label.innerText = comments[i].username;
                label.classList.add("col-md-offset-1");
                div.appendChild(label);
                var textarea = document.createElement("textarea");
                textarea.classList.add("col-md-4");
                textarea.classList.add("col-md-offset-2");
                textarea.setAttribute('style', " overflow-y: auto;height: 50px;width: 105%;padding-right:5%;border: none");
                textarea.setAttribute('readonly', " readonly");
                textarea.innerText = comments[i].comment.comment;
                var time = document.createElement("label");
                var timeContent = comments[i].comment.updateTime;
                if (timeContent == null)
                    timeContent = comments[i].comment.createTime;
                time.innerText = timeContent;
                time.classList.add("col-md-offset-9");
                div.appendChild(textarea);
                div.appendChild(time);
                row.appendChild(div);
                comment_show.appendChild(row);
                var hr = document.createElement("hr");
                hr.classList.add("split-pane-divider");
                comment_show.appendChild(hr);
            }
        }
    });
}

function comment() {
    if (!username) {
        swal("评论失败", "请先登录", "error");
        return;
    }
    var comment = document.getElementById("write_comment").value;
    if (comment.length === 0) {
        swal("评论失败", "未填写评论", "error");
        return;
    }
    $.ajax({
        url: "http://127.0.0.1:8080/comment/commentAnimation",
        method: 'post',
        data: {username: username, comment: comment, animationName: animationName},
        dataType: "json",
        beforeSend: function (request) {
            request.setRequestHeader("authorization", "Bearer " + getCookie("token"));
        },
        success: function (result) {
            if (result.result) {
                swal("评论成功", "", "success");
                document.getElementById("write_comment").value = "";
                var comment_show = document.getElementById("comment_show");
                while (comment_show.firstChild) {
                    comment_show.removeChild(comment_show.firstChild);
                }
                getAllComments();

            } else {
                swal("评论失败", result.message, "success")
            }
        }
    });

}

function like() {
    if (!username) {
        swal("点赞失败", "请先登录", "error");
        return;
    }
    $.ajax({
        url: "http://127.0.0.1:8080/attitude/likeIt",
        method: 'post',
        data: {username: username, animationName: animationName},
        dataType: "json",
        beforeSend: function (request) {
            request.setRequestHeader("authorization", "Bearer " + getCookie("token"));
        },
        success: function (result) {
            if (result.result) {
                swal("点赞成功", "", "success");
                getAnimation();
            } else {
                swal("点赞失败", result.message, "error");
            }
        }
    });
}

function dislike() {
    if (!username) {
        swal("点踩失败", "请先登录", "error");
        return;
    }
    $.ajax({
        url: "http://127.0.0.1:8080/attitude/dislikeIt",
        method: 'post',
        data: {username: username, animationName: animationName},
        dataType: "json",
        beforeSend: function (request) {
            request.setRequestHeader("authorization", "Bearer " + getCookie("token"));
        },
        success: function (result) {
            if (result.result) {
                swal("点踩成功", "", "success");
                getAnimation();
            } else {
                swal("点踩失败", result.message, "error");
            }
        }
    });
}

getAnimation();

getAllComments();

