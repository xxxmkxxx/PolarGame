let countComments = $("#review_block2 .comment").length;

$(document).ready(() => {});

const moreGameCommentsEvent = () => {
    if(countComments >= countAllComments)
        hideElement($("#button_show_more"));

    $("#button_show_more").click(function (event) {
        event.preventDefault();

        let data = {
            lastCommentId : countComments,
            gameId : gameId
        };

        $.ajax({
            type : "POST",
            url : "/PolarGame/ajax/game/comments/more",
            data : data,
            success : function (message) {
                if(message.text === "success")
                    displayMoreGameComments(message.object);
                else
                    console.log(message.text);
            },
            error : function () {
                console.log("error");
            }
        });
    });
}

const displayMoreGameComments = (commentsList) => {
    for (let i = 0; i < commentsList.length; i++) {
        displayCommentBlock(countComments, commentsList[i]);
        countComments++;
    }

    if(countComments >= countAllComments)
        hideElement($("#button_show_more"));
}

const updateViewGameComments = () => {
    $("#review_block2").empty();
    countComments = 0;

    let data = {
        gameId : gameId
    }

    $.ajax({
        type : "POST",
        url : "/PolarGame/ajax/game/comments/update",
        data : data,
        success : function (message) {
            if(message.text === "success") {
                let commentsList = message.object;

                for (let i = 0; i < commentsList.length; i++) {
                    displayCommentBlock(countComments, commentsList[i]);
                    countComments++;
                }

                if(countComments < countAllComments)
                    displayElement($("#button_show_more"));
                else
                    hideElement($("#button_show_more"));
            } else
                console.log(message.text);
        },
        error : function () {
            console.log("error");
        }
    });
}

const displayCommentBlock = (number, comment) => {
    let commentDiv = $("<div>", {
        "class": "comment",
        "id": "comment_id " + number
    });

    let div_author_data = $("<div>", {
        "class": "author_data"
    });

    let div_comment_text = $("<div>", {
        "class": "comment_text"
    }).text(comment.text);

    let span_author_icon = $("<span>", {
        "class": "author_icon"
    });

    let span_author_name = $("<span>", {
        "class": "author_name",
    }).text(comment.user.login);

    let img = $("<img>", {
        "src": "/PolarGame/images/" + comment.user.urlUserIcon
    });

    span_author_icon.append(img);
    div_author_data.append(span_author_icon);
    div_author_data.append(span_author_name);
    commentDiv.append(div_author_data);
    commentDiv.append(div_comment_text);

    $("#review_block2").append(commentDiv);
}

const openCreationGameCommentFormEvent = () => {
    $(".write").click(() => {
        if($(".write_commment").css("display") == "none"){
            displayElement(".write_commment");
        }
    });
}

const closeCreationGameCommentFormEvent = () => {
    $(".write").click(() => {
        if($(".write_commment").css("display") == "flex"){
            displayElement(".write_commment");
        }

        closeOutZoneElement(".write_commment");
    });
}

const createCommentEvent = () => {
    $("#write_commment_form").submit(function (event) {
        event.preventDefault();

        let data = {
            gameId : gameId,
            text : $("#write_commment_area").val()
        }

        $.ajax({
            type : "POST",
            url : "/PolarGame/ajax/game/comments/create",
            data : data,
            success : function (message) {
                if(message.text === "success") {
                    $("#write_commment_area").val("");
                    hideElement(".write_commment");
                    updateViewGameComments();
                } else
                    console.log(message.text)
            },
            error : function () {
                console.log("error");
            }
        });
    });
}
