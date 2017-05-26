SET NAMES 'utf8' COLLATE 'utf8_general_ci';

DROP DATABASE IF EXISTS `rebfa`;

CREATE DATABASE `rebfa` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE `rebfa`;

CREATE TABLE `trading` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` TEXT NOT NULL,
    `city` TEXT NOT NULL,
    `carCapacity` INT NOT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE `car` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `brand` TEXT NOT NULL,
    `year` INT NOT NULL,
    `color` TEXT NOT NULL,
    `tradingId` INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (tradingId) REFERENCES `trading`(id)
);

INSERT INTO `trading`(`name`, `city`, `carCapacity`)
VALUES ('Misi Szalon', 'Miskolc', 5);

INSERT INTO `trading`(`name`, `city`, `carCapacity`)
VALUES ('Zoli Car', 'Encs', 4);

INSERT INTO `trading`(`name`, `city`, `carCapacity`)
VALUES ('Robi Auto', 'Polgár', 3);


INSERT INTO `car`(`brand`, `year`, `color`, `tradingId`)
VALUES ('Opel', 1999, 'red', 1);

INSERT INTO `car`(`brand`, `year`, `color`, `tradingId`)
VALUES ('Suzuki', 2006, 'silver', 1);

INSERT INTO `car`(`brand`, `year`, `color`, `tradingId`)
VALUES ('Saab', 2005, 'black', 1);


INSERT INTO `car`(`brand`, `year`, `color`, `tradingId`)
VALUES ('BMW', 2001, 'yellow', 2);

INSERT INTO `car`(`brand`, `year`, `color`, `tradingId`)
VALUES ('Audi', 2003, 'blue', 2);

INSERT INTO `car`(`brand`, `year`, `color`, `tradingId`)
VALUES ('Fiat', 2008, 'brown', 3);

INSERT INTO `car`(`brand`, `year`, `color`, `tradingId`)
VALUES ('Opel', 2004, 'white', 3);


