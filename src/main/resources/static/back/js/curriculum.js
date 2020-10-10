$(document).ready(function () {
    $(".btn-update").click(function () {
        $.post('/getCurriculumById/' + this.value, null, function (data) {
            Array.of(...$("form[name='saveCurriculum'] input")).forEach(i => {
                if (i.type != "file" && i.type != "button") {
                    i.value = data[i.name] != undefined ? data[i.name] : "";
                }
            });
            let fileVideo = document.createElement("video");
            fileVideo.setAttribute("width","300px");
            fileVideo.setAttribute("height", "200px");
            fileVideo.setAttribute("controls", "controls");
            fileVideo.setAttribute("src", data["curVideo"]);
            $("input[id='videoUpload']")[0].parentNode.appendChild(fileVideo);
            if(data["detailList"] != null){
                let addDetailElement = $("#addDetail")[0];
                removeDetailHtml('saveCurriculum', addDetailElement);
                data["detailList"].forEach(i => {
                    let textAreaElement = addDetailHtml();
                    textAreaElement.innerText = i;
                    addDetailElement.parentNode.insertBefore(textAreaElement,addDetailElement);
                });
            }
            if(data["imgList"] != null){
                let dropZoneElement = $("#dropzone-demo")[0];
                dropZoneElement.innerHTML= data["imgList"].map(i =>
                    `
                        <div class="dz-preview dz-processing dz-success dz-image-preview">
                            <div class="dz-details">
                                <div class="dz-thumbnail">
                                    <img data-dz-thumbnail="" alt="${i}" src="${i}">
                                    <span class="dz-nopreview">No preview</span>
                                    <div class="dz-success-mark"></div>
                                    <div class="dz-error-mark"></div>
                                    <div class="dz-error-message">
                                        <span data-dz-errormessage=""></span>
                                    </div>
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuemin="0"
                                            aria-valuemax="100" data-dz-uploadprogress="">
                                        </div>
                                    </div>
                                </div>
                                <div class="dz-filename" data-dz-name="">${i}
                                </div>
                                <div class="dz-size" data-dz-size="">
                                    <strong></strong> </div>
                            </div>
                            <div class="dz-remove dz-remove-old">Cancel upload</div>
                            <input name="imgList" type="hidden" value="${i}">
                        </div>
                        `
                ).join("");
            }

            $(".dz-remove-old").click(function () {
                this.parentNode.parentNode.removeChild(this.parentNode);
            });
        }, "json");
    });
    insertTable("saveCurriculum");
    delTable("/delCurriculum/");

    $("input[id='videoUpload']").change(function () {
        let files = $("input[id='videoUpload']").prop("files");
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
                    $("input[id='videoUpload']")[0].parentNode.appendChild(fileVideo);
                    $("input[name='curVideo']")[0].value = data;
                }else {
                    alert("上传失败");
                }
            }
        });
    });
});

