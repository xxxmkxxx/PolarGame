$(document).ready(() => {
    openMenuEvent();
    openMainPageEvent();
    openProfileEvent("");
    notification();
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
    $(document).on("click", ".test", function () {
        let review = $(this).attr("id").split("_")[1];
        let data = {
            review : review
        };

        $.ajax({
            type : "POST",
            url : "/PolarGame/ajax/game/popular/review",
            data : data,
            success : (message) => {
                console.log(message.object)
            },
            error : function () {
                console.log("error");
            }
        });
    });

    let data = {
        gameId : gameId
    };

    $.ajax({
        type : "POST",
        url : "/PolarGame/ajax/game/popular/get",
        data : data,
        success : (message) => {
            let starRang = message.object;
            let children = $(".rating-area").children("label");

            for (let i = 0; i <= starRang; i++) {
                $(children[5-i]).css("color","gold");
            }
        },
        error : function () {
            console.log("error");
        }
    });


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

function notification () {
    $(document).on("click", ".apply_notif" ,function () {
        $(".notification_form").css("display", "none");
    });


    $(document).on("click", ".cancel_notif" ,function () {
        console.log($(".notification_form"))
        $(".notification_form").css("display", "none");
    });

    $(".notification_icon").click(function () {
        hideElement(".notification_form");
    });


}

