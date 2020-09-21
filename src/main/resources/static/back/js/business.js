
function updateTable(updateUrl,fromName,){
    $(".btn-update").click(function () {
        $.post(updateUrl+this.value,null,function (data) {
            let formObj = $("form[name="+fromName+"] input");
            Array.of(...formObj).forEach(i => {if(i.type != "file"){i.value = data[i.name]}});
        },"json");
    });
}
function insertTable(fromName){
    $(".btn-insert").click(function () {
        $("form[name="+fromName+"]")[0].reset();
        $("input[name='id']")[0].value = "";
    });
}
function delTable(delUrl){
    $('#bootbox-confirm').on('click', function() {
        let id = this.value;
        bootbox.confirm({
            message:   'Are you sure to delete it?',
            className: 'bootbox-sm',
            callback: function(result) {
                if(result){
                    location.href = delUrl + id;
                }
            },
        });
    });
}