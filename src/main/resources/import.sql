insert into roles (descripcion) values ('administrador');
insert into roles (descripcion) values ('empleado');


INSERT INTO usuarios (email, password, nombre, apellido, direccion, telefono, dni) VALUES ('avillanueva@unitru.edu.pe','$2a$10$Abw2fx8bb97LSM4SOB1D4.qU6PQWJy9jCOubDpcy6fLBkI0sNtXCi','ARTURO','VILLANUEVA','Bacilio pacheco El Bosque',978334357,74867266);
INSERT INTO usuarios (email, password, nombre, apellido, direccion, telefono, dni) VALUES ('mhernandezb@unitru.edu.pe','$2a$10$Abw2fx8bb97LSM4SOB1D4.qU6PQWJy9jCOubDpcy6fLBkI0sNtXCi','MARCOS','HERNANDEZ','Huanchaquito Las Ortencias',966210800,71238739);
INSERT INTO usuario_rol (usuario_id, rol_id) VALUES (1,1);
INSERT INTO usuario_rol (usuario_id, rol_id) VALUES (2,2);

insert into empresa (razon_social) values('BOBAGUS');

insert into lugar(descripcion) values ('TRUJILLO');
insert into lugar(descripcion) values ('LIMA');
insert into lugar(descripcion) values ('PIURA');
insert into lugar(descripcion) values ('TUMBES');
insert into lugar(descripcion) values ('CHICLAYO');

insert into sucursal (id_empresa, direccion, id_lugar) values (1,'TRUJILLO: Miraflores 123',1);
insert into sucursal (id_empresa, direccion, id_lugar) values (1,'LIMA: San Isidro 145',2);
insert into sucursal (id_empresa, direccion, id_lugar) values (1,'PIURA: Caguama 145',3);
insert into sucursal (id_empresa, direccion, id_lugar) values (1,'TUMBES: La Pileta 145',4);
insert into sucursal (id_empresa, direccion, id_lugar) values (1,'CHICLAYO: Las Ortencias 879',5);

insert into administrador (id_sucursal, usuario_id) values(1,1);
insert into empleado (id_sucursal, usuario_id) values(1,2);

insert into tipo_asiento(descripcion) values ('SEMI CAMA 140 GRADOS');
insert into tipo_asiento(descripcion) values ('SOFA CAMA 160 GRADOS');
insert into tipo_asiento(descripcion) values ('SUPER CAMA 180 GRADOS');

insert into plano(descripcion) values ('PISO 1');
insert into plano(descripcion) values ('PISO 2');

insert into ruta(id_lugar_origen, id_lugar_destino) values (1,2);
insert into ruta(id_lugar_origen, id_lugar_destino) values (1,3);
insert into ruta(id_lugar_origen, id_lugar_destino) values (1,4);
insert into ruta(id_lugar_origen, id_lugar_destino) values (1,5);

insert into ruta(id_lugar_origen, id_lugar_destino) values (2,1);
insert into ruta(id_lugar_origen, id_lugar_destino) values (2,3);
insert into ruta(id_lugar_origen, id_lugar_destino) values (2,4);
insert into ruta(id_lugar_origen, id_lugar_destino) values (2,5);

insert into ruta(id_lugar_origen, id_lugar_destino) values (3,1);
insert into ruta(id_lugar_origen, id_lugar_destino) values (3,2);
insert into ruta(id_lugar_origen, id_lugar_destino) values (3,4);
insert into ruta(id_lugar_origen, id_lugar_destino) values (3,5);

insert into ruta(id_lugar_origen, id_lugar_destino) values (4,1);
insert into ruta(id_lugar_origen, id_lugar_destino) values (4,2);
insert into ruta(id_lugar_origen, id_lugar_destino) values (4,3);
insert into ruta(id_lugar_origen, id_lugar_destino) values (4,5);

insert into ruta(id_lugar_origen, id_lugar_destino) values (5,1);
insert into ruta(id_lugar_origen, id_lugar_destino) values (5,2);
insert into ruta(id_lugar_origen, id_lugar_destino) values (5,3);
insert into ruta(id_lugar_origen, id_lugar_destino) values (5,4);


insert into bus(nro_placa) values ('ABC-123');
insert into bus(nro_placa) values ('DEF-456');
insert into bus(nro_placa) values ('GHI-789');
insert into bus(nro_placa) values ('JKL-101');


insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,1);

insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,1,70,'disponible',1,1);


insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,1,70,'disponible',1,2);

insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,2);

insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,3);

insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,2,90,'disponible',1,3);

insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (1,2,90,'disponible',1,4);

insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,3,120,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,3,120,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,3,120,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,3,120,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,3,120,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,3,120,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,3,120,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,3,120,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,3,120,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,3,120,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,3,120,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,3,120,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,3,120,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,3,120,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,3,120,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,3,120,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,3,120,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,3,120,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,3,120,'disponible',1,4);
insert into asiento(id_plano, id_tipo_asiento, costo, estado, descuento, id_bus) values (2,3,120,'disponible',1,4);

insert into cronograma_viaje(id_bus, id_ruta, fecha_salida, hora_salida, fecha_llegada, hora_aprox_llegada) values (1,1,'2022-09-01','21:00:00', '2022-09-02', '05:00:00');
insert into cronograma_viaje(id_bus, id_ruta, fecha_salida, hora_salida, fecha_llegada, hora_aprox_llegada) values (2,1,'2022-09-01','22:00:00', '2022-09-02', '06:00:00');

insert into cronograma_viaje(id_bus, id_ruta, fecha_salida, hora_salida, fecha_llegada, hora_aprox_llegada) values (3,5,'2022-09-03','19:00:00', '2022-09-04', '03:00:00');
insert into cronograma_viaje(id_bus, id_ruta, fecha_salida, hora_salida, fecha_llegada, hora_aprox_llegada) values (4,5,'2022-09-03','20:00:00', '2022-09-04', '04:00:00');

insert into bus_sucursal(id_bus,id_sucursal,activo) values (1,1,false);
insert into bus_sucursal(id_bus,id_sucursal,activo) values (1,2,false);
insert into bus_sucursal(id_bus,id_sucursal,activo) values (1,3,false);
insert into bus_sucursal(id_bus,id_sucursal,activo) values (1,4,false);
insert into bus_sucursal(id_bus,id_sucursal,activo) values (1,5,false);

insert into bus_sucursal(id_bus,id_sucursal,activo) values (2,1,false);
insert into bus_sucursal(id_bus,id_sucursal,activo) values (2,2,false);
insert into bus_sucursal(id_bus,id_sucursal,activo) values (2,3,false);
insert into bus_sucursal(id_bus,id_sucursal,activo) values (2,4,false);
insert into bus_sucursal(id_bus,id_sucursal,activo) values (2,5,false);

insert into bus_sucursal(id_bus,id_sucursal,activo) values (3,1,false);
insert into bus_sucursal(id_bus,id_sucursal,activo) values (3,2,false);
insert into bus_sucursal(id_bus,id_sucursal,activo) values (3,3,false);
insert into bus_sucursal(id_bus,id_sucursal,activo) values (3,4,false);
insert into bus_sucursal(id_bus,id_sucursal,activo) values (3,5,false);

insert into bus_sucursal(id_bus,id_sucursal,activo) values (4,1,false);
insert into bus_sucursal(id_bus,id_sucursal,activo) values (4,2,false);
insert into bus_sucursal(id_bus,id_sucursal,activo) values (4,3,false);
insert into bus_sucursal(id_bus,id_sucursal,activo) values (4,4,false);
insert into bus_sucursal(id_bus,id_sucursal,activo) values (4,5,false);

insert into cliente(nro_documento,nombres,apellido_paterno,apellido_materno,sexo,fecha_nacimiento,telefono,email) values ('71238739','Marcos Ivan','Hernández','Barba','M','2000-07-02','966210800','mhernandezb@unitru.edu.pe');
insert into cliente(nro_documento,nombres,apellido_paterno,apellido_materno,sexo,fecha_nacimiento,telefono,email) values ('71238740','Gustavo Enrique','Piminchumo','Olivos','M','2000-06-02','966210801','pimol@unitru.edu.pe');
insert into cliente(nro_documento,nombres,apellido_paterno,apellido_materno,sexo,fecha_nacimiento,telefono,email) values ('71238741','Luis Antonio','Guevara','Aredo','M','2000-05-25','966210802','lguevara@unitru.edu.pe');
 




