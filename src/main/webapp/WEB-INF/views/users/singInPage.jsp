<html xmlns:th="http://www.thymeleaf.org" lang="ru">

<head>
    <meta charset="utf-8">
    <title> АВТОРИЗАЦИЯ </title>
    <link th:href="@{/styles/css/sign_in.css}" rel="stylesheet" type="text/css">
</head>

<body>
<header>
    <div class = "click_logo">
        <span class = "header_minilogo"> <img th:src="@{/images/images/minilogo.png}"> </span>
        <span class = "header_minilogo"> POLARGAME </span>
    </div>
</header>

<main>
    <form id="sing_in" th:method="POST" th:action="@{/users/verefication/}">
        <div class = "main_form_reg">
            <div class = "main_form_reg_name" id="main_form_reg_name"> Вход </div>

            <div class = "main_form_reg_fields_names"> Логин </div>
            <input type="text" id = "sign_form_login" required name = "sign_form_login" class = "main_form_reg_fields" size="40">

            <div class = "main_form_reg_fields_names"> Пароль </div>
            <input type="password" id = "sign_form_password"required name = "sign_form_password" class = "main_form_reg_fields" size="40">

            <div class = "Error_form">
                <div class = "error_icon"> <img  id="error_icon" src="" > </div>
                <div class = "Error_message" id="Error_message"></div>
            </div>

            <input type="submit" name = "button_sign_in" id = "button_sign_in" class ="button_create_account" value="войти"/>

            <div class = "bottom_line">
                <div class = "back"> <a th:href="@{/}"> Назад </a> </div>
                <div class = "forgot_password" id="forgot_password" align="right"> <a th:href="@{/}"> Забыли пароль? </a> </div>
            </div>

        </div>
    </form>
</main>

</body>

</html>
