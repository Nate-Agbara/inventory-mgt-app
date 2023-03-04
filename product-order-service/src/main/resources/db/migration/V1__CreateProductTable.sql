CREATE TABLE product (
  id BIGINT AUTO_INCREMENT NOT NULL,
   product_name VARCHAR(255) NOT NULL,
   product_description VARCHAR(255) NULL,
   unit_price DECIMAL(20,2) NULL,
   quantity INTEGER NULL,
   created_by VARCHAR(255) NULL,
   date_created DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
   updated_by VARCHAR(255) NULL,
   date_updated datetime NULL,
   CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE customer_order (
  id BIGINT AUTO_INCREMENT NOT NULL,
   customer_name VARCHAR(255) NULL,
   customer_mobile VARCHAR(255) NULL,
   product_id BIGINT NOT NULL,
   order_quantity VARCHAR(255) NOT NULL,
   amount DECIMAL(20,2) NOT NULL,
   created_by VARCHAR(255) NULL,
   date_created DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
   updated_by VARCHAR(255) NULL,
   date_updated datetime NULL,
   CONSTRAINT pk_order PRIMARY KEY (id)
);

ALTER TABLE customer_order ADD CONSTRAINT FK_PRODUCT_ON_ORDER FOREIGN KEY (product_id) REFERENCES product (id);