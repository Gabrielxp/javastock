CREATE TABLE Pessoa (
 id_pessoa SERIAL CONSTRAINT pk_pessoa PRIMARY KEY,
 nome VARCHAR(100) NOT NULL,
 rua VARCHAR(100) NOT NULL,
 numero INT NOT NULL,
 bairro VARCHAR(30) NOT NULL,
 cidade VARCHAR(30) NOT NULL,
 uf VARCHAR(4) NOT NULL,
 cep VARCHAR(15) NOT NULL,
 email VARCHAR(60) NOT NULL,
 rg VARCHAR(15) NOT NULL,
 cpf VARCHAR(15) NOT NULL
);


CREATE TABLE Telefone (
 cod_telefone SERIAL CONSTRAINT pk_telefone PRIMARY KEY,
 telefone VARCHAR(15) NOT NULL,
 id_pessoa INT NOT NULL,
 CONSTRAINT fk_pessoa FOREIGN KEY (id_pessoa) REFERENCES Pessoa (id_pessoa)
);

CREATE TABLE Cliente (
 c_id_pessoa INT NOT NULL,
 CONSTRAINT pk_cliente PRIMARY KEY (c_id_pessoa),
 CONSTRAINT fk_cliente FOREIGN KEY (c_id_pessoa) REFERENCES Pessoa (id_pessoa)
);

CREATE TABLE Funcionario (
 salario FLOAT NOT NULL,
 carga_horario NUMERIC NOT NULL,
 funcao INT NOT NULL,
 regime_trabalho VARCHAR(40) NOT NULL,
 senha varchar(20) NOT NULL,
 status SMALLINT NOT NULL,
 f_id_pessoa INT NOT NULL,
 CONSTRAINT pk_funcionario PRIMARY KEY (f_id_pessoa),
 CONSTRAINT fk_funcionario FOREIGN KEY (f_id_pessoa) REFERENCES Pessoa (id_pessoa)
);

CREATE TABLE Produto (
 id_produto SERIAL CONSTRAINT pk_produto PRIMARY KEY,
 nome VARCHAR(100) NOT NULL,
 descricao VARCHAR(200) NOT NULL,
 categoria VARCHAR(30) NOT NULL,
 fornecedor VARCHAR(100) NOT NULL,
 preco_entrada FLOAT NOT NULL,
 quantidade_estoque INT NOT NULL,
 margem_lucro NUMERIC NOT NULL,
 quantidade_minima INT NOT NULL 
);

CREATE TABLE Venda (
 id_venda SERIAL CONSTRAINT pk_venda PRIMARY KEY,
 data TIMESTAMP WITHOUT TIME ZONE,
 desconto NUMERIC NOT NULL,
 v_c_id_pessoa INT,
 v_f_id_pessoa INT NOT NULL,
 CONSTRAINT fk_cliente FOREIGN KEY (v_c_id_pessoa) REFERENCES Cliente (c_id_pessoa),
 CONSTRAINT fk_funcionario FOREIGN KEY (v_f_id_pessoa) REFERENCES Funcionario (f_id_pessoa)
);


CREATE TABLE venda_produto (
 id_venda_produto SERIAL CONSTRAINT pk_venda_produto PRIMARY KEY,
 vp_id_venda INT,
 vp_id_produto INT,
 quantidade INT,
 valor_unitario FLOAT,
 CONSTRAINT fk_venda FOREIGN KEY (vp_id_venda) REFERENCES Venda (id_venda),
 CONSTRAINT fk_produto FOREIGN KEY (vp_id_produto) REFERENCES Produto (id_produto)
);


