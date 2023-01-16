DROP TABLE IF EXISTS names;

CREATE TABLE names (
 id int unsigned AUTO_INCREMENT,
 name VARCHAR(20) NOT NULL,
 birthdate CHAR(10) NOT NULL,
 pin int,
 PRIMARY KEY(id)
);

INSERT INTO names (name,birthdate,pin) VALUES ("田中","1998-12-01",12354);
INSERT INTO names (name,birthdate,pin) VALUES ("佐藤","1999-05-07",45678);
INSERT INTO names (name,birthdate,pin) VALUES ("佐藤","1999-09-03",58903);
INSERT INTO names (name,birthdate,pin) VALUES ("石川","1999-06-30",64630);
INSERT INTO names (name,birthdate,pin) VALUES ("渡邉","1999-03-15",15384);
INSERT INTO names (name,birthdate,pin) VALUES ("増田","1999-05-05",95605);
INSERT INTO names (name,birthdate,pin) VALUES ("高橋","1999-03-07",43867);
INSERT INTO names (name,birthdate,pin) VALUES ("五十嵐","1999-07-09",99709);
INSERT INTO names (name,birthdate,pin) VALUES ("石塚","1999-04-24",84242);
INSERT INTO names (name,birthdate,pin) VALUES ("山崎","1999-06-30",60934);
INSERT INTO names (name,birthdate,pin) VALUES ("小川","1999-04-21",94214);
INSERT INTO names (name,birthdate,pin) VALUES ("小林","1999-07-29",87297);
INSERT INTO names (name,birthdate,pin) VALUES ("安藤","1999-07-30",73100);
INSERT INTO names (name,birthdate,pin) VALUES ("進藤","1999-06-02",66992);