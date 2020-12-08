DROP TABLE Meinedaten IF EXISTS;

CREATE TABLE Meinedaten (
   id BIGINT IDENTITY NOT NULL PRIMARY KEY,
   Vorname VARCHAR(20),
   Nachname VARCHAR(20),
   Buchstabenanzahl BIGINT
);