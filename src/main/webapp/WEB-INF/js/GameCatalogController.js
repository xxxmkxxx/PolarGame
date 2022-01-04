$(document).ready(mainFunction());

function mainFunction() {
    isClickedIcon(".pop_game");
    isClickedIcon(".game");

    searchGame();
}

function isClickedIcon(iconClass) {
    $(document).on('click', iconClass, function (obj) {
        obj.preventDefault();

        transitionToGame(this.getAttribute('id'));
    });
}

function transitionToGame(id) {
    $.ajax({
        type : 'POST',
        url : '/PolarGame/catalog/openGamePage',
        data: {id : id},
        success: function () {
            window.location.href = '/PolarGame/game/' + id;
        },
        error : function () {
            alert("error")
        }
    });
}

function searchGame() {
    $("#find_game").on('input', function () {
        $.ajax({
            type : 'POST',
            url : '/PolarGame/ajax/catalog/game/search',
            data: {searchPattern : $("#find_game").val()},
            success: function (gamesList) {
                displayFoundGames(gamesList);
            },
            error : function () {
                console.log("error");
            }
        });
    });
}

function displayFoundGames(gamesList) {
    $('#games_block').remove();
    $('#popular_games_row').remove();

    let gamesBlock = $('<div>', {
        'class': 'games_block',
        'id': 'games_block'
    });

    $('#game_catalog').append(gamesBlock);

    let gamesRow = $('#games_row');

    for (let i = 0; i < gamesList.length; i++) {
        if((i) % 6 != 0) {
            viewGame(gamesList[i], gamesRow);
        } else {
            gamesRow = createGamesRow(i / 6);
            viewGame(gamesList[i], gamesRow);
        }

    }
}

function createGamesRow(id) {
    let gamesRowDiv = $('<div>', {
        'class': 'games_row',
        'id': 'games_row' + id
    });

    $('#games_block').append(gamesRowDiv);

    return $('#games_row' + id);
}

function viewGame(game, gamesRow) {
    let gameSpan = $('<span>', {
        'class': 'game',
        'data-tooltip': game.name,
        'id': game.gameId
    });

    let gameIconImg = $('<img>', {
        'src': '/PolarGame/images/' + game.urlGameIcon
    });

    gameSpan.append(gameIconImg)
    gamesRow.append(gameSpan);
}