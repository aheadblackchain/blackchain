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
                alert(data);
            }
        });
        // $.post("/fileUpload",dataParam,function (data) {
        //     alert(data);
        // },"json");
    });
});

