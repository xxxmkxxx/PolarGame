insert into users_roles(id_users_roles, users_role)
values (1,'Модератор');
insert into users_roles(id_users_roles, users_role)
values (2,'Обычный');

insert into Users(id_user, login, password, email, id_users_roles, user_icon, user_description)
values (1, 'abc', 12345, 'xyz@gmail.com', 2, 'dsfhnjs', 'ahljsafsah');
insert into Users(id_user, login, password, email, id_users_roles, user_icon, user_description)
values (2, 'def', 98765, 'abc@gmail.com', 2, 'sfdgerh', 'sdfggdfsgsdf');
insert into Users(id_user, login, password, email, id_users_roles, user_icon, user_description)
values (3, 'xyz', 45056, 'def@gmail.com', 2, 'dgfdgfd', 'ljadfjhkgfdh');
insert into Users(id_user, login, password, email, id_users_roles, user_icon, user_description)
values (4, 'test', '$2y$10$3P8P9MC2Xv4vVIO2TwBPb.Lh6RQ4XORvOvvYfCnptg3csNNIuGJEu', 'test@mail.ru', 2, 'default.png', 'default');

/*insert into PrivateMessage(id_message, id_sender, id_receiver, date_time, message_text)
values (1, 1, 2, '2021-05-10 20:30:00', 'привет');
insert into PrivateMessage(id_message, id_sender, id_receiver, date_time, message_text)
values (2, 2, 1, '2021-05-10 20:30:00', 'hello');*/

insert into party(id_party, game_id, party_password, gamers_amount, party_description, privacy, party_icon, party_creator)
values (1, 1, '12345', 3, 'ищу пати для совместной прокачки', 'открытая', '---', 2);
insert into party(id_party, game_id, party_password, gamers_amount, party_description, privacy, party_icon, party_creator)
values (2, 2, '67890', 4, 'научите играть кто-нибудь пж', 'открытая', '---', 1);
insert into party(id_party, game_id, party_password, gamers_amount, party_description, privacy, party_icon, party_creator)
values (3, 3, 'abcde', 3, 'ищу людей поиграть по фану', 'открытая', '---', 4);
insert into party(id_party, game_id, party_password, gamers_amount, party_description, privacy, party_icon, party_creator)
values (4, 4, 'fghij', 5, 'ищу с кем поиграть в сборку с модами, мне 11', 'закрытая', '---', 3);
insert into party(id_party, game_id, party_password, gamers_amount, party_description, privacy, party_icon, party_creator)
values (5, 5, 'klmno', 4, 'ищу адекватных людей, шарящих в игре', 'закрытая', '---', 6);
insert into party(id_party, game_id, party_password, gamers_amount, party_description, privacy, party_icon, party_creator)
values (6, 6, 'pqrst', 2, 'ищу человека поиграть на 5 лвлах', 'открытая', '---', 5);
insert into party(id_party, game_id, party_password, gamers_amount, party_description, privacy, party_icon, party_creator)
values (7, 7, 'uvwxy', 2, 'ищу саппорта', 'закрытая', '---', 9);
insert into party(id_party, game_id, party_password, gamers_amount, party_description, privacy, party_icon, party_creator)
values (8, 8, 'z1234', 5, 'начал играть недавно. буду рад если поможете разобраться', 'открытая', '---', 7);
insert into party(id_party, game_id, party_password, gamers_amount, party_description, privacy, party_icon, party_creator)
values (9, 9, '56789', 3, 'пошлите на арену. играю хорошо', 'закрытая', '---', 8);
insert into party(id_party, game_id, party_password, gamers_amount, party_description, privacy, party_icon, party_creator)
values (10, 10, '0abcd', 4, 'ищу людей для ограбления казино', 'закрытая', '---', 1);

insert into party_members(party_id, members_party_id, party_member_role, nickname)
values (1, 2, 'обычный', 'kdjsalf');
insert into party_members(party_id, members_party_id, party_member_role, nickname)
values (1, 1, 'создатель', 'kdjsalf');



insert into genres(id_genre, genre)
values (1, 'MMORPG');
insert into genres(id_genre, genre)
values (2, 'Шутер');
insert into genres(id_genre, genre)
values (3, 'Королевская битва');
insert into genres(id_genre, genre)
values (4, 'Песочница');
insert into genres(id_genre, genre)
values (5, 'Симулятор выживания');
insert into genres(id_genre, genre)
values (6, 'MMO');
insert into genres(id_genre, genre)
values (7, 'Симулятор');
insert into genres(id_genre, genre)
values (8, 'MOBA');
insert into genres(id_genre, genre)
values (9, 'Приключенческий боевик');
insert into genres(id_genre, genre)
values (10, 'Экшен');
insert into genres(id_genre, genre)
values (11, 'RPG');
insert into genres(id_genre, genre)
values (12, 'Аркада');
insert into genres(id_genre, genre)
values (13, 'Спорт');
insert into genres(id_genre, genre)
values (14, 'Гонки');
insert into genres(id_genre, genre)
values (15, 'Gacha');

insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (1, 'WORLD OF WARCRAFT', 'Массовая многопользовательская ролевая онлайн-игра, разработанная и издаваемая компанией Blizzard Entertainment. Всё действие происходит в Азероте, мире магии и нескончаемых приключений. Исследуйте постоянно развивающийся фантастический мир и прокачивайте персонажей. Во время своих приключений вы встретите других игроков, что обитают в Азероте. В WoW есть множество сообществ, участники которых связаны между собой крепкими узами дружбы. Дух этой игры сплачивает людей, будь то надежные товарищи, верная команда или достойные соперники. Это не просто игра... это образ жизни.', '../images/WORLD_OF_WARCRAFT.png', 4);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (2, 'COUNTER STRIKE: GLOBAL OFFENSIVE (CS:GO)', 'Трёхмерный многопользовательский шутер от первого лица, в котором игроки распределяются по двум командам и сражаются друг против друга, разработанная компаниями Valve и Hidden Path Entertainment. В игре представлены две команды: террористы и спецназ, а также содержит несколько многопользовательских режимов игры: обычный и соревновательный режим (разминирование бомбы, спасение заложников), королевская битва, военные игры (гонка вооружений, уничтожение объекта, перелётные снайперы), бой насмерть, зачистка, совместный налёт, напарники и страж. В первом сценарии игроки, играющие за команду террористов, должны заложить бомбу в одной из нескольких точек закладки, а спецназ — успешно её разминировать. Во втором сценарии игрокам из команды террористов необходимо не дать противоборствующей команде спасти заложников, которых они похитили.', '../images/CSGO.png', 4.2);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (3, 'PLAYERUNKNOWN`S BATTLEGROUNDS (PUBG)', 'Многопользовательская онлайн-игра в жанре королевской битвы, PlayerUnknown’s Battlegrounds является экшн-игрой, разрабатываемая и издаваемая студией PUBG Corporation, дочерней компанией корейского издателя Bluehole. в которой игроки в количестве до 100 человек сражаются в «королевской битве» (Battle Royale), по типу крупномасштабной «last man standing» схватки в deathmatch режиме, где игроки воюют между собой, чтобы стать последним выжившим. Игроки могут выбирать, как войти в матч: в одиночку, в паре, в трио или отрядом из четырёх человек. В любом случае, последний человек или команда, оставшаяся в живых, выигрывает матч.', '../images/PUBG.png', 4);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (4, 'MINECRAFT', 'Инди-игра в жанре песочницы с элементами выживания и открытым миром. По стилю, мир игры полностью состоит из блоков (ландшафт, предметы, мобы, игрок), и для текстурирования используются текстуры с низким разрешением. Построй, всё что хочешь, из блоков в режиме «творчество», или развивайся в режиме «выживание», или выбери режим «хардкор» и тогда, после твоей смерти, данные о персонаже стираются.', '../images/MINECRAFT.png', 4);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (5, 'RUST', 'Компьютерная игра в жанре симулятора выживания, была создана британской студией Facepunch. Как и в других многопользовательских играх в ней присутствуют игроки, к сожалению для вас, они могут найти вас, убить вас и забрать ваши вещи, к счастью для вас, вы можете убить их и забрать их вещи. Или же вы можете объединиться и помочь друг другу в выживании.', '../images/RUST.png', 4);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (6, 'WORLD OF TANKS', 'Культовая ММО-игра о бронетехнике, покорившая миллионы игроков по всему миру. Разнообразие игровых карт, исторически достоверные машины, реалистичный геймплей — присоединяйтесь к армии танкистов и окунитесь в атмосферу легендарных сражений.', '../images/WORLD_OF_TANKS.png', 4);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (7, 'DOTA 2', 'Компьютерная многопользовательская командная игра в жанре multiplayer online battle arena, разработанная корпорацией Valve. Каждый день миллионы игроков по всему миру вступают в командную битву 5 на 5 в роли одного из более чем сотни героев. Dota — глубочайшая многопользовательская стратегия всех времён, в которой всегда найдётся место новой стратегии или тактике. Начинайте защищать своего Древнего уже сейчас.', '../images/DOTA2.png', 5);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (8, 'LEAGUE OF LEGENDS', 'League of Legends – это стратегическая кооперативная игра, разработанная и выпущенная компанией Riot Games, в которой две команды из пяти могущественных чемпионов сражаются друг с другом, пытаясь уничтожить вражескую базу. Выбирайте персонажа из более чем 140 чемпионов, создавайте эпические моменты, зарабатывайте убийства и сносите башни на пути к победе.', '../images/LEAGUE_OF_LEGENDS.png', 4);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (9, 'FORTNITE', 'Кооперативная песочница на выживание, разработанная американской компанией Epic Games. Основными механиками которой являются исследование, сбор ресурсов, строительство укрепленных зданий и борьба с волнами наступающих зомби. Строительство является основной механикой, при этом в игре «уйма лута». Fortnite: Battle Royale — соревновательный режим в жанре королевской битвы, в котором 100 игроков должны сражаться друг с другом, пока в живых не останется только один.', '../images/FORTNITE.png', 3);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (10, 'GRAND THEFT AUTO (GTA5)', 'Мультиплатформенная компьютерная игра в жанре action-adventure с открытым миром, разработанная компанией Rockstar North и изданная компанией Rockstar Games. Объединяйтесь в команду, станьте грозой Лос-Сантоса, покупайте машины, лодки, квартиры, дома, участвуйте в гонках на любом транспорте, и по любым трассам, играйте в перестрелки и противоборства, выполняйте ограбления, или просто бегайте от полиции, это и многое другое в GTA Online.', '../images/GTA5.png', 5);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (11, 'OVERWATCH', 'Командный шутер от первого лица разработанный компанией Blizzard, выполненный в мультяшной стилистике. Игрокам предстоит сражаться друг с другом на разных аренах в нескольких разных режимах, выбрав одного из десятков уникальных героев, каждый из которых обладает своей историей и навыками.', '../images/OVERWATCH.png', 5);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (12, 'MONSTER HUNTER WORLD: ICEBORNE', 'Action/RPG действия, которые происходят в открытом мире от третьего лица. Как и в предыдущих играх в серии, игрок берет на себя роль Охотника, которому поручается «Исследовательская миссия», по ходу которой он убивает либо ловит монстров, обитающих вокруг центральной базы Астера.', '../images/MONSTER_HUNTER_WORLD_ICEBORNE.png', 3);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (13, 'BATTLEFIELD 3', 'Шутер от первого лица, разработанный студией EA Digital Illusions CE и изданный компанией Electronic Arts; одиннадцатая в серии Battlefield. ... Battlefield 3 — прямой сиквел к Battlefield 2', '../images/BATTLEFIELD_3.png', 4);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (14, 'DEEP ROCK GALACTIC', 'Научно-фантастический шутер с видом от первого лица для совместной игры, в котором вас ждут крутые космические гномы, полностью разрушаемое окружение, процедурно генерируемые системы пещер и бесконечные волны инопланетных чудовищ.', '../images/DEEP_ROCK_GALACTIC.png', 3);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (15, 'CONAN EXILES', 'Мультиплеерный симулятор выживания в открытом мире в сеттинге вселенной Conan, разработанный студией Funcom. Игра предлагает игрокам несколько видов земель (включая пустынные и покрытые снегом), огромное количество разнообразных противников, возможность призывать огромных богов и множество других вещей.', '../images/CONAN_EXILES.png', 3);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (16, 'THE DIVISION 2', 'Продолжение многопользовательского боевика от Ubisoft, в котором события разворачиваются через 6 месяцев после первой части. Место действия перенесено в Вашингтон, округ Колумбия, в котором разразилась гражданская война между выжившими и группами мародеров.', '../images/THE_DIVISION_2.png', 3);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (17, 'APEX LEGENDS', 'Многопользовательская онлайн-игра в жанре «королевская битва», разработанная американской студией Respawn Entertainment и выпущенная компанией Electronic Arts. Игра сталкивает на одной карте до 60 игроков, действующих группами по три человека. перед началом каждого матча предлагает выбрать одного из героев со своими уникальными способностями.', '../images/APEX_LEGENDS.png', 4);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (18, 'EVE ONLINE', 'Массовая многопользовательская онлайн-игра с научно-фантастическим сюжетом, разработана исландской компанией CCP Games, Действие разворачивается в космосе, а игрок выступает в качестве капитана космического корабля.', '../images/EVE_ONLINE.png', 3);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (19, 'WAR THUNDER', 'Многопользовательская онлайн-игра с элементами симулятора, разработанная компанией Gaijin Entertainment, посвящённая боевой авиации, боевым вертолётам, бронетехнике и флоту довоенного периода, а также Второй мировой войны и послевоенного периода.', '../images/WAR_THUNDER.png', 4);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (20, 'ARK: SURVIVAL EVOLVED', 'Приключенческая игра, выполненная в жанре коллективного путешествия разрабатываемая Studio Wildcard, Instinct Games, Effecto Studios, и Virtual Basement.. Вместе с другими игроками вам предстоит высадиться на мистический остров Арк и построить на нем новую цивилизацию.', '../images/ARK_SURVIVAL_EVOLVED.png', 4);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (21, 'BORDERLANDS', 'Игра в жанре фантастического шутера от первого лица/ролевой игры, которую разработала компания Gearbox Software. Действие происходит на Пандоре, планете на краю вселенной, куда искатели сокровищ прилетают в поиске приключений, выбери одного из четырех искателей и вперед за сокровищами в постапокалиптическом мире.', '../images/BORDERLANDS.png', 4);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (22, 'BORDERLANDS 2', 'Прямое продолжение первой части. Встречайте новых искателей сокровищ, новые локации, новые боссы и новый увлекательный сюжет.', '../images/BORDERLANDS_2.png', 5);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (23, 'TEAM FORTRESS 2', 'Гротескный "шпионский" боевик, разработанная и изданная компанией Valve, выполненный в стиле 50-х годов прошлого века. Игроки, разделенные на две команды - Красную и Синию, воюют друг с другом, выступая за несколько разных боевых классов, каждый из которых вооружен уникальным оружием.', '../images/TEAM_FORTRESS_2.png', 3);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (24, 'ROCKET LEAGUE', 'Аркадный проект, который сочетает в себе элементы футбола и боевых гонок на мощных автомобилях. Разработанна и изданна компанией Psyonix. Является логическим продолжением игры Supersonic Acrobatic Rocket-Powered Battle-Cars, в которой игроки занимались примерно тем же - то есть играли в футбол на машинах.', '../images/ROCKET_LEAGUE.png', 4);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (25, 'TERRARIA', 'Пиксельная "песочница", смешивающая Minecraft и приключенческую ролевую игру. Разработанная студией Re-Logic. Игроки вольны исследовать большой, процедурно генерируемый двухмерный мир, добывать ресурсы, строить здания, искать мощную экипировку и сражаться с разнообразными противниками и угрозами.', '../images/TERRARIA.png', 5);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (26, 'WARFRAME', 'Кооперативный онлайн-экшен с видом от третьего лица, созданный компанией Digital Extremes. События игры разворачиваются в далеком будущем, где Земля лежит в руинах и заросла непроходимыми лесами. Игра рассчитана на четырёх человек. Игроки используют варфрейм (с собственным набором умений и характеристик) и оснащены 4 видами вооружения.', '../images/WARFRAME.png', 4);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (27, 'PAYDAY: THE HEIST', 'Шутер от первого лица, разработанный компанией Overkill Software, в котором четверо закоренелых преступников, гонимые рвением сорвать очередной куш, раз за разом совершают налеты на различные предприятия.', '../images/PAYDAY_THE_HEIST.png', 3);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (28, 'PAYDAY 2', 'Кооперативный шутер от первого лица для 4-х игроков. разработанный компанией Overkill Software. Игрокам предстоит "обчистить" бункер борцов с киберпреступностью, лабораторию ученого-ядерщика, который изобрел термоядерный реактор, вызволять различных людей из тюрьмы и так далее.', '../images/PAYDAY_2.png', 4);
insert into game(game_id, game_name, game_description, game_icon_link, popularity)
values (29, 'GENSHIN IMPACT', 'Игра в жанре Action-adventure с открытым миром и элементами RPG, разработанная китайской компанией miHoYo Limited. В роли таинственного персонажа под названием «Путешественник», игроки отправляются исследовать мир, искать и находить его тайны, встречаться с различными персонажами, сражаться с разнообразными противниками и в конечном итоге сделать всё возможное, чтобы воссоединиться со своим потерянным родственником.', '../images/GENSHIN_IMPACT.png', 5);

insert into games_genres (game_id, genre_id)
	values (1, 1);
insert into games_genres (game_id, genre_id)
	values (2, 2);
insert into games_genres (game_id, genre_id)
	values (3, 3);
insert into games_genres (game_id, genre_id)
	values (3, 2);
insert into games_genres (game_id, genre_id)
	values (4, 4);
insert into games_genres (game_id, genre_id)
	values (5, 5);
insert into games_genres (game_id, genre_id)
	values (5, 2);
insert into games_genres (game_id, genre_id)
	values (6, 6);
insert into games_genres (game_id, genre_id)
	values (6, 7);
insert into games_genres (game_id, genre_id)
	values (7, 8);
insert into games_genres (game_id, genre_id)
	values (8, 8);
insert into games_genres (game_id, genre_id)
	values (9, 3);
insert into games_genres (game_id, genre_id)
	values (9, 5);
insert into games_genres (game_id, genre_id)
	values (10, 9);
insert into games_genres (game_id, genre_id)
	values (11, 2);
insert into games_genres (game_id, genre_id)
	values (12, 10);
insert into games_genres (game_id, genre_id)
	values (12, 11);
insert into games_genres (game_id, genre_id)
	values (13, 2);
insert into games_genres (game_id, genre_id)
	values (14, 2);
insert into games_genres (game_id, genre_id)
	values (15, 5);
insert into games_genres (game_id, genre_id)
	values (15, 9);
insert into games_genres (game_id, genre_id)
	values (16, 10);
insert into games_genres (game_id, genre_id)
	values (16, 11);
insert into games_genres (game_id, genre_id)
	values (17, 2);
insert into games_genres (game_id, genre_id)
	values (17, 3);
insert into games_genres (game_id, genre_id)
	values (18, 1);
insert into games_genres (game_id, genre_id)
	values (19, 6);
insert into games_genres (game_id, genre_id)
	values (19, 7);
insert into games_genres (game_id, genre_id)
	values (20, 5);
insert into games_genres (game_id, genre_id)
	values (20, 9);
insert into games_genres (game_id, genre_id)
	values (21, 2);
insert into games_genres (game_id, genre_id)
	values (21, 10);
insert into games_genres (game_id, genre_id)
	values (21, 11);
insert into games_genres (game_id, genre_id)
	values (22, 2);
insert into games_genres (game_id, genre_id)
	values (22, 10);
insert into games_genres (game_id, genre_id)
	values (22, 11);
insert into games_genres (game_id, genre_id)
	values (23, 2);
insert into games_genres (game_id, genre_id)
	values (24, 10);
insert into games_genres (game_id, genre_id)
	values (24, 12);
insert into games_genres (game_id, genre_id)
	values (24, 13);
insert into games_genres (game_id, genre_id)
	values (24, 14);
insert into games_genres (game_id, genre_id)
	values (25, 4);
insert into games_genres (game_id, genre_id)
	values (25, 9);
insert into games_genres (game_id, genre_id)
	values (26, 2);
insert into games_genres (game_id, genre_id)
	values (26, 10);
insert into games_genres (game_id, genre_id)
	values (26, 11);
insert into games_genres (game_id, genre_id)
	values (27, 2);
insert into games_genres (game_id, genre_id)
	values (28, 2);
insert into games_genres (game_id, genre_id)
	values (29, 10);
insert into games_genres (game_id, genre_id)
	values (29, 11);
insert into games_genres (game_id, genre_id)
	values (29, 15);

insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (1, 1, 1, 'Любая игра, в которой есть Дун Морог, заслуживает 10 баллов', '2021-05-10 20:30:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (2, 1, 2, 'Поиграл на оффе, после 3.1.3, боже что сделали с игрой? Повальный автолевелинг, автоизучение скилов, у шмоток впринципе можно было оставить 1 параметр "КГУТОСТЬ!!!" потому что они теперь кардинально между собой не отличаются, и невозможно кардинально перекачать шмотом персонажа, потому что статы шмота теперь формируются динамически при выпаде, и он всегда будет чуть-чуть лучше чем то что на тебе одето, короче превратили мою уютную ВоВку в какой - то скайфордж для имбецилов((', '2021-05-12 10:50:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (3, 1, 3, 'Тот момент когда самое лучшее становится как его конкуренты. Компания уже прямо говорит что им нужны бабки а не люди и не мнение. рест и пис близ.', '2021-05-13 23:10:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (4, 2, 1, 'Отзывы никто не читает, поэтому скажу, что я гей', '2021-04-15 19:35:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (5, 2, 2, 'Я помню чудное мгновенье
Цзшка, Молотов и флешка
Тащить я должен на длине,
Но тут выходит враг ко мне.
А я мой друг не растерялся,
Мой верный Молотов взорвался,
Врагам на зло в коробе той.
Но вот и Молотов потух,
И что же делать милый друг ?
Пора милок достать цзшку,
А с ней и флешку.
И вот я флеш кидаю в них,
Враг мой ослеп и тут же сник.
А я к ним мчуся как стрела,
В руке есть дрожь и нет скила.
Но я отнюдь не забоялся,
Я прям в коробу к ним ворвался,
Не дожидаясь тиму с дна,
Я сделал минус,
Потом два.
Потом еще, еще, еще !!!
И вот он эйс мой долгожданный,
Но тут очнулся я от сна.
И вижу счет 16:2.', '2021-04-19 13:11:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (6, 2, 3, 'Игра хорошая, не советую.', '2021-04-28 18:18:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (7, 4, 1, 'ИГРА ГАВНОО, МЕНЯ ЗАГРИФИРИЛИ.', '2021-04-02 14:56:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (8, 4, 2, 'Игра по сути хорошая, но довольно быстро наводит скуку. Есть огромный плюс в виде большого количества модов, которые вносят разнообразия в игровой процесс. В онлайне у нее полно неразумных людей, что сильно отталкивает от игры (хотя это везде так).', '2021-04-09 16:44:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (9, 4, 3, 'Майнкрафт это моя жизнь (с)', '2021-04-17 10:32:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (10, 7, 1, 'Лучшая игра для нервного срыва, рекомендую.', '2021-03-30 02:39:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (11, 7, 2, 'Welcome to the club buddy! ♂
Entrance fee to the club 300 bucks. ♂
Gaben wishes you a happy fistiпg! ♂', '2021-04-01 12:52:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (12, 7, 3, 'Написано, что игра бесплатная, но она стоила мне жизни.', '2021-04-01 16:34:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (13, 8, 1, 'Нерфы персонажей из-за про сцены, плохой реворк предметов. Если вы хотите поиграть в Лигу Ваншотов, тогда это игра для вас. Недавно Рито в очередной раз ослабили Азира, самого слабого чемпиона в лоле по вр. И этот чемпион заслуживает нерф.', '2021-04-12 19:44:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (14, 8, 2, 'Играла в лигу пол года на RU. Даже не знаю с чего начать, RU сервер сборище неадекватных, очень злых людей. Буквально в каждой катке вас обосрет и ваша тима и враги. Учиться играть на персонажах которые вам нравятся вам просто не дадут, против вас будет рыло с миллионами очков( ибо подбора игроков просто нет) вас убьет каждый кто сможет дотянуться и ваша тема и враги захейтят вас в чате, потому что на RU если не унизишь в чате соперника то победа и не победа вовсе. Если вы подумали создать смурфа и поучиться поиграть среди новичков, то нет вас встретит тот же чел с миллионом очков только на смурфе и обосрет ещё раз. Стоит ли говорить, что новичкам на RU делать просто нечего, сама сталкивалась с тем что будучи новичком меня кидало с челами 400+лвл. Баны в игре просто бесполезны, за все время игры только 2 раза мне приходило уведомление что чела на которого я кинула репорт забанили. Игра зайдёт только тем у кого стальные нервы и ноль эмоций , иначе я не знаю как можно вывезти все то дерьмо что в ней происходит.', '2021-04-17 23:56:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (15, 10, 1, 'Игра – играй и отдыхай, свобода действий.', '2021-04-25 01:14:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (16, 10, 2, 'Сюжет потрясающий, при первом прохождении затягивает. Онлайн был неплох, каскадерские гонки, ограбления вообще супер, но превращения игры в saints row играть стало невозможно, летающие машины и мотоциклы с ракетами, каждый школьник на опрессоре наровит тебя взорвать, пока ты пытаешься заработать на машину из последнего обновления. До обновлений с опрессором мк2 поставил бы 10 /10, сейчас в онлайн нормально играть невозможно, поэтому 4/10', '2021-04-26 04:18:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (17, 10, 3, '10 сбитых оленей из 10', '2021-04-30 10:50:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (18, 9, 1, 'ФОРТННННННАААААЙТ!!!11!11!', '2021-05-03 15:20:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (19, 9, 2, 'Игра топ, скины топ, всем советую, играл пять лет со 2 сезона и только один читер. Кто то скажет что фортнайт портит игровую индустрию но будет не прав ведь сколько людей играет в неё и причём не только дети!!! Ставлю твёрдую 10', '2021-05-09 19:40:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (20, 9, 3, 'К большому сожалению игра реально упала во всех смыслах. И Комьюнити игры стала на много токсичней(', '2021-05-12 03:10:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (21, 5, 1, 'Довольно тупой крафт. Нет возможности 100% защиты жилища, пусть даже и "за дорого". Очень "дорого" обходится поддержание жилища в относительно "безопасном" состоянии. И это учитывая, что к тебе могут прийти "друзья" с взрывчаткой, когда тебя вообще нет в игре и почистить под ноль всё твоё "богатство". (Про всякие там мины и турели не говорим, т.к. это всё нейтрализуется доступными игровыми элементами). Да и вообще сомнительной "идеологии" игра, где человеческое мясо "не очень вкусное" и "сушит во рту"...', '2021-04-04 09:59:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (22, 5, 3, '2021 год. На игру никто не забил, она развивается сильнее, чем в 2016.', '2021-04-28 15:04:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (23, 6, 1, 'Сделайте уже ограничение на 2 арты, да и вообще выведете её нахер. 10 поджогов когда снаряд упал в 5 метрах от танка из 10', '2021-04-10 12:54:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (24, 6, 2, 'Симулятор ожидания, берешь птшку, садишься в куст и ждешь. 10 фугасных снарядов из 10', '2021-04-17 16:00:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (25, 6, 3, 'Играю с 2016 года, в целом игра интересная, много разнообразной техники, красивая графика, звуковые эффекты, можно играть без доната (правда будете дольше фармить валюту). Из минусов это то, что когда ты открываешь новый танк он даётся в стоковой комплектации, т.е. неиграбельной, а чтобы вывести его в топ нужно пострадать несколько часов. Также очень раздражает артиллерия, из-за которой играть на медленной и бронированной технике некомфортно. И, наконец, самый жирный минус — аудитория. Индивиды, играющие сотни, тысячи часов, но до сих пор не научившиеся играть и обвиняющие в своей криворукости всех, но только не себя. Было очень весело читать их отзывы ниже)', '2021-05-04 00:46:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (26, 11, 1, 'Игра сбаланшена просто ужасно. Лодку меты все время кардинально раскачивают то в одну сторону то в другую. То гендзи имба - то черезмерно законтрен. А тот же турбосвин в мете сидит с самого релиза игры, как был толстым дпсом который по медалям способен обогнать больше половины персонажей, тем более в руках криворуких тиммейтов, так и остался таковым.', '2021-04-04 09:59:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (27, 11, 5, 'Лучшее, что нынешние близы умеют высирать - это дисбалансное дерьмо. Овервотч ни разу не исключение. Как состав пати, так и сами герои абсолютно не сбалансированы. Тебя - новичка, вполне может закинуть в пати таких же, но противостоять вам будут мамкины нагибаторы. Зато, все по канону современной толерантности. Единственные плюсы - относительно мало читеров, более-менее сносный графен. А так - что БФА, что Рефордж, что Оверсрач - продукты чистой коммерции, беспощадные и бесполезные.', '2021-04-30 10:50:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (28, 12, 6, 'Людей, которые отвечают за оптимизацию в этой игре, нужно посадить в одну клетку с Раджангом', '2021-04-28 15:04:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (29, 12, 7, 'купил игру и пропал на полтора месяца уж очень там много что можно делать а если играть с такими же отбитыми охотниками игра становится шедевром и очень увлекательной в плане сюжета', '2021-05-12 03:10:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (30, 13, 2, 'Лучший battlefield из всех серии', '2021-04-30 10:50:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (31, 13, 3, 'Самая лучшая часть Battlefield. Разрушения урезали, а кампанию делали от балды, но зато не поскупились сделать 2 ядерных взрыва, а не один, как в CoD MW. И получилось очень хорошо.', '2021-05-12 03:10:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (32, 14, 1, 'вы дворф? Вы ненавидите своего начальника? вы готовы часами копаться в пещерах где из приятного только красный сахар и крики союзников по которым вы попали, чтож эта игра для вас! 10 гребаных мишон контролов из 10', '2021-04-10 12:54:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (33, 14, 5, 'Сначала я прочищаю шахту другу, потом он мне. Что может быть лучше?', '2021-04-30 10:50:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (34, 15, 7, 'Игра стоит своих денег! Если хотите видеть как взрывается ваша база и ваши ресурсы увозят на слонах, эта игра для вас!', '2021-04-28 15:04:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (35, 15, 8, 'Замечательный мир полный различных загадок, интересных мест, диких зверей, таких же как ты хищных людей, ищущих свою выгоду. Тут всегда есть чем заняться и для любителей ПВП и для любителей сбора ресурсов и охоты.', '2021-04-25 01:14:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (36, 16, 2, 'И первый был хорош, а второй еще лучше, гораздо больше мотивирующего лора, отличная графика и не убивающие требования.', '2021-04-30 10:50:00'); 
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (37, 16, 3, 'Нудный шутер, в кооператива еще можно играть. Но в соло просто самое скучное что может быть. Сюжет, банален и тупой.', '2021-04-28 15:04:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (38, 17, 4, 'Лучший в своем жанре', '2021-04-30 10:50:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (39, 17, 5, 'рекомендую если хотите взорвать пукан', '2021-04-30 10:50:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (40, 18, 6, 'EVE игра вообще не для всех. Она очень тяжёлая и если ты не гений лучше не заходить до 14 лет. А так всем советую.', '2021-04-10 12:54:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (41, 18, 7, 'Excel таблица завернутая в игру', '2021-04-26 04:18:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (42, 19, 8, 'После последнего обновления разрабы что то сделали с игрой. Каждый бой лютые фризы и зависания с вылетом. Играть невозможно', '2021-04-10 12:54:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (43, 19, 1, 'Достойная игра в войнушку. Различная техника, отличная графика. Но требует денег ощутимо.', '2021-05-12 03:10:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (44, 20, 2, 'Одна из лучших игр, правда лагает многовато, но она классная:)', '2021-04-30 10:50:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (45, 20, 3, 'Эта игра отличная. Невероятная графика и отличный геймплей, для тех кто любит различные выживалки.', '2021-04-01 16:34:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (46, 21, 4, 'Удивительно, что такая на первый взгляд блеклая и вторичная игра сначала так увлекает, а потом заставляет пройти все ее дополнения и с радостью погрузиться в прохождение всех ее продолжений.', '2021-04-28 15:04:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (47, 21, 5, 'Я знаю, что многие любят и обожают Borderlands, однако лично для меня она не стала ничем большим чем "Поди туда, убей кого-то, принеси то-то". Однако, стоит отметить юмор в игре отменный, но это не спасает его однообразный геймплей.', '2021-04-30 10:50:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (48, 22, 6, 'Блин, эта игра просто супер (и не смейте этого отрицать). Тут без дополнений можно просидеть десятки часов (даже без кооператива), а с дополнение вообще можно остаться и окунуться в неё с головой.', '2021-05-12 03:10:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (49, 22, 7, 'Игровой мир этой игры заточен под корпоративную игру вчетвером. В одиночном режиме он н меняется, и поэтому тгра превращается в медленное тупое задротство с мобами.', '2021-04-04 09:59:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (50, 29, 1, 'Шикарная игра, большой открытый мир и много контента, для людей которые любят анимешный стиль рисовки понравится безусловно. Плюс ко всему есть кроссплатформенная совместимость что позволить позалипать в нее как дома на компе так и на телефоне, на работе или по пути куда-то', '2021-04-04 09:59:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (51, 29, 2, 'Ноэлль лучшая вайфу <3', '2021-05-09 19:40:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (52, 23, 3, 'ничего не понял кучу раз сдох забил', '2021-04-30 10:50:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (53, 23, 4, 'Начал играть в 2009 году,когда игра еще была платной, и честно не пожалел ни одной копейки денег.Ни у одного шутера нет такого бэкграунда как у ТФ2(я имею в виду онлайнового). Харизматичные персонажи, навсегда оставшиеся в памяти. Большая часть их фраз растянута на цитаты, что не удивительно. Про донат можно не вспоминать вообще,только если захочешь большой инвентарь,а так заходишь и играешь,без каких либо ограничений.', '2021-04-01 12:52:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (54, 24, 5, 'Машинки с ракетными ускорителями? Футбол? Всё это вместе? Что ещё нужно? 10 из 10', '2021-05-04 00:46:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (55, 24, 6, 'Rocket League это смесь микромашинок и футбола. Всё просо две команды 3 на 3 на разных площадках пытаются за 5 минут забить как можно больше голов друг другу, в случае равенства победитель определяется по дополнительным показаниям. Данная игра сначала добилась успеха на PS потом покорила и ПК, по ней проводится международные чемпионаты с крупными призовыми фондами. Американцев из Psyonix не зря пригрела сама Warner Bros., ребята действительно толковые, главное, что они тонко чувствуют желания публики постоянно модернизируя свой проект, в итоге получаем игру универсала для домашних вечеринок и рейтинговых состязаний, хотя весь потенциал раскрывается в онлайн баталиях. Минус тоже есть, странная физика мяча может довести до белого каления людей с повышенной возбудимостью, так что психованных друзей лучше не приглашать, в игре мало режимов и она по своей сути достаточно однообразна, а также в ней отсутствует даже какой то намёк на тактику. Вообщем интересное развлечение, но только при наличии живых партнёров', '2021-06-01 10:46:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (56, 25, 7, 'Для меня быстро кончилась игра. Мы убили всех боссов и стало неинтересно играть.', '2021-05-30 17:30:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (57, 25, 8, 'Кто считает, что эта игра скучная, попробуйте немного разыграться и вас эта игра не отпустит до самого конца! Также произошло со мной: как только я победил первого босса, я понял, что уже на что-то здесь способен, и захотелось играть дальше! Отличная игра!', '2021-06-12 00:17:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (58, 26, 1, 'за этот год всё что добавили в игру окончательно её убило личи кувы, рейлджек, алое копьё, и сердце деймоса, ОСНОВНАЯ ОШИБКА разрабодчика фарм ради фарма. В сердце деймоса они себя переплюнули репутацию у новой фракции качать стало невыносимо, нужно собирать жетоны чтобы обменять на репутацию и затем собрать жетоны чтобы поднять ранг у фракции. чтобы собрать новое оружие нужнособрать в компоненты ствол, приклад, приёмник, и внимание теперь ствол,приклад,приёмник тоже крафтяться из ресов. фарм ради фарма', '2021-04-20 23:23:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (59, 26, 2, 'в начале прикольно, проходишь вполне интересный сюжет, потом игра превращается в бесконечный фарм, наскучивает. 5 из 10', '2021-05-20 19:39:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (60, 27, 3, 'вспомнил как с другом играл на первой плойке на одном экране и диване', '2021-03-20 14:45:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (61, 27, 4, 'Лучшее что сегодня есть в кооп шутерах.', '2021-05-02 18:13:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (62, 28, 5, 'Игра, сломавшая мое представление о мире, заставила мою голову нещадно кружиться, а желудок - тошнить. Несравненный шедевр', '2021-04-21 05:42:00');
insert into game_comments(id_comment, game_id, id_user, comment_text, date_time)
	values (60, 28, 6, 'Все было так весело и радужно...пока не завезли сраные ДЛС и кейсы, которые просто убили нахер вес челендж игры. Раньше каждая миссия выше уровни "сложно" заставляла изрядно попотеть,а теперь хер. Купи ДЛС и забери просто убийственное оружие, которое раза в 3 сильнее всех старых. Надоело в команде убивать мини боссов? Чтож с ДЛС вы будете убивать их с 1ого или 2ух выстрелов, а так же купите ДЛС с огнеметом и просто разносити турели и щитовиков в хлам тупо в лоб. Короче, очередная игра сгубленная жадность разрабов, игра из разряда «плати,чтобы нагибать»', '2021-05-27 22:06:00');

insert into team(id_team, team_name, game_id, team_password, privacy, team_icon, gamers_amount, team_description, team_creator)
	values (1, 'abc', 1, '123', 'закрытая', '---', 4, 'fsdoifjkddsigk', 2)

insert into team_members(team_id, members_team_id, team_member_role, nickname)
	values (1, 1, 'создатель', 'авыодатвд')
insert into team_members(team_id, members_team_id, team_member_role, nickname)
	values (1, 2, 'обычный', 'воыадываавы')