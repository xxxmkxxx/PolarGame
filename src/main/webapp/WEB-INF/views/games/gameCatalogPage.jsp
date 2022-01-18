<html xmlns:th="http://www.thymeleaf.org" lang="ru">
    <head>
        <meta charset="utf-8">
        <title th:text="${namePage}"></title>
        <link th:href="@{/styles/game_catalog.css}" rel="stylesheet" type="text/css">
        <link th:href="@{/styles/headerStyle.css}" rel="stylesheet" type="text/css">
        <link rel="icon" th:href="@{/images/logotest2.png}">
        <script th:src="@{/webjars/jquery/3.6.0/jquery.min.js}"></script>
        <script th:src="@{/scripts/configs/GameCatalogNameElementsConfig.js}"></script>
        <script th:src="@{/scripts/configs/commonNameElementsConfig.js}"></script>
        <script th:src="@{/scripts/CommonModuls.js}"></script>
    </head>

    <body>
        <header th:insert="~{/templates/BasicTemplates :: difficultHeader}"></header>

        <div th:insert="~{/templates/BasicTemplates :: menu}"></div>

        <div th:replace="~{/templates/BasicTemplates :: notificationsForm}"></div>

        <main>

            <div class = "filters_row">
                <span class = "LargeText"> ВЫБОР ИГРЫ </span>
                <form id="search">
                    <input type="text" name = "find_game" id="find_game" class = "find_game_inp">
                </form>
                <span class = "find_icon"> <img id="find_icon" th:src="@{/images/find_icon.png}"></span>
                <span class = "filter_icon"> <img th:src="@{/images/filter_icon.png}"></span>
            </div>

            <form id="choose_filters" th:method="POST" th:action="@{/catalog}">
                <div class = "filters" id="filters">

                    <div class = "filters_block">
                        <span class = "filter_categories" > жанр  </span>
                    </div>

                    <div class = "take_categ" id="take_categ"></div>

                    <input type="submit" class ="send_filters" id="send_filters" value="применить"/>
                </div>
            </form>

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

        <script type="application/javascript" th:src="@{/scripts/GameCatalogController.js}"></script>
    </body>
</html>