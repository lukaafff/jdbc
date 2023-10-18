-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 18-Out-2023 às 00:15
-- Versão do servidor: 8.0.31
-- versão do PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `livros`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `emprestimo`
--

DROP TABLE IF EXISTS `emprestimo`;
CREATE TABLE IF NOT EXISTS `emprestimo` (
  `ID` int NOT NULL,
  `ID_Livro` int DEFAULT NULL,
  `ID_Usuario` int DEFAULT NULL,
  `Data_Emprestimo` date DEFAULT NULL,
  `Data_Devolucao_Prevista` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_Livro` (`ID_Livro`),
  KEY `ID_Usuario` (`ID_Usuario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `emprestimo`
--

INSERT INTO `emprestimo` (`ID`, `ID_Livro`, `ID_Usuario`, `Data_Emprestimo`, `Data_Devolucao_Prevista`) VALUES
(1, 1, 1, '2023-10-17', '2023-10-24'),
(2, 2, 2, '2023-10-18', '2023-10-25'),
(3, 3, 3, '2023-10-19', '2023-10-26');

-- --------------------------------------------------------

--
-- Estrutura da tabela `livro`
--

DROP TABLE IF EXISTS `livro`;
CREATE TABLE IF NOT EXISTS `livro` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Titulo` varchar(255) DEFAULT NULL,
  `Autor` varchar(255) DEFAULT NULL,
  `Ano_Publicacao` int DEFAULT NULL,
  `Genero` varchar(50) DEFAULT NULL,
  `Numero_Paginas` int DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `livro`
--

INSERT INTO `livro` (`ID`, `Titulo`, `Autor`, `Ano_Publicacao`, `Genero`, `Numero_Paginas`) VALUES
(1, 'Dom Quixote', 'Miguel de Cervantes', 1605, 'Romance', 863),
(2, '1984', 'George Orwell', 1949, 'Ficção Científica', 328),
(3, 'Moby Dick', 'Herman Melville', 1851, 'Aventura', 635),
(4, 'Orgulho e Preconceito', 'Jane Austen', 1813, 'Romance', 279),
(5, 'Metamorfose', 'Laura Garcia', 2021, 'Auto ajuda', 198);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `ID` int NOT NULL,
  `Nome` varchar(255) DEFAULT NULL,
  `Endereco` varchar(255) DEFAULT NULL,
  `Numero_Telefone` varchar(20) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`ID`, `Nome`, `Endereco`, `Numero_Telefone`, `Email`) VALUES
(1, 'João Silva', 'Rua A, 123', '123-456-7890', 'joao.silva@email.com'),
(2, 'Maria Santos', 'Rua B, 456', '987-654-3210', 'maria.santos@email.com'),
(3, 'Carlos Oliveira', 'Rua C, 789', '111-222-3333', 'carlos.oliveira@email.com');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
