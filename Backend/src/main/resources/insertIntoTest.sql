insert into MOVIMIENTO (id, descripcion, monto) values
((SELECT HIBERNATE_SEQUENCE.NEXTVAL FROM DUAL), 'descripcion agregada', '345.32'),
((SELECT HIBERNATE_SEQUENCE.NEXTVAL FROM DUAL), 'descripcion agregada2', '123.32'),
((SELECT HIBERNATE_SEQUENCE.NEXTVAL FROM DUAL), 'descripcion agregada3', '234.32'),
((SELECT HIBERNATE_SEQUENCE.NEXTVAL FROM DUAL), 'descripcion agregada4', '345.32');