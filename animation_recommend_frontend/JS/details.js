var animationName = GetRequest()['animationName'];
var username = getCookie("user");
var nowPage = 1;
var totalPage;
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

$.ajax({
    url: "http://127.0.0.1:8080/attitude/getAttitudeByUsernameAndAnimationName",
    method: 'get',
    data: {username: username, animationName: animationName},
    dataType: "json",
    beforeSend: function (request) {
        request.setRequestHeader("authorization", "Bearer " + getCookie("token"));
    },
    success: function (attitude) {
        if (attitude) {
            if (attitude.favorite) {
                var like = document.getElementById("like");
                like.classList.add("like");
                like.setAttribute("src", "../img/已点赞.png")
            } else {
                var dislike = document.getElementById("dislike");
                dislike.classList.add("dislike");
                dislike.setAttribute("src", "../img/已点踩.png")
            }
        }
    }
});

getCommentsByPageNum();

getAnimation();

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
            var comment_show = document.getElementById("comment_show");
            for (var i = 0; i < comments.length; i++) {
                var row = document.createElement("div");
                row.classList.add("row");
                var div = document.createElement("div");
                div.setAttribute('style', "overflow: hidden");
                div.classList.add("col-md-10");
                var div_label = document.createElement("div");
                div_label.classList.add("col-md-12");
                var label = document.createElement("label");
                label.innerText = comments[i].username;
                label.setAttribute("style", "float:left");
                div_label.appendChild(label);

                var time = document.createElement("label");
                var timeContent = comments[i].comment.updateTime;
                if (timeContent == null)
                    timeContent = comments[i].comment.createTime;
                time.innerText = timeContent;
                time.setAttribute("style", "float:right");
                div_label.appendChild(time);

                div.appendChild(div_label);

                var textarea = document.createElement("textarea");
                textarea.classList.add("col-md-4");
                textarea.classList.add("col-md-offset-2");
                textarea.setAttribute('style', " overflow-y: auto;height: 50px;width: 105%;padding-right:5%;border: none");
                textarea.setAttribute('readonly', " readonly");
                textarea.innerText = comments[i].comment.comment;
                div.appendChild(textarea);
                row.appendChild(div);

                var button = document.createElement("button");
                button.classList.add("btn");
                button.classList.add("btn-warning");
                button.setAttribute("style", "float:right;margin-top:2%;margin-right:4%;");
                button.innerText = "删除评论";

                row.appendChild(button);

                comment_show.appendChild(row);
                var hr = document.createElement("hr");
                hr.classList.add("split-pane-divider");
                comment_show.appendChild(hr);

                if (comments[i].username !== username) {
                    button.setAttribute("disabled", "disabled");
                } else {
                    (function (comment, row, hr) {
                        button.addEventListener("click", function (ev) {
                            deleteComment(comment, row, hr);
                        });
                    })(comments[i].comment.comment, row, hr);
                }
            }
        }
    });
}

function deleteComment(comment, row, hr) {
    $.ajax({
        url: "http://127.0.0.1:8080/comment/deleteOneComment",
        method: 'post',
        data: {comment: comment, username: username, animationName: animationName},
        dataType: "json",
        beforeSend: function (request) {
            request.setRequestHeader("authorization", "Bearer " + getCookie("token"));
        }, success: function (result) {
            if (result.result) {
                swal("删除成功", "", "success");
                var comment_show = document.getElementById("comment_show");
                comment_show.removeChild(row);
                comment_show.removeChild(hr);
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
                getCommentsByPageNum();
            } else {
                swal("评论失败", result.message, "error")
            }
        }
    });

}

function like() {
    if (!username) {
        swal("请先登录", "", "error");
        return;
    }
    if (document.getElementById("like").classList.contains("like")) {
        stopLikingIt();
    } else {
        likeIt();
    }
}

function likeIt() {
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
                var like = document.getElementById("like");
                like.classList.add("like");
                like.setAttribute("src", "../img/已点赞.png");
                var dislike = document.getElementById("dislike");
                if (dislike.classList.contains("dislike")) {
                    dislike.classList.remove("dislike");
                    dislike.setAttribute("src", "../img/点踩.png");
                }
            } else {
                swal("点赞失败", result.message, "error");
            }
        }
    });
}

function stopLikingIt() {
    $.ajax({
        url: "http://127.0.0.1:8080/attitude/stopLiking",
        method: 'post',
        data: {username: username, animationName: animationName},
        dataType: "json",
        beforeSend: function (request) {
            request.setRequestHeader("authorization", "Bearer " + getCookie("token"));
        },
        success: function (result) {
            if (result.result) {
                swal("取消点赞成功", "", "success");
                getAnimation();
                var like = document.getElementById("like");
                like.classList.remove("like");
                like.setAttribute("src", "../img/点赞.png");
            } else {
                swal("取消点赞失败", result.message, "error");
            }
        }
    });
}

function dislike() {
    if (!username) {
        swal("请先登录", "", "error");
        return;
    }
    if (document.getElementById("dislike").classList.contains("dislike")) {
        stopDislikingIt();
    } else {
        dislikeIt();
    }
}

function dislikeIt() {
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
                var dislike = document.getElementById("dislike");
                dislike.classList.add("dislike");
                dislike.setAttribute("src", "../img/已点踩.png");
                var like = document.getElementById("like");
                if (like.classList.contains("like")) {
                    like.classList.remove("like");
                    like.setAttribute("src", "../img/点赞.png");
                }
            } else {
                swal("点踩失败", result.message, "error");
            }
        }
    });
}

function stopDislikingIt() {
    $.ajax({
        url: "http://127.0.0.1:8080/attitude/stopDisliking",
        method: 'post',
        data: {username: username, animationName: animationName},
        dataType: "json",
        beforeSend: function (request) {
            request.setRequestHeader("authorization", "Bearer " + getCookie("token"));
        },
        success: function (result) {
            if (result.result) {
                swal("取消点踩成功", "", "success");
                getAnimation();
                var dislike = document.getElementById("dislike");
                dislike.classList.remove("dislike");
                dislike.setAttribute("src", "../img/点踩.png")
            } else {
                swal("取消点踩失败", result.message, "error");
            }
        }
    });
}

function getCommentsByPageNum() {
    $.ajax({
        url: "http://127.0.0.1:8080/comment/getAllCommentsByAnimationNameAndPageNum",
        method: 'get',
        data: {animationName: animationName, pageNum: nowPage},
        dataType: "json",
        beforeSend: function (request) {
            request.setRequestHeader("authorization", "Bearer " + getCookie("token"));
        },
        success: function (result) {
            console.log(result);
            var comment_show = document.getElementById("comment_show");
            var comments = result.comments;
            totalPage = result.totalPage;
            console.log(totalPage);
            for (var i = 0; i < comments.length; i++) {
                var row = document.createElement("div");
                row.classList.add("row");
                var div = document.createElement("div");
                div.setAttribute('style', "overflow: hidden");
                div.classList.add("col-md-10");
                var div_label = document.createElement("div");
                div_label.classList.add("col-md-12");
                var label = document.createElement("label");
                label.innerText = comments[i].username;
                label.setAttribute("style", "float:left");
                div_label.appendChild(label);

                var time = document.createElement("label");
                // var timeContent = comments[i].comment.createTime;
                // if (timeContent == null)
                //     timeContent = comments[i].comment.createTime;
                time.innerText = comments[i].comment.createTime;
                time.setAttribute("style", "float:right");
                div_label.appendChild(time);

                div.appendChild(div_label);

                var textarea = document.createElement("textarea");
                textarea.classList.add("col-md-4");
                textarea.classList.add("col-md-offset-2");
                textarea.setAttribute('style', " overflow-y: auto;height: 50px;width: 105%;padding-right:5%;border: none");
                textarea.setAttribute('readonly', " readonly");
                textarea.innerText = comments[i].comment.comment;
                div.appendChild(textarea);
                row.appendChild(div);

                var div_button = document.createElement("div");

                var deleteButton = document.createElement("button");
                deleteButton.classList.add("btn");
                deleteButton.classList.add("btn-warning");
                deleteButton.setAttribute("style", "float:right;margin-top:1%;margin-right:4%;");
                deleteButton.innerText = "删除评论";

                var modifyButton = document.createElement("button");
                modifyButton.classList.add("btn");
                modifyButton.classList.add("btn-info");
                modifyButton.setAttribute("style", "float:right;margin-top:1%;margin-right:4%;");
                modifyButton.innerText = "修改评论";

                div_button.appendChild(deleteButton);
                div_button.appendChild(modifyButton);

                row.appendChild(div_button);

                comment_show.appendChild(row);
                var hr = document.createElement("hr");
                hr.classList.add("split-pane-divider");
                comment_show.appendChild(hr);

                if (comments[i].username !== username) {
                    deleteButton.setAttribute("disabled", "disabled");
                    modifyButton.setAttribute("disabled", "disabled");
                } else {
                    (function (comment, row, hr) {
                        deleteButton.addEventListener("click", function (ev) {
                            deleteComment(comment, row, hr);
                        });
                    })(comments[i].comment.comment, row, hr);
                    (function (textarea) {
                        modifyButton.addEventListener("click", function (ev) {
                            modifyComment(textarea);
                        });
                    })(textarea);
                }
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

function modifyComment(textarea) {
    var oldComment = textarea.value;
    var content = document.createElement("textarea");
    content.classList.add("write_comment_class");
    content.placeholder = "请自觉遵守互联网相关的政策法规，严禁发布色情、暴力、反对的言论";
    swal({
        title: "修改评论",
        text: "旧的评论:" + oldComment,
        content: content,
        buttons: ["取消", "保存"]
    }).then(function (value) {
        if (value === null || value === false) return false;

        if (content.value === "") {
            swal("修改评论失败", "评论内容不能为空", "error");
            return false
        } else if (oldComment === content.value) {
            swal("修改评论失败", "内容未改变", "error");
            return false
        }
        $.ajax({
            url: "http://127.0.0.1:8080/comment/modifyComment",
            method: 'post',
            data: {username: username, oldComment: oldComment, newComment: content.value, animationName: animationName},
            dataType: "json",
            beforeSend: function (request) {
                request.setRequestHeader("authorization", "Bearer " + getCookie("token"));
            },
            success: function (result) {
                if (result.result) {
                    swal("修改评论成功", "", "success");
                    textarea.innerText = content.value;
                } else {
                    swal("修改评论失败", result.message, "error");
                }
            }
        });
    });

}


function lastPage() {
    if (document.getElementById("last").classList.contains("disabled"))
        return;
    nowPage = nowPage - 1;
    var comment_show = document.getElementById("comment_show");
    while (comment_show.firstChild) {
        comment_show.removeChild(comment_show.firstChild);
    }
    getCommentsByPageNum();
}

function nextPage() {
    if (document.getElementById("next").classList.contains("disabled"))
        return;
    nowPage = nowPage + 1;
    var comment_show = document.getElementById("comment_show");
    while (comment_show.firstChild) {
        comment_show.removeChild(comment_show.firstChild);
    }
    getCommentsByPageNum();
}

