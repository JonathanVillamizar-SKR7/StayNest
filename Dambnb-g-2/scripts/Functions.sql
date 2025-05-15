DELIMITER $$

/*Devuelve el número total de viviendas registradas*/
CREATE FUNCTION fn_getHousingCount()
RETURNS INT UNSIGNED
DETERMINISTIC
BEGIN
DECLARE total INT;
SET total = (SELECT COUNT(*) FROM Housing);
RETURN total;
END$$

/*Devuelve cuántas viviendas están disponibles*/
CREATE FUNCTION fn_getAvailableHousingCount()
RETURNS INT 
DETERMINISTIC
BEGIN
DECLARE total INT;
SET total = (SELECT COUNT(*) FROM Housing where idHouse IN (SELECT idHouse from HousingFacilities where available = 1));
END$$