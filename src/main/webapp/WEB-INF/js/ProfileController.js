let friendLogin;

$(document).ready(() => {
    displayRemoveFriendFormEvent(".delete_icon");
    closeRemoveFriendFormEvent("#confirmationCancel");

    removeFriendEvent();

    descriptionEditEvent();

    userDataEditEvent();

    chooseSectionEvent();
});

const chooseSectionEvent = () => {
    $(document).on('click', '#settings_button', function () {
        $('#friends_section').css('display', 'none');
        $('#settings_section').css('display', 'block');
        $('#settings_button').css('opacity', '100%');
        $('#friends_button').css('opacity', '50%');
    });

    $(document).on('click', '#friends_button', function () {
        $('#settings_section').css('display', 'none');
        $('#friends_section').css('display', 'block');
        $('#friends_button').css('opacity', '100%');
        $('#settings_button').css('opacity', '50%');
    });

    $(document).on('click', '#userIsIN_button', function () {
        $('#users_friends').css('display', 'none');
        $('#userIsIn').css('display', 'block');
        $('#userIsIN_button').css('opacity', '100%');
        $('#friends_buttonForUser').css('opacity', '50%');
    });

    $(document).on('click', '#friends_buttonForUser', function () {
        $('#userIsIn').css('display', 'none');
        $('#users_friends').css('display', 'block');
        $('#friends_buttonForUser').css('opacity', '100%');
        $('#userIsIN_button').css('opacity', '50%');
    });
};

const descriptionEditEvent = () => {
    $("#edit_description").click(() => {
        let iconSrc = $("#edit_description").attr("src");

        if(iconSrc === "/PolarGame/images/apply.png") {
            document.getElementById('edit_description').src = '/PolarGame/images/edit_icon.png';
            $('#user_description_area').css('pointer-events', 'none');

            updateUserDescription();
        } else if(iconSrc === "/PolarGame/images/edit_icon.png") {
            document.getElementById('edit_description').src = '/PolarGame/images/apply.png';
            $('#user_description_area').css('pointer-events', 'auto');
        }
    });
}

const updateUserDescription = () => {
    let description = $("#user_description_area").val();
    let data = {
        description : description
    }

    $.ajax({
        type : "POST",
        url : "/PolarGame/ajax/user/update/description",
        data : data,
        success: function(message) {
            console.log(message);
        },
        error : function() {
            console.log("error");
        }
    });
}

const displayRemoveFriendFormEvent = (element) => {
    $(element).click(function () {
        displayElement("#confirmationBlock");

        friendLogin = $(this).children().attr("id");
    });
}

const closeRemoveFriendFormEvent = (element) => {
    $(element).click(() => {
        hideElement("#confirmationBlock");
    });

    closeOutZoneElement("#confirmationBlock", hideElement("#confirmationBlock"));
}

const removeFriendEvent = () => {
    $("#confirmationToDelete").click(() => {
        let data = {
            friendLogin : friendLogin
        };

        $.ajax({
            type : "POST",
            url : "/PolarGame/ajax/user/friends/remove",
            data : data,
            success: function(message) {
                if(message === "success") {
                    updateFriendsList();
                    hideElement("#confirmationBlock");
                }
            },
            error : function() {
                console.log("error");
            }
        });
    });
}

const displayFriendsList = (friendsList) => {
    $(".friends_form").empty();

    for (let i = 0; i < friendsList.length; i++) {
        createFriendLine(friendsList[i]);
    }
}

const createFriendLine = (friend) => {
    let friendLineDiv = $("<div>", {
        "class" : "friend_line"
    });

    let friendIconSpan = $("<span>", {
        "class" : "friend_icon"
    });

    let friendIconImg = $("<img>", {
        "id" : "friend_icon",
        "src" : "/PolarGame/images/" + friend.urlUserIcon
    });

    let friendNickSpan = $("<span>", {
        "class" : "friend_nick"
    }).text(friend.login);

    let friendLineIconsSpan = $("<span>", {
        "class" : "friend_line_icons"
    });

    let messageIconSpan = $("<span>", {
        "class" : "friend_func_icon message_icon"
    });

    let messageImg = $("<img>", {
        "id" : "AUF",
        "src" : "/PolarGame/images/message_icon.png"
    });

    let deleteIconSpan = $("<span>", {
        "class" : "friend_func_icon delete_icon"
    });

    let deleteImg = $("<img>", {
        "id" : "AUF",
        "src" : "/PolarGame/images/delete_icon.png"
    });

    deleteIconSpan.append(deleteImg);
    messageIconSpan.append(messageImg);

    friendLineIconsSpan.append(messageIconSpan);
    friendLineIconsSpan.append(deleteIconSpan);

    friendIconSpan.append(friendIconImg);

    friendLineDiv.append(friendIconSpan);
    friendLineDiv.append(friendNickSpan);
    friendLineDiv.append(friendLineIconsSpan);

    $(".friends_form").append(friendLineDiv);
}

const updateFriendsList = () => {
    $.ajax({
        type : "POST",
        url : "/PolarGame/ajax/user/friends/get",
        success: function(friendsList) {
            displayFriendsList(friendsList);
        },
        error : function() {
            console.log("error");
        }
    });
}

const userDataEditEvent = () => {
    $("#settings_form").submit((event) => {
        event.preventDefault();

        let data = {
            newLogin : $("#new_login_field").val(),
            lostPassword : $("#lost_password_field").val(),
            newPassword : $("#new_password_field").val(),
            repeatPassword : $("#repeat_password_field").val()
        };

        $.ajax({
            type : "POST",
            url : "/PolarGame/ajax/user/update/data",
            data : data,
            success: function(message) {
                if(message.text === "success")
                    updateUserDataView(message.object);

                console.log(message);
            },
            error : function() {
                console.log("error");
            }
        });
    })
}

const updateUserDataView = (user) => {
    $("#user_name").text(user.login);
    $("#user_icon").attr("src", "/PolarGame/images/" + user.urlUserIcon);
    $("#user_description_area").val(user.description);

    $("#new_login_field").val("");
    $("#lost_password_field").val("");
    $("#new_password_field").val("");
    $("#repeat_password_field").val("");
}
