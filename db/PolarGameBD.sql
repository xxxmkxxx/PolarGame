create table users_roles(
	id_users_roles integer primary key AUTO_INCREMENT,
	users_role text
);

create table users(
	id_user integer primary key AUTO_INCREMENT,
	login text,
	password varchar(15),
	email text,
	id_users_roles integer references users_roles(id_users_roles) on delete cascade,
	user_icon text,
	user_description text
);

/*create table private_message(
	id_message integer primary key AUTO_INCREMENT,
	id_sender integer references Users(id_user),
	id_receiver integer references Users(id_user),
	date_time datetime,
	message_text text
);*/

create table genres(
	id_genre integer primary key AUTO_INCREMENT,
	genre text
);

create table game(
	game_id integer primary key AUTO_INCREMENT,
	game_name text,
	game_description text,
	game_icon_link text,
	popularity integer
);

create table games_genres(
	game_id integer not null,
	genre_id integer not null,
	foreign key (game_id) references game(game_id) on delete cascade,
	foreign key (genre_id) references genres(id_genre) on delete cascade
);

create table game_comments(
	id_comment integer primary key AUTO_INCREMENT, 
	game_id integer references game(game_id) on delete cascade,
	id_user integer references users(id_user) on delete cascade,
	comment_text text,
	date_time datetime
);

create table party(
	id_party integer primary key AUTO_INCREMENT, 
	game_id integer references game(game_id) on delete cascade,
	party_password varchar(15),
	gamers_amount integer,
	party_description text,
	privacy text,
	party_icon text,
	party_creator integer references users(id_user) on delete cascade
);

create table party_members(
	party_id integer not null,
	members_party_id integer not null,
	foreign key (party_id) references party(id_party) on delete cascade,
	foreign key (members_party_id) references users(id_user) on delete cascade,
	party_member_role text,
	nickname text
);

create table team(
	id_team integer primary key AUTO_INCREMENT, 
	team_name text,
	game_id integer references game(game_id) on delete cascade,
	team_password varchar(15),
	privacy text,
	team_icon text,
	gamers_amount integer,
	team_description text,
	team_creator integer references users(id_user) on delete cascade
);

create table team_members(
	team_id integer not null,
	members_team_id integer not null,
	foreign key (team_id) references team(id_team) on delete cascade,
	foreign key (members_team_id) references users(id_user) on delete cascade,
	team_member_role text,
	nickname text
);

/*create table TeamMessage(
	id_message integer primary key, 
	id_sender integer references Users(id_user),
	id_team integer references Team(id_team),
	Date_Time datetime,
	MessageText text
)*/