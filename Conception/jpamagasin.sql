-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema jpamagasin
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema jpamagasin
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jpamagasin` ;
USE `jpamagasin` ;

-- -----------------------------------------------------
-- Table `jpamagasin`.`commande`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jpamagasin`.`commande` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(45) NULL,
  `date` TIMESTAMP NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jpamagasin`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jpamagasin`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  `prenom` VARCHAR(45) NULL,
  `commande_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_client_commande_idx` (`commande_id` ASC) VISIBLE,
  CONSTRAINT `fk_client_commande`
    FOREIGN KEY (`commande_id`)
    REFERENCES `jpamagasin`.`commande` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jpamagasin`.`categorie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jpamagasin`.`categorie` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jpamagasin`.`produit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jpamagasin`.`produit` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  `prix` FLOAT NULL,
  `categorie_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_produit_categorie1_idx` (`categorie_id` ASC) VISIBLE,
  CONSTRAINT `fk_produit_categorie1`
    FOREIGN KEY (`categorie_id`)
    REFERENCES `jpamagasin`.`categorie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jpamagasin`.`commande_has_produit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jpamagasin`.`commande_has_produit` (
  `commande_id` INT NOT NULL,
  `produit_id` INT NOT NULL,
  PRIMARY KEY (`commande_id`, `produit_id`),
  INDEX `fk_commande_has_produit_produit1_idx` (`produit_id` ASC) VISIBLE,
  INDEX `fk_commande_has_produit_commande1_idx` (`commande_id` ASC) VISIBLE,
  CONSTRAINT `fk_commande_has_produit_commande1`
    FOREIGN KEY (`commande_id`)
    REFERENCES `jpamagasin`.`commande` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_commande_has_produit_produit1`
    FOREIGN KEY (`produit_id`)
    REFERENCES `jpamagasin`.`produit` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
