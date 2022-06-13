$("#id, #pw").on("keyup keydown", function () {
    let $button = $(".btn");

    if ($("#id").val() && $("#pw").val()) {
        $button.removeClass("background__red-none");
        $button.addClass("background__red");
    } else {
        $button.removeClass("background__red");
        $button.addClass("background__red-none");
    }
});
