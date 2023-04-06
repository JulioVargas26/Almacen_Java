DROP SCHEMA IF EXISTS basa ;
CREATE SCHEMA IF NOT EXISTS basa_mysql;
USE basa_mysql ;

DROP TABLE IF EXISTS tb_tipo_insumo;
CREATE TABLE IF NOT EXISTS tb_tipo_insumo (
    id_insumo INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(100) NOT NULL 
)  AUTO_INCREMENT=1;

DROP TABLE IF EXISTS tb_serigrafiado ;
CREATE TABLE IF NOT EXISTS tb_serigrafiado (
  id_serigrafiado INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  tipo_insumo INT NOT NULL REFERENCES tb_tipo_insumo(id_insumo),
  cantSalida INT NOT NULL,
  guiaSalida VARCHAR(45) NOT NULL,
  cantIngreso INT NOT NULL,
  guiaIngreso VARCHAR(45) NOT NULL,
  merma INT NOT NULL,
  fecha DATE NOT NULL
) 
AUTO_INCREMENT = 1;


