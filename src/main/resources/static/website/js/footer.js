$(document).ready(function () {
    $("#opinionSubmit").click(function () {
        $("#contact-form").submit();
        alert("您的意见已提交，我们会尽快联系您！");
        $("#contact-form").reset();
    });
});