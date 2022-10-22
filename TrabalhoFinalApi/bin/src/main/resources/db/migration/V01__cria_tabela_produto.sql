CREATE TABLE categoria (
id_categoria serial PRIMARY KEY, 
nome_categoria varchar(30)NOT NULL UNIQUE, 
descricao_categoria varchar(200));

CREATE TABLE produto (
id_produto serial PRIMARY KEY, 
nome_produto varchar (30) NOT NULL UNIQUE,
descricao_produto varchar(200),
qtd_estoque INT,
data_cadastro DATE,
valor_unitario REAL NOT NULL,
imagem BYTEA,  
id_categoria int REFERENCES categoria(id_categoria)
);

CREATE TABLE endereco (
id_endereco serial PRIMARY KEY,
cep varchar(8) NOT NULL, 
rua varchar(80) NOT NULL,
bairro varchar(50) NOT NULL,
cidade varchar(80) NOT NULL,
numero varchar(20) NOT NULL,
complemento varchar(80),
uf varchar(2) NOT NULL
);

CREATE TABLE cliente (
id_cliente serial PRIMARY KEY,
nome_completo varchar(50) NOT NULL,
email varchar (80) not null UNIQUE,
cpf varchar(11) NOT null unique,
telefone varchar(40) NOT NULL,
data_nascimento DATE,
id_endereco int REFERENCES endereco(id_endereco) NOT NULL
);

CREATE TABLE pedido (
id_pedido serial PRIMARY KEY,
data_pedido Date NOT NULL, 
data_entrega Date,
data_envio Date,
status varchar(2) NOT NULL,
valor_total REAL NOT NULL, 
id_cliente int REFERENCES cliente(id_cliente) NOT NULL
);

CREATE TABLE item_pedido (
id_item_pedido serial PRIMARY KEY,
quantidade INT NOT NULL, 
preco_venda REAL NOT NULL,
percentual_desconto REAL NOT NULL,
valor_bruto REAL NOT NULL,
valor_liquido REAL NOT NULL,
id_produto int REFERENCES produto(id_produto) NOT NULL,
id_pedido int REFERENCES pedido(id_pedido) NOT NULL
);












