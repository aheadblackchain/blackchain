$(document).ready(function () {
    $(".btn-update").click(function () {
        $.post('/animation/byId/' + this.value, null, function (data) {
            Array.of(...$("form[name='saveAnimation'] input")).forEach(i => {
                if (i.type != "file" && i.type != "button") {
                    i.value = data[i.name] != undefined ? data[i.name] : "";
                }
            });
            Array.of(... $("textarea")).forEach(i => i.innerText = data[i.name]);
            let fileVideo = document.createElement("video");
            fileVideo.setAttribute("width","300px");
            fileVideo.setAttribute("height", "200px");
            fileVideo.setAttribute("controls", "controls");
            fileVideo.setAttribute("src", data["talentsVideo"]);
            $("input[id='fileUpload']")[0].parentNode.appendChild(fileVideo);
        }, "json");
    });
    insertTable("saveAnimation");
    delTable("/animation/del/");

    $("input[type='file']").change(function () {
        let files = $("input[id='fileUpload']").prop("files");
        let dataParam = new FormData();
        dataParam.append('fileUpload', files[0]);
        $.ajax({
            url: '/fileUpload',
            type: 'POST',
            data: dataParam,
            cache: false,
            processData: false,
            contentType: false,
            success:function (data) {
                console.log(data);
                if(data != null && data != ""){
                    let fileVideo = document.createElement("video");
                    fileVideo.setAttribute("width","300px");
                    fileVideo.setAttribute("height", "200px");
                    fileVideo.setAttribute("controls", "controls");
                    fileVideo.setAttribute("src", data);
                    $("input[id='fileUpload']")[0].parentNode.appendChild(fileVideo);
                    $("input[name='talentsVideo']")[0].value = data;
                }else {
                    alert("上传失败");
                }
            }
        });
        // $.post("/fileUpload",dataParam,function (data) {
        //     alert(data);
        // },"json");
    });
});

