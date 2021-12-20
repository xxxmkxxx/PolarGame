<html xmlns:th="http://www.thymeleaf.org" lang="ru">

<head>
    <meta charset="utf-8">
    <title> КАТАЛОГ ИГР </title>
    <link th:href="@{/styles/css/game_catalog.css}" rel="stylesheet" type="text/css">
    <script th:src="@{/scripts/js/jquery.js}"></script>
</head>

<body>
<header>
    <div class = "click_logo">
        <span class = "header_minilogo"> <img th:src="@{/images/images/minilogo.png}"> </span>
        <span class = "header_minilogo"> POLARGAME </span>
    </div>

    <div class = "profile_data">
        <span class = "profile" id="profile">  </span>
        <div class = "profile_icon"> <img th:src="@{/images/images/profile_icon.png}"></div>
        <span class = "menu_icon"> <img id="menu_icon" th:src="@{/images/images/menu_icon.png}"></span>
    </div>
</header>

<main>

    <div class = "menu">
        <a th:href="@{/}"> <span class = "menu_categories"> ДРУЗЬЯ </span> </a>
        <a th:href="@{/}">  <span class = "menu_categories"> ДИАЛОГИ </span> </a>
        <span class = "menu_categories"> ИГРЫ </span>
        <span class = "menu_categories"> ВЫЙТИ </span>
    </div>

    <div class = "filters_row">
        <span class = "LargeText"> ВЫБОР ИГРЫ </span>
        <form id="search">
            <input type="text" name = "find_game" id="find_game" class = "find_game_inp">
        </form>
        <span class = "find_icon"> <img id="find_icon" th:src="@{/images/images/find_icon.png}"></span>
        <span class = "filter_icon"> <img th:src="@{/images/images/filter_icon.png}"></span>
    </div>

    <div class = "filters" id="filters">

        <div class = "filters_block">
            <span class = "filter_categories" > жанр  </span>
            <span class = "filter_categories">   </span>
            <!-- <span class = "filter_categories">  популярность </span> -->
        </div>

        <div class = "take_categ" id="take_categ">


        </div>
        <form>
            <button class ="send_filters" id="send_filters"> применить </button>
        </form>
    </div>

    <div id="game_catalog">
        <div class = "popular_games_row" id="popular_games_row">
            <span th:each="game : ${popularGames}" class="pop_game" th:id="${game.gameId}">
                <img th:src="@{'/images/' + ${game.urlGameIcon}}">
            </span>
        </div>

        <div class = "games_block" id="games_block">
            <div th:each="row : ${sortedGames}" class = "games_row" id="games_row">
                <span th:each="game : ${row}" class="game" th:data-tooltip="${game.name}" th:id="${game.gameId}">
                    <img th:src="@{'/images/' + ${game.urlGameIcon}}">
                </span>
            </div>
        </div>
    </div>
</main>

<script type="application/javascript" th:src="@{/scripts/js/GameCatalogController.js}"></script>

</body>

</html>