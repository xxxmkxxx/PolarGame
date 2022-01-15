$(document).ready(() => {
    clickOnGameIconEvent(gameCatalogConfig.get("popular_game_block_class"));
    clickOnGameIconEvent(gameCatalogConfig.get("normal_game_block_class"));

    searchGame(gameCatalogConfig.get("game_search_field_id"));
    displayGameFilters(gameCatalogConfig.get("filter_games_block_class"));
    hideGameFilters(gameCatalogConfig.get("filters_section_class"));
    chooseGenresFilters();
    confirmFilters(gameCatalogConfig.get("filters_form_id"));
});

let isDownloadGameFilters = false;

//Обработчик события клика по иконке игры
function clickOnGameIconEvent(iconElement) {
    $(document).on("click", iconElement, function () {
        transitionToGame($(this).attr("id"));
    })
}

//Функция перехода на страницу игры
function transitionToGame(id) {
    $.ajax({
        type : 'GET',
        url : '/PolarGame/game/' + id,
        success: function () {
            window.location.href = '/PolarGame/game/' + id;
        },
        error : function () {
            console.log("error")
        }
    });
}

//Функция поиска игр
function searchGame(searchField) {
    $(searchField).on("input", function () {
        $.ajax({
            type : "POST",
            url : "/PolarGame/ajax/catalog/games/search",
            data : {searchPattern : $(searchField).val()},
            success : function (message) {
                if(message.text === "success")
                    displayFoundGames(message.object);
                else
                    console.log(message.text);
            },
            error : function () {
                console.log("error");
            }
        });
    });
}

//Функция отображения списка найденных игр
function displayFoundGames(gamesList) {
    $(gameCatalogConfig.get("normal_games_section_id")).empty();
    $(gameCatalogConfig.get("popular_games_row_block_id")).remove();

    let gamesRow = $(gameCatalogConfig.get("normal_games_row_block_id"));

    for (let i = 0; i < gamesList.length; i++) {
        if((i) % 6 != 0) {
            viewGame(gamesList[i], gamesRow);
        } else {
            gamesRow = createGamesRow(i / 6);
            viewGame(gamesList[i], gamesRow);
        }

    }
}

//Функция создания строки обычных игр
function createGamesRow(id) {
    let gamesRowDiv = $("<div>", {
        "class" : gameCatalogConfig.get("normal_games_row_block_class").replace('.', ''),
        "id" : gameCatalogConfig.get("normal_games_row_block_id").replace('#', '') + id
    });

    $(gameCatalogConfig.get("normal_games_section_id")).append(gamesRowDiv);

    return gamesRowDiv;
}

//Функция отображения одной обычной игры
function viewGame(game, gamesRow) {
    let gameSpan = $("<span>", {
        "class" : gameCatalogConfig.get("normal_game_block_class").replace('.', ''),
        "data-tooltip" : game.name,
        "id" : game.gameId
    });

    let gameIconImg = $("<img>", {
        "src": "/PolarGame/images/" + game.urlGameIcon
    });

    gameSpan.append(gameIconImg)
    gamesRow.append(gameSpan);
}

//Обработчик события нажатия на иконку с фильтрами
function displayGameFilters(gameFiltersElement) {
    $(gameFiltersElement).click(() => {
        if(!isDownloadGameFilters) {
            getGenres();
            isDownloadGameFilters = true;
        }

        let filtersSection = $(gameCatalogConfig.get("filters_section_class"));

        if(filtersSection.css("display") == "none"){
            filtersSection.slideDown(200);

        } else
            filtersSection.slideUp(200);
    });
}

function hideGameFilters(gameFiltersElement) {
    closeOutZoneElement(gameFiltersElement, "old");
}

//Функция отображения полученых из бд жанров игр
function displayGenres(genres) {
    let gameGenresBlock = $("<div>", {
        "class": gameCatalogConfig.get("games_genres_block_class").replace('.', ''),
        "id": gameCatalogConfig.get("games_genres_block_id").replace('#', '')
    });

    for(let i = 0; i < genres.length; i++) {
        gameGenresBlock.append(createGenreFilter(genres[i]));
    }

    $(gameCatalogConfig.get("games_genres_input_block_id")).append(gameGenresBlock);
}

//Функция создания блока жанра игры
function createGenreFilter(genre) {
    let categ_itemDiv = $("<div>", {
        "class": gameCatalogConfig.get("game_genre_block_class").replace('.', '')
    });

    var inputCheckbox = $("<input>", {
        "type" : "checkbox",
        "class" : gameCatalogConfig.get("game_genre_checkbox_class").replace('.', ''),
        "id" : "genre_" + genre.genreId,
        "value": genre.genreName
    });

    categ_itemDiv.append(inputCheckbox);
    categ_itemDiv.append(genre.genreName);

    return categ_itemDiv;
}

//Функция получения жанров игр из бд
function getGenres() {
    $.ajax({
        type : "POST",
        url : "/PolarGame/ajax/catalog/games/get/genres",
        success: function(message) {
            if(message.text === "success")
                displayGenres(message.object);
            else
                console.log(message.text);
        },
        error : function() {
            console.log("error");
        }
    });
}

//Обработчик события подтверждения выбранных жанров
function confirmFilters(filtersForm) {
    $(filtersForm).submit((event) => {
        event.preventDefault();

        let data = {
            genresId : chooseGenresFilters()
        };

        $.ajax({
            type : "POST",
            url : "/PolarGame/ajax/catalog/games/filters",
            data: data,
            success: function(message) {
                if(message.text === "success")
                    displayFoundGames(message.object);
                else
                    console.log(message.text);
            },
            error : function() {
                console.log("error");
            }
        });

        $(gameCatalogConfig.get("filters_section_class")).slideUp(200);
    });
}

//Функция получения списка id выбранных жанров
function chooseGenresFilters() {
    let selectedGenres = $(gameCatalogConfig.get("games_genres_block_id")).children(gameCatalogConfig.get("game_genre_block_class"));
    let genresId = [];

    for (let i = 0; i < selectedGenres.length; i++) {
        let genreCheckbox = $(selectedGenres[i]).children(gameCatalogConfig.get("game_genre_checkbox_class"))[0];

        if($(genreCheckbox).prop("checked")) {
            genresId.push($(genreCheckbox).attr("id"));
        }
    }

    return genresId;
}
