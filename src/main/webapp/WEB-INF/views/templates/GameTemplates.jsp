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

<div th:fragment="openOrClosed" class="row2">
    <span id = "participants" class="participants" th:text="${party.members.size()} + ' из ' + ${party.usersAmount}"></span>
    <form th:id = "${'checkPassword_' + party.partyId}">
        <span id = "passwordOfParty" th:fragment = "passwordField" class="partyPassword">
            <input type = "password" placeholder="введите пароль">
        </span>
    </form>

    <span th:replace = "~{/templates/GameTemplates :: ${false} ? open : closed}"></span>
</div>

<span th:fragment = "open" class="come_in" th:id="${party.partyId}">
    <img th:src="@{/images/come_in_icon.png}" id = "open_icon">
</span>

<span th:fragment = "closed" class="come_in" th:id="${party.partyId}">
    <img th:src="@{/images/closed_icon.png}" id = "closed_icon">
</span>






