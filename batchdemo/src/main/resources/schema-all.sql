DROP TABLE Meinedaten IF EXISTS;

CREATE TABLE Meinedaten (
   id BIGINT auto_increment NOT NULL PRIMARY KEY,
   Vorname VARCHAR(20),
   Nachname VARCHAR(20),
   Buchstabenanzahl BIGINT
);