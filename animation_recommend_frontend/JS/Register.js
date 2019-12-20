document.getElementById("submit").addEventListener("click", function () {
    // const obj = {};
    // obj.username = document.getElementById("username").value;
    // obj.password = document.getElementById("password").value;
    // obj.signature = document.getElementById("signature").value;
    const tag = document.getElementsByName("tag");
    const tags = [];
    for (let i = 0; i < tag.length; i++) {
        if (tag[i].checked) {
            tags[i] = tag[i].value;
        }
    }
    // obj.myTypes = tags;

    var formData = new FormData();
    formData.append("name",document.getElementById("username").value);
    formData.append("password",document.getElementById("password").value);
    formData.append("signature",document.getElementById("signature").value);
    formData.append("myTypes",tags);

    console.log(formData.get("password"))

    // const jsonStr = JSON.stringify(obj);
    // var json1 = JSON.parse(jsonStr);

    $.ajax({
        url: "http://127.0.0.1:8080/user/signUp",
        method: 'post',
        data: formData,
        dataType:"json",
        mimeType:"multipart/form-data",
        cache:false,
        contentType: false,
        processData: false,
        success: function (data) {
            console.log(data);
            if (data.result) {
                alert("注册成功");
                window.location.href = "./login.html"
            }else {
                swal("注册失败",data.message,"error");
            }
        }
    });
});