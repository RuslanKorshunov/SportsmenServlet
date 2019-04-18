create database sportsman;
use sportsman;
CREATE TABLE IF NOT EXISTS sportsman
(
  idSportsmen INT NOT NULL,
  nameSp VARCHAR(45) NOT NULL,
  surnameSp VARCHAR(45) NOT NULL,
  country VARCHAR(25) NOT NULL,
  PRIMARY KEY (idSportsmen));
  
insert into sportsman values
  (1, 'Yuzuru', 'Hanyu', 'Japan'),
  (2, 'Shoma', 'Uno', 'Japan'),
  (3, 'Javier', 'Fernández', 'Spain'),
  (4, 'Alina', 'Zagitova', 'Russia'),
  (5, 'Evgenia', 'Medvedeva', 'Russia'),
  (6, 'Kaetlyn', 'Osmond', 'Canada');
  
  create table if not exists medals
  (
	idSportsmen INT NOT NULL,
    numberOG INT NOT NULL,
    eventOG VARCHAR(45) NOT NULL,
    medal VARCHAR(6) NOT NULL,
    PRIMARY KEY (idSportsmen, numberOG),
    FOREIGN KEY (idSportsmen) REFERENCES sportsman(idSportsmen)
  );
  
  insert into medals values
	(1, 2018, 'Mens singles', 'gold'),
    (2, 2018, 'Mens singles', 'silver'),
    (3, 2018, 'Mens singles', 'bronze'),
    (4, 2018, 'Ladies singles', 'gold'),
    (5, 2018, 'Ladies singles', 'silver'),
    (6, 2018, 'Ladies singles', 'bronze'),
    (1, 2014, 'Mens singles', 'gold');