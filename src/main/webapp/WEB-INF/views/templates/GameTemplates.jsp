<div th:fragment="parties" class = "com_party_place" id="com_party_place">
    <div th:each="row, i : ${partyGroups}" class="row1" th:id="rowParty + ${i.index}">
            <span th:each="party, j : ${row}" th:class="form + ${j.index % row.size() + 1}">
                <div th:with="owner = ${partyMembersService.getOwner(party.members)}" class="formsdata">
                    <span class="form_img">
                        <img th:src="@{'/images/' + ${owner.urlUserIcon}}">
                    </span>

                    <span class="party_creator" th:text="${owner.login}"></span>
                </div>

                <div th:replace = "~{/templates/GameTemplates :: openOrClosed}"></div>
            </span>
    </div>
</div>

<div th:fragment = "teams" class = "com_party_place" id="com_party_place">
    <div th:each="row, i : ${teamsGroups}" class="row1" th:id="rowParty + ${i.index}">
        <span th:each="team, j : ${row}" th:class="form + ${j.index % row.size() + 1}">
            <div class="formsdata">
                <span class="form_img">
                    <img th:src="@{'/images/' + ${team.urlTeamIcon}}">
                </span>

                <span class="party_creator" th:text="${team.teamName}"></span>
            </div>

            <div class="row2">
                <span id = "participants" class="participants" th:text="${team.members.size()} + ' из ' + ${team.teamGamersAmount}"></span>

                <span class="come_in open" th:id="${team.teamId}">
                    <img th:src="@{/images/come_in_icon.png}" id = "open_icon">
                </span>
            </div>

        </span>
    </div>
</div>

<div th:fragment="openOrClosed" class="row2">
    <span id = "participants" class="participants" th:text="${party.members.size()} + ' из ' + ${party.usersAmount}"></span>
    <form th:id = "${'checkPassword_' + party.partyId}">
        <span id = "passwordOfParty" th:fragment = "passwordField" class="partyPassword">
            <input type = "password" placeholder="введите пароль">
        </span>
    </form>

    <span th:replace = "~{/templates/GameTemplates :: ${true} ? open : closed}"></span>
</div>

<span th:fragment = "open" class="come_in open" th:id="${party.partyId}">
    <img th:src="@{/images/come_in_icon.png}" id = "open_icon">
</span>

<span th:fragment = "closed" class="come_in" th:id="${party.partyId}">
    <img th:src="@{/images/closed_icon.png}" id = "closed_icon">
</span>

<div th:fragment = "party" class="party_form" id="party_form">

    <div class="party_data">
        <div class="party_icon">
            <img th:src="@{'/images/example_pic.png'}">
        </div>

        <div class="party_descriprion" id="party_descriprion">
            Описание пати
        </div>
    </div>

    <div class="party_сontent">
        <div class="party_members_form" id="party_members_form">
            <div th:replace = "~{/templates/GameTemplates :: partyMemberRow}"></div>
            <div th:replace = "~{/templates/GameTemplates :: partyMemberRow}"></div>
            <div th:replace = "~{/templates/GameTemplates :: partyMemberRowMe}"></div>
        </div>

        <div class="members_counter" id="members_counter">
            <div class="members_here" id="members_here"></div>
            <div id="members_amount"></div>
        </div>

        <div class="party_buttons">
            <button id="ready_button" class="ready_button">Я ГОТОВ(А)</button>
            <button id="exit_button" class="exit_button">ВЫЙТИ</button>
        </div>
    </div>
</div>

<div th:fragment="partyMemberRow" class="party_member_row">
    <div class="party_member_icon"> <img th:src="@{'/images/example_pic.png'}"></div>
    <div class="party_member_name">ник участника</div>
    <div class="game_nick">ник в игре</div>
</div>

<div th:fragment="partyMemberRowMe" class="party_member_row">
    <div class="party_member_icon"> <img th:src="@{'/images/example_pic.png'}"></div>
    <div class="party_member_name">твой ник</div>
    <input type="text" id="my_nick" class="game_nick_input" />
</div>