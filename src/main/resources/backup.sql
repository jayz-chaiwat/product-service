create table product
(
	id bigserial not null
		constraint product_pk
			primary key,
	product_name varchar(120) not null,
	product_desc varchar(255)
);

alter table product owner to postgres;

create unique index product_id_uindex
	on product (id);

create unique index product_product_name_uindex
	on product (product_name);

create table detail
(
	id bigserial not null
		constraint detail_pk
			primary key,
	product_id bigint,
	det_name varchar(100) not null,
	det_value varchar(255) not null
);

alter table detail owner to postgres;

create unique index detail_id_uindex
	on detail (id);

