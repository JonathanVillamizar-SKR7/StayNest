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
    description TEXT,
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
    description TEXT,
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


-- INSERT INTO

-- Types
INSERT INTO Types (idType, type) VALUES (1, 'Cabin');
INSERT INTO Types (idType, type) VALUES (2, 'Tiny home');
INSERT INTO Types (idType, type) VALUES (3, 'Apartment');
INSERT INTO Types (idType, type) VALUES (4, 'Countryside');
INSERT INTO Types (idType, type) VALUES (5, 'Villa');

-- Users
INSERT INTO Users (idUser, userName, phone, email, passport) VALUES (1, 'admin_user', 687550711, 'admin@stayapp.com', 85019795);
INSERT INTO Users (idUser, userName, phone, email, passport) VALUES (2, 'Francesco_Vergolini', 693266457, 'Fran@example.com', 72725747);
INSERT INTO Users (idUser, userName, phone, email, passport) VALUES (3, 'Natasha_Kiev', 675822906, 'Natasha@example.com', 90830697);

-- Details
INSERT INTO Details (userName, password, userType, description) VALUES ('admin_user', 'password123', 'admin', 'Admin user account.');
INSERT INTO Details (userName, password, userType, description) VALUES ('Francesco_Vergolini', 'password123', 'client', 'Client user account.');
INSERT INTO Details (userName, password, userType, description) VALUES ('Natasha_Kiev', 'password123', 'client', 'Client user account.');

-- Credit Cards
INSERT INTO CreditCards (idCreditCard, cardHolderName, creditCardNumber, expirationDate, cvv, idUser) VALUES (1, 'Admin User', 4369505627370175, '2026-03-01', 551, 1);
INSERT INTO CreditCards (idCreditCard, cardHolderName, creditCardNumber, expirationDate, cvv, idUser) VALUES (2, 'Francesco Vergolini', 4666097128827326, '2028-08-01', 144, 2);
INSERT INTO CreditCards (idCreditCard, cardHolderName, creditCardNumber, expirationDate, cvv, idUser) VALUES (3, 'Natasha Kiev', 4371979161070215, '2026-05-01', 834, 3);

-- Housing (15 registros)
INSERT INTO Housing (idHouse, name, description, location, numGuest, numBedroom, numBed, numBath, idType, price) VALUES 
(1, 'Countryside Stay #1', 'Recent organization charge adult safe through price.', 'Stewartmouth, Germany', 6, 2, 1, 1, 4, 112.99),
(2, 'Countryside Stay #2', 'Individual detail effort loss sure.', 'North Jasonport, Germany', 5, 3, 1, 3, 4, 228.99),
(3, 'Tiny home Stay #3', 'Visit security small including campaign fall.', 'Hawkinsstad, Portugal', 3, 1, 2, 3, 2, 163.99),
(4, 'Countryside Stay #4', 'Society wall current of young.', 'Arnoldfurt, USA', 3, 3, 1, 3, 4, 189.99),
(5, 'Tiny home Stay #5', 'Add have since take and.', 'Jeremiahtown, Germany', 1, 4, 5, 1, 2, 105.99),
(6, 'Cabin Stay #6', 'Worker term will.', 'South Beverlyview, France', 2, 2, 1, 2, 1, 195.99),
(7, 'Villa Stay #7', 'Type season science scientist.', 'Port James, Portugal', 3, 1, 1, 3, 5, 87.99),
(8, 'Apartment Stay #8', 'Party cover notice law tell.', 'Jeannetown, Germany', 2, 2, 3, 2, 3, 177.99),
(9, 'Apartment Stay #9', 'Hit fear full make.', 'Transide, Germany', 3, 4, 5, 3, 3, 179.99),
(10, 'Apartment Stay #10', 'Up force big least also meeting growth.', 'Thomasview, USA', 3, 4, 4, 1, 3, 99.99),
(11, 'Cabin Stay #11', 'Its must style billion million.', 'South Jenniferburgh, Germany', 5, 1, 2, 1, 1, 133.99),
(12, 'Apartment Stay #12', 'Understand baby your name expect large.', 'Aliciaburgh, USA', 5, 1, 1, 1, 3, 190.99),
(13, 'Cabin Stay #13', 'History big space create Democrat event south.', 'New Christopher, USA', 4, 3, 4, 1, 1, 136.99),
(14, 'Countryside Stay #14', 'Lead soon lead responsibility none as rather.', 'Lake Robertborough, USA', 3, 3, 4, 3, 4, 148.99),
(15, 'Apartment Stay #15', 'Artist author world last interest worker wide.', 'Bryantview, Portugal', 2, 4, 4, 2, 3, 119.99);

-- Facilities (45 registros, 3 por cada Housing)
INSERT INTO Facilities (idFacility, typeFacility) VALUES
(1, 'Private patio'),
(2, 'WiFi'),
(3, 'TV'),
(4, 'Washer'),
(5, 'Air conditioning'),
(6, 'Dedicated workspace'),
(7, 'Kitchen'),
(8, 'Free parking'),
(9, 'Pool'),
(10, 'Hot tub'),
(11, 'Fireplace'),
(12, 'Gym'),
(13, 'Balcony'),
(14, 'Pet-friendly'),
(15, 'Security system');

INSERT INTO Images (idImage, imgRoute)
VALUES 
(1001, 'url_image1.jpg'),
(1002, 'url_image2.jpg'),
(1003, 'url_image3.jpg'),
(1004, 'url_image4.jpg'),
(1005, 'url_image5.jpg'),
(1006, 'url_image5.jpg'),
(1007, 'url_image5.jpg'),
(1008, 'url_image5.jpg'),
(1009, 'url_image5.jpg'),
(1010, 'url_image5.jpg'),
(1011, 'url_image5.jpg'),
(1012, 'url_image5.jpg'),
(1013, 'url_image5.jpg'),
(1014, 'url_image5.jpg'),
(1015, 'url_image5.jpg');


-- Casa 1: Countryside
INSERT INTO HousingFacilities VALUES
(1, 1, true, 'Fast rural internet', 1001),
(1, 4, true, 'Fully equipped kitchen', 1004),
(1, 5, true, 'Private outdoor parking', 1005),
(1, 7, true, 'Heating system for cold nights', 1007),
(1, 11, true, 'Cozy fireplace in the living room', 1011);

-- Casa 2: Countryside
INSERT INTO HousingFacilities VALUES
(2, 1, true, 'High-speed WiFi', 1001),
(2, 2, true, 'Outdoor pool with mountain view', 1002),
(2, 5, true, 'Spacious private parking', 1005),
(2, 7, true, 'Central heating', 1007),
(2, 11, true, 'Fireplace for cozy evenings', 1011),
(2, 14, true, 'Pets allowed on request', 1014);

-- Casa 3: Tiny home
INSERT INTO HousingFacilities VALUES
(3, 1, true, 'Basic WiFi', 1001),
(3, 4, true, 'Compact but functional kitchen', 1004),
(3, 6, true, 'Smart TV with Netflix', 1006),
(3, 7, true, 'Small heater', 1007);

-- Casa 4: Countryside
INSERT INTO HousingFacilities VALUES
(4, 1, true, 'WiFi included', 1001),
(4, 4, true, 'Farm-style kitchen', 1004),
(4, 5, true, 'Parking for 2 cars', 1005),
(4, 11, true, 'Classic fireplace', 1011),
(4, 14, true, 'Pet friendly area', 1014);

-- Casa 5: Tiny home
INSERT INTO HousingFacilities VALUES
(5, 1, true, 'Rural internet', 1001),
(5, 4, true, 'Kitchen with essentials', 1004),
(5, 6, true, 'TV available', 1006),
(5, 7, true, 'Portable heater', 1007),
(5, 13, true, 'Tiny balcony with garden view', 1013);

-- Casa 6: Cabin
INSERT INTO HousingFacilities VALUES
(6, 1, true, 'WiFi in the woods', 1001),
(6, 5, true, 'Cabin parking area', 1005),
(6, 6, true, 'Flat-screen TV', 1006),
(6, 7, true, 'Warm heating system', 1007),
(6, 11, true, 'Stone fireplace', 1011),
(6, 14, false, 'No pets allowed', 1014);

-- Casa 7: Villa
INSERT INTO HousingFacilities VALUES
(7, 1, true, 'WiFi across the villa', 1001),
(7, 2, true, 'Private pool with loungers', 1002),
(7, 3, true, 'Air conditioning in all rooms', 1003),
(7, 4, true, 'Modern kitchen', 1004),
(7, 12, true, 'On-site gym access', 1012),
(7, 15, true, 'Advanced security system', 1015);

-- Casa 8: Apartment
INSERT INTO HousingFacilities VALUES
(8, 1, true, 'WiFi included', 1001),
(8, 3, true, 'Air conditioning', 1003),
(8, 4, true, 'Compact kitchen', 1004),
(8, 6, true, 'Smart TV', 1006),
(8, 8, true, 'Washer in unit', 1008),
(8, 13, true, 'Balcony view', 1013);

-- Casa 9: Apartment
INSERT INTO HousingFacilities VALUES
(9, 1, true, 'WiFi high-speed', 1001),
(9, 3, true, 'Air conditioning', 1003),
(9, 4, true, 'Dishwasher and kitchen tools', 1004),
(9, 6, true, 'Big screen TV', 1006),
(9, 8, true, 'Washer', 1008),
(9, 9, true, 'Dryer included', 1009);

-- Casa 10: Apartment
INSERT INTO HousingFacilities VALUES
(10, 1, true, 'WiFi provided', 1001),
(10, 3, true, 'Central AC', 1003),
(10, 6, true, 'TV with streaming services', 1006),
(10, 9, true, 'Dryer included', 1009),
(10, 13, true, 'Private balcony', 1013);

-- Casa 11: Cabin
INSERT INTO HousingFacilities VALUES
(11, 1, true, 'Basic WiFi', 1001),
(11, 5, true, 'Cabin parking spot', 1005),
(11, 7, true, 'Heating system', 1007),
(11, 11, true, 'Chimney fireplace', 1011),
(11, 14, false, 'No pets allowed', 1014);

-- Casa 12: Apartment
INSERT INTO HousingFacilities VALUES
(12, 1, true, 'WiFi access', 1001),
(12, 3, true, 'AC', 1003),
(12, 4, true, 'Minimalist kitchen', 1004),
(12, 6, true, 'Smart TV', 1006),
(12, 15, true, 'Security cameras in lobby', 1015);

-- Casa 13: Cabin
INSERT INTO HousingFacilities VALUES
(13, 1, true, 'WiFi for remote work', 1001),
(13, 5, true, 'Parking spot', 1005),
(13, 7, true, 'Wood heater', 1007),
(13, 11, true, 'Rustic fireplace', 1011),
(13, 14, true, 'Pet friendly area', 1014);

-- Casa 14: Countryside
INSERT INTO HousingFacilities VALUES
(14, 1, true, 'WiFi in common areas', 1001),
(14, 4, true, 'Kitchen with countryside charm', 1004),
(14, 5, true, 'Free parking', 1005),
(14, 7, true, 'Heating included', 1007),
(14, 11, true, 'Stone fireplace', 1011);

-- Casa 15: Apartment
INSERT INTO HousingFacilities VALUES
(15, 1, true, 'Fast WiFi', 1001),
(15, 3, true, 'A/C throughout', 1003),
(15, 6, true, 'Flat screen TV', 1006),
(15, 8, true, 'Washer', 1008),
(15, 9, true, 'Dryer', 1009),
(15, 13, true, 'Balcony with street view', 1013);


-- Description modified

-- Cambiar el tipo de columna a TEXT para permitir descripciones largas
ALTER TABLE Housing MODIFY COLUMN description TEXT;

-- Actualizar descripciones
UPDATE Housing SET description = 'This charming countryside stay offers a peaceful retreat from the hustle and bustle of city life. With a cozy atmosphere, it’s perfect for families or small groups, providing ample space for relaxation. The property features two comfortable bedrooms, a modern bathroom, and a spacious living area with rustic décor. Spend your days exploring the surrounding countryside or enjoy a meal on the private patio while taking in the scenic views. Whether you are looking for outdoor adventure or a tranquil escape, this countryside stay is sure to meet your needs.' WHERE idHouse = 1;

UPDATE Housing SET description = 'Nestled in the heart of the countryside, this beautiful home offers a serene and tranquil getaway. Perfect for families or small groups, this house features three bedrooms, each thoughtfully designed with comfort in mind. With three bathrooms, there is plenty of space for everyone to relax. The spacious living room, with its inviting atmosphere and modern touches, is the perfect spot for family gatherings. The location allows you to explore nature trails or enjoy a peaceful evening under the stars. Don’t miss the chance to unwind in this tranquil haven.' WHERE idHouse = 2;

UPDATE Housing SET description = 'This tiny home is the perfect blend of modern design and compact luxury. Ideal for couples or small families, it boasts a functional and stylish layout that maximizes every inch of space. With a fully equipped kitchen, comfortable bedroom, and three bathrooms, this tiny home proves that small spaces can be both charming and practical. Located in a quiet area, it’s the ideal place to relax after a busy day exploring the nearby attractions. Enjoy the serenity and charm of this cozy home, designed with thoughtful details to make your stay unforgettable.' WHERE idHouse = 3;

UPDATE Housing SET description = 'This countryside stay offers a peaceful retreat surrounded by nature. The home features three cozy bedrooms and three bathrooms, making it ideal for families or small groups. With a large living area and a modern kitchen, this home provides all the comforts needed for an extended stay. Step outside to enjoy the private patio or explore the surrounding fields and trails. Whether you want to relax by the fire or embark on an outdoor adventure, this countryside home provides the perfect setting for a memorable vacation.' WHERE idHouse = 4;

UPDATE Housing SET description = 'This tiny home is both efficient and stylish, offering an ideal stay for solo travelers or couples. With four bedrooms, each thoughtfully designed for comfort, the home has all the necessary amenities including a fully equipped kitchen and one bathroom. Whether you are looking for a weekend getaway or an extended stay, this tiny home offers the perfect balance of comfort and convenience. Its quaint charm and functional design make it a perfect choice for anyone seeking a cozy, affordable escape.' WHERE idHouse = 5;

UPDATE Housing SET description = 'This cozy cabin is designed for ultimate relaxation and comfort. Located in a secluded area, it offers two bedrooms and two bathrooms, making it perfect for couples or small groups looking for a peaceful retreat. The living area is designed for relaxation, with a wood-burning stove and comfortable seating. Whether you’re exploring the nearby trails or simply enjoying a peaceful evening by the fire, this cabin offers a unique blend of nature and comfort that will make your stay unforgettable.' WHERE idHouse = 6;

UPDATE Housing SET description = 'This luxurious villa is the perfect getaway for those seeking comfort, privacy, and style. Featuring a spacious layout with one bedroom, one bath, and modern furnishings, the villa is designed to meet all your needs. Located in a prime area, it offers stunning views and an atmosphere of peace and tranquility. With a fully equipped kitchen, a washer, and Wi-Fi, you’ll have everything you need for a seamless stay. Relax in the villa’s chic environment or explore the vibrant surroundings of Port James, Portugal.' WHERE idHouse = 7;

UPDATE Housing SET description = 'Located in the heart of the city, this modern apartment provides the perfect blend of luxury and convenience. With two bedrooms, three beds, and two bathrooms, this apartment offers spacious accommodations for families or small groups. Enjoy a relaxing evening in the open-plan living area, cook a meal in the fully equipped kitchen, or explore the city’s attractions just a short walk away. Whether you are in the city for business or leisure, this apartment will meet all your needs while offering a high level of comfort and style.' WHERE idHouse = 8;

UPDATE Housing SET description = 'This spacious apartment is perfect for families or larger groups. With four bedrooms, five beds, and three bathrooms, there’s plenty of space for everyone to feel comfortable. The apartment is fully furnished with modern décor, offering all the comforts of home, including a fully equipped kitchen and a cozy living area. Located in a prime area of Transide, Germany, this apartment is just a short walk from local attractions, shopping, and restaurants. It’s the ideal place to relax after a busy day of sightseeing.' WHERE idHouse = 9;

UPDATE Housing SET description = 'This apartment offers a great value for those looking for a comfortable and affordable stay. With four bedrooms, four beds, and one bathroom, the apartment can accommodate small families or groups. Located in a convenient area with easy access to shops and restaurants, this apartment is perfect for travelers seeking both comfort and convenience. The open-plan living area is bright and airy, providing a welcoming space to relax after a busy day. A great option for those seeking a blend of value and comfort.' WHERE idHouse = 10;

UPDATE Housing SET description = 'This stylish cabin offers a perfect escape to nature while providing all the modern amenities you need for a comfortable stay. With two bedrooms, two beds, and one bathroom, the cabin is perfect for small families or groups of friends. Enjoy the open-air patio with beautiful views of the surrounding countryside or relax by the cozy fireplace inside. The cabin is equipped with a kitchen, washer, and air conditioning, making it a convenient and comfortable choice for a peaceful getaway in the heart of nature.' WHERE idHouse = 11;

UPDATE Housing SET description = 'This spacious apartment offers a high level of comfort and modern design. Located in a prime area of the USA, this apartment features five bedrooms, each carefully designed to provide comfort and relaxation. With a fully equipped kitchen, living area, and ample bathroom facilities, this apartment ensures your stay is both comfortable and convenient. Explore the vibrant city life or relax in the comfort of this well-appointed home. Whether you are visiting for business or leisure, this apartment is the ideal place to stay.' WHERE idHouse = 12;

UPDATE Housing SET description = 'This charming cabin is perfect for those looking to enjoy both comfort and nature. With three bedrooms and four beds, it comfortably accommodates families or small groups. The cabin features a well-equipped kitchen, a cozy living area, and a modern bathroom. The spacious backyard is perfect for outdoor dining, barbecues, and enjoying the fresh air. Set in a beautiful rural area, the cabin offers a peaceful environment ideal for relaxation, hiking, and outdoor activities.' WHERE idHouse = 13;

UPDATE Housing SET description = 'Located in a beautiful lakeside area, this countryside home offers a perfect escape for those seeking nature and tranquility. With three bedrooms, four beds, and three bathrooms, the home provides ample space for families or small groups. The spacious living room features large windows with picturesque views, making it an ideal place to relax. The outdoor area includes a private patio, perfect for dining or simply enjoying the fresh air. This countryside stay provides a wonderful balance of comfort and nature.' WHERE idHouse = 14;

UPDATE Housing SET description = 'This tiny home is designed to offer an intimate and cozy getaway for couples or solo travelers. Featuring a modern design and fully equipped with all the essentials, the tiny home makes the most of its compact space. With a small but efficient kitchen, a comfortable bedroom, and one bathroom, it provides everything needed for a convenient and enjoyable stay. Situated in a peaceful area, this tiny home is a perfect retreat for those who value simplicity and nature.' WHERE idHouse = 15;
