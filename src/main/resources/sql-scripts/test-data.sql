DROP TABLE IF EXISTS movies;

CREATE TABLE IF NOT EXISTS movies (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    minutes INT NOT NULL,
    genre VARCHAR(255) NOT NULL
);

INSERT INTO movies (title, minutes, genre) VALUES ('The Shawshank Redemption', 142, 'DRAMA');
INSERT INTO movies (title, minutes, genre) VALUES ('The Godfather', 175, 'DRAMA');
INSERT INTO movies (title, minutes, genre) VALUES ('The Dark Knight', 152, 'ACTION');