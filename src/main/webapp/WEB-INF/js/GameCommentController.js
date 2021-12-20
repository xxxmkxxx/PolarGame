$(document).ready(mainFunction());

function mainFunction() {
    getMoreGameComments();
}

function getMoreGameComments() {
    var countComments = $("#review_block2 .comment").length;

    if(countComments == countAllComments) {
        $("#button_show_more").hide();
        return;
    }

    $("#button_show_more").click(function() {
        var lastCommentId = {
            lastCommentId : countComments,
            gameId : gameId
        };

        $.ajax({
            type : 'POST',
            url : '/PolarGame/ajax/game/comments/more',
            data: lastCommentId,
            success: function (commentsList) {
                displayMoreGameComments(commentsList, countComments);
            },
            error : function () {
                console.log("error");
            }
        });
    });
}

function displayMoreGameComments(commentsList, countComments) {
    for (let i = 0; i < commentsList.length; i++) {
        displayComment(countComments, commentsList[i]);
        countComments++;
    }

    if(countComments == countAllComments) {
        $("#button_show_more").hide();
    }
}

function displayComment(number, comment) {
    var commentDiv = $('<div>', {
        'class': 'comment',
        'id': 'comment_id ' + number
    });

    var div_author_data = $('<div>', {
        'class': 'author_data'
    });

    var div_comment_text = $('<div>', {
        'class': 'comment_text'
    }).text(comment.text);

    var span_author_icon = $('<span>', {
        'class': 'author_icon'
    });

    var span_author_name = $('<span>', {
        'class': 'author_name',
    }).text(comment.user.login);

    var img = $('<img>', {
        'src': '/PolarGame/images/' + comment.user.urlUserIcon
    });

    span_author_icon.append(img);
    div_author_data.append(span_author_icon);
    div_author_data.append(span_author_name);
    commentDiv.append(div_author_data);
    commentDiv.append(div_comment_text);

    $('#review_block2').append(commentDiv);
}