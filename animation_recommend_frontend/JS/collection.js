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

var username = getCookie("user");
if (!username) {
    window.location = "../html/login.html";
}
document.getElementById("userName").innerHTML = username;


$.ajax({
    url: "http://127.0.0.1:8080/attitude/getCollectionsByUsername",
    method: 'get',
    data: {username: username},
    dataType: "json",
    beforeSend: function (request) {
        request.setRequestHeader("authorization", "Bearer " + getCookie("token"));
    },
    success: function (collections) {
        console.log(collections);
        var collections_container = document.getElementById("collections");

        for (var i = 0; i < collections.length; i++) {
            var collection = collections[i];

            var row = document.createElement("div");
            row.classList.add("row");
            var div_img = document.createElement("div");

            div_img.classList.add("col-md-2");
            div_img.classList.add("col-md-offset-1");

            var a_img = document.createElement("a");
            a_img.href = "../html/details.html?animationName=" + collection.name;

            var img = document.createElement("img");
            img.setAttribute("style", "width:100%;height: auto");
            img.src = collection.cover;

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
            a_name.href = "../html/details.html?animationName=" + collection.name;
            a_name.innerText = collection.name;
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
            textarea.innerText = collection.detail;

            div_textarea.appendChild(textarea);
            div_detail.appendChild(div_textarea);
            div_message.appendChild(div_detail);

            row.appendChild(div_message);

            collections_container.appendChild(row);
            var hr = document.createElement("hr");
            hr.classList.add("divider");
            collections_container.appendChild(hr);

        }
    }
});
