CREATE TABLE Pessoa (
 id_pessoa SERIAL CONSTRAINT pk_pessoa PRIMARY KEY,]
 rg VARCHAR(10) NOT NULL,
 cpf VARCHAR(11) NOT NULL,
 nome VARCHAR(50) NOT NULL,
 rua VARCHAR(50) NOT NULL,
 numero INT NOT NULL,
 bairro VARCHAR(30) NOT NULL,
 cidade VARCHAR(30) NOT NULL,
 uf VARCHAR(2) NOT NULL,
 cep VARCHAR(10) NOT NULL
);


CREATE TABLE Telefone (
 cod_telefone SERIAL CONSTRAINT pk_telefone PRIMARY KEY,
 telefone VARCHAR(12) NOT NULL,
 id_pessoa INT NOT NULL,
 CONSTRAINT fk_pessoa FOREIGN KEY (id_pessoa) REFERENCES Pessoa (id_pessoa)
);

CREATE TABLE Cliente (
 c_id_pessoa INT NOT NULL,
 CONSTRAINT pk_cliente PRIMARY KEY (c_id_pessoa),
 CONSTRAINT fk_cliente FOREIGN KEY (c_id_pessoa) REFERENCES Pessoa (id_pessoa)
);

CREATE TABLE Funcionario (
 funcao INT NOT NULL,
 salario FLOAT NOT NULL,
 carga_horario NUMERIC NOT NULL,
 regime_trabalho VARCHAR(30) NOT NULL,
 f_id_pessoa INT NOT NULL,
 CONSTRAINT pk_funcionario PRIMARY KEY (f_id_pessoa),
 CONSTRAINT fk_funcionario FOREIGN KEY (f_id_pessoa) REFERENCES Pessoa (id_pessoa)
);

CREATE TABLE Produto (
 id_produto SERIAL CONSTRAINT pk_produto PRIMARY KEY,
 nome VARCHAR(50) NOT NULL,
 descricao VARCHAR(30) NOT NULL,
 categoria VARCHAR(30) NOT NULL,
 fornecedor VARCHAR(50) NOT NULL,
 preco_entrada FLOAT NOT NULL,
 quantidade_estoque INT NOT NULL,
 margem_lucro NUMERIC NOT NULL,
 quantidade_minima INT NOT NULL 
);

CREATE TABLE Venda (
 id_venda SERIAL CONSTRAINT pk_venda PRIMARY KEY,
 data DATE,
 desconto NUMERIC NOT NULL,
  valor_venda FLOAT, 
 v_c_id_pessoa INT NOT NULL,
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
 valor_total FLOAT,
 CONSTRAINT fk_venda FOREIGN KEY (vp_id_venda) REFERENCES Venda (id_venda),
 CONSTRAINT fk_produto FOREIGN KEY (vp_id_produto) REFERENCES Produto (id_produto)
);


