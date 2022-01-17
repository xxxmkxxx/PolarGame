<html xmlns:th="http://www.thymeleaf.org" lang="ru">

<div th:fragment="authentificationInfoBlock" class = "header_buttons_cont">
    <a th:href="@{/user/login}"><span name = "header_button_sign_in" class = "header_buttons" style = "border: none"> войти </span></a>
    <a th:href="@{/user/new}"><span name = "header_button_registration" class = "header_buttons"> создать аккаунт </span></a>
</div>

<div th:fragment="userInfoBlock" class = "profile_data">
    <span class = "profile" id="profile" th:text="${user.login}"></span>
    <div class = "profile_icon"> <img th:src="@{'/images/' + ${user.urlUserIcon}}"></div>
</div>

<div th:fragment="logoInfoBlock" class = "click_logo">
    <span class = "header_minilogo"> <img th:src="@{/images/minilogo.png}"> </span>
    <span class = "header_minilogo"> POLARGAME </span>
</div>

<header th:fragment="difficultHeader">
    <div th:replace="~{/templates/BasicTemplates :: logoInfoBlock}"></div>

    <div th:replace="~{/templates/BasicTemplates :: (${authorized} ? userInfoBlock : authentificationInfoBlock)}" ></div>

    <span th:if="${authorized}" class = "menu_icon"> <img id="menu_icon" th:src="@{/images/menu_icon.png}"></span>
</header>

<header th:fragment="simpleHeader">
    <div th:replace="~{/templates/BasicTemplates :: logoInfoBlock}"></div>

    <span th:if="${authorized}" class = "menu_icon" style = "margin-left: 75.4vw"> <img id="menu_icon" th:src="@{/images/menu_icon.png}"></span>
</header>

<div th:fragment="menu" class = "menu">

    <span class = "menu_categories"> ИГРЫ </span>
    <a th:href="@{/dialogs/}"> <span class = "menu_categories"> ДИАЛОГИ </span> </a>
    <span class = "menu_categories"> ВЫЙТИ </span>
</div>