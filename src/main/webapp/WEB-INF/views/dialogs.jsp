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

            </div>

        </span>

        <span class="section2">
          <div class="messages">
            <!-- сообщение -->
            <div class="message_block">
                 <div class="dialog_member_icon"><img th:src="@{/images/example_pic.png}" /></div>
                  <div class="message">
                        <div class="message_info">
                              <span class="message_sender_name">name</span>
                              <span class="message_time">16:55</span>
                        </div>
                        <div class="message_text">Текст сообщения</div>
                  </div>
            </div>
              <!--  -->
              <!-- МОЕ сообщение -->
            <div class="message_block" style="flex-direction: row-reverse">
              <div class="dialog_member_icon"><img th:src="@{/images/example_pic.png}" /></div>
              <div class="message">
                <div class="message_info" style="flex-direction: row-reverse">
                  <span class="message_sender_name">name</span>
                  <span class="message_time">16:55</span>
                </div>
                <div class="message_text">Текст сообщения</div>
              </div>
            </div>
              <!--  -->
          </div>

          <div class="send_message_block">
            <input type="text" placeholder="Напишите сообщение..." class="type_message" />
            <div class="push_icon"><img th:src="@{/images/push_icon.png}" /></div>
          </div>
        </span>
    </div>
</main>

<script th:src="@{/scripts/DialogsController.js}"></script>

</body>
</html>
