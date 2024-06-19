drop schema if exists spring;

drop user if exists 'user'@'localhost';

create schema spring;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on spring.* to user@'localhost';

use spring;

create table usr_usuario (
  usr_id bigint unsigned not null auto_increment,
  usr_nome varchar(20) not null,
  usr_senha varchar(150) not null,
  primary key (usr_id),
  unique key uni_usuario_nome (usr_nome)
);

create table aut_autorizacao (
  aut_id bigint unsigned not null auto_increment,
  aut_nome varchar(20) not null,
  primary key (aut_id),
  unique key uni_aut_nome (aut_nome)
);

create table uau_usuario_autorizacao (
  usr_id bigint unsigned not null,
  aut_id bigint unsigned not null,
  primary key (usr_id, aut_id),
  foreign key aut_usuario_fk (usr_id) references usr_usuario (usr_id) on delete restrict on update cascade,
  foreign key aut_autorizacao_fk (aut_id) references aut_autorizacao (aut_id) on delete restrict on update cascade
);

create table ant_anotacao (
  ant_id bigint unsigned not null auto_increment,
  ant_texto varchar(256) not null,
  ant_data_hora datetime not null,
  ant_usr_id bigint unsigned not null,
  primary key (ant_id),
  foreign key ant_usr_fk (ant_usr_id) references usr_usuario(usr_id)
);

create table bal_balanco (
  bal_id bigint unsigned not null auto_increment,
  bal_desc varchar(256) not null,
  bal_data_hora datetime not null,
  bal_valor_unitario numeric(10,2) not null,
  bal_quantidade int not null,
  primary key (bal_id)
);

create table enc_encomenda (
  enc_rastreio bigint unsigned not null auto_increment,
  enc_conteudo varchar(256) not null,
  enc_valor_declarado numeric(10,2),
  enc_data_hora_prevista datetime not null,
  enc_data_hora_entrega datetime,
  primary key (enc_rastreio)
);

create table pro_produto (
  pro_id bigint unsigned not null auto_increment,
  pro_nome varchar(256) not null,
  pro_data_hora datetime not null,
  pro_valor numeric(10,2) not null,
  pro_valor_minimo numeric(10,2),
  pro_valor_maximo numeric(10,2),
  primary key (pro_id)
);

insert into usr_usuario (usr_nome, usr_senha)
  values ('admin', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C');
insert into aut_autorizacao (aut_nome)
  values ('ROLE_ADMIN');
insert into uau_usuario_autorizacao (usr_id, aut_id) 
  values (1, 1);
insert into ant_anotacao(ant_texto, ant_data_hora, ant_usr_id)
  values('Meu novo projeto', '2023-08-01 19:10', 1);
insert into bal_balanco(bal_desc, bal_data_hora, bal_valor_unitario, bal_quantidade)
  values('Supermercado', '2024-03-16 10:25', -221.45, 2);
insert into bal_balanco(bal_desc, bal_data_hora, bal_valor_unitario, bal_quantidade)
  values('Salário', '2024-03-18 07:00', 4230.70, 1);
insert into enc_encomenda(enc_conteudo, enc_valor_declarado, enc_data_hora_prevista, enc_data_hora_entrega)
  values('Nintendo Switch', 1850.00, '2024-06-10 19:00', null);
insert into enc_encomenda(enc_conteudo, enc_data_hora_prevista, enc_data_hora_entrega)
  values('Sabonete Líquido', '2024-05-25 10:00', '2024-05-27 12:00');
insert into enc_encomenda(enc_conteudo, enc_data_hora_prevista, enc_data_hora_entrega)
  values('Refrigerante', '2024-05-26 11:00', '2024-05-24 10:30');
insert into pro_produto(pro_nome, pro_data_hora, pro_valor, pro_valor_minimo, pro_valor_maximo)
  values('Sapato', '2024-05-26 11:00', 22.1, 17.8, 23.6);
insert into pro_produto(pro_nome, pro_data_hora, pro_valor, pro_valor_minimo, pro_valor_maximo)
  values('Pente', '2024-05-26 12:00', 27.1, 17.8, 22.6);