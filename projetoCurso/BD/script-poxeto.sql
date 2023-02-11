CREATE DATABASE poxetoFinances

CREATE Schema financas

CREATE TABLE financas.usuario
(
	id bigserial NOT NULL PRIMARY KEY,
	nome character varying(150),
	email character varying (100),
	senha character varying (20),
	data_cadastro date DEFAULT Now()

);


CREATE TABLE financas.lancamento
(
	id bigserial NOT NULL PRIMARY KEY,
	descricao character varying(100) NOT NULL,
	mes integer NOT NULL,
	ano integer NOT NULL,
	valor numeric (16,2),
	tipo character varying (20) CHECK (tipo in ('RECEITA', 'DESPESA')),
	status character varying (20) CHECK (status in ('PENDENTE', 'CANCELADO', 'EFETIVADO')) NOT NULL,
	id_usuario bigint REFERENCES financas.usuario(id),
	data_cadastro date DEFAULT Now()
)

