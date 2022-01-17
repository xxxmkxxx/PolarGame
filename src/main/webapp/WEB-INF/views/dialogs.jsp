<!DOCTYPE html>

<html lang="ru">
<head>
    <meta charset="utf-8" />
    <title>Диалоги</title>
    <link th:href="@{/styles/dialogs.css}" rel="stylesheet" />
    <link th:href="@{/styles/headerStyle.css}" rel="stylesheet" type="text/css">
    <link rel="icon" th:href="@{/images/logotest2.png}">
    <script th:src="@{/webjars/jquery/3.6.0/jquery.min.js}"></script>
    <script th:src="@{/scripts/configs/commonNameElementsConfig.js}"></script>
    <script th:src="@{/scripts/CommonModuls.js}"></script>
</head>

<body>
    <header th:insert="~{/templates/BasicTemplates :: difficultHeader}"></header>
    <div th:insert="~{/templates/BasicTemplates :: menu}"></div>

<main id="main" name="main">


    <div class="sections">
        <span class="section1">
            <div class = "dialogs" id = "dialogs">
                <div th:each="team : ${teams}" th:id="${'team_' + team.teamId}" class="dialog"><span class="about_dialog_member">
                    <span class="dialog_icon"><img th:src="@{'/images/' + ${team.urlTeamIcon}}"></span>
                    <span class="dialog_member_nick" th:text="${team.teamName}"></span></span>
                    <span class="last_message_time">fwfwfwdwwa</span>
                </div>
            </div>


        </span>

        <span class="section2">
          <div class="messages">
            <!-- сообщение -->
            <div th:each="message : ${teamMessages}" class="message_block" th:style="${message.user.login == user.login} ? 'flex-direction: row-reverse' : ''">
                 <div class="dialog_member_icon">
                     <img th:src="@{'/images/' + ${message.user.urlUserIcon}}" />
                 </div>

                  <div class="message">
                        <div class="message_info">
                              <span class="message_sender_name" th:text="${message.user.login}"></span>
                              <span class="message_time" th:text="${message.messageDate}"></span>
                        </div>

                        <div class="message_text" th:text="${message.messageText}"></div>
                  </div>
            </div>
          </div>

            <form id="send_message_form" th:method="POST">
                <div class="send_message_block">
                    <input id="message_text" type="text" placeholder="Напишите сообщение..." class="type_message" />

                    <div class="push_icon"><img th:src="@{/images/push_icon.png}" /></div>
                </div>
            </form>
        </span>
    </div>
</main>

<script th:src="@{/scripts/DialogsController.js}"></script>

</body>
</html>
