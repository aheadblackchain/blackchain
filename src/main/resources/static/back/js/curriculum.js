$(document).ready(function () {
    updateTable("/getCurriculumById/","saveCurriculum");
    insertTable("saveCurriculum");
    delTable("/delCurriculum/");

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
                    let fileVideo = document.createElement("img");
                    fileVideo.setAttribute("width","300px");
                    fileVideo.setAttribute("height", "200px");
                   // fileVideo.setAttribute("controls", "controls");
                    fileVideo.setAttribute("src", data);
                    $("input[id='fileUpload']")[0].parentNode.appendChild(fileVideo);
                    $("input[name='curriculumImage']")[0].value = data;
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

