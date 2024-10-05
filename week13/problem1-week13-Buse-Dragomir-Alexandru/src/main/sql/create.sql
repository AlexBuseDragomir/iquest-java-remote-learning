drop database if exists `jdbc-assignment`;
create database `jdbc-assignment`;

use `jdbc-assignment`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
       `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
       `name` VARCHAR(50) NOT NULL,
       `username` VARCHAR(50) NOT NULL UNIQUE,
       `balance` DECIMAL(10,2) NOT NULL
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 ;

DROP TABLE IF EXISTS `operation`;
CREATE TABLE `operation` (
       `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
       `amount` DECIMAL(10,2) NOT NULL,
       `description` VARCHAR(255) NOT NULL,
       `requested_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       `user_id` BIGINT NOT NULL,
       FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

INSERT INTO `user` (`id`, `name`, `username`, `balance`) VALUES (1, "Monica Albert", "monica", 999.99);
INSERT INTO `user` (`id`, `name`, `username`, `balance`) VALUES (2, "Andrew Jackson", "andrew", 250.30);
INSERT INTO `user` (`id`, `name`, `username`, `balance`) VALUES (3, "John Petterson", "john", 3450.65);
INSERT INTO `user` (`id`, `name`, `username`, `balance`) VALUES (4, "Michelle Stone", "michelle", 1678.20);
INSERT INTO `user` (`id`, `name`, `username`, `balance`) VALUES (5, "Irwin Stevens", "irwin", 4200.99);
INSERT INTO `user` (`id`, `name`, `username`, `balance`) VALUES (6, "Anne Watches", "anne", 8900.10);

INSERT INTO `operation` (`amount`, `description`, `user_id`) VALUES (3000, "salary for April", 1);
INSERT INTO `operation` (`amount`, `description`, `user_id`) VALUES (-260, "new carpet", 1);
INSERT INTO `operation` (`amount`, `description`, `user_id`) VALUES (3600, "salary for May", 2);
INSERT INTO `operation` (`amount`, `description`, `user_id`) VALUES (850, "gratuity for holidays", 3);
INSERT INTO `operation` (`amount`, `description`, `user_id`) VALUES (-500, "police ticket", 4);
INSERT INTO `operation` (`amount`, `description`, `user_id`) VALUES (-19.99, "twitch subscription", 4);
INSERT INTO `operation` (`amount`, `description`, `user_id`) VALUES (-2500, "donation for charity", 5);
INSERT INTO `operation` (`amount`, `description`, `user_id`) VALUES (1700, "private scholarship", 6);