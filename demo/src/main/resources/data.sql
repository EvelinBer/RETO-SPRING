    -- IF NOT EXIST ES PORQUE GARANTIZA QUE SE CREE LA TABLA SI LA ENTIDAD LLEGA A FALLAR
    --Y ASI NO SE GENERA ERROR AL INTENTAR INSERTAR DATOS A UNA TABLA QUE NO EXISTE
    CREATE TABLE IF NOT EXISTS 
fases
(
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(40) NOT NULL,
    PRIMARY KEY (id)
    );
-- INSERT INGNORE INTO INSERTA LOS DATOS PERO SI ESTOS YA EXISTEN SOLO LOS IGNORA
INSERT IGNORE INTO fases (id, nombre) VALUES
(1, 'PENDIENTE'),
(2, 'EN_PREPARACION'),
(3, 'CANCELADO'),
(4, 'LISTO'),
(5, 'ENTREGADO');

CREATE TABLE IF NOT EXISTS 
rol
(
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(40) NOT NULL,
    PRIMARY KEY (id)
    );
    -- INSERT INGNORE INTO INSERTA LOS DATOS PERO SI ESTOS YA EXISTEN SOLO LOS IGNORA
INSERT IGNORE INTO rol (id, nombre) VALUES
(1,'ADMINISTRADOR'),
(2,'PROPIETARIO'),
(3,'CLIENTE'),
(4,'EMPLEADO');

-- -- USUARIOS DE PRUEBA (password para todos: admin123)
-- INSERT IGNORE INTO usuario (id, nombre, apellido, telefono, documento, fecha_nacimiento, email, password) VALUES
-- (1, 'Admin', 'Sistema', '+573001234567', '1000000001', '1990-01-01', 'admin@reto.com', '$2a$10$N9qo8uLOickgx2ZMRZoMye7J962M3LJjj3GkcKfmGzgn5Y.rE.YYe'),
-- (2, 'Propietario', 'Restaurante', '+573001234568', '1000000002', '1985-05-15', 'propietario@reto.com', '$2a$10$N9qo8uLOickgx2ZMRZoMye7J962M3LJjj3GkcKfmGzgn5Y.rE.YYe'),
-- (3, 'Empleado', 'Restaurante', '+573001234569', '1000000003', '1995-10-20', 'empleado@reto.com', '$2a$10$N9qo8uLOickgx2ZMRZoMye7J962M3LJjj3GkcKfmGzgn5Y.rE.YYe'),
-- (4, 'Cliente', 'Prueba', '+573001234570', '1000000004', '2000-03-25', 'cliente@reto.com', '$2a$10$N9qo8uLOickgx2ZMRZoMye7J962M3LJjj3GkcKfmGzgn5Y.rE.YYe');

-- -- ASIGNAR ROLES A USUARIOS
-- INSERT IGNORE INTO rol_usuario (id, usuario_id, rol_id) VALUES
-- (1, 1, 1),
-- (2, 2, 2),
-- (3, 3, 4),
-- (4, 4, 3);
