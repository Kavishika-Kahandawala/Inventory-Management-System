-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 28, 2022 at 06:08 AM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ims`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
CREATE TABLE IF NOT EXISTS `attendance` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `employee_name` varchar(50) NOT NULL,
  `day` int(11) NOT NULL,
  `month` varchar(10) NOT NULL,
  `year` int(11) NOT NULL,
  `time` varchar(20) NOT NULL,
  `role` varchar(15) NOT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=MyISAM AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`aid`, `employee_id`, `username`, `employee_name`, `day`, `month`, `year`, `time`, `role`) VALUES
(1, 1, 'Kim', 'Kim', 12, 'January', 2020, '17:44:46', 'cashier'),
(2, 1, 'Kim', 'Kim', 14, 'January', 2020, '17:46:20', 'cashier'),
(3, 1, 'Kim', 'Kim', 24, 'January', 2021, '17:47:06', 'cashier'),
(4, 1, 'Navindu', 'Navindu', 15, 'January', 2022, '17:47:26', 'cashier'),
(5, 1, 'Kumara', 'Kumara', 25, 'February', 2020, '17:57:38', 'manager'),
(6, 1, 'Rathnayake', 'Rathnayake', 16, 'February', 2022, '23:33:03', 'admin'),
(7, 1, 'Kim', 'Kim', 18, 'March', 2020, '17:47:06', 'cashier'),
(8, 1, 'Kim', 'Kim', 24, 'March', 2021, '17:47:06', 'cashier'),
(9, 1, 'Navindu', 'Navindu', 17, 'March', 2022, '17:05:55', 'cashier'),
(10, 1, 'Kumara', 'Kumara', 17, 'March', 2022, '18:26:33', 'manager'),
(11, 1, 'Rathnayake', 'Rathnayake', 17, 'April', 2022, '18:30:12', 'admin'),
(12, 1, 'Kumara', 'Kumara', 15, 'April', 2022, '18:33:43', 'manager'),
(13, 1, 'Rathnayake', 'Rathnayake', 17, 'June', 2020, '18:34:01', 'admin'),
(14, 1, 'Navindu', 'Navindu', 17, 'July', 2022, '18:36:26', 'cashier'),
(15, 1, 'Kim', 'Kim', 12, 'July', 2019, '18:36:59', 'cashier'),
(16, 1, 'Kim', 'Kim', 17, 'July', 2022, '18:38:07', 'cashier'),
(17, 1, 'Kim', 'Kim', 12, 'August', 2019, '18:38:31', 'cashier'),
(18, 1, 'Rathnayake', 'Rathnayake', 17, 'August', 2022, '18:43:08', 'admin'),
(19, 1, 'Navindu', 'Navindu', 12, 'August', 2019, '18:51:51', 'cashier'),
(20, 1, 'Philip', 'Philip', 17, 'October', 2022, '19:03:04', 'cashier'),
(21, 1, 'Philip', 'Philip', 19, 'October', 2019, '12:30:10', 'cashier'),
(22, 1, 'Navindu', 'Navindu', 19, 'October', 2022, '14:07:50', 'cashier'),
(23, 1, 'Rathnayake', 'Rathnayake', 19, 'November', 2022, '14:08:45', 'admin'),
(24, 1, 'Kim', 'Kim', 19, 'November', 2022, '14:12:18', 'cashier'),
(25, 1, 'Kumara', 'Kumara', 19, 'November', 2022, '14:13:49', 'manager'),
(26, 1, 'hello', 'cash', 19, 'November', 2022, '14:18:07', 'Cashier'),
(27, 1, 'hello', 'cash', 19, 'November', 2022, '14:19:12', 'Cashier'),
(28, 1, 'hello', 'cash', 19, 'November', 2022, '14:20:52', 'Cashier'),
(29, 1, 'hello', 'cash', 19, 'November', 2022, '14:22:01', 'Cashier'),
(30, 1, 'hello', 'cash', 19, 'November', 2022, '14:27:51', 'Cashier'),
(31, 1, 'hello', 'cash', 19, 'November', 2022, '14:28:58', 'Cashier'),
(32, 1, 'hello', 'cash', 20, 'November', 2022, '10:36:30', 'Cashier'),
(33, 1, 'hello', 'cash', 20, 'November', 2022, '10:38:11', 'Cashier'),
(34, 1, 'hello', 'cash', 20, 'November', 2022, '10:40:11', 'Cashier'),
(35, 1, 'hello', 'cash', 20, 'November', 2022, '10:49:16', 'Cashier'),
(36, 1, 'hello', 'cash', 22, 'November', 2022, '21:30:51', 'Cashier'),
(37, 1, 'hello', 'cash', 22, 'November', 2022, '21:34:15', 'Cashier'),
(38, 1, 'hello', 'cash', 22, 'November', 2022, '21:36:07', 'Cashier'),
(39, 1, 'hello', 'cash', 24, 'November', 2022, '15:11:53', 'Cashier'),
(40, 1, 'hello', 'cash', 24, 'November', 2022, '16:28:53', 'Cashier'),
(41, 1, 'hello', 'cash', 26, 'November', 2022, '18:13:10', 'Cashier'),
(42, 1, 'hello', 'cash', 26, 'November', 2022, '18:14:19', 'Cashier'),
(43, 1, 'hello', 'Kim', 27, 'November', 2022, '00:02:42', 'cashier'),
(44, 2, 'hello', 'James', 28, 'November', 2022, '00:10:56', 'cashier'),
(45, 3, 'manager', 'James', 28, 'November', 2022, '01:36:49', 'manger'),
(46, 1, 'cashier', 'Kim', 28, 'November', 2022, '01:38:26', 'cashier'),
(47, 3, 'James', 'James', 28, 'November', 2022, '01:40:12', 'manger'),
(48, 1, 'Kim', 'Kim', 28, 'November', 2022, '02:27:21', 'cashier');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
CREATE TABLE IF NOT EXISTS `cart` (
  `cartid` int(11) NOT NULL AUTO_INCREMENT,
  `INID` int(11) NOT NULL,
  `pid` varchar(10) NOT NULL,
  `Product_Name` varchar(50) NOT NULL,
  `qty` varchar(20) NOT NULL,
  `Unit_Price` varchar(20) NOT NULL,
  `Total_Price` varchar(20) NOT NULL,
  `Total_Cost` double DEFAULT '0',
  `profit` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`cartid`)
) ENGINE=MyISAM AUTO_INCREMENT=306 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`cartid`, `INID`, `pid`, `Product_Name`, `qty`, `Unit_Price`, `Total_Price`, `Total_Cost`, `profit`) VALUES
(305, 95, '20', 'mask', '10', '550.0', '5500.0', 1200, 4300);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `Cid` int(11) NOT NULL AUTO_INCREMENT,
  `Customer_FirstName` varchar(50) NOT NULL,
  `Customer_LastName` varchar(50) NOT NULL,
  `Customer_TP` varchar(10) NOT NULL,
  `Customer_Email` varchar(50) NOT NULL,
  `Loyalty_Points` varchar(10) NOT NULL DEFAULT '0',
  `Total_Discounts` varchar(10) NOT NULL DEFAULT '0',
  `Reg_Date` varchar(50) NOT NULL,
  `Reg_Employee` varchar(10) NOT NULL,
  `Reg_year` int(11) NOT NULL DEFAULT '0',
  `Reg_Month` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Cid`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Cid`, `Customer_FirstName`, `Customer_LastName`, `Customer_TP`, `Customer_Email`, `Loyalty_Points`, `Total_Discounts`, `Reg_Date`, `Reg_Employee`, `Reg_year`, `Reg_Month`) VALUES
(11, 'Nicky', 'Minaj', '0332455353', 'wek@sub.com', '0', '', '14-09-2022', 'Employee', 2022, 8),
(12, 'Saul', 'Goodman', '0458145854', 'Saul@gmail.com', '0', '', '18-06-2022', 'hello', 2022, 5),
(17, 'Hector', 'Salamanca', '04584158', 'Hector@gmail.com', '0', '', '20-07-2021', 'Employee', 2021, 6),
(20, 'Manula', 'Pasan', '0769131392', 'manula413hemantha@gmail.com', '892.0', '5825.5', '01-12-2021', 'hello', 2021, 11),
(21, 'Lalo', 'Salamanca', '45678248', 'lalo@gmail.com', '0', '', '20-03-2020', 'Employee', 2020, 2),
(22, 'Kim', 'Wexler', '458144', 'kim@gmail.com', '0', '0', '15-07-2020', 'hello', 2019, 6),
(24, 'Gus', 'Fring', '45741', 'gus@gmai.com', '100', '0', '20-11-2022', 'hello', 2022, 10),
(29, 'Pasan', 'Hemantha', '12345678', 'manula413hemantha@gmail.com', '0', '0', '2022-11-27', 'null', 2021, 4),
(30, 'David', 'Degea', '46164', 'david@gmai.com', '0', '0', '2022-11-27', 'null', 2022, 10);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `Employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `Employee_name` varchar(50) NOT NULL,
  `Employee_tp` varchar(10) NOT NULL,
  `Employee_email` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `Employee_Role` varchar(20) NOT NULL,
  PRIMARY KEY (`Employee_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`Employee_id`, `Employee_name`, `Employee_tp`, `Employee_email`, `username`, `password`, `Employee_Role`) VALUES
(1, 'Kim', '0754862759', 'kim@gmail.com', 'Kim', '12345', 'cashier'),
(3, 'James', '0785479685', 'james@gmail.com', 'James', '12345', 'manager'),
(4, 'Rathnayake', '0715479852', 'james@gmail.com', 'Rathnayake', '12345', 'admin'),
(6, 'Navindu', '072547895', 'navindu@yahoo.com', 'Navindu', '12345', 'cashier'),
(7, 'John Silva', '071547953', 'john@gmail.com', 'John', '12345', 'cashier'),
(8, 'Kumara', '0775864951', 'kumara@gmail.com', 'Kumara', '12345', 'manager'),
(9, 'Yasith', '077586341', 'yasith@outlook.com', 'Yasith', '12345', 'manager'),
(10, 'Philip', '0725419753', 'philip@gmail.com', 'Philip', '12345', 'cashier');

-- --------------------------------------------------------

--
-- Table structure for table `employee_salary`
--

DROP TABLE IF EXISTS `employee_salary`;
CREATE TABLE IF NOT EXISTS `employee_salary` (
  `esalid` int(11) NOT NULL AUTO_INCREMENT,
  `empid` int(11) NOT NULL,
  `empname` varchar(50) NOT NULL,
  `paymonth` varchar(10) NOT NULL,
  `payyear` int(11) NOT NULL,
  `paiddate` varchar(30) NOT NULL,
  `amount` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`esalid`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_salary`
--

INSERT INTO `employee_salary` (`esalid`, `empid`, `empname`, `paymonth`, `payyear`, `paiddate`, `amount`, `status`) VALUES
(1, 3, 'James', 'August', 2022, '', 20000, 0),
(2, 1, 'Kim', 'November', 2022, '25 - November - 2022', 20000, 1),
(3, 1, 'Kim', 'January', 2021, '', 20000, 0),
(4, 1, 'Kim', 'June', 2022, '27 - June - 2022', 20000, 1),
(5, 1, 'Kim', 'January', 2020, '', 20000, 0),
(6, 1, 'Kim', 'April', 2022, '15 - April - 2022', 20000, 1),
(7, 1, 'Kim', 'June', 2022, '28 - June - 2022', 20000, 1),
(8, 1, 'Kim', 'October', 2019, '30 - June - 2022', 20000, 1),
(9, 8, 'Kumara', 'November', 2022, '', 50000, 0),
(10, 9, 'Yasith', 'November', 2022, '', 50000, 0),
(11, 10, 'Philip', 'November', 2022, '', 20000, 0),
(12, 3, 'James', 'November', 2022, '28 - November - 2022', 50000, 1),
(13, 6, 'Navindu', 'November', 2022, '22 - November - 2022', 20000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `extra`
--

DROP TABLE IF EXISTS `extra`;
CREATE TABLE IF NOT EXISTS `extra` (
  `exid` int(11) NOT NULL AUTO_INCREMENT,
  `val` varchar(10) NOT NULL,
  PRIMARY KEY (`exid`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `extra`
--

INSERT INTO `extra` (`exid`, `val`) VALUES
(1, '95');

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
CREATE TABLE IF NOT EXISTS `inventory` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) NOT NULL,
  `barcode` varchar(50) NOT NULL,
  `cprice` double NOT NULL,
  `sprice` double NOT NULL,
  `quantity` double NOT NULL,
  `sname` varchar(50) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`pid`, `pname`, `barcode`, `cprice`, `sprice`, `quantity`, `sname`, `status`) VALUES
(17, 'Soap', '12345', 500, 550, 90, 'Russell', 1),
(18, 'Toothpaste', '45215', 120, 170, 45, 'Willson', 1),
(19, 'Gloves', '415481', 50, 100, 65, 'Russell', 1),
(20, 'Mask', '1416165', 120, 550, 90, 'DoT', 0),
(21, 'Bottle', '548161', 100, 200, 100, 'DoT', 1),
(22, 'Toy', '4596451', 100, 150, 100, 'Mark', 0),
(24, 'Bowl', '5487', 200, 250, 500, 'Kim', 1),
(25, 'Tooth Brush', '7548', 100, 120, 800, 'Suleka', 1),
(26, 'Flower Vase', '35363', 500, 800, 250, 'Suleka', 1),
(27, 'Plastic Flowers', '3534', 450, 600, 250, 'Dot', 0),
(28, 'Battery Charger', '7248', 1800, 2200, 50, 'Kim', 0),
(29, 'Garden Horse', '45721', 3000, 3800, 20, 'DoT', 1),
(30, 'HP USB Mouse', '7542', 2200, 2500, 60, 'Kim', 1),
(31, 'Plastic Container', '472754', 4000, 4500, 120, 'Mark', 1),
(32, 'Pencil Box', '45721', 400, 420, 200, 'DoT', 1),
(33, 'Floor Cleaner', '45721', 800, 900, 200, 'Kim', 1);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
CREATE TABLE IF NOT EXISTS `sales` (
  `saleid` int(11) NOT NULL AUTO_INCREMENT,
  `INID` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Time` varchar(20) NOT NULL,
  `Cashier` varchar(20) NOT NULL,
  `Cid` int(11) NOT NULL,
  `Customer_Name` varchar(50) NOT NULL,
  `No_Items` varchar(10) NOT NULL DEFAULT '0',
  `Total_Bill` varchar(10) NOT NULL,
  `Total_Cost` double DEFAULT '0',
  `Paid_Amount` varchar(10) NOT NULL DEFAULT '0',
  `Balance` varchar(10) NOT NULL,
  `Loyalty_Points` int(11) NOT NULL DEFAULT '0',
  `Discount` varchar(10) NOT NULL DEFAULT '0',
  `Profit` double DEFAULT '0',
  PRIMARY KEY (`saleid`)
) ENGINE=MyISAM AUTO_INCREMENT=96 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`saleid`, `INID`, `Date`, `Time`, `Cashier`, `Cid`, `Customer_Name`, `No_Items`, `Total_Bill`, `Total_Cost`, `Paid_Amount`, `Balance`, `Loyalty_Points`, `Discount`, `Profit`) VALUES
(59, 63, '2021-10-13', '03:47:31 PM', 'Employee', 0, 'Unregistered', '0', '800.0', 500, '0', '200.0', 0, '0', 300),
(60, 64, '2022-11-26', '03:47:48 PM', 'Employee', 0, 'Unregistered', '0', '1500.0', 1200, '0', '500.0', 0, '0', 300),
(61, 65, '2022-11-27', '03:47:48', 'Employee', 0, 'Unregistered', '0', '700', 500, '0', '300', 0, '0', 200),
(62, 66, '2020-02-20', '03:47:48', 'Employee', 0, 'Unregistered', '0', '700', 500, '0', '300', 0, '0', 200),
(63, 67, '2020-01-25', '03:47:48', 'Employee', 0, 'Unregistered', '0', '700', 500, '0', '300', 0, '0', 200),
(64, 68, '2021-06-26', '03:47:48', 'Employee', 0, 'Unregistered', '0', '700', 500, '0', '300', 0, '0', 200),
(65, 69, '2021-05-17', '03:47:48', 'Employee', 0, 'Unregistered', '0', '700', 500, '0', '300', 0, '0', 200),
(66, 70, '2022-09-07', '03:47:48', 'Employee', 0, 'Unregistered', '0', '700', 500, '0', '300', 0, '0', 200),
(67, 71, '2023-11-17', '03:47:48', 'Employee', 0, 'Unregistered', '0', '700', 500, '0', '300', 0, '0', 200),
(68, 72, '2023-10-14', '03:47:48', 'Employee', 0, 'Unregistered', '0', '700', 500, '0', '300', 0, '0', 200),
(69, 73, '2023-10-20', '03:47:48', 'Employee', 0, 'Unregistered', '5', '700', 500, '0', '300', 0, '0', 200),
(70, 74, '2023-10-21', '03:47:48', 'Employee', 0, 'Unregistered', '7', '700', 500, '0', '300', 0, '0', 200),
(71, 65, '2022-11-26', '08:27:27 PM', 'Employee', 0, 'Unregistered', '15.0', '1550.0', 1100, '0', '50.0', 0, '0', 450),
(72, 66, '2022-11-26', '09:46:14 PM', 'Employee', 0, 'Unregistered', '10.0', '1500.0', 1200, '0', 'Rs.00.00', 0, '0', 300),
(73, 67, '2022-11-26', '11:14:45 PM', 'Employee', 0, 'Unregistered', '15.0', '1900.0', 1450, '0', '100.0', 0, '0', 450),
(74, 68, '2022-11-26', '11:17:16 PM', 'Employee', 0, 'Unregistered', '10.0', '800.0', 500, '0', 'Rs.00.00', 0, '0', 300),
(75, 69, '2022-11-26', '11:18:19 PM', 'Employee', 0, 'Unregistered', '10.0', '5200.0', 1200, '0', 'Rs.00.00', 0, '0', 4000),
(76, 70, '2022-11-26', '11:21:29 PM', 'Employee', 0, 'Unregistered', '10.0', '1500.0', 1200, '0', '500.0', 0, '0', 300),
(77, 71, '2022-11-26', '11:24:08 PM', 'Employee', 0, 'Unregistered', '10.0', '800.0', 500, '0', '200.0', 0, '0', 300),
(78, 72, '2022-11-26', '11:24:50 PM', 'Employee', 0, 'Unregistered', '15.0', '1550.0', 1100, '0', '50.0', 0, '0', 450),
(79, 79, '2022-11-27', '01:28:47 AM', 'cashier', 20, 'Manula', '100.0', '28850.0', 15700, '28000', '592.5', 50, '1442.5', 11707.5),
(80, 80, '2022-11-27', '12:18:01 PM', 'Employee', 0, 'Unregistered', '10.0', '800.0', 500, '1000', '200.0', 0, '0', 300),
(81, 81, '2022-11-27', '03:09:21 PM', 'Employee', 0, 'Unregistered', '10.0', '5500.0', 5000, '6000', '500.0', 0, '0', 500),
(82, 82, '2022-11-27', '03:33:33 PM', 'cashier', 20, 'Manula', '15.0', '2200.0', 1450, '2500', '300.0', 0, '0.0', 750),
(83, 83, '2022-11-27', '11:38:19 PM', 'Employee', 0, 'Unregistered', '10.0', '1700.0', 1200, '2000', '300.0', 0, '0', 500),
(84, 84, '2022-11-27', '11:38:44 PM', 'Employee', 0, 'Unregistered', '5.0', '850.0', 600, '1000', '150.0', 0, '0', 250),
(85, 85, '2022-11-27', '11:39:15 PM', 'Employee', 0, 'Unregistered', '10.0', '1700.0', 1200, '2000', '300.0', 0, '0', 500),
(86, 86, '2022-11-28', '01:44:52 AM', 'Employee', 0, 'Unregistered', '10.0', '1700.0', 1200, '2000', '300.0', 0, '0', 500),
(87, 87, '2022-11-28', '01:45:41 AM', 'Employee', 0, 'Unregistered', '10.0', '1000.0', 500, '10000', '9000.0', 0, '0', 500),
(88, 88, '2022-11-28', '01:47:45 AM', 'Employee', 0, 'Unregistered', '10.0', '1700.0', 1200, '1800', '100.0', 0, '0', 500),
(89, 89, '2022-11-28', '01:51:15 AM', 'Employee', 0, 'Unregistered', '15.0', '2200.0', 1450, '2500', '300.0', 0, '0', 750),
(90, 90, '2022-11-28', '01:52:20 AM', 'Employee', 0, 'Unregistered', '10.0', '1700.0', 1200, '2000', '300.0', 0, '0', 500),
(91, 91, '2022-11-28', '02:05:53 AM', 'Employee', 0, 'Unregistered', '10.0', '1700.0', 1200, '2000', '300.0', 0, '0', 500),
(92, 92, '2022-11-28', '02:16:20 AM', 'Employee', 0, 'Unregistered', '10.0', '1700.0', 1200, '10000', '8300.0', 0, '0', 500),
(93, 93, '2022-11-28', '02:17:42 AM', 'Employee', 0, 'Unregistered', '10.0', '1700.0', 1200, '2000', '300.0', 0, '0', 500),
(94, 94, '2022-11-28', '02:19:51 AM', 'Employee', 0, 'Unregistered', '5.0', '500.0', 250, '1000', '500.0', 0, '0', 250),
(95, 95, '2022-11-28', '02:21:03 AM', 'cashier', 20, 'Manula', '10.0', '5500.0', 1200, '5500', '275.0', 50, '275.0', 4025);

-- --------------------------------------------------------

--
-- Table structure for table `stock_report`
--

DROP TABLE IF EXISTS `stock_report`;
CREATE TABLE IF NOT EXISTS `stock_report` (
  `stid` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NOT NULL,
  `pname` varchar(50) NOT NULL,
  `quantity` double NOT NULL,
  `day` int(11) NOT NULL,
  `month` varchar(10) NOT NULL,
  `year` int(11) NOT NULL,
  `time` varchar(20) NOT NULL,
  `status` varchar(15) NOT NULL,
  PRIMARY KEY (`stid`)
) ENGINE=MyISAM AUTO_INCREMENT=48 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock_report`
--

INSERT INTO `stock_report` (`stid`, `pid`, `pname`, `quantity`, `day`, `month`, `year`, `time`, `status`) VALUES
(1, 24, 'Bowl', 45, 12, 'January', 2020, '00:10:42', 'stock-in'),
(2, 28, 'Battery Charger', 23, 10, 'January', 2020, '23:58:31', 'stock-out'),
(3, 20, 'mask', 45, 12, 'January', 2020, '00:04:22', 'stock-in'),
(18, 8, 'Toothpaste', 12, 17, 'November', 2022, '00:07:20', 'stock-out'),
(4, 25, 'Tooth Brush', 45, 12, 'January', 2021, '00:04:22', 'stock-in'),
(5, 26, 'Flower Vase', 45, 12, 'January', 2021, '00:04:22', 'stock-in'),
(6, 30, 'HP USB Mouse', 56, 12, 'March', 2021, '00:02:22', 'stock-in'),
(7, 21, 'Bottle', 45, 12, 'April', 2021, '00:01:22', 'stock-in'),
(8, 27, 'Plastic Flowers', 45, 25, 'April', 2020, '00:01:22', 'stock-in'),
(9, 31, 'Plastic Container', 45, 18, 'JUNE', 2019, '00:01:22', 'stock-in'),
(11, 32, 'Pencil Box', 21, 16, 'November', 2022, '23:57:20', 'stock-in'),
(12, 25, 'Tooth Brush', 100, 16, 'November', 2022, '23:58:31', 'stock-in'),
(13, 19, 'Gloves', 60, 22, 'November', 2022, '23:59:27', 'stock-in'),
(14, 22, 'Toy', 30, 16, 'October', 2022, '23:59:40', 'stock-in'),
(15, 29, 'Garden Horse', 20, 17, 'July', 2022, '00:01:22', 'stock-in'),
(16, 27, 'Plastic Flowers', 10, 17, 'November', 2022, '00:04:22', 'stock-out'),
(17, 31, 'Plastic Container', 5, 19, 'July', 2022, '00:04:22', 'stock-in'),
(19, 8, 'Gloves', 8, 15, 'November', 2022, '00:07:20', 'stock-in'),
(20, 32, 'Pencil Box', 7, 17, 'November', 2022, '00:07:49', 'stock-out'),
(21, 28, 'Battery Charger', 2, 17, 'June', 2022, '00:07:49', 'stock-in'),
(22, 24, 'Bowl', 60, 23, 'April', 2022, '00:10:42', 'stock-out'),
(23, 20, 'Mask', 1, 17, 'November', 2022, '00:10:42', 'stock-in'),
(24, 17, 'Soap', 20, 24, 'November', 2022, '00:12:26', 'stock-in'),
(25, 33, 'Floor Cleaner', 30, 16, 'November', 2022, '12:03:25', 'stock-in'),
(26, 32, 'Pencil Box', 200, 17, 'November', 2022, '12:03:41', 'stock-out'),
(27, 11, 'sfsf', 300, 17, 'November', 2022, '12:03:41', 'stock-in'),
(28, 18, '', 100, 20, 'November', 2022, '18:04:55', 'stock-in'),
(29, 19, 'Gloves', 10, 27, 'November', 2022, '12:18:01', 'stock-out'),
(30, 18, 'Toothpaste', 150, 27, 'November', 2022, '12:32:03', 'stock-in'),
(31, 17, 'Soap', 10, 27, 'November', 2022, '15:09:21', 'stock-out'),
(32, 18, 'Toothpaste', 10, 27, 'November', 2022, '15:33:33', 'stock-out'),
(33, 19, 'Gloves', 5, 27, 'November', 2022, '15:33:33', 'stock-out'),
(34, 18, 'Toothpaste', 10, 27, 'November', 2022, '23:38:19', 'stock-out'),
(35, 18, 'Toothpaste', 5, 27, 'November', 2022, '23:38:44', 'stock-out'),
(36, 18, 'Toothpaste', 10, 27, 'November', 2022, '23:39:15', 'stock-out'),
(37, 18, 'Toothpaste', 10, 28, 'November', 2022, '01:44:52', 'stock-out'),
(38, 19, 'Gloves', 10, 28, 'November', 2022, '01:45:41', 'stock-out'),
(39, 18, 'Toothpaste', 10, 28, 'November', 2022, '01:47:45', 'stock-out'),
(40, 19, 'Gloves', 5, 28, 'November', 2022, '01:51:15', 'stock-out'),
(41, 18, 'Toothpaste', 10, 28, 'November', 2022, '01:51:15', 'stock-out'),
(42, 18, 'Toothpaste', 10, 28, 'November', 2022, '01:52:20', 'stock-out'),
(43, 18, 'Toothpaste', 10, 28, 'November', 2022, '02:05:53', 'stock-out'),
(44, 18, 'Toothpaste', 10, 28, 'November', 2022, '02:16:20', 'stock-out'),
(45, 18, 'Toothpaste', 10, 28, 'November', 2022, '02:17:42', 'stock-out'),
(46, 19, 'Gloves', 5, 28, 'November', 2022, '02:19:51', 'stock-out'),
(47, 20, 'mask', 10, 28, 'November', 2022, '02:21:03', 'stock-out');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
CREATE TABLE IF NOT EXISTS `supplier` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `supplier_Name` varchar(50) NOT NULL,
  `tp_Number` varchar(10) NOT NULL,
  `company` varchar(50) NOT NULL,
  `sp_email` varchar(50) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`sid`, `supplier_Name`, `tp_Number`, `company`, `sp_email`) VALUES
(11, 'DoT', '0114456543', 'CBL ', 'test@test.com'),
(12, 'Kim', '0114587596', 'Wexler', 'kim@gmail.com'),
(13, 'Suleka', '0774853759', 'MCT', 'mct@gmai.com'),
(14, 'Russell', '0724857495', 'Vanguard', 'russell@vanguard.com'),
(15, 'Willson', '0754862574', 'Riot', 'willson@riot.com'),
(16, 'Mark', '0775896425', 'H&B', 'mark@outlook.com'),
(17, 'Ruwan', '0775896425', 'R&B', 'ruwan@outlook.com');

-- --------------------------------------------------------

--
-- Table structure for table `user_salary`
--

DROP TABLE IF EXISTS `user_salary`;
CREATE TABLE IF NOT EXISTS `user_salary` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `usertype` varchar(20) NOT NULL,
  `salary` int(11) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_salary`
--

INSERT INTO `user_salary` (`uid`, `usertype`, `salary`) VALUES
(1, 'cashier', 20000),
(2, 'manager', 50000),
(3, 'admin', 80000);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
