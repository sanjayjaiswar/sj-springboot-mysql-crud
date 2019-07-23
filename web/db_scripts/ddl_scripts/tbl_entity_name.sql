CREATE TABLE `backendappdb`.tbl_entity_name
(
  entity_id BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  entity_name VARCHAR(128) NOT NULL,
  created_at DATETIME NOT NULL,
  modified_at DATETIME NOT NULL,
  UNIQUE INDEX `idx_entity_name` (`entity_name` ASC)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

GRANT SELECT, INSERT, UPDATE, DELETE ON `backendappdb`.`tbl_entity_name` TO 'sanjay'@'localhost';
