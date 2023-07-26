INSERT INTO Usuarios(usu_nombre, usu_apellido, usu_correo, usu_password, usu_perfil_acceso, usu_cedula) 
VALUES ('admin', 'admin', 'admin@edu.ec', 'admin', 'Ad', '0105524584');

INSERT INTO Empleados(usu_id, emp_cargo, emp_area_trabajo)
VALUES (1, 'Administrador', 'Administracion');

INSERT INTO Usuarios(usu_nombre, usu_apellido, usu_correo, usu_password, usu_perfil_acceso, usu_cedula) 
VALUES ('Cristina', 'Lopez', 'cristinal@edu.ec', '12345', 'Em', '0105524744');

INSERT INTO Empleados(usu_id, emp_cargo, emp_area_trabajo)
VALUES (2, 'Secretario', 'Marketing');

INSERT INTO Usuarios(usu_nombre, usu_apellido, usu_correo, usu_password, usu_perfil_acceso, usu_cedula) 
VALUES ('Adrian', 'Lopez', 'adrianl@edu.ec', '12345', 'Do', '0104724744');

INSERT INTO Profesores(usu_id, pro_especialidad)
VALUES (3, 'Matematicas');

INSERT INTO Usuarios(usu_nombre, usu_apellido, usu_correo, usu_password, usu_perfil_acceso, usu_cedula) 
VALUES ('Marcos', 'Pacheco', 'marcosl@edu.ec', '12345ma', 'ES', '0104724781');

INSERT INTO Estudiantes(usu_id, est_grado_academico)
VALUES (4, 'Postgrado');