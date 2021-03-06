<html xmlns:th="http://www.thymeleaf.org" lang="ru">

<head>
    <meta charset="utf-8">
    <title> РЕГИСТРАЦИЯ </title>
    <link th:href="@{/styles/registration.css}" rel="stylesheet" type="text/css">
    <link rel="icon" th:href="@{/images/logotest2.png}">
    <script th:src="@{/webjars/jquery/3.6.0/jquery.min.js}"></script>
</head>

<body>

<header th:insert="~{/templates/BasicTemplates :: simpleHeader}"></header>

<main>
    <form id="registration" th:method="POST" th:action="@{/user/new}">
        <div class = "main_form_reg">
            <div id = "main_form_reg_name" class = "main_form_reg_name"> Регистрация </div>

            <div class = "main_form_reg_fields_names"> Логин <span class = "sign_required_field"> * </span> </div>
            <input type="text" id = "reg_form_login" name = "reg_form_login" class = "main_form_reg_fields" size="40">

            <div class = "main_form_reg_fields_names"> Email <span class = "sign_required_field"> * </span></div>
            <input type="text" id = "reg_form_mail" name = "reg_form_mail" class = "main_form_reg_fields" size="40" th:value="${mail}">

            <div class = "main_form_reg_fields_names"> Пароль <span class = "sign_required_field"> * </span></div>
            <input type="password" id = "reg_form_password" name = "reg_form_password" class = "main_form_reg_fields" size="40">

            <div class = "main_form_reg_fields_names"> Повторите пароль <span class = "sign_required_field"> * </span></div>
            <input type="password" id = "reg_form_password2" name = "reg_form_password2" class = "main_form_reg_fields" size="40">


            <div class = "Error_form">
                <div class = "error_icon" id="error_icon"> </div>
                <div class = "Error_message" id="Error_message"></div>
            </div>

            <input type="submit" name = "button_create_account" id = "button_create_account" class ="button_create_account" value="создать аккаунт" />

            <div class = "back"> <a th:href="@{/}"> Назад </a> </div>
        </div>
    </form>

</main>

<script type="application/javascript" th:src="@{/scripts/RegistrationController.js}"></script>

</body>

</html>