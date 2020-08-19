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

INSERT INTO public.detail (id, det_name, det_value, product_id) VALUES (1, 'type', 'pizza', 1);
INSERT INTO public.detail (id, det_name, det_value, product_id) VALUES (2, 'conutry', 'Italy', 1);
INSERT INTO public.detail (id, det_name, det_value, product_id) VALUES (3, 'type', 'alcohol', 2);
INSERT INTO public.detail (id, det_name, det_value, product_id) VALUES (4, 'conutry', 'Thai', 2);

INSERT INTO public.product (id, product_desc, product_name) VALUES (1, 'hawaiian pizza', 'pizza');
INSERT INTO public.product (id, product_desc, product_name) VALUES (2, 'sigha beer', 'beer');