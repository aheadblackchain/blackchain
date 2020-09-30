function updateTable(updateUrl, fromName,) {
    $(".btn-update").click(function () {
        $.post(updateUrl + this.value, null, function (data) {
            Array.of(...$("form[name=" + fromName + "] input")).forEach(i => {
                if (i.type != "file" || i.type != "button") {
                    i.value = data[i.name] != undefined ? data[i.name] : "";
                }
            });
           Array.of(... $("textarea")).forEach(i => i.innerText = data[i.name]);
        }, "json");
    });
}

function insertTable(fromName) {
    $(".btn-insert").click(function () {
        $("form[name=" + fromName + "]")[0].reset();
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
$(document).ready(function () {
    let i = 0;
    $("#addDetail").click(function () {
        let textNode = document.createElement("textarea");
        textNode.setAttribute("class","form-control");
        textNode.setAttribute("name", "detailList");
        textNode.setAttribute("rows", "10");
        this.parentNode.insertBefore(textNode,this);
        i++;
    });
});