-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 20 avr. 2018 à 15:13
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
-- Base de données :  `cards`
--

-- --------------------------------------------------------

--
-- Structure de la table `card`
--

DROP TABLE IF EXISTS `card`;
CREATE TABLE IF NOT EXISTS `card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attack` int(11) DEFAULT NULL,
  `defence` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `energy` int(11) DEFAULT NULL,
  `family` varchar(255) DEFAULT NULL,
  `hp` int(11) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `card`
--

INSERT INTO `card` (`id`, `attack`, `defence`, `description`, `energy`, `family`, `hp`, `img_url`, `name`, `price`) VALUES
(1, 500, 1, 'NULL', 0, 'DC Comics', 3000, 'https://combien.io/wp-content/uploads/2017/02/super-hero-marvel-678x381.jpg', 'myHERO', 20),
(2, 10, 10, 'the best one', 5, 'Ninja Turtle', 50, 'https://cdn.movieweb.com/img.news.tops/NEvRS174lkloyx_1_b/Teenage-Mutant-Ninja-Turtles-Leonardo-Character-Poster.jpg', 'leonardo', 30),
(3, 50, 14, 'qsdqsdqsd', 5, 'DC Comics', 50, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQeFUf-8mpGysYVgmz-WuJEkwmBznhEBuN4zrd80zwM3AsoGzZ9', 'qsdqsdqsd', -1),
(4, 1, 1, 'qsdqsd', 1, 'Marvel', 50, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAI4z90vGSY6gMAbcPLZkdzx8u0GDk3LauIqgfdyx_wwMde-dQ4g', '2222222222222', 40),
(5, 500, 1, 'NULL', 0, 'DC Comics', 3000, 'https://combien.io/wp-content/uploads/2017/02/super-hero-marvel-678x381.jpg', 'test', -1),
(6, 500, 1, 'NULL', 0, 'DC Comics', 3000, 'https://combien.io/wp-content/uploads/2017/02/super-hero-marvel-678x381.jpg', 'test', -1),
(7, 500, 1, 'salut', 0, 'DC Comics', 3000, 'https://combien.io/wp-content/uploads/2017/02/super-hero-marvel-678x381.jpg', 'test2', -1);

-- --------------------------------------------------------

--
-- Structure de la table `family`
--

DROP TABLE IF EXISTS `family`;
CREATE TABLE IF NOT EXISTS `family` (
  `name` varchar(255) NOT NULL,
  `strength` varchar(255) DEFAULT NULL,
  `weakness` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `family`
--

INSERT INTO `family` (`name`, `strength`, `weakness`) VALUES
('Marvel', 'feu', 'herbe'),
('DC Comics', 'Marvel', 'feu'),
('Ninja Turtle', 'terre', 'feu');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
