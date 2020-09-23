$(document).ready(function () {
    updateTable("/getUserById/","saveUser");
    insertTable("saveUser");
    delTable("/delUser/");
    $("input[name='passWord']").change(function () {
        $("input[name='isUpdatePassWord']")[0].value = true;
    });
});