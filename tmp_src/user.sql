-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/



SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";




--
-- Base de données :  `users`
--

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) DEFAULT NULL,
  `Prenom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
 
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `card` (`id`, `Nom`,`Prenom`, `password`) VALUES
(1, 'SAMI','SAMI','abcdef'),
(2, 'Koula','Koula','dhijk'),
(3, 'Ahmed','Ahmed', 'dcmoe'),
(4, 'Seraphin','Seraphin','dlorio'),
(5, 'Julien','Julien', 'abbbbb'),
(6, 'Nicolas','Nicolas', 'ccccccc'),
(7, 'Amine','Amine','dededede'),
(8, 'Abed' ,'Abed', '123456'),





