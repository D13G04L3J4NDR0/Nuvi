-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-06-2018 a las 04:24:00
-- Versión del servidor: 10.1.30-MariaDB
-- Versión de PHP: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `nuvi`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarEstadosCasos` ()  SELECT * FROM CASOS WHERE fk_Estado_Caso = 1$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listarMaterialesRequeridos` (`cod_proyecto` INT)  SELECT * FROM materiales_proyecto
WHERE fk_Proyecto=cod_proyecto$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listarMaterialesRequeridosString` (`cod` VARCHAR(45))  SELECT * FROM materiales_proyecto
left JOIN proyectos ON
proyectos.id_Proyecto =  materiales_proyecto.fk_Proyecto
WHERE proyectos.cod_proyecto = cod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listarProyectosPorEstado` (`estado` VARCHAR(45))  SELECT * FROM proyectos WHERE proyectos.Estado_Proyecto = estado$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sumarTotales` (`cod` VARCHAR(45))  SELECT materiales_proyecto.Valor_Total FROM nuvi.materiales_proyecto
INNER JOIN proyectos on proyectos.id_Proyecto = materiales_proyecto.fk_Proyecto 
WHERE proyectos.cod_proyecto = cod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sumarTotalesDos` (`cod` VARCHAR(45))  SELECT sum(materiales_proyecto.Valor_Total) FROM materiales_proyecto
left JOIN proyectos ON
proyectos.id_Proyecto =  materiales_proyecto.fk_Proyecto
WHERE proyectos.cod_proyecto = cod$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `donaciones`
--

CREATE TABLE `donaciones` (
  `id_Donacion` int(11) NOT NULL,
  `Valor_Donacion` int(11) DEFAULT NULL,
  `Fecha_Donacion` date DEFAULT NULL,
  `fk_Proyecto` int(11) DEFAULT NULL,
  `img_Comporbante` varchar(45) DEFAULT NULL,
  `fk_Donador` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `donador`
--

CREATE TABLE `donador` (
  `id_Donador` int(11) NOT NULL,
  `nombre_Donador` varchar(45) DEFAULT NULL,
  `fk_TipoDocum` int(11) DEFAULT NULL,
  `Docu_Donador` int(11) DEFAULT NULL,
  `fecha_Ingreso` date DEFAULT NULL,
  `Contac_Donador` varchar(45) DEFAULT NULL,
  `Email_Donador` varchar(45) DEFAULT NULL,
  `Direccion_Residencia` varchar(30) DEFAULT NULL,
  `Ciudad_Residencia` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `donador`
--

INSERT INTO `donador` (`id_Donador`, `nombre_Donador`, `fk_TipoDocum`, `Docu_Donador`, `fecha_Ingreso`, `Contac_Donador`, `Email_Donador`, `Direccion_Residencia`, `Ciudad_Residencia`) VALUES
(1, 'Camilo Torres', NULL, 98887777, NULL, '(888) 888-8888', 'alejo@gmail.com', 'Cl 1234', 'Bogota'),
(2, 'Diego Leguizamon', NULL, 9090909, NULL, '(888) 888-8888', 'alejo@gmail.com', 'Cl 123', 'Bogota'),
(3, 'Carlos', NULL, 12345111, NULL, '(315) 345-5677', 'nhrodrigueza@misena.edu.co', 'calle123', 'Bogota'),
(4, 'Diego Leguizamon', NULL, 1019077632, NULL, '(155) 151-5155', 'alejandrohuertas@gmail.com', 'Cr 454', 'Bogota'),
(5, 'Camilo Lopezz', NULL, 1011907756, NULL, '(115) 151-5111', 'alejandrohuertas@gmail.com', 'Cl 123', 'Cali'),
(6, 'Camilo', NULL, 454645454, NULL, '(454) 554-5454', 'alejandrohuertas@gmail.com', 'CL 4564646', 'Bogota'),
(7, 'fds', NULL, 121212121, NULL, '(121) 212-1212', 'alejandrohuertas@gmail.com', 'Cl 12121', 'bogota');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `familias`
--

CREATE TABLE `familias` (
  `id_Familia` int(11) NOT NULL,
  `Nombre_Cde_Familia` varchar(45) DEFAULT NULL,
  `Apellido_Cde_Familia` varchar(45) DEFAULT NULL,
  `Fecha_Visita` date DEFAULT NULL,
  `fk_TipoDocum` int(11) DEFAULT NULL,
  `Docum_Cde_Familia` varchar(45) DEFAULT NULL,
  `Integrantes_Familia` int(11) DEFAULT NULL,
  `Barrio_Familia` varchar(45) DEFAULT NULL,
  `Direccion_Familia` varchar(45) DEFAULT NULL,
  `ciudad_Familia` varchar(45) DEFAULT NULL,
  `fk_Problematica` int(11) DEFAULT NULL,
  `imgHogar` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `familias`
--

INSERT INTO `familias` (`id_Familia`, `Nombre_Cde_Familia`, `Apellido_Cde_Familia`, `Fecha_Visita`, `fk_TipoDocum`, `Docum_Cde_Familia`, `Integrantes_Familia`, `Barrio_Familia`, `Direccion_Familia`, `ciudad_Familia`, `fk_Problematica`, `imgHogar`) VALUES
(1, 'Camilo', 'Ortega', '2018-06-07', 1, '101907778855', 4, 'Villa', 'Kr 123456', 'Bogotá', 2, NULL),
(2, 'Parra', 'Perez', '2018-06-07', 1, '45446545454', 4, 'Villa', 'Cl454545', 'fsdfas', 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materiales`
--

CREATE TABLE `materiales` (
  `id_Material` int(11) NOT NULL,
  `Nombre_Material` varchar(45) DEFAULT NULL,
  `Unidad_Medida` varchar(10) DEFAULT NULL,
  `Descripcion` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `materiales`
--

INSERT INTO `materiales` (`id_Material`, `Nombre_Material`, `Unidad_Medida`, `Descripcion`) VALUES
(1, 'Madera', '10', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materiales_proyecto`
--

CREATE TABLE `materiales_proyecto` (
  `id_Material_Proyecto` int(11) NOT NULL,
  `fk_Proyecto` int(11) DEFAULT NULL,
  `fk_Material` int(11) DEFAULT NULL,
  `Cantidad_Material` float DEFAULT NULL,
  `Valor_Unitario` float DEFAULT NULL,
  `Valor_Total` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `materiales_proyecto`
--

INSERT INTO `materiales_proyecto` (`id_Material_Proyecto`, `fk_Proyecto`, `fk_Material`, `Cantidad_Material`, `Valor_Unitario`, `Valor_Total`) VALUES
(2, 4, 1, 10, 1000, 10000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisos`
--

CREATE TABLE `permisos` (
  `id_Permiso` int(11) NOT NULL,
  `Nombre_Permiso` varchar(100) DEFAULT NULL,
  `url` text,
  `icon` varchar(45) DEFAULT NULL,
  `Permiso_padre` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `permisos`
--

INSERT INTO `permisos` (`id_Permiso`, `Nombre_Permiso`, `url`, `icon`, `Permiso_padre`) VALUES
(1, 'Gestión de Proyectos', NULL, 'fa fa-child', NULL),
(2, 'Iniciar Proyecto', '../Proyectos/RegistroProyecto.xhtml', 'fa fa-angle-double-right', 1),
(3, 'Gestión de Familias', NULL, 'fas fa-users', NULL),
(4, 'Registro de familias', '../Familias/RegistroFamilia.xhtml', 'fa fa-angle-double-right', 3),
(5, 'Cerrar proyecto', '../Proyectos/CerrarProyecto.xhtml', 'fa fa-angle-double-right', 1),
(6, 'Generar reportes', '../Grafica/GraficaTProblematicas.xhtml', 'fa fa-angle-double-right', NULL),
(7, 'Asignar costo a materiales', '../Proyectos/CostoMaterial.xhtml', 'fa fa-angle-double-right', 1),
(8, 'Consultas', NULL, NULL, NULL),
(9, 'Lista Proyectos', '../Proyectos/ListaProyectos.xhtml', 'fa fa-angle-double-right', 8),
(10, 'Reportes', NULL, 'fa fa-angle-double-right', NULL),
(11, 'Problematicas', '../Grafica/GraficaTProblematicas.xhtml', 'fa fa-angle-double-right', 10),
(12, 'Gestión de Voluntarios', NULL, 'fa fa-angle-double-right', NULL),
(13, 'Registro de Personal Contratado', '../Voluntarios/RegistrarPersonalContratado.xhtml', NULL, 12),
(14, 'Asignación de Personal', '../Voluntarios/ListaVoluntarios.xhtml', NULL, 12),
(15, 'Gestión de Donaciones', NULL, 'fas fa-hand-holding-heart', NULL),
(16, 'Asignación de Donaciones', '../Donaciones/ListaDonaciones.xhtml', NULL, 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisosroles`
--

CREATE TABLE `permisosroles` (
  `fk_Rol` int(11) DEFAULT NULL,
  `fk_Permiso` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `permisosroles`
--

INSERT INTO `permisosroles` (`fk_Rol`, `fk_Permiso`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(2, 1),
(2, 7),
(1, 8),
(1, 9),
(1, 10),
(1, 11),
(2, 12),
(2, 13),
(2, 14),
(2, 15),
(2, 16);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personal`
--

CREATE TABLE `personal` (
  `id_personal` int(11) NOT NULL,
  `Nombre_Personal` varchar(45) DEFAULT NULL,
  `Apellido_Personal` varchar(45) DEFAULT NULL,
  `Profesion_Personal` varchar(45) DEFAULT NULL,
  `fecha_Nacimiento` date DEFAULT NULL,
  `fecha_ingreso` date DEFAULT NULL,
  `Categoria_Personal` varchar(45) DEFAULT NULL,
  `fk_TipoDocum` int(11) DEFAULT NULL,
  `Docum_Personal` varchar(45) DEFAULT NULL,
  `Contac_Personal` varchar(45) DEFAULT NULL,
  `Email_Personal` varchar(45) DEFAULT NULL,
  `Costo` int(11) DEFAULT NULL,
  `Disponibilidad` varchar(45) DEFAULT NULL,
  `fk_Proyecto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `personal`
--

INSERT INTO `personal` (`id_personal`, `Nombre_Personal`, `Apellido_Personal`, `Profesion_Personal`, `fecha_Nacimiento`, `fecha_ingreso`, `Categoria_Personal`, `fk_TipoDocum`, `Docum_Personal`, `Contac_Personal`, `Email_Personal`, `Costo`, `Disponibilidad`, `fk_Proyecto`) VALUES
(1, 'fasdf', '', '', NULL, NULL, '', NULL, '', '', '', NULL, '', NULL),
(2, 'klkjkj', '', '', NULL, NULL, '', NULL, '', '', '', NULL, '', NULL),
(3, 'gsdfg', 'gdsfg', 'gdsfg', '2018-06-05', NULL, 'Voluntario', NULL, '4747474', '(474) 747-4747', 'alejandrohuertas1992@gmail.com', NULL, 'Disponible', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `problematicas`
--

CREATE TABLE `problematicas` (
  `id_Problematica` int(11) NOT NULL,
  `Problematica` varchar(45) DEFAULT NULL,
  `Detalle_Problematica` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `problematicas`
--

INSERT INTO `problematicas` (`id_Problematica`, `Problematica`, `Detalle_Problematica`) VALUES
(1, 'Violencia Familias', NULL),
(2, 'Salubridad', NULL),
(3, 'Espacios no adecuados', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyectos`
--

CREATE TABLE `proyectos` (
  `id_Proyecto` int(11) NOT NULL,
  `cod_proyecto` varchar(15) DEFAULT NULL,
  `Nombre_Proyecto` varchar(45) DEFAULT NULL,
  `FechaInicio_Proyecto` date DEFAULT NULL,
  `FechaFin_Proyecto` date DEFAULT NULL,
  `Costo_Material` float DEFAULT NULL,
  `Costo_Personal` float DEFAULT NULL,
  `Costo_Proyecto` float DEFAULT NULL,
  `Cantidad_Voluntarios` int(11) DEFAULT NULL,
  `Dinero_Recaudado` float DEFAULT NULL,
  `Solucion_Proyecto` varchar(1000) DEFAULT NULL,
  `fk_Familia` int(11) DEFAULT NULL,
  `Estado_Proyecto` varchar(10) DEFAULT NULL,
  `imgCierreProyecto` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `proyectos`
--

INSERT INTO `proyectos` (`id_Proyecto`, `cod_proyecto`, `Nombre_Proyecto`, `FechaInicio_Proyecto`, `FechaFin_Proyecto`, `Costo_Material`, `Costo_Personal`, `Costo_Proyecto`, `Cantidad_Voluntarios`, `Dinero_Recaudado`, `Solucion_Proyecto`, `fk_Familia`, `Estado_Proyecto`, `imgCierreProyecto`) VALUES
(1, 'COD1', 'Remodelación Familia Ortega Bosa', '2018-06-17', '2018-06-21', NULL, NULL, NULL, 5, NULL, 'Adecuación de habitaciones, baño y cocina.', 1, 'Creado', NULL),
(2, 'COD2', 'Casa nueva', '2018-06-06', '2018-06-14', NULL, NULL, NULL, 5, NULL, 'Casa nueva de la famila Ortega', 1, 'Creado', NULL),
(3, 'COD3', 'fsdf', '2018-06-17', '2018-06-19', NULL, NULL, NULL, 5, NULL, 'jljlkjlk', 1, 'Creado', NULL),
(4, 'COD4', 'gjhgjh', '2018-06-17', '2018-06-28', NULL, NULL, NULL, 5, NULL, 'fsdfasdfas', 2, 'Creado', NULL),
(5, 'cdsfds', 'fsadfa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', NULL, '', NULL),
(6, 'fasdfa', 'fsadf', '2018-06-01', '2018-06-13', NULL, NULL, NULL, 34, NULL, 'fasdfa', 2, 'Creado', NULL),
(7, 'fasdf', 'fasdf', '2018-06-14', '2018-06-21', NULL, NULL, NULL, 4, NULL, 'fasdf', 2, 'Creado', NULL),
(8, NULL, NULL, NULL, NULL, 10000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyectos_usuarios`
--

CREATE TABLE `proyectos_usuarios` (
  `id_Proyecto_Usuario` int(11) NOT NULL,
  `fk_Proyecto` int(11) DEFAULT NULL,
  `fk_Usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id_Rol` int(11) NOT NULL,
  `Nombre_Rol` varchar(45) DEFAULT NULL,
  `Detalle_Rol` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id_Rol`, `Nombre_Rol`, `Detalle_Rol`) VALUES
(1, 'Adm Proyectos', NULL),
(2, 'Adm Costos', NULL),
(3, 'Adm Sistema', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodocumentos`
--

CREATE TABLE `tipodocumentos` (
  `id_TipoDocum` int(11) NOT NULL,
  `Tipo_Docum` varchar(10) DEFAULT NULL,
  `Descripcion` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipodocumentos`
--

INSERT INTO `tipodocumentos` (`id_TipoDocum`, `Tipo_Docum`, `Descripcion`) VALUES
(1, 'CC', 'Cedula de ciudadania');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_Usuario` int(11) NOT NULL,
  `Nombre_Usuario` varchar(45) DEFAULT NULL,
  `Apellido_Usuario` varchar(45) DEFAULT NULL,
  `fk_TipoDocum` int(11) DEFAULT NULL,
  `Docum_Usuario` int(11) DEFAULT NULL,
  `Clave_Usuario` varchar(45) DEFAULT NULL,
  `Contac_Usuario` varchar(45) DEFAULT NULL,
  `Email_Usuario` varchar(45) DEFAULT NULL,
  `Estado` int(11) DEFAULT NULL,
  `fk_roles` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_Usuario`, `Nombre_Usuario`, `Apellido_Usuario`, `fk_TipoDocum`, `Docum_Usuario`, `Clave_Usuario`, `Contac_Usuario`, `Email_Usuario`, `Estado`, `fk_roles`) VALUES
(1, 'Cindy Julieth', 'Carlos', 1, 1, '1', '9898989', 'j@gmail.com', NULL, 1),
(2, 'Diego Alejandro', 'Leguizamón', 1, 2, '2', '6555656', 'd@gmail.com', NULL, 2),
(3, 'Jose Enrique', 'Casteblanco', 1, 3, '3', '5545555', 'je@gmail.com', NULL, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `donaciones`
--
ALTER TABLE `donaciones`
  ADD PRIMARY KEY (`id_Donacion`),
  ADD KEY `fk_Proyecto` (`fk_Proyecto`),
  ADD KEY `donaciones_ibfk_2` (`fk_Donador`);

--
-- Indices de la tabla `donador`
--
ALTER TABLE `donador`
  ADD PRIMARY KEY (`id_Donador`),
  ADD KEY `fk_TipoDocum` (`fk_TipoDocum`);

--
-- Indices de la tabla `familias`
--
ALTER TABLE `familias`
  ADD PRIMARY KEY (`id_Familia`),
  ADD KEY `fk_TipoDocum` (`fk_TipoDocum`),
  ADD KEY `fk_Problematica` (`fk_Problematica`);

--
-- Indices de la tabla `materiales`
--
ALTER TABLE `materiales`
  ADD PRIMARY KEY (`id_Material`);

--
-- Indices de la tabla `materiales_proyecto`
--
ALTER TABLE `materiales_proyecto`
  ADD PRIMARY KEY (`id_Material_Proyecto`),
  ADD KEY `fk_Material` (`fk_Material`),
  ADD KEY `fk_Proyecto` (`fk_Proyecto`);

--
-- Indices de la tabla `permisos`
--
ALTER TABLE `permisos`
  ADD PRIMARY KEY (`id_Permiso`),
  ADD KEY `Permiso_padre` (`Permiso_padre`);

--
-- Indices de la tabla `permisosroles`
--
ALTER TABLE `permisosroles`
  ADD KEY `fk_Rol` (`fk_Rol`),
  ADD KEY `fk_Permiso` (`fk_Permiso`);

--
-- Indices de la tabla `personal`
--
ALTER TABLE `personal`
  ADD PRIMARY KEY (`id_personal`),
  ADD KEY `fk_TipoDocum` (`fk_TipoDocum`),
  ADD KEY `fk_Proyecto` (`fk_Proyecto`);

--
-- Indices de la tabla `problematicas`
--
ALTER TABLE `problematicas`
  ADD PRIMARY KEY (`id_Problematica`);

--
-- Indices de la tabla `proyectos`
--
ALTER TABLE `proyectos`
  ADD PRIMARY KEY (`id_Proyecto`),
  ADD KEY `fk_Familia` (`fk_Familia`);

--
-- Indices de la tabla `proyectos_usuarios`
--
ALTER TABLE `proyectos_usuarios`
  ADD PRIMARY KEY (`id_Proyecto_Usuario`),
  ADD KEY `fk_Proyecto` (`fk_Proyecto`),
  ADD KEY `fk_Usuario` (`fk_Usuario`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_Rol`);

--
-- Indices de la tabla `tipodocumentos`
--
ALTER TABLE `tipodocumentos`
  ADD PRIMARY KEY (`id_TipoDocum`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_Usuario`),
  ADD KEY `fk_TipoDocum` (`fk_TipoDocum`),
  ADD KEY `fk_roles` (`fk_roles`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `donaciones`
--
ALTER TABLE `donaciones`
  MODIFY `id_Donacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `donador`
--
ALTER TABLE `donador`
  MODIFY `id_Donador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `familias`
--
ALTER TABLE `familias`
  MODIFY `id_Familia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `materiales`
--
ALTER TABLE `materiales`
  MODIFY `id_Material` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `materiales_proyecto`
--
ALTER TABLE `materiales_proyecto`
  MODIFY `id_Material_Proyecto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `personal`
--
ALTER TABLE `personal`
  MODIFY `id_personal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `problematicas`
--
ALTER TABLE `problematicas`
  MODIFY `id_Problematica` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `proyectos`
--
ALTER TABLE `proyectos`
  MODIFY `id_Proyecto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `proyectos_usuarios`
--
ALTER TABLE `proyectos_usuarios`
  MODIFY `id_Proyecto_Usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id_Rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tipodocumentos`
--
ALTER TABLE `tipodocumentos`
  MODIFY `id_TipoDocum` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_Usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `donaciones`
--
ALTER TABLE `donaciones`
  ADD CONSTRAINT `donaciones_ibfk_1` FOREIGN KEY (`fk_Proyecto`) REFERENCES `proyectos` (`id_Proyecto`),
  ADD CONSTRAINT `donaciones_ibfk_2` FOREIGN KEY (`fk_Donador`) REFERENCES `donador` (`id_Donador`);

--
-- Filtros para la tabla `donador`
--
ALTER TABLE `donador`
  ADD CONSTRAINT `donador_ibfk_1` FOREIGN KEY (`fk_TipoDocum`) REFERENCES `tipodocumentos` (`id_TipoDocum`);

--
-- Filtros para la tabla `familias`
--
ALTER TABLE `familias`
  ADD CONSTRAINT `familias_ibfk_1` FOREIGN KEY (`fk_TipoDocum`) REFERENCES `tipodocumentos` (`id_TipoDocum`),
  ADD CONSTRAINT `familias_ibfk_2` FOREIGN KEY (`fk_Problematica`) REFERENCES `problematicas` (`id_Problematica`);

--
-- Filtros para la tabla `materiales_proyecto`
--
ALTER TABLE `materiales_proyecto`
  ADD CONSTRAINT `materiales_proyecto_ibfk_1` FOREIGN KEY (`fk_Material`) REFERENCES `materiales` (`id_Material`),
  ADD CONSTRAINT `materiales_proyecto_ibfk_2` FOREIGN KEY (`fk_Proyecto`) REFERENCES `proyectos` (`id_Proyecto`);

--
-- Filtros para la tabla `permisos`
--
ALTER TABLE `permisos`
  ADD CONSTRAINT `permisos_ibfk_1` FOREIGN KEY (`Permiso_padre`) REFERENCES `permisos` (`id_Permiso`);

--
-- Filtros para la tabla `permisosroles`
--
ALTER TABLE `permisosroles`
  ADD CONSTRAINT `permisosroles_ibfk_1` FOREIGN KEY (`fk_Rol`) REFERENCES `roles` (`id_Rol`),
  ADD CONSTRAINT `permisosroles_ibfk_2` FOREIGN KEY (`fk_Permiso`) REFERENCES `permisos` (`id_Permiso`);

--
-- Filtros para la tabla `personal`
--
ALTER TABLE `personal`
  ADD CONSTRAINT `personal_ibfk_1` FOREIGN KEY (`fk_TipoDocum`) REFERENCES `tipodocumentos` (`id_TipoDocum`),
  ADD CONSTRAINT `personal_ibfk_2` FOREIGN KEY (`fk_Proyecto`) REFERENCES `proyectos` (`id_Proyecto`);

--
-- Filtros para la tabla `proyectos`
--
ALTER TABLE `proyectos`
  ADD CONSTRAINT `proyectos_ibfk_1` FOREIGN KEY (`fk_Familia`) REFERENCES `familias` (`id_Familia`);

--
-- Filtros para la tabla `proyectos_usuarios`
--
ALTER TABLE `proyectos_usuarios`
  ADD CONSTRAINT `proyectos_usuarios_ibfk_1` FOREIGN KEY (`fk_Proyecto`) REFERENCES `proyectos` (`id_Proyecto`),
  ADD CONSTRAINT `proyectos_usuarios_ibfk_2` FOREIGN KEY (`fk_Usuario`) REFERENCES `usuarios` (`id_Usuario`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`fk_TipoDocum`) REFERENCES `tipodocumentos` (`id_TipoDocum`),
  ADD CONSTRAINT `usuarios_ibfk_2` FOREIGN KEY (`fk_roles`) REFERENCES `roles` (`id_Rol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
