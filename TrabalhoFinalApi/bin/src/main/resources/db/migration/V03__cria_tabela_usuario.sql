CREATE TABLE usuario (
   id serial PRIMARY key,
   nome varchar(60),
   email varchar(60),
   senha varchar(255)
);

CREATE TABLE perfil (
   id_perfil serial PRIMARY KEY,
   nome varchar(40)
);

CREATE TABLE usuario_perfil (
    id_usuario int REFERENCES usuario(id),
    id_perfil int REFERENCES perfil(id_perfil),
    data_criacao date,
    CONSTRAINT pk_usuario_perfil PRIMARY KEY (id_usuario, id_perfil)
);

INSERT INTO perfil (nome) VALUES 
 ('ROLE_ADMIN'),
 ('ROLE_USER');
 
INSERT INTO usuario (nome, email, senha) VALUES
('Joao da Silva', 'joao@email.com', '$2a$12$sPPV9up/RlaZGUBA1AU7ju66f4o.eNSGhhCaWUdr4rnvDZ.QjaMtK'),
('Andre das coves', 'andre@email.com', '$2a$12$G7ibc/sJRL0BWCpVCBcRxudHZ2aV8uHbMhHbu/Y6Zpz3Dw1X4.B2S');
INSERT INTO perfil (nome) VALUES
('ADMIN'),
('USER');
INSERT INTO usuario_perfil (id_usuario, id_perfil) VALUES
( (SELECT id FROM usuario WHERE email='joao@email.com'),
  (SELECT id_perfil FROM perfil WHERE nome='ADMIN') ),
( (SELECT id FROM usuario WHERE email='joao@email.com'),
  (SELECT id_perfil FROM perfil WHERE nome='USER') ),
( (SELECT id FROM usuario WHERE email='andre@email.com'),
  (SELECT id_perfil FROM perfil WHERE nome='USER') );