-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-11-2019 a las 14:03:20
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `basededatosobras`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `id_administrador` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`id_administrador`, `id_empleado`) VALUES
(1, 2),
(2, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacen`
--

CREATE TABLE `almacen` (
  `id_almacen` int(11) NOT NULL,
  `id_obra` int(11) NOT NULL,
  `id_almacenista` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `telefono` varchar(18) NOT NULL,
  `direccion` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `almacen`
--

INSERT INTO `almacen` (`id_almacen`, `id_obra`, `id_almacenista`, `nombre`, `telefono`, `direccion`) VALUES
(34, 12, 1, 'Colpet', '5799898', 'colpet 123'),
(35, 13, 2, 'Americas', '310245', 'Americas 123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacenista`
--

CREATE TABLE `almacenista` (
  `id_almacenista` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `estado` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `almacenista`
--

INSERT INTO `almacenista` (`id_almacenista`, `id_empleado`, `estado`) VALUES
(1, 3, 'Ocupado'),
(2, 7, 'Ocupado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bodega`
--

CREATE TABLE `bodega` (
  `id_bodega` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `direccion` varchar(35) NOT NULL,
  `telefono` varchar(18) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `bodega`
--

INSERT INTO `bodega` (`id_bodega`, `nombre`, `direccion`, `telefono`) VALUES
(1, 'Bodega Sevilla', 'sevilla 1324', '5799898'),
(2, 'Bodega Americas', 'Americas #123', '5799898'),
(3, 'Bodega Cenabastos', 'cenabastos 123', '1213');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `control_objeto_almacen`
--

CREATE TABLE `control_objeto_almacen` (
  `id_control_objeto_almacen` int(11) NOT NULL,
  `id_objeto_almacen` int(11) NOT NULL,
  `cantidad_entrada` int(11) NOT NULL,
  `unidad_entrada` varchar(40) NOT NULL,
  `remision_entrada` varchar(20) DEFAULT NULL,
  `cantidad_salida` int(11) NOT NULL,
  `unidad_salida` varchar(40) NOT NULL,
  `destino_salida` int(11) DEFAULT NULL,
  `cantidad_saldo` int(11) NOT NULL,
  `unidad_saldo` varchar(40) NOT NULL,
  `observacion` varchar(200) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `id_empleado` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellido` varchar(35) NOT NULL,
  `telefono` varchar(18) NOT NULL,
  `direccion` varchar(35) NOT NULL,
  `dni` varchar(15) NOT NULL,
  `pass` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`id_empleado`, `nombre`, `apellido`, `telefono`, `direccion`, `dni`, `pass`) VALUES
(1, 'Juancho', 'Fuentes', '310', 'calle falsa', '1090', 'perrito123'),
(2, 'eduard', 'Cantillo', '310245', 'belen 123', '1090527947', '1234'),
(3, 'Gerson', 'Gomez', '310245', 'sevilla', '181818', '12345'),
(5, 'jean', 'Gomez', '310245', 'pueblo nuevo 123', '181819', 'charlie'),
(6, 'julian', 'neco', '3104040', 'americas 123', '9010', '1010'),
(7, 'carlos rene', 'Perez', '310245', '1213da', '10101010', 'lol'),
(9, 'Ángel Yesid', 'Mondragón Rodríguez', '32123456576', 'av simpreviva cll 69', '1005038967', 'angelyesid123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE `equipo` (
  `id_equipo` int(11) NOT NULL,
  `id_objeto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `herramienta`
--

CREATE TABLE `herramienta` (
  `id_herramienta` int(11) NOT NULL,
  `id_objeto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `herramienta`
--

INSERT INTO `herramienta` (`id_herramienta`, `id_objeto`) VALUES
(1, 36);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ing_residente`
--

CREATE TABLE `ing_residente` (
  `id_ing_residente` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `estado` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ing_residente`
--

INSERT INTO `ing_residente` (`id_ing_residente`, `id_empleado`, `estado`) VALUES
(1, 5, 'Ocupado'),
(2, 6, 'Ocupado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `material`
--

CREATE TABLE `material` (
  `id_material` int(11) NOT NULL,
  `id_objeto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `material`
--

INSERT INTO `material` (`id_material`, `id_objeto`) VALUES
(32, 33),
(33, 34),
(34, 37);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `objeto`
--

CREATE TABLE `objeto` (
  `id_objeto` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `descripcion` varchar(400) NOT NULL,
  `unidad` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `objeto`
--

INSERT INTO `objeto` (`id_objeto`, `nombre`, `descripcion`, `unidad`) VALUES
(33, 'Cemento', 'Cemento Argos', 'Paca de 20kg'),
(34, 'Arena', 'Arena arenitas', 'Paca de 20kg'),
(36, 'Puntillas', 'puntilla de 10cm', 'bolsa de 100'),
(37, 'Pintura', 'Marca pintuco', '2 litros');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `objeto_almacen`
--

CREATE TABLE `objeto_almacen` (
  `id_objeto_almacen` int(11) NOT NULL,
  `id_objeto` int(11) NOT NULL,
  `id_almacen` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `estado` varchar(15) NOT NULL,
  `propio_alquilado` varchar(11) NOT NULL,
  `observaciones` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `objeto_almacen`
--

INSERT INTO `objeto_almacen` (`id_objeto_almacen`, `id_objeto`, `id_almacen`, `cantidad`, `estado`, `propio_alquilado`, `observaciones`) VALUES
(1, 33, 34, 30, 'Bueno', 'Propio', 'cemento de bodega'),
(2, 34, 34, 11, 'Bueno', 'Propio', 'Arena con piedra'),
(3, 36, 35, 31, 'Bueno', 'Propio', 'puntillas de ferreteria'),
(4, 37, 34, 5, 'Bueno', 'Propio', 'Pintura color verde');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `objeto_almacen_prestamo`
--

CREATE TABLE `objeto_almacen_prestamo` (
  `id_objeto_almacen_prestamo` int(11) NOT NULL,
  `id_prestamo` int(11) NOT NULL,
  `id_objeto_almacen` int(11) NOT NULL,
  `cantidad` mediumint(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `objeto_almacen_prestamo`
--

INSERT INTO `objeto_almacen_prestamo` (`id_objeto_almacen_prestamo`, `id_prestamo`, `id_objeto_almacen`, `cantidad`) VALUES
(1, 1, 1, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `objeto_bodega`
--

CREATE TABLE `objeto_bodega` (
  `id_objeto_bodega` int(11) NOT NULL,
  `id_objeto` int(11) NOT NULL,
  `id_bodega` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `estado` varchar(15) NOT NULL,
  `observaciones` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `objeto_bodega`
--

INSERT INTO `objeto_bodega` (`id_objeto_bodega`, `id_objeto`, `id_bodega`, `cantidad`, `estado`, `observaciones`) VALUES
(1, 33, 1, 5, 'Bueno', 'de almacen');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `objeto_bodega_prestamo`
--

CREATE TABLE `objeto_bodega_prestamo` (
  `id_objeto_bodega_prestamo` int(11) NOT NULL,
  `id_prestamo` int(11) NOT NULL,
  `id_objeto_bodega` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `obra`
--

CREATE TABLE `obra` (
  `id_obra` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `direccion` varchar(35) NOT NULL,
  `telefono` varchar(18) NOT NULL,
  `id_ing_residente` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `obra`
--

INSERT INTO `obra` (`id_obra`, `nombre`, `direccion`, `telefono`, `id_ing_residente`, `fecha_inicio`, `fecha_fin`) VALUES
(12, 'Sevilla', 'sevilla 1324', '5799898', 2, '2019-11-22', NULL),
(13, 'Lopez', 'lopez123', '102121', 1, '2019-11-22', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `id_prestamo` int(11) NOT NULL,
  `id_bodega_origen` int(11) DEFAULT NULL,
  `id_bodega_destino` int(11) DEFAULT NULL,
  `id_almacen_origen` int(11) DEFAULT NULL,
  `id_almacen_destino` int(11) DEFAULT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(5) DEFAULT NULL,
  `id_almacenista` int(11) NOT NULL,
  `nombre_conductor` varchar(50) NOT NULL,
  `placa_vehiculo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`id_prestamo`, `id_bodega_origen`, `id_bodega_destino`, `id_almacen_origen`, `id_almacen_destino`, `fecha`, `hora`, `id_almacenista`, `nombre_conductor`, `placa_vehiculo`) VALUES
(1, 0, NULL, 34, 35, '2019-11-25', NULL, 1, 'Deprisa SA', ' xyz123');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`id_administrador`),
  ADD KEY `id_empleado` (`id_empleado`);

--
-- Indices de la tabla `almacen`
--
ALTER TABLE `almacen`
  ADD PRIMARY KEY (`id_almacen`),
  ADD KEY `id_obra` (`id_obra`),
  ADD KEY `id_almacenista` (`id_almacenista`);

--
-- Indices de la tabla `almacenista`
--
ALTER TABLE `almacenista`
  ADD PRIMARY KEY (`id_almacenista`),
  ADD KEY `id_empleado` (`id_empleado`);

--
-- Indices de la tabla `bodega`
--
ALTER TABLE `bodega`
  ADD PRIMARY KEY (`id_bodega`);

--
-- Indices de la tabla `control_objeto_almacen`
--
ALTER TABLE `control_objeto_almacen`
  ADD PRIMARY KEY (`id_control_objeto_almacen`),
  ADD KEY `id_objeto_almacen` (`id_objeto_almacen`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`id_empleado`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY (`id_equipo`),
  ADD KEY `id_objeto` (`id_objeto`);

--
-- Indices de la tabla `herramienta`
--
ALTER TABLE `herramienta`
  ADD PRIMARY KEY (`id_herramienta`),
  ADD KEY `id_objeto` (`id_objeto`);

--
-- Indices de la tabla `ing_residente`
--
ALTER TABLE `ing_residente`
  ADD PRIMARY KEY (`id_ing_residente`),
  ADD KEY `id_empleado` (`id_empleado`);

--
-- Indices de la tabla `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`id_material`),
  ADD KEY `id_objeto` (`id_objeto`);

--
-- Indices de la tabla `objeto`
--
ALTER TABLE `objeto`
  ADD PRIMARY KEY (`id_objeto`);

--
-- Indices de la tabla `objeto_almacen`
--
ALTER TABLE `objeto_almacen`
  ADD PRIMARY KEY (`id_objeto_almacen`),
  ADD KEY `id_objeto` (`id_objeto`),
  ADD KEY `id_almacen` (`id_almacen`);

--
-- Indices de la tabla `objeto_almacen_prestamo`
--
ALTER TABLE `objeto_almacen_prestamo`
  ADD PRIMARY KEY (`id_objeto_almacen_prestamo`),
  ADD KEY `id_prestamo` (`id_prestamo`),
  ADD KEY `id_objeto_almacen` (`id_objeto_almacen`);

--
-- Indices de la tabla `objeto_bodega`
--
ALTER TABLE `objeto_bodega`
  ADD PRIMARY KEY (`id_objeto_bodega`),
  ADD KEY `id_objeto` (`id_objeto`),
  ADD KEY `id_bodega` (`id_bodega`);

--
-- Indices de la tabla `objeto_bodega_prestamo`
--
ALTER TABLE `objeto_bodega_prestamo`
  ADD PRIMARY KEY (`id_objeto_bodega_prestamo`),
  ADD KEY `id_prestamo` (`id_prestamo`),
  ADD KEY `id_objeto_bodega` (`id_objeto_bodega`);

--
-- Indices de la tabla `obra`
--
ALTER TABLE `obra`
  ADD PRIMARY KEY (`id_obra`),
  ADD KEY `id_ing_residente` (`id_ing_residente`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`id_prestamo`),
  ADD KEY `id_bodega_origen` (`id_bodega_origen`),
  ADD KEY `id_bodega_destino` (`id_bodega_destino`),
  ADD KEY `id_almacen_origen` (`id_almacen_origen`),
  ADD KEY `id_almacen_destino` (`id_almacen_destino`),
  ADD KEY `id_almacenista` (`id_almacenista`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administrador`
--
ALTER TABLE `administrador`
  MODIFY `id_administrador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `almacen`
--
ALTER TABLE `almacen`
  MODIFY `id_almacen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de la tabla `almacenista`
--
ALTER TABLE `almacenista`
  MODIFY `id_almacenista` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `bodega`
--
ALTER TABLE `bodega`
  MODIFY `id_bodega` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `control_objeto_almacen`
--
ALTER TABLE `control_objeto_almacen`
  MODIFY `id_control_objeto_almacen` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `id_empleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `equipo`
--
ALTER TABLE `equipo`
  MODIFY `id_equipo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `herramienta`
--
ALTER TABLE `herramienta`
  MODIFY `id_herramienta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `ing_residente`
--
ALTER TABLE `ing_residente`
  MODIFY `id_ing_residente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `material`
--
ALTER TABLE `material`
  MODIFY `id_material` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de la tabla `objeto`
--
ALTER TABLE `objeto`
  MODIFY `id_objeto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT de la tabla `objeto_almacen`
--
ALTER TABLE `objeto_almacen`
  MODIFY `id_objeto_almacen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `objeto_almacen_prestamo`
--
ALTER TABLE `objeto_almacen_prestamo`
  MODIFY `id_objeto_almacen_prestamo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `objeto_bodega`
--
ALTER TABLE `objeto_bodega`
  MODIFY `id_objeto_bodega` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `objeto_bodega_prestamo`
--
ALTER TABLE `objeto_bodega_prestamo`
  MODIFY `id_objeto_bodega_prestamo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `obra`
--
ALTER TABLE `obra`
  MODIFY `id_obra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `id_prestamo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD CONSTRAINT `administrador_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`);

--
-- Filtros para la tabla `almacen`
--
ALTER TABLE `almacen`
  ADD CONSTRAINT `almacen_ibfk_1` FOREIGN KEY (`id_almacenista`) REFERENCES `almacenista` (`id_almacenista`),
  ADD CONSTRAINT `almacen_ibfk_2` FOREIGN KEY (`id_obra`) REFERENCES `obra` (`id_obra`);

--
-- Filtros para la tabla `almacenista`
--
ALTER TABLE `almacenista`
  ADD CONSTRAINT `almacenista_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`);

--
-- Filtros para la tabla `control_objeto_almacen`
--
ALTER TABLE `control_objeto_almacen`
  ADD CONSTRAINT `control_objeto_almacen_ibfk_1` FOREIGN KEY (`id_objeto_almacen`) REFERENCES `objeto_almacen` (`id_objeto_almacen`);

--
-- Filtros para la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD CONSTRAINT `equipo_ibfk_1` FOREIGN KEY (`id_objeto`) REFERENCES `objeto` (`id_objeto`);

--
-- Filtros para la tabla `herramienta`
--
ALTER TABLE `herramienta`
  ADD CONSTRAINT `herramienta_ibfk_1` FOREIGN KEY (`id_objeto`) REFERENCES `objeto` (`id_objeto`);

--
-- Filtros para la tabla `ing_residente`
--
ALTER TABLE `ing_residente`
  ADD CONSTRAINT `ing_residente_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`);

--
-- Filtros para la tabla `material`
--
ALTER TABLE `material`
  ADD CONSTRAINT `material_ibfk_1` FOREIGN KEY (`id_objeto`) REFERENCES `objeto` (`id_objeto`);

--
-- Filtros para la tabla `objeto_almacen`
--
ALTER TABLE `objeto_almacen`
  ADD CONSTRAINT `objeto_almacen_ibfk_2` FOREIGN KEY (`id_almacen`) REFERENCES `almacen` (`id_almacen`),
  ADD CONSTRAINT `objeto_almacen_ibfk_3` FOREIGN KEY (`id_objeto`) REFERENCES `objeto` (`id_objeto`);

--
-- Filtros para la tabla `objeto_almacen_prestamo`
--
ALTER TABLE `objeto_almacen_prestamo`
  ADD CONSTRAINT `objeto_almacen_prestamo_ibfk_1` FOREIGN KEY (`id_objeto_almacen`) REFERENCES `objeto_almacen` (`id_objeto_almacen`),
  ADD CONSTRAINT `objeto_almacen_prestamo_ibfk_2` FOREIGN KEY (`id_prestamo`) REFERENCES `prestamo` (`id_prestamo`);

--
-- Filtros para la tabla `objeto_bodega`
--
ALTER TABLE `objeto_bodega`
  ADD CONSTRAINT `objeto_bodega_ibfk_2` FOREIGN KEY (`id_bodega`) REFERENCES `bodega` (`id_bodega`),
  ADD CONSTRAINT `objeto_bodega_ibfk_3` FOREIGN KEY (`id_objeto`) REFERENCES `objeto` (`id_objeto`);

--
-- Filtros para la tabla `objeto_bodega_prestamo`
--
ALTER TABLE `objeto_bodega_prestamo`
  ADD CONSTRAINT `objeto_bodega_prestamo_ibfk_1` FOREIGN KEY (`id_prestamo`) REFERENCES `prestamo` (`id_prestamo`),
  ADD CONSTRAINT `objeto_bodega_prestamo_ibfk_2` FOREIGN KEY (`id_objeto_bodega`) REFERENCES `objeto_bodega` (`id_objeto_bodega`);

--
-- Filtros para la tabla `obra`
--
ALTER TABLE `obra`
  ADD CONSTRAINT `obra_ibfk_1` FOREIGN KEY (`id_ing_residente`) REFERENCES `ing_residente` (`id_ing_residente`);

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`id_bodega_destino`) REFERENCES `bodega` (`id_bodega`) ON DELETE CASCADE,
  ADD CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`id_almacen_origen`) REFERENCES `almacen` (`id_almacen`),
  ADD CONSTRAINT `prestamo_ibfk_3` FOREIGN KEY (`id_almacen_destino`) REFERENCES `almacen` (`id_almacen`),
  ADD CONSTRAINT `prestamo_ibfk_4` FOREIGN KEY (`id_almacenista`) REFERENCES `almacenista` (`id_almacenista`),
  ADD CONSTRAINT `prestamo_ibfk_5` FOREIGN KEY (`id_almacen_origen`) REFERENCES `almacen` (`id_almacen`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
