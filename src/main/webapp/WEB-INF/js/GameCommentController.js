$(document).ready(() => {});

const moreGameCommentsEvent = () => {
    let countComments = $("#review_block2 .comment").length;

    if(countComments == countAllComments) {
        $("#button_show_more").hide();
    }

    $("#button_show_more").click(() => {
        let data = {
            lastCommentId : countComments,
            gameId : gameId
        };

        $.ajax({
            type : "POST",
            url : "/PolarGame/ajax/game/comments/more",
            data : data,
            success : function (commentsList) {
                displayMoreGameComments(commentsList, countComments);
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
                if(message === "success")
                    hideElement(".write_commment");
            },
            error : function () {
                console.log("error");
            }
        });
    });
}
