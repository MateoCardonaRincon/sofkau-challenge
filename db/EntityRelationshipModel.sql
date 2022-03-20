-- MySQL Script generated by MySQL Workbench
-- Sun Mar 20 00:09:08 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema QuizGameDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema QuizGameDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `QuizGameDB` DEFAULT CHARACTER SET utf8 ;
USE `QuizGameDB` ;

-- -----------------------------------------------------
-- Table `QuizGameDB`.`Player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `QuizGameDB`.`Player` (
  `idPlayer` INT NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPlayer`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `QuizGameDB`.`Game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `QuizGameDB`.`Game` (
  `idGame` INT NOT NULL AUTO_INCREMENT,
  `accessKey` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idGame`),
  UNIQUE INDEX `accessKey_UNIQUE` (`accessKey` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `QuizGameDB`.`Record`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `QuizGameDB`.`Record` (
  `idRecord` INT NOT NULL AUTO_INCREMENT,
  `score` INT NOT NULL,
  `Player_idPlayer` INT NOT NULL,
  `Game_idGame` INT NOT NULL,
  PRIMARY KEY (`idRecord`),
  INDEX `fk_Record_Player1_idx` (`Player_idPlayer` ASC) VISIBLE,
  INDEX `fk_Record_Game1_idx` (`Game_idGame` ASC) VISIBLE,
  CONSTRAINT `fk_Record_Player1`
    FOREIGN KEY (`Player_idPlayer`)
    REFERENCES `QuizGameDB`.`Player` (`idPlayer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Record_Game1`
    FOREIGN KEY (`Game_idGame`)
    REFERENCES `QuizGameDB`.`Game` (`idGame`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `QuizGameDB`.`Reward`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `QuizGameDB`.`Reward` (
  `idReward` INT NOT NULL AUTO_INCREMENT,
  `value` INT NOT NULL,
  PRIMARY KEY (`idReward`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `QuizGameDB`.`Category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `QuizGameDB`.`Category` (
  `idCategory` INT NOT NULL AUTO_INCREMENT,
  `Game_idGame` INT NOT NULL,
  `Reward_idReward` INT NOT NULL,
  `level` INT NOT NULL,
  PRIMARY KEY (`idCategory`),
  INDEX `fk_Category_Game1_idx` (`Game_idGame` ASC) VISIBLE,
  INDEX `fk_Category_Reward1_idx` (`Reward_idReward` ASC) VISIBLE,
  CONSTRAINT `fk_Category_Game1`
    FOREIGN KEY (`Game_idGame`)
    REFERENCES `QuizGameDB`.`Game` (`idGame`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Category_Reward1`
    FOREIGN KEY (`Reward_idReward`)
    REFERENCES `QuizGameDB`.`Reward` (`idReward`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `QuizGameDB`.`Question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `QuizGameDB`.`Question` (
  `idQuestion` INT NOT NULL AUTO_INCREMENT,
  `question_body` VARCHAR(100) NOT NULL,
  `Category_idCategory` INT NOT NULL,
  PRIMARY KEY (`idQuestion`),
  INDEX `fk_Question_Category1_idx` (`Category_idCategory` ASC) VISIBLE,
  CONSTRAINT `fk_Question_Category1`
    FOREIGN KEY (`Category_idCategory`)
    REFERENCES `QuizGameDB`.`Category` (`idCategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `QuizGameDB`.`Round`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `QuizGameDB`.`Round` (
  `idRound` INT NOT NULL AUTO_INCREMENT,
  `Question_idQuestion` INT NOT NULL,
  PRIMARY KEY (`idRound`),
  INDEX `fk_Round_Question1_idx` (`Question_idQuestion` ASC) VISIBLE,
  CONSTRAINT `fk_Round_Question1`
    FOREIGN KEY (`Question_idQuestion`)
    REFERENCES `QuizGameDB`.`Question` (`idQuestion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `QuizGameDB`.`Option`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `QuizGameDB`.`Option` (
  `idOption` INT NOT NULL AUTO_INCREMENT,
  `option_body` VARCHAR(150) NOT NULL,
  `is_correct` TINYINT NOT NULL,
  `Question_idQuestion` INT NOT NULL,
  PRIMARY KEY (`idOption`),
  INDEX `fk_Option_Question1_idx` (`Question_idQuestion` ASC) VISIBLE,
  CONSTRAINT `fk_Option_Question1`
    FOREIGN KEY (`Question_idQuestion`)
    REFERENCES `QuizGameDB`.`Question` (`idQuestion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;