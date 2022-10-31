DROP DATABASE IF EXISTS `stock`;
CREATE DATABASE IF NOT EXISTS `stock` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
DROP USER IF EXISTS `springuser`@localhost;
CREATE USER `springuser` @localhost IDENTIFIED BY 'ThePassword';
GRANT USAGE ON *.* TO `springuser` @localhost;
GRANT ALL PRIVILEGES ON `stock`.* TO `springuser`@localhost;
USE `stock`;
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
    `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
    `producto` varchar(255) DEFAULT NULL,
    `cantidad` varchar(255) DEFAULT NULL,
    `precio` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 10 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

INSERT INTO
    `user` (`id`, `producto`, `cantidad`, `precio`);

