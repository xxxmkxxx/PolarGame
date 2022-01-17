<div th:fragment="user_description" class="user_description" id="user_description">
    <textarea id="user_description_area" maxlength = "500" wrap="soft" class="user_description_area" th:text="${user.description}"></textarea>
    <span th:if="${myPage}" class="edit_icon">
        <img id="edit_description" th:src="@{/images/edit_icon.png}" />
    </span>
</div>

<div th:fragment="choice_of_action_for_me" class="choice_of_action">
    <span class="sectionButtons" id = "friends_button" style = "opacity: 100%;"> МОИ ДРУЗЬЯ </span>
    <span class="sectionButtons" id = "settings_button"> НАСТРОЙКИ </span>
</div>

<div th:fragment="choice_of_action_for_user" class="choice_of_action">
    <span class="sectionButtons" id = "friends_buttonForUser" style = "opacity: 100%;"> ДРУЗЬЯ </span>
    <span class="sectionButtons" id = "userIsIN_button"> СОСТОИТ В</span>
</div>

<div th:fragment="myFreinds" class = "friends_section" id = "friends_section">
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

<div th:fragment="usersFreinds" class = "friends_section" id = "usersFriends">
    <div class="filter_row">
            <input
                    type="text"
                    id="find_friend"
                    class="find_friend_inp"
                    placeholder="найти по имени"
            />
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

<div th:fragment="mySettings" class = "settings_section" id = "settings_section">

    <form id="settings_form" th:method="POST">
        <div class="settings_form">
            <div class="type_of_setting">АККАУНТ</div>
            <div class="active_section_of_settings">

                <div class="setting_name">Изменить ник</div>
                <div class="line_to_check">
                    <input type="text" id="new_login_field" class="input_form" placeholder="Введите новый ник" />
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
                    <input type="password" id="lost_password_field" class="input_form" placeholder="Введите старый пароль" />
                    <div class="checking_circle"></div>
                </div>

                <div class="line_to_check">
                    <input type="password" id="new_password_field" class="input_form" placeholder="Введите новый пароль" />
                    <div class="checking_circle"></div>
                </div>

                <div class="line_to_check">
                    <input type="password" id="repeat_password_field" class="input_form" placeholder="Повторите новый пароль" />
                    <div class="checking_circle"></div>
                </div>

            </div>
        </div>

        <input type="submit" id="save_settings" class="button_save_settings" value="СОХРАНИТЬ">
    </form>
</div>

<div th:fragment="friends_of_user" class = "friends_section" id = "users_friends">
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
            <span class="friend_func_icon message_icon" style = "margin-left:3vw">
                <img th:id="${friend.login}" th:src="@{/images/add_friend_icon.png}" />
            </span>

            </span>
        </div>
    </div>
</div>

<div th:fragment="userIsIn" class = "settings_section" id = "userIsIn">
    <div class="users_team_party">
        <div class="typeOfIn" style = "text-decoration: underline">ПАТИ</div>
    </div>

    <div class="users_team_party">
        <div th:replace = "~{/templates/ProfileTemplates :: usersParty}"></div>
    </div>

    <div class="users_team_party">
        <div class="typeOfIn" style = "text-decoration: underline">КОМАНДЫ</div>
    </div>

    <div class="users_team_party">
        <div th:replace = "~{/templates/ProfileTemplates :: usersTeams}"></div>
    </div>

</div>

<div th:fragment="usersParty">
    <div class = "com_party_place" id="com_party_place">

            <span class="form1">
                <div  class="formsdata">
                    <span class="form_img">
                        <img src="">
                    </span>

                    <span class="party_creator" th:text="party_creator"></span>
                </div>

                <div class="row2">
                    <span class="participans" th:text="participans"></span>

                    <span class="come_in" th:id="come_in">
                        <img th:src="@{/images/come_in_icon.png}">
                    </span>
                </div>
            </span>

    </div>
</div>

<div th:fragment="usersTeams">
    <div class = "com_party_place" id="com_party_place">
        <div th:each="row, i : ${partyGroups}" class="row1" th:id="rowParty + ${i.index}">
            <span th:each="party, j : ${row}" th:class="form + ${j.index % row.size() + 1}">
                <div th:with="owner = ${partyMembersService.getOwner(party.members)}" class="formsdata">
                    <span class="form_img">
                        <img th:src="@{'/images/' + ${owner.urlUserIcon}}">
                    </span>

                    <span class="party_creator" th:text="${owner.login}"></span>
                </div>

                <div class="row2">
                    <span class="participans" th:text="${party.members.size()} + ' из ' + ${party.usersAmount}"></span>

                    <span class="come_in" th:id="${party.partyId}">
                        <img th:src="@{/images/come_in_icon.png}">
                    </span>
                </div>
            </span>
        </div>
    </div>
</div>