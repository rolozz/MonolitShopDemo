-- Создание таблицы admin
CREATE TABLE admin (
                       id SERIAL PRIMARY KEY,
                       username BIGINT NOT NULL
);

-- Создание таблицы client
CREATE TABLE client (
                        id SERIAL PRIMARY KEY,
                        username BIGINT NOT NULL
);

-- Создание таблицы blacklist
CREATE TABLE blacklist (
                           id SERIAL PRIMARY KEY,
                           client_id BIGINT,
                           CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE CASCADE
);

-- Создание таблицы order
CREATE TABLE orders (
                        id SERIAL PRIMARY KEY,
                        is_paid BOOLEAN DEFAULT FALSE,
                        client_id BIGINT,
                        CONSTRAINT fk_client_order FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE CASCADE
);

-- Создание таблицы product
CREATE TABLE product (
                         id SERIAL PRIMARY KEY,
                         product_name VARCHAR(255) NOT NULL,
                         price DOUBLE PRECISION NOT NULL
);

-- Создание таблицы deal
CREATE TABLE deal (
                      id SERIAL PRIMARY KEY,
                      amount DOUBLE PRECISION NOT NULL,
                      order_id BIGINT,
                      CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE
);

-- Связь продуктов с заказами (многие ко многим)
CREATE TABLE order_product (
                               order_id BIGINT,
                               product_id BIGINT,
                               PRIMARY KEY (order_id, product_id),
                               CONSTRAINT fk_order_product_order FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
                               CONSTRAINT fk_order_product_product FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE
);