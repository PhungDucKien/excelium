CREATE TABLE IF NOT EXISTS users (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    mail VARCHAR(50) UNIQUE
);

TRUNCATE TABLE users;

INSERT INTO users (id, name, mail) VALUES
    (1, 'admin', 'admin@excelium.com'),
    (2, 'user', 'user@excelium.com');