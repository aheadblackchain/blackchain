$(document).ready(function () {
    updateTable("/getUserById/","saveUser");
    insertTable("saveUser");
    delTable("/delUser/");
});