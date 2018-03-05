-- -----------------------------------------------------
-- Schema pwi
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pwi` DEFAULT CHARACTER SET utf8 ;
USE `pwi` ;

-- -----------------------------------------------------
-- Table `pwi`.`sites`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pwi`.`sites` (
  `siteId` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `siteCode` INT UNSIGNED NULL DEFAULT 0,
  `siteName` VARCHAR(45) NULL,
  PRIMARY KEY (`siteId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pwi`.`brand`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pwi`.`brand` (
  `brandId` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `brandName` VARCHAR(45) NULL,
  PRIMARY KEY (`brandId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pwi`.`warehouse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pwi`.`warehouse` (
  `warehouseId` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `siteId` INT UNSIGNED NULL,
  `warehouseName` VARCHAR(45) NULL,
  PRIMARY KEY (`warehouseId`),
  INDEX `idx_warehouse_siteId_idx` (`siteId` ASC),
  CONSTRAINT `idx_warehouse_siteId`
    FOREIGN KEY (`siteId`)
    REFERENCES `pwi`.`sites` (`siteId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;
CREATE INDEX `idx_warehouse_siteId` ON `warehouse` (`siteId` ASC);

-- -----------------------------------------------------
-- Table `pwi`.`item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pwi`.`item` (
  `itemId` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `warehouseId` INT UNSIGNED NULL,
  `brandId` INT UNSIGNED NULL,
  `itemName` VARCHAR(200) NULL,
  `itemType` VARCHAR(45) NULL,
  `inStockQty` BIGINT UNSIGNED NULL,
  `availableQty` BIGINT UNSIGNED NULL,
  `inTransitQty` BIGINT UNSIGNED NULL,
  `moq` BIGINT UNSIGNED NULL,
  `qpb` BIGINT UNSIGNED NULL,
  `reorderPoint` BIGINT UNSIGNED NULL,
  `createDate` DATETIME NULL,
  `updateDate` DATETIME NULL,
  PRIMARY KEY (`itemId`),
  INDEX `idx_item_warehouseId_idx` (`warehouseId` ASC),
  INDEX `idx_item_brandId_idx` (`brandId` ASC),
  CONSTRAINT `idx_item_warehouseId`
    FOREIGN KEY (`warehouseId`)
    REFERENCES `pwi`.`warehouse` (`warehouseId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idx_item_brandId`
    FOREIGN KEY (`brandId`)
    REFERENCES `pwi`.`brand` (`brandId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;
CREATE INDEX `idx_item_brandId` ON `item` (`brandId` ASC);
CREATE INDEX `idx_item_warehouseId` ON `item` (`warehouseId` ASC);


-- -----------------------------------------------------
-- Table `pwi`.`item_attribute`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pwi`.`item_attribute` (
  `attributeId` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `itemId` INT UNSIGNED NULL,
  `attributeName` VARCHAR(45) NULL,
  `attributeValue` VARCHAR(45) NULL,
  PRIMARY KEY (`attributeId`),
  INDEX `idx_attribute_itemId_idx` (`itemId` ASC),
  CONSTRAINT `idx_attribute_itemId`
    FOREIGN KEY (`itemId`)
    REFERENCES `pwi`.`item` (`itemId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;
CREATE INDEX `idx_attribute_itemId` ON `item_attribute` (`itemId` ASC);