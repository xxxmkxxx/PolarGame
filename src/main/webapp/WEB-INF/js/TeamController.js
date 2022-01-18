$(document).ready(() => {
    sendMessageEvent();
})


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

const sendMessageEvent = () => {
    $("#send_message_form").submit((event) => {
        event.preventDefault();

        let data = {
            text : $("#message_text").val(),
            teamId : $("#team_id").val()
        };

        console.log(data)

        $.ajax({
            type : "POST",
            url : "/PolarGame/ajax/dialogs/team/message/create",
            data : data,
            success : (message) => {
                console.log(message)
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