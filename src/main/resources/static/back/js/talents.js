$(document).ready(function () {
    updateTable("/talent/ById/","saveTalents");
    insertTable("saveTalents");
    delTable("/talent/del/");
});