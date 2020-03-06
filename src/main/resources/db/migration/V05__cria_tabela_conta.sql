CREATE TABLE conta (
	codigo BIGINT(20) PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL,
	codigo_usuario BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into conta(codigo, descricao, codigo_usuario) values (1, 'Padrao', 1);

alter table lancamento drop foreign key lancamento_ibfk_2;

alter table lancamento DROP COLUMN codigo_pessoa;

alter table lancamento add COLUMN codigo_conta BIGINT(20) not null;

update lancamento set codigo_conta = 1;

alter table lancamento add constraint fk_lanc_conta foreign key (codigo_conta) REFERENCES conta (codigo);
