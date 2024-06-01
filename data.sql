-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 01, 2024 at 09:38 AM
-- Server version: 8.2.0
-- PHP Version: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `do_an_android_anh`
--

-- --------------------------------------------------------

--
-- Table structure for table `t_category`
--

DROP TABLE IF EXISTS `t_category`;
CREATE TABLE IF NOT EXISTS `t_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Dumping data for table `t_category`
--

INSERT INTO `t_category` (`id`, `name`) VALUES
(1, 'Túi sách nam'),
(2, 'Túi sách nữ'),
(3, 'Túi sách trẻ em');

-- --------------------------------------------------------

--
-- Table structure for table `t_order`
--

DROP TABLE IF EXISTS `t_order`;
CREATE TABLE IF NOT EXISTS `t_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `total` double NOT NULL,
  `user_id` int DEFAULT NULL,
  `order_date` datetime(6) DEFAULT NULL,
  `address` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKho2r4qgj3txpy8964fnla95ub` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Dumping data for table `t_order`
--

INSERT INTO `t_order` (`id`, `total`, `user_id`, `order_date`, `address`, `phone`) VALUES
(1, 160, 2, '2024-05-01 10:00:00.000000', '123 Đường A, TP.HCM', '0987654321'),
(2, 85, 3, '2024-05-02 11:30:00.000000', '456 Đường B, Hà Nội', '0987654322');

-- --------------------------------------------------------

--
-- Table structure for table `t_order_detail`
--

DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE IF NOT EXISTS `t_order_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` int DEFAULT NULL,
  `price` double NOT NULL,
  `product_id` int DEFAULT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrldcrqix0q1dx0mrmlm96exi7` (`order_id`),
  KEY `FKsh4jdba5oyaxd6g6t3r40o1qw` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Dumping data for table `t_order_detail`
--

INSERT INTO `t_order_detail` (`id`, `order_id`, `price`, `product_id`, `quantity`) VALUES
(1, 1, 50, 1, 2),
(2, 1, 60, 2, 1),
(3, 2, 55, 3, 1),
(4, 2, 30, 5, 1);

-- --------------------------------------------------------

--
-- Table structure for table `t_product`
--

DROP TABLE IF EXISTS `t_product`;
CREATE TABLE IF NOT EXISTS `t_product` (
  `category_id` int DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `price` double NOT NULL,
  `description` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp17nkwpqnnxh5iax87dc58sp3` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Dumping data for table `t_product`
--

INSERT INTO `t_product` (`category_id`, `id`, `price`, `description`, `name`) VALUES
(1, 1, 50, 'Túi sách da dành cho nam', 'Túi da nam 1'),
(1, 2, 60, 'Túi sách vải dành cho nam', 'Túi vải nam 2'),
(2, 3, 55, 'Túi sách da dành cho nữ', 'Túi da nữ 1'),
(2, 4, 70, 'Túi sách vải dành cho nữ', 'Túi vải nữ 2'),
(3, 5, 30, 'Túi sách trẻ em có hình ảnh dễ thương', 'Túi trẻ em 1');

-- --------------------------------------------------------

--
-- Table structure for table `t_product_detail`
--

DROP TABLE IF EXISTS `t_product_detail`;
CREATE TABLE IF NOT EXISTS `t_product_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `quantity` int NOT NULL,
  `color` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `size` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo8jsuec4fv6ifr0fl8x7roly4` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Dumping data for table `t_product_detail`
--

INSERT INTO `t_product_detail` (`id`, `product_id`, `quantity`, `color`, `size`) VALUES
(1, 1, 100, 'Đen', 'M'),
(2, 2, 150, 'Xanh', 'L'),
(3, 3, 120, 'Đỏ', 'S'),
(4, 4, 200, 'Hồng', 'M'),
(5, 5, 80, 'Vàng', 'XS');

-- --------------------------------------------------------

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
CREATE TABLE IF NOT EXISTS `t_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Dumping data for table `t_role`
--

INSERT INTO `t_role` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE IF NOT EXISTS `t_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `phone_number` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `user_name` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK7pg3wxd55e553dj2jom9xx2iq` (`phone_number`),
  KEY `FK76cs7cu4h4y8vc1vd4qyw36rt` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Dumping data for table `t_user`
--

INSERT INTO `t_user` (`id`, `role_id`, `password`, `phone_number`, `user_name`) VALUES
(1, 1, 'admin', '1234567890', 'admin'),
(2, 2, 'password1', '123', 'user1'),
(3, 2, 'password2', '456', 'user2');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `t_order`
--
ALTER TABLE `t_order`
  ADD CONSTRAINT `FKho2r4qgj3txpy8964fnla95ub` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`);

--
-- Constraints for table `t_order_detail`
--
ALTER TABLE `t_order_detail`
  ADD CONSTRAINT `FKrldcrqix0q1dx0mrmlm96exi7` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`),
  ADD CONSTRAINT `FKsh4jdba5oyaxd6g6t3r40o1qw` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`);

--
-- Constraints for table `t_product`
--
ALTER TABLE `t_product`
  ADD CONSTRAINT `FKp17nkwpqnnxh5iax87dc58sp3` FOREIGN KEY (`category_id`) REFERENCES `t_category` (`id`);

--
-- Constraints for table `t_product_detail`
--
ALTER TABLE `t_product_detail`
  ADD CONSTRAINT `FKo8jsuec4fv6ifr0fl8x7roly4` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`);

--
-- Constraints for table `t_user`
--
ALTER TABLE `t_user`
  ADD CONSTRAINT `FK76cs7cu4h4y8vc1vd4qyw36rt` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
