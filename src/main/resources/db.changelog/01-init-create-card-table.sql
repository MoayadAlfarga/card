--liquibase formatted sql

--changeset moayad:1
CREATE TABLE IF NOT EXISTS `card_status` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `card_status` VARCHAR(50) NOT NULL,
    `card_id` BIGINT,
    `created_at` DATETIME DEFAULT NULL,
    `created_by` VARCHAR(100) DEFAULT NULL,
    `updated_at` DATETIME DEFAULT NULL,
    `updated_by` VARCHAR(100) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `cards` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `card_type` VARCHAR(50) DEFAULT NULL,
    `card_number` BIGINT DEFAULT NULL,
    `account_number` BIGINT DEFAULT NULL,
    `mobile_number` VARCHAR(20) DEFAULT NULL,
    `card_holder_name` VARCHAR(100) DEFAULT NULL,
    `status_id` BIGINT,
    `created_at` DATETIME DEFAULT NULL,
    `created_by` VARCHAR(100) DEFAULT NULL,
    `updated_at` DATETIME DEFAULT NULL,
    `updated_by` VARCHAR(100) DEFAULT NULL,
    CONSTRAINT `fk_status` FOREIGN KEY (`status_id`) REFERENCES `card_status` (`id`)
);

ALTER TABLE `card_status` ADD CONSTRAINT `fk_card` FOREIGN KEY (`card_id`) REFERENCES `cards` (`id`);
