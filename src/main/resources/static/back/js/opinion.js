$(document).ready(function () {
    $(".btn-info").click(function () {
        $.post("/opinion/byId/" + this.value, null, function (data) {
            Array.of(...$("form[name='opinionForm'] input")).forEach(i => {
                 i.value = data[i.name] != undefined ? data[i.name] : "";
            });
            Array.of(... $("textarea")).forEach(i => i.innerText = data[i.name]);
        }, "json");
    });
});