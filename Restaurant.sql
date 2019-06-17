-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: mysql1
-- Generation Time: Jun 17, 2019 at 02:22 AM
-- Server version: 5.7.26
-- PHP Version: 7.2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Restaurant`
--

-- --------------------------------------------------------

--
-- Table structure for table `Anios`
--

CREATE TABLE `Anios` (
  `Anio` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Anios`
--

INSERT INTO `Anios` (`Anio`) VALUES
('2019'),
('2020'),
('2021'),
('2022'),
('2023'),
('2024'),
('2025'),
('2026'),
('2027'),
('2028'),
('2029'),
('2030'),
('2031'),
('2032'),
('2033'),
('2034'),
('2035'),
('2036'),
('2037'),
('2038'),
('2039'),
('2040');

-- --------------------------------------------------------

--
-- Table structure for table `Camarero`
--

CREATE TABLE `Camarero` (
  `IdCamarero` int(11) NOT NULL,
  `Nombre` varchar(80) NOT NULL,
  `Apellido1` varchar(50) NOT NULL,
  `Apellido2` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Camarero`
--

INSERT INTO `Camarero` (`IdCamarero`, `Nombre`, `Apellido1`, `Apellido2`) VALUES
(1, 'Andres', 'Lopez', NULL),
(2, 'Carlos Joaquin', 'Medina', 'Mendoza'),
(3, 'Jesus Antonio', 'Perez', 'Ficticio');

-- --------------------------------------------------------

--
-- Table structure for table `Cliente`
--

CREATE TABLE `Cliente` (
  `IdCliente` int(11) NOT NULL,
  `Nombre` varchar(80) NOT NULL,
  `Apellido1` varchar(50) NOT NULL,
  `Apellido2` varchar(50) DEFAULT NULL,
  `Observaciones` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Cliente`
--

INSERT INTO `Cliente` (`IdCliente`, `Nombre`, `Apellido1`, `Apellido2`, `Observaciones`) VALUES
(1, 'Brayan', 'Herrera', 'Triviño', 'Cliente VIP'),
(2, 'Sonia', 'Triviño', 'Perez', '');

-- --------------------------------------------------------

--
-- Stand-in structure for view `CNComprasClientesMayorQue`
-- (See below for the actual view)
--
CREATE TABLE `CNComprasClientesMayorQue` (
`IdCliente` int(11)
,`Cliente` varchar(182)
,`Total` decimal(32,0)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `CNFacturadoXPeriodoXCamareros`
-- (See below for the actual view)
--
CREATE TABLE `CNFacturadoXPeriodoXCamareros` (
`IdCamarero` int(11)
,`Camarero` varchar(182)
,`Periodo` varchar(7)
,`Total` decimal(32,0)
);

-- --------------------------------------------------------

--
-- Table structure for table `Cocinero`
--

CREATE TABLE `Cocinero` (
  `IdCocinero` int(11) NOT NULL,
  `Nombre` varchar(80) NOT NULL,
  `Apellido1` varchar(50) NOT NULL,
  `Apellido2` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Cocinero`
--

INSERT INTO `Cocinero` (`IdCocinero`, `Nombre`, `Apellido1`, `Apellido2`) VALUES
(1, 'Ana Maria', 'Peñalosa', NULL),
(2, 'Juan Jose', 'Valentin', 'Valentin');

-- --------------------------------------------------------

--
-- Table structure for table `DetalleFactura`
--

CREATE TABLE `DetalleFactura` (
  `IdFactura` int(11) NOT NULL,
  `IdDetalleFactura` int(11) NOT NULL,
  `IdCocinero` int(11) NOT NULL,
  `Plato` varchar(80) NOT NULL,
  `Importe` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `DetalleFactura`
--

INSERT INTO `DetalleFactura` (`IdFactura`, `IdDetalleFactura`, `IdCocinero`, `Plato`, `Importe`) VALUES
(1, 1, 1, 'TRUCHA', 25000),
(1, 2, 1, 'MOJARRA', 15000),
(2, 3, 1, 'ARROZ CON POLLO', 12000),
(2, 4, 1, 'FILETE', 18000),
(3, 5, 1, 'CANGREJO EN SALSA', 75000),
(4, 6, 1, 'ENSALADA MIXTA', 10000),
(4, 7, 1, 'POLLO BROASTER', 35000),
(5, 8, 1, 'Pescado', 12000),
(6, 9, 1, 'Arroz con pollo', 10000),
(7, 10, 1, 'guacamole', 5000),
(8, 11, 1, 'CONEJO', 15000),
(9, 12, 1, 'queso', 5000),
(10, 13, 1, 'AAA', 1000),
(10, 14, 2, 'BBB', 2000),
(10, 15, 1, 'CCC', 3000),
(10, 16, 2, 'DDD', 4000);

-- --------------------------------------------------------

--
-- Table structure for table `Factura`
--

CREATE TABLE `Factura` (
  `IdFactura` int(11) NOT NULL,
  `IdCliente` int(11) NOT NULL,
  `IdCamarero` int(11) NOT NULL,
  `IdMesa` int(11) NOT NULL,
  `FechaFactura` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Factura`
--

INSERT INTO `Factura` (`IdFactura`, `IdCliente`, `IdCamarero`, `IdMesa`, `FechaFactura`) VALUES
(1, 1, 2, 1, '2019-06-15 02:39:43'),
(2, 2, 1, 4, '2019-06-15 02:39:43'),
(3, 2, 2, 3, '2019-06-15 02:39:43'),
(4, 1, 1, 3, '2019-05-03 00:00:00'),
(5, 1, 1, 2, '2019-06-17 00:45:53'),
(6, 2, 2, 3, '2019-06-17 01:10:09'),
(7, 1, 2, 2, '2019-06-17 01:12:38'),
(8, 1, 1, 2, '2019-06-17 02:08:01'),
(9, 2, 1, 1, '2019-06-17 02:15:02'),
(10, 1, 2, 3, '2019-06-17 02:19:00');

-- --------------------------------------------------------

--
-- Table structure for table `Mesa`
--

CREATE TABLE `Mesa` (
  `IdMesa` int(11) NOT NULL,
  `NumMaxComensales` int(11) NOT NULL,
  `Ubicacion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Mesa`
--

INSERT INTO `Mesa` (`IdMesa`, `NumMaxComensales`, `Ubicacion`) VALUES
(1, 4, 'INFERIOR IZQUIERDA'),
(2, 4, 'SUPERIOR IZQUIERDA'),
(3, 4, 'INFERIOR DERECHA'),
(4, 5, 'SUPERIOR DERECHA');

-- --------------------------------------------------------

--
-- Table structure for table `Meses`
--

CREATE TABLE `Meses` (
  `Mes` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Meses`
--

INSERT INTO `Meses` (`Mes`) VALUES
('01'),
('02'),
('03'),
('04'),
('05'),
('06'),
('07'),
('08'),
('09'),
('10'),
('11'),
('12');

-- --------------------------------------------------------

--
-- Structure for view `CNComprasClientesMayorQue`
--
DROP TABLE IF EXISTS `CNComprasClientesMayorQue`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `CNComprasClientesMayorQue`  AS  select `C`.`IdCliente` AS `IdCliente`,trim(concat(`C`.`Nombre`,' ',`C`.`Apellido1`,' ',ifnull(`C`.`Apellido2`,''))) AS `Cliente`,sum(`DF`.`Importe`) AS `Total` from ((`Factura` `F` join `DetalleFactura` `DF` on((`DF`.`IdFactura` = `F`.`IdFactura`))) join `Cliente` `C` on((`C`.`IdCliente` = `F`.`IdCliente`))) group by `C`.`IdCliente` having (`Total` > 100000) ;

-- --------------------------------------------------------

--
-- Structure for view `CNFacturadoXPeriodoXCamareros`
--
DROP TABLE IF EXISTS `CNFacturadoXPeriodoXCamareros`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `CNFacturadoXPeriodoXCamareros`  AS  select `C`.`IdCamarero` AS `IdCamarero`,trim(concat(`C`.`Nombre`,' ',`C`.`Apellido1`,' ',ifnull(`C`.`Apellido2`,''))) AS `Camarero`,concat(`A`.`Anio`,'-',`M`.`Mes`) AS `Periodo`,ifnull(sum(`DF`.`Importe`),0) AS `Total` from ((((`Anios` `A` join `Meses` `M`) join `Camarero` `C`) left join `Factura` `F` on(((`F`.`IdCamarero` = `C`.`IdCamarero`) and (convert(date_format(`F`.`FechaFactura`,'%Y-%m') using utf8) = concat(`A`.`Anio`,'-',`M`.`Mes`))))) left join `DetalleFactura` `DF` on((`DF`.`IdFactura` = `F`.`IdFactura`))) group by `C`.`IdCamarero`,concat(`A`.`Anio`,'-',`M`.`Mes`) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Camarero`
--
ALTER TABLE `Camarero`
  ADD PRIMARY KEY (`IdCamarero`);

--
-- Indexes for table `Cliente`
--
ALTER TABLE `Cliente`
  ADD PRIMARY KEY (`IdCliente`);

--
-- Indexes for table `Cocinero`
--
ALTER TABLE `Cocinero`
  ADD PRIMARY KEY (`IdCocinero`);

--
-- Indexes for table `DetalleFactura`
--
ALTER TABLE `DetalleFactura`
  ADD PRIMARY KEY (`IdDetalleFactura`),
  ADD KEY `FK_Factura_DetalleFactura` (`IdFactura`),
  ADD KEY `FK_Cocinero_DetalleFactura` (`IdCocinero`);

--
-- Indexes for table `Factura`
--
ALTER TABLE `Factura`
  ADD PRIMARY KEY (`IdFactura`),
  ADD KEY `FK_Cliente_Factura` (`IdCliente`),
  ADD KEY `FK_Mesa_Factura` (`IdMesa`),
  ADD KEY `FK_Camarero_Factura` (`IdCamarero`);

--
-- Indexes for table `Mesa`
--
ALTER TABLE `Mesa`
  ADD PRIMARY KEY (`IdMesa`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Camarero`
--
ALTER TABLE `Camarero`
  MODIFY `IdCamarero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `Cliente`
--
ALTER TABLE `Cliente`
  MODIFY `IdCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `Cocinero`
--
ALTER TABLE `Cocinero`
  MODIFY `IdCocinero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `DetalleFactura`
--
ALTER TABLE `DetalleFactura`
  MODIFY `IdDetalleFactura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `Factura`
--
ALTER TABLE `Factura`
  MODIFY `IdFactura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `Mesa`
--
ALTER TABLE `Mesa`
  MODIFY `IdMesa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `DetalleFactura`
--
ALTER TABLE `DetalleFactura`
  ADD CONSTRAINT `FK_Cocinero_DetalleFactura` FOREIGN KEY (`IdCocinero`) REFERENCES `Cocinero` (`IdCocinero`),
  ADD CONSTRAINT `FK_Factura_DetalleFactura` FOREIGN KEY (`IdFactura`) REFERENCES `Factura` (`IdFactura`);

--
-- Constraints for table `Factura`
--
ALTER TABLE `Factura`
  ADD CONSTRAINT `FK_Camarero_Factura` FOREIGN KEY (`IdCamarero`) REFERENCES `Camarero` (`IdCamarero`),
  ADD CONSTRAINT `FK_Cliente_Factura` FOREIGN KEY (`IdCliente`) REFERENCES `Cliente` (`IdCliente`),
  ADD CONSTRAINT `FK_Mesa_Factura` FOREIGN KEY (`IdMesa`) REFERENCES `Mesa` (`IdMesa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
