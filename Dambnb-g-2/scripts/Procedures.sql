DELIMITER $$
/*--------------HOUSING--------------*/
/*Crear una casa nueva*/
CREATE PROCEDURE pc_InsertHousing(in idHouse INT,in `name` varchar(100),in location varchar(100),in numG int,in numB int,in numBa int, in idType int,in price double)
BEGIN
INSERT INTO Housing VALUES (idHouse,bame,location,numG,numB,numBa,idType,price);
END$$

/*Obtiene todas las casas*/
CREATE PROCEDURE pc_getAllHousing()
BEGIN
SELECT * FROM Housing; 
END$$

/*Busca casa por idType*/
CREATE PROCEDURE pc_getHousingByType(IN id_t INT)
BEGIN
SELECT * FROM Housing where idType = id_t;
END$$


/*Busca casa por id*/
CREATE PROCEDURE pc_getHousingById(IN id INT)
BEGIN
SELECT * from Housing where id=idHouse;
END$$

/*Buscar casa por numero de habitaciones*/
CREATE PROCEDURE pc_getHousing(in n INT)
BEGIN
SELECT * from Housing where n = numBedroom;  
END$$

/*Actualiza el precio de una vivienda por su id*/
CREATE PROCEDURE pc_updateHousingPrice(IN id INT, IN newPrice Double)
BEGIN
UPDATE Housing set price = newPrice where id=idHousing;
END$$

/*Eliminar casa por id*/
CREATE PROCEDURE pc_DeleteHousingById(IN id_d INT)
BEGIN
DELETE FROM Housing WHERE idHousing = id_d ;
END$$

/*-------------------RESERVE-------------------*/
/*Obtiene todas las reservas*/
CREATE PROCEDURE pc_GetAllReserves()
BEGIN
SELECT * FROM Reserves;
END$$

/*Actualizar reserva por id*/
CREATE PROCEDURE pc_updateReserveById(in id int,in Nname varchar(100),in nCheckIn date, in ncheckOut date, in nnumGuests int)
BEGIN
UPDATE Reserves set name =Nname,CheckIn = nCheckIn,checkOut = ncheckOut, numGuests = nnumGuests; 
END$$

/*Buscar reserve por usuario*/
CREATE PROCEDURE pc_getReserveByUser(IN id int)
BEGIN
Select * from Reserves where id = idUser;
END$$

/*Eliminar casa por id*/
CREATE PROCEDURE pc_DeleteReserveById(IN id_d INT)
BEGIN
DELETE FROM Reserve WHERE idReserve = id_d ;
END$$

/*Buscar reserva por tipo*/
CREATE PROCEDURE pc_getReserveByType(IN idT int)
BEGIN
SELECT R.*
    FROM Reserves R
    JOIN Housing H ON R.idHouse = H.idHouse
    WHERE H.idType = idT;
END$$

/*-------------------USER-------------------*/

/*Buscar usuario por id*/
/*Listar usuarios*/
/*Eliminar usuario por id*/

/*-------------------FACILITY-------------------*/

/*Crear facility*/
