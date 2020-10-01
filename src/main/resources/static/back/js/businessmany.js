function updateTable(updateUrl, fromName,) {
    $(".btn-update").click(function () {
        $.post(updateUrl + this.value, null, function (data) {
            Array.of(...$("form[name='" + fromName + "'] input")).forEach(i => {
                if (i.type != "file" && i.type != "button") {
                    i.value = data[i.name] != undefined ? data[i.name] : "";
                }
            });
            if(data["detailList"] != null){
                let addDetailElement = $("#addDetail")[0];
                removeDetailHtml(fromName, addDetailElement);
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
}

function insertTable(fromName) {
    $(".btn-insert").click(function () {
        $("form[name=" + fromName + "]")[0].reset();
        removeDetailHtml(fromName, $("#addDetail")[0]);
        $("#dropzone-demo")[0].innerHTML = "";
        Array.of(...$("input[type='hidden']")).forEach(i => i.value = "");
    });
}

function delTable(delUrl) {
    $('.btn-delete').on('click', function () {
        let id = this.value;
        bootbox.confirm({
            message: 'Are you sure to delete it?',
            className: 'bootbox-sm',
            callback: function (result) {
                if (result) {
                    location.href = delUrl + id;
                }
            },
        });
    });
}
function addDetailHtml(){
    let textNode = document.createElement("textarea");
    textNode.setAttribute("class","form-control");
    textNode.setAttribute("name", "detailList");
    textNode.setAttribute("rows", "10");
    return textNode;
}
function removeDetailHtml(fromName,addDetailElement){
    let oldDetailList =$("form[name='" + fromName + "'] textarea[name='detailList']");
    Array.of(...oldDetailList).forEach(i => addDetailElement.parentNode.removeChild(i));
}
$(document).ready(function () {
    $("#addDetail").click(function () {
        this.parentNode.insertBefore(addDetailHtml(),this);
    });
});