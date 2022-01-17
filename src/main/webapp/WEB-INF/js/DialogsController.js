let selectedDialogId;

$(document).ready(() => {
    selectedDialogId = $($("#dialogs").children("div")[0]).attr("id").split("_")[1];

    sendMessageEvent();
    chooseTeamDialogEvent();
})

const createDialogBlock = (dialog, dialogType) => {
    let icon;
    let dialogName;
    let lastMessageTime;

    if (dialogType === "team") {
        icon = dialog.urlTeamIcon;
        dialogName = dialog.teamName;
        lastMessageTime = "";
    } else if(dialogType === "friend") {
        icon = dialog.urlUserIcon;
        dialogName = dialog.login;
        lastMessageTime = "";
    }

    let dialogBlock = $("<div>", {
        "class" : "dialog"
    });

    let about_dialog_member = $("<span>", {
        "class" : "about_dialog_member"
    });

    let dialog_icon_span = $("<span>", {
        "class" : "dialog_icon"
    });

    let img_dialog = $("<img>", {
        "src" : "/PolarGame/images/" + icon
    });

    let dialog_member_nick = $("<span>", {
        "class" : "dialog_member_nick"
    }).text(dialogName);

    let last_message_time = $("<span>", {
        "class" : "last_message_time"
    }).text(lastMessageTime);

    dialog_icon_span.append(img_dialog);
    about_dialog_member.append(dialog_icon_span);
    about_dialog_member.append(dialog_member_nick);
    dialogBlock.append(about_dialog_member);
    dialogBlock.append(last_message_time);

    return dialog;
}

const createMessageBlock = (message, senderType) => {
    let messageInfoStyle = senderType ? "flex-direction: row-reverse" : "";
    let messageTextBlockStyle = senderType ? "align-self: self-end" : "";
    let messageBlockStyle = senderType ? "flex-direction: row-reverse" : "";

    let userIcon = message.user.urlUserIcon;
    let userName = message.user.login;
    let sendTime = message.date;
    let messageText = message.text;

    let messageBlock = $("<div>", {
        "class" : "message_block",
        "style" : messageBlockStyle
    });

    let dialogMemberIcon = $("<div>", {
        "class" : "dialog_member_icon"
    });

    let img = $("<img>", {
        "src" : "/PolarGame/images/" + userIcon
    });

    let mess = $("<div>", {
        "class" : "message"
    });

    let messageInfo = $("<div>", {
        "class" : "message_info",
        "style" : messageInfoStyle
    });

    let messageSenderName = $("<span>", {
        "class" : "message_sender_name"
    }).text(userName);

    let messageTime = $("<span>", {
        "class" : "message_time"
    }).text(sendTime);

    let messageTextBlock = $("<span>", {
        "class" : "message_text",
        "style" : messageTextBlockStyle
    }).text(messageText);


    dialogMemberIcon.append(img);

    messageInfo.append(messageSenderName);
    messageInfo.append(messageTime);

    mess.append(messageInfo);
    mess.append(messageTextBlock);

    messageBlock.append(dialogMemberIcon);
    messageBlock.append(mess);

    return messageBlock;
}

const displayMessage = (message) => {
    let messageBlock;
    let senderType = message.user.login === $("#profile").text();
    messageBlock = createMessageBlock(message, senderType);

    $(".messages").append(messageBlock);
}

const updateMessages = (messages) => {
    $(".messages").empty();

    for (let i = 0; i < messages.length; i++) {
        displayMessage(messages[i]);
    }
}

const sendMessageEvent = () => {
    $("#send_message_form").submit((event) => {
        event.preventDefault();

        let data = {
            text : $("#message_text").val(),
            teamId : selectedDialogId
        };

        $.ajax({
            type : "POST",
            url : "/PolarGame/ajax/dialogs/team/message/create",
            data : data,
            success : (message) => {
                if(message.text === "success")
                    displayMessage(message.object);
                else
                    console.log(message.text);

                //stompClient.send("/app/parties", {}, JSON.stringify({gameId : gameId}));
            },
            error : function () {
                console.log("error");
            }
        });

        $("#message_text").val("");
    });
}

const chooseTeamDialogEvent = () => {
    $(document).on("click", ".dialog", function () {
        let data = {
            teamId : $(this).attr("id").split("_")[1]
        }

        $.ajax({
            type : "POST",
            url : "/PolarGame/ajax/dialogs/team/get",
            data : data,
            success : (message) => {
                if(message.text === "success")
                    updateMessages(message.object);
                else
                    console.log(message.text);
            },
            error : function () {
                console.log("error");
            }
        });
    });
}

const scrollDown = () => {
    $(".messages").scrollTop($(".messages").prop('scrollHeight'));
}

scrollDown();