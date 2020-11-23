drop table if exists gracze;
drop table if exists wygrana;

create table gracze (
	id_gracze int not null,
	nick varchar(20) not null,
	primary key (id_gracze)
);

create table wygrana (
	id_wygrana int not null,
	wygrana int not null,
	primary key (id_wygrana)
);

insert into gracze (id_gracze, nick) values
;

insert into wygrana (id_wygrana, wygrana) values
;

