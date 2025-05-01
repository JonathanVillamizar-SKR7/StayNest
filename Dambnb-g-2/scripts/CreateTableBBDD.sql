
-- Tabla de imágenes
CREATE TABLE Images (
    idImage INT PRIMARY KEY,
    imgRoute VARCHAR(255)
);

-- Tipos de vivienda
CREATE TABLE Types (
    idType INT PRIMARY KEY,
    type VARCHAR(100) NOT NULL
);

-- Tabla de usuarios
CREATE TABLE Users (
    idUser INT PRIMARY KEY,
    userName VARCHAR(100) UNIQUE,
    phone BIGINT,
    email VARCHAR(100),
    passport INT
);

-- Detalles de autenticación del usuario
CREATE TABLE Details (
    userName VARCHAR(100) PRIMARY KEY,
    password VARCHAR(100),
    userType VARCHAR(50),
    userDescription TEXT,
    FOREIGN KEY (userName) REFERENCES Users(userName)
);

-- Tarjetas de crédito
CREATE TABLE CreditCards (
    idCreditCard INT PRIMARY KEY,
    cardHolderName VARCHAR(100),
    creditCardNumber BIGINT,
    expirationDate DATE,
    cvv INT,
    idUser INT,
    FOREIGN KEY (idUser) REFERENCES Users(idUser)
);

-- Tabla de viviendas
CREATE TABLE Housing (
    idHouse INT PRIMARY KEY,
    name VARCHAR(100),
    location VARCHAR(100),
    numGuest INT,
    numBedroom INT,
    numBed INT,
    numBath INT,
    idType INT,
    price DOUBLE,
    FOREIGN KEY (idType) REFERENCES Types(idType)
);

-- Tabla de facilidades generales
CREATE TABLE Facilities (
    idFacility INT PRIMARY KEY,
    typeFacility VARCHAR(100)
);

-- Relación entre viviendas y facilidades
CREATE TABLE HousingFacilities (
    idHouse INT,
    idFacility INT,
    available BOOLEAN,
    description TEXT,
    idImage INT,
    PRIMARY KEY (idHouse, idFacility),
    FOREIGN KEY (idHouse) REFERENCES Housing(idHouse),
    FOREIGN KEY (idFacility) REFERENCES Facilities(idFacility),
    FOREIGN KEY (idImage) REFERENCES Images(idImage)
);

-- Tabla de reservas
CREATE TABLE Reserves (
    idReserve INT PRIMARY KEY,
    idHouse INT,
    idUser INT,
    name VARCHAR(100),
    checkIn DATE,
    checkOut DATE,
    numGuests INT,
    totalPrice DOUBLE,
    FOREIGN KEY (idHouse) REFERENCES Housing(idHouse),
    FOREIGN KEY (idUser) REFERENCES Users(idUser)
);
