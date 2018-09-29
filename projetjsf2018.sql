-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 29 Septembre 2018 à 20:05
-- Version du serveur :  5.7.14
-- Version de PHP :  7.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projetjsf2018`
--

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

CREATE TABLE `site` (
  `site_id` int(11) NOT NULL,
  `site_nom` varchar(50) NOT NULL,
  `site_lieu` varchar(50) NOT NULL,
  `site_tarifjournaliere` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `site`
--

INSERT INTO `site` (`site_id`, `site_nom`, `site_lieu`, `site_tarifjournaliere`) VALUES
(1, 'Tsimbazazalakkala', 'TANA', 15000),
(2, 'Tsimbalehibe', 'TANA', 12000),
(3, 'Beolona', 'Toliara', 25000);

-- --------------------------------------------------------

--
-- Structure de la table `visiter`
--

CREATE TABLE `visiter` (
  `visiter_id` int(11) NOT NULL,
  `visiter_site_id` int(11) NOT NULL,
  `visiter_visiteur_id` int(11) NOT NULL,
  `visiter_nbjours` int(11) NOT NULL,
  `visiter_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `visiteur`
--

CREATE TABLE `visiteur` (
  `visiteur_id` int(11) NOT NULL,
  `visiteur_nom` varchar(50) NOT NULL,
  `visiteur_adresse` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `visiteur`
--

INSERT INTO `visiteur` (`visiteur_id`, `visiteur_nom`, `visiteur_adresse`) VALUES
(1, 'RANDRIA', 'Lot Saropody lavitra');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `site`
--
ALTER TABLE `site`
  ADD PRIMARY KEY (`site_id`);

--
-- Index pour la table `visiter`
--
ALTER TABLE `visiter`
  ADD PRIMARY KEY (`visiter_id`),
  ADD KEY `visiter_site_id` (`visiter_site_id`,`visiter_visiteur_id`),
  ADD KEY `visiter_visiteur_id` (`visiter_visiteur_id`);

--
-- Index pour la table `visiteur`
--
ALTER TABLE `visiteur`
  ADD PRIMARY KEY (`visiteur_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `site`
--
ALTER TABLE `site`
  MODIFY `site_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `visiter`
--
ALTER TABLE `visiter`
  MODIFY `visiter_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `visiteur`
--
ALTER TABLE `visiteur`
  MODIFY `visiteur_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `visiter`
--
ALTER TABLE `visiter`
  ADD CONSTRAINT `visiter_ibfk_1` FOREIGN KEY (`visiter_site_id`) REFERENCES `site` (`site_id`),
  ADD CONSTRAINT `visiter_ibfk_2` FOREIGN KEY (`visiter_visiteur_id`) REFERENCES `visiteur` (`visiteur_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
