$(document).ready(() => {
    openMenuEvent();
    openMainPageEvent();
    openProfileEvent("");
});

let closeOutZoneElement = (element, method) => {
    if(method === "old") {
        $(document).mouseup(function (event) {
            if(!$(element).is(event.target) && $(element).has(event.target).length === 0)
                $(element).slideUp(200);
        });
    } else {
        $(document).mouseup(function (event) {
            if(!$(element).is(event.target) && $(element).has(event.target).length === 0)
                hideElement();
        });
    }

}

let openProfileEvent = (login) => {
    $(common.get("profile_block_class")).click(() => {
        window.location.href = "/PolarGame/user/profile/" + login;
    });
}

let openMenuEvent = () => {
    $(common.get("menu_icon_block_class")).click(() => {
        let menu = $(common.get("menu_block_class"));

        if(menu.css("display") == "none")
            menu.css("display","inline-flex");
        else
            menu.css("display","none");

    });
}

let openMainPageEvent = () => {
    $(common.get("logo_block_class")).click(() => {
        window.location.href = "/PolarGame/catalog";
    });
}

const displayElement = (form) => {
    $('#whiteBack').css('display', 'flex');
    $(form).css('display', 'flex');
}

const hideElement = (form) => {
    $('#whiteBack').css('display', 'none');
    $(form).css('display', 'none');
}

