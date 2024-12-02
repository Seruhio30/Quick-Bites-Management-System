CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL,
    total_price DOUBLE NOT NULL,
    status VARCHAR(255) NOT NULL
);
