$(document).ready(function () {
    updateTable("/surrounding/byId/","saveSurrounding");
    insertTable("saveSurrounding");
    delTable("/surrounding/del/");

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
                    let fileImg = document.createElement("img");
                    fileImg.setAttribute("width","300px");
                    fileImg.setAttribute("height", "200px");
                    //fileImg.setAttribute("controls", "controls");
                    fileImg.setAttribute("src", data);
                    $("input[id='fileUpload']")[0].parentNode.appendChild(fileImg);
                    $("input[name='surimg']")[0].value = data;
                }else {
                    alert("上传失败");
                }
            }
        });
    });
});

