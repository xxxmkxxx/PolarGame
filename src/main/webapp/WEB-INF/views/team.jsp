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
            <div class="team_member_row">
              <div class="team_member_icon"><img th:src="@{/images/example_pic.png}" /></div>
              <div class="team_member_name">ник создателя</div>
            </div>

            <div class="team_member_row">
              <div class="team_member_icon"><img th:src="@{/images/example_pic.png}" /></div>
              <div class="team_member_name">ник участника</div>
            </div>

            <div class="team_member_row">
              <div class="team_member_icon"><img th:src="@{/images/example_pic.png}" /></div>
              <div class="team_member_name">ник участника</div>
            </div>
          </div>
        </span>

        <span class="section2">
          <div th:replace = "~{/templates/DialogTemplates :: messagesForm}"></div>

          <div th:replace = "~{/templates/DialogTemplates :: sendMessageBlock}"></div>
        </span>
      </div>
    </main>
  </body>
</html>
