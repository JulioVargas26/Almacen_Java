-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Basa
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Basa` ;

-- -----------------------------------------------------
-- Schema Basa
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Basa` DEFAULT CHARACTER SET utf8 ;
USE `Basa` ;

-- -----------------------------------------------------
-- Table `Basa`.`tb_insumo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Basa`.`tb_insumo` ;

CREATE TABLE IF NOT EXISTS `Basa`.`tb_insumo` (
  `id_insumo` INT NOT NULL,
  `descripcion` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_insumo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Basa`.`tb_serigrafiado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Basa`.`tb_serigrafiado` ;

CREATE TABLE IF NOT EXISTS `Basa`.`tb_serigrafiado` (
  `id_serigrafiado` INT NOT NULL,
  `insumo` INT NOT NULL,
  `cantSalida` INT NOT NULL,
  `guiaSalida` VARCHAR(45) NOT NULL,
  `cantIngreso` INT NOT NULL,
  `guiaIngreso` VARCHAR(45) NOT NULL,
  `merma` INT NOT NULL,
  `fecha` DATE NOT NULL,
  PRIMARY KEY (`id_serigrafiado`),
  INDEX `fk_serigrafiado_insumo_idx` (`insumo` ASC) VISIBLE,
  CONSTRAINT `fk_serigrafiado_insumo`
    FOREIGN KEY (`insumo`)
    REFERENCES `Basa`.`tb_insumo` (`id_insumo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


INSERT INTO `basa`.`tb_insumo` (`id_insumo`, `descripcion`) VALUES ('0302615', 'botella 350');


INSERT INTO `basa`.`tb_serigrafiado` (`id_serigrafiado`, `insumo`, `cantSalida`, `guiaSalida`, `cantIngreso`, `guiaIngreso`, `merma`, `fecha`) 
VALUES ('1256498', '1', '12000', '1200-232', '11998', '1500-562', '2', '2023-02-12');


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
