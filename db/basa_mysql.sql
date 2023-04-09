-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema basa_mysql
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `basa_mysql` ;

-- -----------------------------------------------------
-- Schema basa_mysql
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `basa_mysql` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
-- -----------------------------------------------------
-- Schema clinica_kvbe_2023_1
-- -----------------------------------------------------
USE `basa_mysql` ;

-- -----------------------------------------------------
-- Table `basa_mysql`.`tb_tipo_insumo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basa_mysql`.`tb_tipo_insumo` ;

CREATE TABLE IF NOT EXISTS `basa_mysql`.`tb_tipo_insumo` (
  `id_insumo` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id_insumo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `basa_mysql`.`tb_serigrafiado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basa_mysql`.`tb_serigrafiado` ;

CREATE TABLE IF NOT EXISTS `basa_mysql`.`tb_serigrafiado` (
  `id_serigrafiado` INT NOT NULL AUTO_INCREMENT,
  `cant_Salida` INT NULL DEFAULT NULL,
  `guia_Salida` VARCHAR(45) NULL DEFAULT NULL,
  `cant_Ingreso` INT NULL DEFAULT NULL,
  `guia_Ingreso` VARCHAR(45) NULL DEFAULT NULL,
  `merma` INT NULL DEFAULT NULL,
  `fecha` DATE NULL DEFAULT NULL,
  `tipo_insumo` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id_serigrafiado`),
  INDEX `fk_tipo_serigrafiado` (`tipo_insumo` ASC) VISIBLE,
  CONSTRAINT `fk_tb_serigrafiado_tb_tipo_insumo`
    FOREIGN KEY (`tipo_insumo`)
    REFERENCES `basa_mysql`.`tb_tipo_insumo` (`id_insumo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
