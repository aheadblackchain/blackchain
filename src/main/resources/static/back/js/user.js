$(document).ready(function () {
    updateTable("/user/byId/","saveUser");
    insertTable("saveUser");
    delTable("/user/del/");
    $("input[name='passWord']").change(function () {
        $("input[name='isUpdatePassWord']")[0].value = 1;
    });
});