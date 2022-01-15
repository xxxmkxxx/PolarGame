<html xmlns:th="http://www.thymeleaf.org" lang="ru">
  <head>
    <meta charset="utf-8" />
    <title th:text="${pageName}"></title>
    <link th:href="@{/styles/profile.css}" rel="stylesheet" />
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

            <div class="user_description" id="user_description">
              <textarea id="user_description_area" maxlength = "500" wrap="soft" class="user_description_area" th:text="${user.description}"></textarea>
                <span class="edit_icon">
                  <img id="edit_description" th:src="@{/images/edit_icon.png}" />
                </span>
              </span>
            </div>

          </div>
        </span>

        <span class="section2">
          <div class="choice_of_action">
            <span class="sectionButtons" id = "friends_button" style = "opacity: 100%;"> МОИ ДРУЗЬЯ </span>
            <span class="sectionButtons" id = "settings_button"> НАСТРОЙКИ </span>
          </div>

          <div class = "friends_section" id = friends_section> 
          <div class="filter_row">
            <form id="friend_search">
              <input
                type="text"
                id="find_friend"
                class="find_friend_inp"
                placeholder="найти по имени"
              />
            </form>
            <span class="find_icon"> <img id="find_icon" th:src="@{/images/find_icon.png}" /></span>
          </div>

          <div class="friends_form">
            <div th:each="friend : ${friends}" class="friend_line">
              <span class="friend_icon">
                <img id="friend_icon" th:src="@{'/images/' + ${friend.urlUserIcon}}" />
              </span>
              <span class="friend_nick" th:text="${friend.login}"></span>
              <span class="friend_line_icons">
                <span class="friend_func_icon message_icon">
                  <img th:id="${friend.login}" th:src="@{/images/message_icon.png}" />
                </span>
                <span class="friend_func_icon delete_icon">
                  <img th:id="${friend.login}" th:src="@{/images/delete_icon.png}" />
                </span>
              </span>
            </div>
          </div>
          </div>
       
          <div class = "settings_section" id = "settings_section">

          <div class="settings_form">
            <div class="type_of_setting">АККАУНТ</div>
              <div class="active_section_of_settings">
                
                  <div class="setting_name">Изменить ник</div>
                  <div class="line_to_check">
                    <input type="text" class="input_form" placeholder="Введите новый ник" />
                    <div class="checking_circle"></div>
                  </div>
                
                  <div class="setting_name">Изменить изображение</div>
                  <input
                    type="file"
                    name="new_profile_pic_input"
                    accept="image/*"
                    class="new_pic_input"
                  />

                  <div class="setting_confirm_email">Отправить письмо для подтверждения email</div>
                
              </div>
          </div>
          
          <div class="settings_form">

            <div class="type_of_setting">ПАРОЛЬ</div>
              <div class="active_section_of_settings">
                
                <div class="setting_name">Изменить пароль</div>

                <div class="line_to_check">
                  <input type="password" class="input_form" placeholder="Введите старый пароль" />
                  <div class="checking_circle"></div>
                </div>

                <div class="line_to_check">
                  <input type="password" class="input_form" placeholder="Введите новый пароль" />
                  <div class="checking_circle"></div>
                </div>

                <div class="line_to_check">
                  <input type="password" class="input_form" placeholder="Повторите новый пароль" />
                  <div class="checking_circle"></div>
                </div>

              </div>
            </div>

            <button id="save_settings" class="button_save_settings">СОХРАНИТЬ</button>
        </div> 

        </span>
      </div>
    </main>

    <script type="application/javascript" th:src="@{/scripts/ProfileController.js}"></script>
  </body>
</html>
