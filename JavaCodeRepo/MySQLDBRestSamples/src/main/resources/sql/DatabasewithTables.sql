create database Generator;
CREATE TABLE Generator.`Id_gen` (
  `uuid` binary(16) NOT NULL,
  `is_used` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO Id_gen(uuid, is_used)
VALUES(UUID_TO_BIN(UUID()),'N'),
      (UUID_TO_BIN(UUID()),'N'),
      (UUID_TO_BIN(UUID()),'N');
      

      
SELECT 
    BIN_TO_UUID(uuid) uuid, 
    is_used
FROM
    Id_gen;  