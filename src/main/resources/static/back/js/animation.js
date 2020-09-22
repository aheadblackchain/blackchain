$(document).ready(function () {
    updateTable("/getAnimationById/","saveAnimation");
    insertTable("saveAnimation");
    delTable("/delAnimation/");

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
                if(data != null){
                    let fileVideo = document.createElement("video");
                    fileVideo.setAttribute("width","300px");
                    fileVideo.setAttribute("height", "300px");
                    fileVideo.setAttribute("controls", "controls");
                    // let fileSource = document.createElement("source");
                    fileVideo.setAttribute("src", data);
                    // fileSource.setAttribute("type", "video/mp4");
                    // fileVideo.appendChild(fileSource);
                    $("input[id='fileUpload']")[0].parentNode.appendChild(fileVideo);
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

