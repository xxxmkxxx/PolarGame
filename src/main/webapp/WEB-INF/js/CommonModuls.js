$(document).ready(() => {
    openProfileEvent();
    openMenuEvent();
});

let closeOutZoneElement = (element) => {
    $(document).mouseup(function (event) {
        if(!$(element).is(event.target) && $(element).has(event.target).length === 0)
            $(element).slideUp(200);
    });
}

let openProfileEvent = () => {
    $(common.get("profile_block_class")).click(() => {
        window.location.href = "/PolarGame/user/profile";
    });
}

let openMenuEvent = () => {
    $(common.get("menu_icon_block_class")).click(() => {
        let menu = $(common.get("menu_block_class"));

        if(menu.css("display") == "none")
            $(common.get("menu_block_class")).slideDown(200);
        else
            $(common.get("menu_block_class")).slideUp(200);
    });
}

