-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: mysql:3306
-- Tempo de geração: 04/06/2025 às 00:52
-- Versão do servidor: 8.0.41
-- Versão do PHP: 8.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `aluga_aqui`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `alugueis`
--

CREATE TABLE `alugueis` (
  `id_alugueis` int NOT NULL,
  `data_inicio_alugueis` date DEFAULT NULL,
  `data_fim_alugueis` date DEFAULT NULL,
  `valor_total_alugueis` double DEFAULT NULL,
  `observacoes_alugueis` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `carros_id_carros` bigint DEFAULT NULL,
  `nome_cliente` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Despejando dados para a tabela `alugueis`
--

INSERT INTO `alugueis` (`id_alugueis`, `data_inicio_alugueis`, `data_fim_alugueis`, `valor_total_alugueis`, `observacoes_alugueis`, `endereco`, `carros_id_carros`, `nome_cliente`) VALUES
(1, '2025-05-05', '2025-05-06', 1600, 'teste', 'RUA', 2, 'Eric Ferreira Gomes'),
(6, '2025-06-12', '2025-06-22', 3620, 'sdadsadasdasdsadas', 'Rua 18 Jardim Sorriso 2', 5, 'EDMAR FERREIRA GOMES'),
(7, '2025-06-05', '2025-06-25', 7240, 'sdadsadasdasdsadas', 'Rua 18 Jardim Sorriso 2', 5, 'EDMAR FERREIRA GOMES'),
(8, '2025-06-11', '2025-06-29', 900, 'sdadsadasdasdsadas', 'sdadas', 6, 'eric ferreira');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `alugueis`
--
ALTER TABLE `alugueis`
  ADD PRIMARY KEY (`id_alugueis`),
  ADD KEY `fk_alugueis_carros_idx` (`carros_id_carros`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `alugueis`
--
ALTER TABLE `alugueis`
  MODIFY `id_alugueis` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `alugueis`
--
ALTER TABLE `alugueis`
  ADD CONSTRAINT `fk_alugueis_carros` FOREIGN KEY (`carros_id_carros`) REFERENCES `carros` (`id_carros`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;