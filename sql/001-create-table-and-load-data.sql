DROP TABLE IF EXISTS names;

CREATE TABLE names (
 id int unsigned AUTO_INCREMENT,
 name VARCHAR(20) NOT NULL,
 birthdate CHAR(10) NOT NULL,
 pin int,
 PRIMARY KEY(id)
);

INSERT INTO names (name,birthdate,pin) VALUES ("田中","1998-12-01",12354);
INSERT INTO names (name,birthdate,pin) VALUES ("佐藤","1999-04-05",45678);
