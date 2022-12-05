BEGIN;
DROP TABLE customers IF EXISTS;
CREATE TABLE customers (id bigserial, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO customers (name) VALUES ('admin'), ('user1'), ('user2');

DROP TABLE products IF EXISTS;
CREATE TABLE products (id bigserial, title VARCHAR(255), price int, PRIMARY KEY (id));
INSERT INTO products (title,price) VALUES ('iphone',1000), ('samsung',500);

DROP TABLE products_customers IF EXISTS;
CREATE TABLE products_customers (customer_id bigint, product_id bigint, FOREIGN KEY (product_id) REFERENCES products(id),
FOREIGN KEY (customer_id) REFERENCES customers(id));
INSERT INTO products_customers (customer_id, product_id) VALUES (2, 1), (2, 2), (3, 2);

COMMIT;