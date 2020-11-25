drop table if exists wygrana;

create table wygrana (
	id_wygrana int not null,
	nick varchar(20) not null,
	wygrana int not null,
	uklad_kart varchar(20) not null,
	primary key (id_wygrana)
);

insert into wygrana (id_wygrana, nick, wygrana, uklad_kart) values
;