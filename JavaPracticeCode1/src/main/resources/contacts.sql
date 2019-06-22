create database practiceDB;
commit;

CREATE TABLE IF NOT EXISTS practiceDB.contacts (

    contactId INT AUTO_INCREMENT,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255),
    comapny VARCHAR(200),
    contactGroup VARCHAR(200),
    recordTime timestamp,
   PRIMARY KEY (contactId)
)  ENGINE=INNODB;