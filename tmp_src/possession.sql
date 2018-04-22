-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 22 avr. 2018 à 13:43
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `possession`
--

-- --------------------------------------------------------

--
-- Structure de la table `possession`
--

DROP TABLE IF EXISTS `possession`;
CREATE TABLE IF NOT EXISTS `possession` (
  `idcard` int(11) NOT NULL,
  `iduser` int(11) NOT NULL,
  `energy_card` int(11) DEFAULT NULL,
  `last_used` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`iduser`,`idcard`),
  KEY `FK6q1wan3jqcmkvjeg41fvstdyo` (`idcard`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `possession`
--

INSERT INTO `possession` (`idcard`, `iduser`, `energy_card`, `last_used`, `price`) VALUES
(1, 1, 12, 12, 13),
(3, 1, 12, 12, -1),
(4, 2, 12, 1, 13),
(2, 5, 16, 12, 10);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
