<!DOCTYPE html>

<html lang="ru">
  <head>
    <meta charset="utf-8" />
    <title>КОМАНДЫ</title>
    <link th:href="@{/styles/team.css}" rel="stylesheet" />
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

    <input type="hidden" id="team_id" th:value="${team.teamId}">

    <main id="main" name="main">
      <div class="sections">
        <span class="section1">
          <div class="team_data">
            <div class="team_icon"><img id="team_icon" th:src="@{'/images/' + ${team.urlTeamIcon}}" /></div>

            <div class="team_data_right">
              <div class="team_name" id="team_name" th:text="${team.teamName}"></div>
              <div class="team_rating"></div>
            </div>
          </div>

          <div class="team_description" id="team_description" th:text="${team.teamDescription}"></div>

          <div class="members_block">
            <div th:each="member : ${members}" class="team_member_row">
              <div class="team_member_icon"><img th:src="@{'/images/' + ${member.user.urlUserIcon}}" /></div>
              <div class="team_member_name" th:text="${member.nick}"></div>
            </div>
          </div>
        </span>

        <span class="section2">
          <div th:replace = "~{/templates/DialogTemplates :: messagesForm}" class="messages"></div>

          <form id="send_message_form" th:method="POST">
            <div th:replace = "~{/templates/DialogTemplates :: sendMessageBlock}" class="send_message_block"></div>
          </form>
        </span>
      </div>
    </main>

    <script th:src="@{/scripts/TeamController.js}"></script>
  </body>
</html>
