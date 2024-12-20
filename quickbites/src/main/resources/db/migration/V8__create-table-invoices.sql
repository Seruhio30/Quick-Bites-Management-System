CREATE TABLE invoices (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT NOT NULL,
    issued_at TIMESTAMP NOT NULL,
    total DOUBLE NOT NULL,
    tax DOUBLE NOT NULL,
    CONSTRAINT fk_order_invoice FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE
);
