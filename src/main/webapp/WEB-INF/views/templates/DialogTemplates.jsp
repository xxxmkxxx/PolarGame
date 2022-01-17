<div th:fragment = "messagesForm" class="messages">
    <div th:each="message : ${teamMessages}" class="message_block" th:style="${message.user.login == user.login} ? 'flex-direction: row-reverse' : ''">
        <div class="dialog_member_icon">
            <img th:src="@{'/images/' + ${message.user.urlUserIcon}}" />
        </div>

        <div class="message">
            <div class="message_info" th:style="${message.user.login == user.login} ? 'flex-direction: row-reverse' : ''">
                <span class="message_sender_name" th:text="${message.user.login}"></span>
                <span class="message_time" th:text="${message.messageDate}"></span>
            </div>

            <div class="message_text" th:text="${message.messageText}" th:style="${message.user.login == user.login} ? 'align-self: self-end' : ''"></div>
        </div>
    </div>
</div>


<div th:fragment = "sendMessageBlock" class="send_message_block">
    <input id="message_text" type="text" placeholder="Напишите сообщение..." class="type_message" />

    <div class="push_icon"><input type = "image" th:src="@{/images/push_icon.png}" /></div>
</div>