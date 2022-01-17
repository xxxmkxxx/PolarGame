$(document).ready(() => {
    openMenuEvent();
    openMainPageEvent();
    openProfileEvent("");
    foo();

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
                hideElement(element);
        });
    }
}

let openProfileEvent = (login) => {
    $(common.get("profile_block_class")).click(() => {
        if(login === "")
            window.location.href = "/PolarGame/user/profile";
        else
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

function foo() {
    $(document).on("click", ".test", function () {})

    let starRang = 4;
    let children = $(".rating-area").children("label");
    for (let i = starRang; i > 0; i--) {
        $(children[i]).css("color","gold");
    }

    $(".rating-area").on("mouseover", function (event) {

        let starTypes = $(event.target).attr("for").split("_")[1];
        let children = $(".rating-area").children("label");

        for (let i = 0; i <= 5 ; i++) {
            if (i <= starTypes) {
                $(children[5-i]).css("color", "gold");
            } else {
                $(children[5-i]).css("color", "grey");
            }

        }
    });

}

