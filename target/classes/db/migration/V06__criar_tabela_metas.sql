CREATE TABLE meta (
	codigo BIGINT(20) PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL,
	valor decimal(19,2),
	codigo_usuario BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;