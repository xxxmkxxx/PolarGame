$(document).ready(mainFunction());

let isDownloadGameFilters = false;

function mainFunction() {
    isClickedIcon(".pop_game");
    isClickedIcon(".game");

    searchGame();
    displayGameFilters();
    chooseGenresFilters();
    confirmFilters();
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

function displayGameFilters() {
    $(document).on('click','.filter_icon', function (obj) {
        obj.preventDefault();

        if(!isDownloadGameFilters) {
            getGenres();
            isDownloadGameFilters = true;
        }

        if($(".filters").css("display") == "none"){
            $(".filters").slideDown(200);

        } else
            $('.filters').slideUp(200);
    });
}

function displayGenres(genres) {
    var categGenresDiv = $('<div>', {
        'class': 'categ',
        'id': 'genres'
    });

    $('#genres').remove();

    for (let i = 0; i < genres.length; i++) {
        categGenresDiv.append(createGenreFilter(genres[i]));
    }

    $('#take_categ').append(categGenresDiv);
}

function createGenreFilter(genre) {
    var categ_itemDiv = $('<div>', {
        'class': 'categ_item'
    });

    var inputCheckbox = $('<input>', {
        'type' : 'checkbox',
        "class" : "genre",
        "id" : "genre_" + genre.genreId,
        'value': genre.genreName
    });

    categ_itemDiv.append(inputCheckbox);
    categ_itemDiv.append(genre.genreName);

    return categ_itemDiv;
}

function getGenres() {
    $.ajax({
        type : 'POST',
        url : '/PolarGame/ajax/catalog/game/get/genres',
        success: function (genresList) {
            displayGenres(genresList);
        },
        error : function () {
            console.log("error");
        }
    });
}

function confirmFilters() {
    $("#choose_filters").submit(function(event) {
        event.preventDefault();

        let data = {
            genresId : chooseGenresFilters()
        };

        $.ajax({
            type : 'POST',
            url : '/PolarGame/ajax/catalog/game/filters',
            data: data,
            success: function (gamesList) {
                displayFoundGames(gamesList);
            },
            error : function () {
                console.log("error");
            }
        });

        $('.filters').slideUp(200);
    });
}

function chooseGenresFilters() {
    let selectedGenres = $("#genres").children(".categ_item");
    let genresId = [];

    for (let i = 0; i < selectedGenres.length; i++) {
        let genreCheckbox = $(selectedGenres[i]).children(".genre")[0];

        if($(genreCheckbox).prop("checked")) {
            genresId.push($(genreCheckbox).attr("id"));
        }
    }

    return genresId;
}
