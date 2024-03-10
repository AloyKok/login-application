CREATE USER user1 PASSWORD 'password1';
CREATE USER user2 PASSWORD 'password2';

CREATE TABLE IF NOT EXISTS users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    role VARCHAR(20) NOT NULL
);

INSERT INTO users (username, password, email, role)
VALUES ('tom', 'password', 'user@gmail.com', 'user'), ('kelly', 'password', 'manager@gmail.com', 'manager');