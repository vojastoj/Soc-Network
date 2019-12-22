-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 19, 2019 at 03:45 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projekat`
--

-- --------------------------------------------------------

--
-- Table structure for table `ljudi`
--

CREATE TABLE `ljudi` (
  `ID` int(11) NOT NULL,
  `Ime` varchar(30) NOT NULL,
  `Prezime` varchar(35) NOT NULL,
  `Godine` int(11) DEFAULT NULL,
  `Pol` enum('Musko','Zensko') NOT NULL,
  `Prijatelji` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ljudi`
--

INSERT INTO `ljudi` (`ID`, `Ime`, `Prezime`, `Godine`, `Pol`, `Prijatelji`) VALUES
(1, 'Paul', 'Crowe', 28, 'Musko', '2'),
(2, 'Rob', 'Fitz', 23, 'Musko', '1,3'),
(3, 'Ben', 'O\'Carolan', NULL, 'Musko', '2,4,5,7'),
(4, 'Victor', '', 28, 'Musko', '3'),
(5, 'Peter', 'Mac', 29, 'Musko', '3,6,11,10,7'),
(6, 'John', 'Barry', 18, 'Musko', '5'),
(7, 'Sarah', 'Lane', 30, 'Zensko', '3,5,20,12,8'),
(8, 'Susan', 'Downe', 28, 'Zensko', '7'),
(9, 'Jack', 'Stam', 28, 'Musko', '12'),
(10, 'Amy', 'Lane', 24, 'Zensko', '5,11'),
(11, 'Sandra', 'Phelan', 28, 'Zensko', '5,10,19,20'),
(12, 'Laura', 'Murphy', 33, 'Zensko', '7,9,13,20'),
(13, 'Lisa', 'Daly', 28, 'Zensko', '12,14,20'),
(14, 'Mark', 'Johnson', 28, 'Musko', '13,15'),
(15, 'Seamus', 'Crowe', 24, 'Musko', '14'),
(16, 'Daren', 'Slater', 28, 'Musko', '18,20'),
(17, 'Dara', 'Zoltan', 48, 'Musko', '18,20'),
(18, 'Marie', 'D', 28, 'Zensko', '17'),
(19, 'Catriona', 'Long', 28, 'Zensko', '11,20'),
(20, 'Katy', 'Couch', 28, 'Zensko', '7,11,12,13,16,17,19');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ljudi`
--
ALTER TABLE `ljudi`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ljudi`
--
ALTER TABLE `ljudi`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
