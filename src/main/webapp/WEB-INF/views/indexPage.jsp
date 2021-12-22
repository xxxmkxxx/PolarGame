<html xmlns:th="http://www.thymeleaf.org" lang="ru">

<head>
    <meta charset="utf-8">
    <title> ГЛАВНАЯ СТРАНИЦА </title>
    <link th:href="@{/styles/css/Start.css}" rel="stylesheet" type="text/css">
    <script th:src="@{/scripts/js/jquery.js}"></script>
</head>

<body>

<script type="application/javascript" th:inline="javascript">

</script>

<header>
    <div class = "click_logo">
        <span class = "header_minilogo"> <img th:src="@{/images/images/minilogo.png}"> </span>
        <span class = "header_minilogo"> POLARGAME </span>
    </div>

    <span class = "header_buttons_cont">
			<a th:href="@{/user/login}"><span name = "header_button_sign_in" class = "header_buttons" style = "border: none"> войти </span></a>
			<a th:href="@{/user/new}"><span name = "header_button_registration" class = "header_buttons"> создать аккаунт </span></a>
		</span>
</header>

<img th:src="@{/images/images/SliceOfBG.svg}" class ="main_background_circle" >

<main>
    <div th:class = "main_column_1">

        <div class = "main_column_1_in">
            <div span class = "Larger_text"> Сервис поиска тиммейтов. </div> Забудь про игры в случайных  командах.<br> Знакомься или приводи друзей в игру!
        </div>

        <div class = "main_column_1_in">
            <div class = "main_column_1_in_fields">

                <form id="create_account_with_mail" th:method="GET">
                    <input type="text" id = "registration_inputtype" placeholder="email"/>

                    <input type="submit" name = "main_button_registration" id = "registration_button" value="создать аккаунт" />
                </form>
            </div>
        </div>

    </div>

    <div class = "main_column_2"> <img th:src="@{/images/images/logotest2.png}"> </div>

</main>

<script type="application/javascript" th:src="@{/scripts/js/indexController.js}"></script>

</body>


</html>