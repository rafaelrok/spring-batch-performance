drop table if exists clientes;
CREATE TABLE `clientes` (
  `id` int NOT NULL AUTO_INCREMENT ,
  `nome` varchar(255) NOT NULL,
  `cpf` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  unique index `cpf` (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

drop table if exists acessos;
CREATE TABLE `acessos` (
  `id` int NOT NULL AUTO_INCREMENT ,
  `data` date NOT NULL,
  `cliente` int NOT NULL,
  `sistema` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

drop table if exists compras;
CREATE TABLE `compras` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `cliente` int NOT NULL,
  `valor` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

drop table if exists devolucoes;
CREATE TABLE `devolucoes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `cliente` int NOT NULL,
  `valor` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

