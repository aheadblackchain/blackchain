$(document).ready(function () {
    $(".btn-update").click(function () {
        $.post("/getUser/"+this.value,null,function (data) {
            let formObj = $("form[name='userSave'] input");
            Array.of(...formObj).forEach(i => i.value = data[i.name]);
        },"json")
    });
    $(".btn-insert").click(function () {
        $("form[name='userSave']")[0].reset();
        $("input[name='id']")[0].value = "";
    });
    $('#bootbox-confirm').on('click', function() {
        let id = this.value;
        bootbox.confirm({
            message:   'Are you sure to delete it?',
            className: 'bootbox-sm',
            callback: function(result) {
                if(result){
                    location.href = "delUser/" + id;
                }
            },
        });
    });
});