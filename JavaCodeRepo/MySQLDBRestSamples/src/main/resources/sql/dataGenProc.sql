CREATE DEFINER=`root`@`%` PROCEDURE `generate_data`()
BEGIN
DECLARE i INT DEFAULT 0;
  WHILE i < 1000 DO
  INSERT INTO Generator.Id_gen (uuid, is_used)
VALUES(UUID_TO_BIN(UUID()),'N');
  SET i = i + 1;
  END WHILE;
END