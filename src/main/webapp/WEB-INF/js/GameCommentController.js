$(document).ready(() => {});

const moreGameCommentsEvent = () => {
    let countComments = $("#review_block2 .comment").length;

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
                console.log(countComments)
                console.log(message)
                if(message.text === "success")
                    displayMoreGameComments(message.object, countComments);
                else
                    console.log(message.text);
            },
            error : function () {
                console.log("error");
            }
        });
    });
}

const displayMoreGameComments = (commentsList, countComments) => {
    for (let i = 0; i < commentsList.length; i++) {
        displayCommentBlock(countComments, commentsList[i]);
        countComments++;
    }

    if(countComments == countAllComments)
        hideElement("#button_show_more");
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
                console.log(message)

                if(message.text === "success")
                    hideElement(".write_commment");
                else
                    console.log(message.text)
            },
            error : function () {
                console.log("error");
            }
        });
    });
}
