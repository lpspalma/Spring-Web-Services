DROP TABLE IF EXISTS student;

CREATE TABLE student (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL
);

INSERT INTO student (first_name, last_name, email) VALUES
                      ('Aliko', 'Dangote', 'email1'),
                      ('Bill', 'Gates', 'email2'),
                      ('Folrunsho', 'Alakija', 'email3');