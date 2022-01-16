
const testDialogs = ()=> {
   $("#test").click(() => {
       $("#dialogs").prepend(createDialogBlock(null, 'team'));
   });
}

const createDialogBlock = (message, dialogType) => {

    let icon = 'awd';
    let dialogName = 'wfwf';
    let lastMessageTime = 'fwfwfwdwwa';

    // if (dialogType === "team") {
    //     icon = message.team.teamIcon;
    //     dialogName = message.team.teamName;
    //     lastMessageTime = message.team.dispatchTime;
    // } else {
    //     icon = message.user.userIcon;
    //     dialogName = message.user.userNick;
    //     lastMessageTime = message.user.dispatchTime;
    // }


    let dialogs = $("<div>", {
        "class" : "dialogs"
    });

    let dialog = $("<div>", {
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
    dialog.append(about_dialog_member);
    dialog.append(last_message_time);

    return dialog;
}

testDialogs();