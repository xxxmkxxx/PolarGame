<html xmlns:th="http://www.thymeleaf.org" lang="ru">
  <head>
    <meta charset="utf-8" />
    <title th:text="${pageName}"></title>
    <link th:href="@{/styles/profile.css}" rel="stylesheet" />
    <link th:href="@{/styles/team_party_style.css}" rel="stylesheet" type="text/css"><link th:href="@{/styles/headerStyle.css}" rel="stylesheet" type="text/css">
    <link rel="icon" th:href="@{/images/logotest2.png}">
    <script th:src="@{/webjars/jquery/3.6.0/jquery.min.js}"></script>
    <script th:src="@{/scripts/configs/ptrofileNameElementsConfig.js}"></script>
    <script th:src="@{/scripts/configs/commonNameElementsConfig.js}"></script>
    <script th:src="@{/scripts/CommonModuls.js}"></script>

  </head>

  <body>
    <header th:replace="~{/templates/BasicTemplates :: simpleHeader}"></header>

    <div th:insert="~{/templates/BasicTemplates :: menu}"></div>

     <!-- ФОРМА ПОДТВЕРЖДЕНИЯ УДАЛЕНИЯ ДРУГА -->
     <div class = "whiteBack" id = "whiteBack"> </div>
     <div class = "confirmationBlock" id = "confirmationBlock">
       <div class = "confirmationText">Вы уверены, что хотите удалить <span id = "friendToDelete">ХХХ</span> из друзей?</div>
       <div class = "confirmationButtons"> 
         <button class = "confirmationButton" id = "confirmationToDelete" >удалить</button>
         <button class = "confirmationButton" id = "confirmationCancel">отменить</button>
       </div>
     </div>
     <!--  -->

    <main id="main" name="main">

      <div class = "notification_icon"><img th:src="@{/images/notify_icon.png}"></div>
      <div class = "notificatation_form">

        <!-- ФОРМА УВЕДОМЛЕНИЙ -->
        <div class = "notification_one">
          <span class = "notification_text">хочет добавить вас в друзья </span>
          <span class = "notify_choice_of_action">
            <span class = "notification_icons"><img th:src="@{/images/apply_icon.png}"></span>
            <span class = "notification_icons"><img th:src="@{/images/cancel_icon.png}"></span>
          </span>
        </div>
      </div>
      <div class="sections">
        <span class="section1">
            <div class="usersection">
                <div class="user_data">
                    <div class="user_icon">
                    <img id="user_icon" th:src="@{'/images/' + ${user.urlUserIcon}}" /></div>

                    <div class="user_name_and_rating">
                        <div class="user_name" id="user_name" th:text="${user.login}"></div>
                        <div class="user_rating"></div>
                    </div>
                </div>

                <div th:replace="~{/templates/ProfileTemplates :: user_description}"></div>
          </div>
        </span>

        <span class="section2">
            <div th:replace = "~{/templates/ProfileTemplates :: (${myPage} ? choice_of_action_for_me : choice_of_action_for_user)}"></div>

            <div th:replace = "~{/templates/ProfileTemplates :: (${myPage} ? myFreinds : friends_of_user)}"></div>

            <div th:replace = "~{/templates/ProfileTemplates :: (${myPage} ? mySettings : userIsIn)}"></div>
        </span>
      </div>
    </main>

    <script type="application/javascript" th:src="@{/scripts/ProfileController.js}"></script>
  </body>
</html>
