<html xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="utf-8">
    <title> СТРАНИЦА ИГРЫ </title>
    <link th:href="@{/styles/css/game.css}" rel="stylesheet" type="text/css">
</head>

<body>

<header>
    <div class = "click_logo">
        <span class = "header_minilogo"> <img th:src="@{/images/images/minilogo.png}"> </span>
        <span class = "header_minilogo"> POLARGAME </span>
    </div>

    <div class = "profile_data">

        <span class = "profile" id="profile"> TESTTT </span>
        <div class = "profile_icon"> <img th:src="@{/images/images/profile_icon.png}"></div>
        <span class = "menu_icon"> <img id="menu_icon" th:src="@{/images/images/menu_icon.png}"></span>
    </div>
</header>

<main id = "main" name = "main">

    <form id="create_party_form"> <!-- форма создания пати -->

        <div class = "create_party_form">
            <div class = "close_party_creator" onclick = ""> <img th:src="@{/images/images/close_icon.png}"> </div>

            <div class = "cre_row">
                <span class = "privacy_name" style = "margin-top: 0vw"> Приватность: </span>
                <input type="checkbox" id = "privacy" class = "privacy" value="no">

                <span class = "pl_num_name"> Количество игроков: </span>
                <input type="number" id="player_num"  min="2" max="100" value="2" class = "player_num">
            </div>

            <input type ="text" class = "password_form" id="passwordForm" placeholder="пароль">


            <div class = "cre_row">
                <span class = "load_name"> Загрузите изображение: </span>
                <input type="file" id="file" class = "load">

            </div>

            <div class = "cre_row">
                <div class="preview"><img id="preview" src="#" alt="your image"></div>
            </div>

            <div class = "cre_row">
                <span class = "par_descr_name"> Описание: </span>
            </div>

            <div class = "cre_row">
                <textarea id="party_descr" wrap = "soft" maxlength="400" class = "party_descr"> </textarea>
            </div>

            <button id="create_party_button" class = "create_button"> СОЗДАТЬ ПАТИ</button>
        </div>
    </form>

    <div class = "party_filters" id = "party_filters">
        <div class = "party_filt_categ">
            <div class = "filter_data">
                <div class = "filter_name"> ПРИВАТНОСТЬ </div>

                <div class = "categ_box">
                    <input type="checkbox" id = "privacy_filter1" class = "privacy_filter"> приватные
                </div>

                <div class = "categ_box">
                    <input type="checkbox" id = "privacy_filter2" class = "privacy_filter"> публичные
                </div>
            </div>

            <div class = "filter_data">
                <div class = "filter_name" style = "margin-left: 2.5vw;"> КОЛИЧЕСТВО УЧАСТНИКОВ </div>
                <input type="range" min="2" max="15" step="1" value="2" id = "filter_range" name = "filter_range" onchange="" class = "input_range">
                <output type = "text" id = "ouput_range" class = "ouput_range"> 2 </output>
            </div>
        </div>

        <button id = "apply_party_filt" class = "apply_party_filt" onclick = ""> ПРИМЕНИТЬ </button>
    </div>
    <!--</form>-->


    <div class = "menu">
        <a th:href="@{/}"> <span class = "menu_categories"> ДРУЗЬЯ </span> </a>
        <a th:href="@{/}">  <span class = "menu_categories"> ДИАЛОГИ </span> </a>
        <span class = "menu_categories">  ИГРЫ </span>
        <span class = "menu_categories"> ВЫЙТИ </span>
    </div>

    <div class = "sections">
			<span class = "section1">
				<div class = "gamesection">
                    <div class = "game_data">
                        <div class = "game_icon"> <img id="game_icon" th:src="@{'/images/' + ${game.urlGameIcon}}"> </div>

                        <div class = "game_data_right">
                            <div class = "game_name" id="game_name" th:text="${game.name}"></div>
                            <div class = "game_rating">

                            </div>
                        </div>


                    </div>

                    <div class = "game_description" id="game_description" th:text="${game.description}"></div>
				</div>



				<div class = "reviews">
					<div class = "review_block1">
						<span class = "rev"> отзывы </span>
						<span class = "write"> <img th:src="@{/images/images/write_comment.png}">  </span>
					</div>

                    <form id="write_commment_form"> <!-- Форма создания отзыва -->
                        <div class = "write_commment">
                            <textarea id="write_commment_area" wrap="soft" class="write_commment_area"> </textarea>
                            <button class = "comment_but" id="write_commment_button"> отправить </button>
                        </div>
                    </form>

					<div th:each="comment : ${gameComments}" class = "review_block2" id="review_block2">
                        <div class="comment">
                            <div class="author_data">
                                <span class="author_icon">
                                    <img th:src="@{'/images/' + ${comment[1].urlUserIcon}}"/>
                                </span>
                                <span class="author_name" th:text="${comment[1].login}"></span>
                            </div>

                            <div class="comment_text" th:text="${comment[0].text}"></div>
                        </div>
					</div>


				</div>

				<button class = "button_show_more" id="button_show_more"> ПОКАЗАТЬ БОЛЬШЕ </button>

			</span>

        <span class = "section2">
				<div class = "choice_of_action">
					<span class = "find_party"> НАЙТИ ПАТИ </span>
					<span class = "find_command"> НАЙТИ КОМАНДУ </span>
				</div>

				<div class = "filter_row">
					<form id="party_search">
						<input type="text" id="find_party" class = "find_game_inp" placeholder="ник создателя пати">
					</form>
					<span class = "find_icon"> <img id="find_icon" th:src="@{/images/images/find_icon.png}"></span>
					<span class = "filter_icon" > <img th:src="@{/images/images/filter_icon.png}" onclick = "" ></span>
					<span class = "create_party" onclick = ""> СОЗДАТЬ ПАТИ </span>
					<span class = "create_com"> СОЗДАТЬ КОМАНДУ </span>
				</div>

				<div class = "search_message" id="search_message"> </div>
				<div class = "com_party_place" id="com_party_place">
                    <div th:each="row, i : ${partyGroups}" class="row1" th:id="rowParty + ${i.index}">
                        <span th:each="party, j : ${row}" th:class="form + ${j.index % row.size() + 1}">
                            <div class="formsdata">
                                <span class="form_img">
                                    <img th:src="@{'/images/' + ${party.user.urlUserIcon}}">
                                </span>

                                <span class="party_creator" th:text="${party.user.login}"></span>
                            </div>

                            <div class="row2">

                                <span class="participans" th:text="${partyMemberDAO.getMembersByPartyId(party.partyId).size()} + ' из ' + ${party.usersAmount}"></span>

                                <span class="come_in" th:id="${party.partyId}">
                                    <img th:src="@{/images/images/come_in_icon.png}">
                                </span>
                            </div>
                        </span>
                    </div>
				</div>
			</span>
    </div>

</main>

</body>
</html>