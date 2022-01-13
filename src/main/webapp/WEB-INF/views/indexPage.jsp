<html xmlns:th="http://www.thymeleaf.org" lang="ru">

<head>
    <meta charset="utf-8">
    <title th:text="${pageName}"></title>
    <link th:href="@{/styles/Start.css}" rel="stylesheet" type="text/css">
    <script th:src="@{/webjars/jquery/3.6.0/jquery.min.js}"></script>
    <script th:src="@{/scripts/configs/IndexNameElementsConfig.js}"></script>
    <script th:src="@{/scripts/configs/commonNameElementsConfig.js}"></script>
    <script th:src="@{/scripts/CommonModuls.js}"></script>
</head>
    <body>
        <header th:replace="~{/templates/BasicTemplates :: difficultHeader}"></header>

        <img th:src="@{/images/SliceOfBG.svg}" class ="main_background_circle" >

        <main>
            <div th:class = "main_column_1">
                <div class = "main_column_1_in">
                    <div span class = "Larger_text"> Сервис поиска тиммейтов. </div> Забудь про игры в случайных  командах.<br> Знакомься или приводи друзей в игру!
                </div>

                <div class = "main_column_1_in">
                    <div class = "main_column_1_in_fields">
                        <form id="create_account_with_mail">
                            <input type="text" id="registration_inputtype" placeholder="email"/>

                            <input type="submit" name="main_button_registration" id="registration_button" value="создать аккаунт" />
                        </form>
                    </div>
                </div>
            </div>

            <div class = "main_column_2"> <img th:src="@{/images/logotest2.png}"> </div>
        </main>

        <script type="application/javascript" th:src="@{/scripts/indexController.js}"></script>
    </body>
</html>