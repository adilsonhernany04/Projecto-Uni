
/*
Author: @Adilson Hernany
*/

CREATE DATABASE escola;

/*CREATE TABLE estudante IF NOT EXISTS;*/

CREATE TABLE `estudante` (
  `id` int NOT NULL AUTO_INCREMENT default 1,
  `nome` varchar(45) NOT NULL default 'Adilson Hernany',
  `email` varchar(45) NOT NULL default 'adilsonteste@programacao.com',
  `senha` varchar(20) NOT NULL default 'meuTesteSemSeguranca',
  `endereco` varchar(45) NOT NULL default 'Onde quer que seja!',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
