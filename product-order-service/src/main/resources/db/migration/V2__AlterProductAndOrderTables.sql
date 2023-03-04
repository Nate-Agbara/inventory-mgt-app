ALTER TABLE product ADD COLUMN status VARCHAR(255) NULL AFTER date_updated;

ALTER TABLE customer_order ADD COLUMN status VARCHAR(255) NULL AFTER date_updated;