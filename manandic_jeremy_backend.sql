-- Jeremy Manandic 
-- Project database
-- Written in MySQL

create database manandic_jeremy_db;
use manandic_jeremy_db;
-- ********* table creation ********** --
create table AddressOF (
	addressID integer not null,
    streetAddress char(20) not null,
    city char(20) not null,
    state char(15) not null,
    country char(20) not null,
    zipcode integer not null,
    primary key (addressID)
    );



create table Drivetrain (
	drivetrainID integer not null,
    name char(5) not null,
    primary key (drivetrainID)
    );
create table Make (
	makeID integer not null,
    name char(15) not null,
    country char(15) null,
    primary key (makeID)
    );
    
create table Model (
	modelID integer not null,
    makeID integer not null,
    name char(15) not null,
    primary key (modelID, makeID),
    foreign key (makeID) references Make(makeID)
	);
    
create table Color (
	colorID integer not null,
    name char(15) not null,
    primary key (colorID)
    );
    
create table Bodystyle (
	bodystyleID integer not null,
    name char(10) not null,
    primary key (bodystyleID)
    );
    
create table Transmission (
	transmissionID integer not null,
    name char(10) not null,
    primary key (transmissionID)
    );
    
create table Engine (
	engineID integer not null,
    name char(25) not null,
    primary key (engineID)
    );

create table FuelType (
	fueltypeID integer not null,
    name char(10) not null,
    primary key (fueltypeID)
    );
    
create table Category (
	categoryID integer not null,
    name char(10) not null,
    primary key (categoryID)
    );
    
create table Trims (
	trimID integer not null,
    name char(10) not null,
    primary key (trimID)
    );
    
create table Dealership (
	dealershipID integer not null,
    name char(20) not null,
    addressID integer not null,
    primary key (dealershipID)
    );

create table SalesRep (
	salesRepID integer not null,
    dealershipID integer not null,
    firstName char(12) not null,
    lastName char(12) not null,
    phone char(15) null,
    email char(25) null,
    primary key (salesRepID)
    );
    
create table Customer (
	customerID integer not null,
    firstName char(12) not null,
    lastName char(12) not null,
    phone char(15) null,
    addressID integer null,
    primary key (customerID)
    );
    
create table Vehicle (
	vin char(17) not null,
    makeID integer not null,
    modelID integer not null,
    colorID integer null,
    bodyStyleID integer null,
    drivetrainID integer null,
    engineID integer null,
    fueltypeID integer null,
    categoryID integer null,
    transmissionID integer null,
    trimID integer null,
    miles integer null,
    conditionCar char(10) null,
    dealershipID integer not null,
    price decimal(10,2) null,
    primary key (vin),
    foreign key (makeID) references Make(makeID),
    foreign key (modelID) references Model(modelID),
    foreign key (colorID) references Color(colorID),
    foreign key (bodyStyleID) references Bodystyle(bodystyleID),
    foreign key (drivetrainID) references Drivetrain(drivetrainID),
    foreign key (engineID) references Engine(engineID),
    foreign key (fueltypeID) references FuelType(fueltypeID),
    foreign key (categoryID) references Category(categoryID),
    foreign key (transmissionID) references Transmission(transmissionID),
    foreign key (trimID) references Trims(trimID),
    foreign key (dealershipID) references Dealership(dealershipID)
    );

create table OrderDetails (
	vin char(17) not null,
    customerID integer not null,
    salesRepID integer not null,
    orderDate char(20) null,
    otdPrice decimal(10,2) null,
    primary key (vin, customerID, salesRepID)
    );

-- ** enter data ** --
-- inserting into Address dealer address
insert into AddressOF values 
	(1001, '6969 Tyee Dr SW', 'Tumwater', 'Washington', 'USA', 98512);

insert into AddressOF values 
	(1002, '2700 NE 55th ST', 'Seattle', 'Washington', 'USA', 98105);
    
insert into AddressOF values 
	(1003, '7838 S Tacoma Way', 'Tacoma', 'Washington', 'USA', 98409);
    
insert into AddressOF values
	(1004, '4101 S Tacoma Way', 'Tacoma', 'Washington', 'USA', 98409);  
    
insert into AddressOF values
	(1005, '4110 S Tacoma Way', 'Tacoma', 'Washington', 'USA', 98409);  
    
insert into AddressOF values
	(1006, '400 River RD', 'Puyallup', 'Washington', 'USA', 98371);
    
-- inserting customer address --
insert into AddressOF values
	(2001, '3108 Crockett Ln', 'Beaverton', 'Washington', 'USA', 97008);

insert into AddressOF values
	(2002, '4655 Pinnickinick St', 'Vancouver', 'Washington', 'USA', 98663);
    
insert into AddressOF values
	(2003, '2861  University St', 'Seattle', 'Washington', 'USA', 98155);

insert into AddressOF values
	(2004, '4545  Horizon Circle', 'Tukwila', 'Washington', 'USA', 98188);
    
insert into AddressOF values
	(2005, '4063  Pratt Avenue', 'Bellingham', 'Washington', 'USA', 98225);

insert into AddressOF values
	(2006, '8401 Plum St', 'Olympia', 'Washington', 'USA', 98513);
    
-- ** inserting into make ** --
insert into Make values 
	(1, 'Toyota', 'Japan');

insert into Make values 
	(2, 'Honda', 'Japan');
    
insert into Make values 
	(3, 'Hyundai', 'South Korea');

insert into Make values 
	(4, 'Kia', 'South Korea');
    
insert into Make values 
	(5, 'Ford', 'USA');
    
insert into Make values 
	(6, 'Volkswagen', 'Germany');
    
insert into Make values 
	(7, 'Chevrolet', 'USA');
    
insert into Make values 
	(8, 'BMW', 'Germany');

insert into Make values 
	(9, 'Tesla', 'USA');
    
-- models --
-- Toyota --
insert into Model values 
	(101, 1,'Corolla' );

insert into Model values 
	(102, 1, 'Camry' );
    
insert into Model values 
	(103, 1, 'Tacoma' );
    
insert into Model values 
	(104, 1, '86' );
    
insert into Model values 
	(105, 1,'Celica' );
    
insert into Model values 
	(106, 1,'Rav-4' );

insert into Model values 
	(107, 1,'Supra' );
    
-- Honda -- 
insert into Model values
	(201, 2,'Civic');

insert into Model values
	(202, 2,'Accord');

insert into Model values
	(203, 2,'HRV');
    
insert into Model values
	(204, 2,'S2000');
    
insert into Model values
	(205, 2,'CRV');
    
insert into Model values
	(206, 2,'Pilot');
    
insert into Model values
	(207, 2,'Insight');
    
-- everything else --
INSERT INTO Model VALUES
    (301,3,'Accent'),
    (302,3,'Elantra'),
    (303,3,'Kona'),
    (304,3,'Veloster'),
    (305,3,'Tiburon'),
    (306,3,'Sonata'),
    (307,3,'SantaFe'),
    (401,4,'Rio'),
    (402,4,'Soul'),
    (403,4,'Forte'),
    (404,4,'Stinger'),
    (405,4,'Optima'),
    (406,4,'K900'),
    (407,4,'Sedona'),
    (501,5,'Focus'),
    (502,5,'Fusion'),
    (503,5,'Edge'),
    (504,5,'Mustang'),
    (505,5,'Falcon'),
    (506,5,'F150'),
    (507,5,'Ranger'),
    (601,6,'Golf'),
    (602,6,'Passat'),
    (603,6,'Jetta'),
    (604,6,'Beatle'),
    (701,7,'Cruze'),
    (702,7,'Camaro'),
    (703,7,'Tahoe'),
    (704,7,'Malibu'),
    (705,7,'Bolt'),
    (801,8,'328i'),
    (802,8,'x5'),
    (901,9,'Model S'),
    (902,9,'Model 3'),
    (903,9,'Model X'),
    (904,9,'Model Y');

INSERT INTO Color VALUES
    (1,'Red'),
    (2,'Blue'),
    (3,'Yellow'),
    (4,'Green'),
    (5,'White'),
    (6,'Grey'),
    (7,'Black');
    
INSERT INTO Bodystyle VALUES
    (1,'Coupe'),
    (2,'Sedan'),
    (3,'SUV'),
    (4,'Truck'),
    (5,'Van');
    
INSERT INTO Transmission VALUES
    (1,'5 Spd Man'),
    (2,'4 Spd Auto'),
    (3,'CVT'),
    (4,'6 Spd Man'),
    (5,'6 Spd Auto'),
    (6,'8 Spd Auto'),
    (7,'5 Spd Auto');

INSERT INTO FuelType Values
	(1, 'Gas'),
    (2, 'Disel'),
    (3, 'Electric');
    
INSERT INTO Category Values
	(1, 'Compact'),
    (2, 'Mid-Size'),
    (3, 'Full-Size'),
    (4, 'Muscle');
    
insert into Trims values
	(1, 'Base'),
    (2, 'Premium'),
    (3, 'Sport'),
    (4, 'Limited'),
    (5, 'Touring');
    
insert into Drivetrain values
	(1, 'RWD'),
    (2, 'FWD'),
    (3, 'AWD');
    
insert into Dealership values
	(1, 'Olympia Autos', 1001),
    (2, 'Billy Bobs Luxary', 1002),
    (3, 'South Tacoma Autos', 1003),
    (4, 'New and Used Autos', 1004),
    (5, 'Electrify Cars', 1005),
    (6, 'Puyallup Automotive', 1006);
    
INSERT INTO SalesRep VALUES
    (1,1001,'Efa','Zavala','253-171-8888','Zavala@Autos.com'),
    (2,1002,'Patrick','Einz','450-182-9873','Einz@Autos.com'),
    (3,1001,'Gonzo','Barlos','828-939-1431','Barlos@Autos.com'),
    (4,1003,'Lindsey','Chi','821-392-9983','Chi@Autos.com'),
    (5,1004,'David','Roberts','291-199-8391','Roberts@Autos.com'),
    (6,1005,'Joe','Link','453-234-1235','Link@Autos.com'),
    (7,1002,'Nick','Mick','124-234-9930','Mick@Autos.com'),
    (8,1006,'Jill','Filo','102-939-8839','Filo@Autos.com');

insert into Engine values
	(1, 'Turbo 4 Cyl'),
    (2, 'NA 4 Cyl'),
    (3, 'Turbo 6 Cyl'),
    (4, 'V6'),
    (5, 'V8'),
    (6, 'Electric');

INSERT INTO Vehicle VALUES
    ('1G1JC1243T7246823',1,101,5,2,1,4,1,1,3,2,43019,'Used',4,41484),
    ('JH4DA9450MS001229',1,103,6,4,3,3,1,2,3,1,100548,'Used',3,48102),
    ('5XYKT4A64CG224929',1,106,7,3,2,1,1,2,3,1,68166,'Used',1,27751),
    ('5GZCZ23D13S847842',1,107,5,1,2,4,1,2,2,1,0,'New',5,37179),
    ('JKBVNKD167A013982',2,201,1,2,2,4,1,2,5,1,18706,'Used',2,28294),
    ('1FAFP66L0WK258659',2,201,4,1,1,2,1,2,2,1,105945,'Used',3,45995),
    ('4T1SK12E1NU028452',2,205,4,3,2,3,1,2,2,1,63773,'Used',3,13220),
    ('1D7HU18D54S747050',3,305,6,1,2,3,1,2,4,3,0,'New',2,27419),
    ('5N1AA08A64N729252',3,306,4,2,3,3,1,2,3,1,97097,'Used',5,27991),
    ('1M1AK06Y96N008881',4,401,1,2,2,1,1,2,2,3,111231,'Used',2,35262),
    ('1FMZK05135GAGG488',4,401,3,2,1,5,1,2,1,3,0,'New',5,12234),
    ('1FAFP58U0XA209159',4,404,5,2,2,5,1,1,4,3,7033,'Used',2,27230),
    ('JN1BY1AR3BM374797',5,506,7,4,1,1,2,2,4,1,69635,'Used',2,41371),
    ('4A3AA46G11E035323',5,507,1,4,1,5,2,3,2,1,35153,'Used',4,22293),
    ('JH4KA4640LC001187',5,501,3,2,2,2,1,1,2,2,28260,'Used',4,19371),
    ('WDBJF65J1YB039105',5,505,5,1,1,3,1,2,2,2,0,'New',3,17806),
    ('JH4DA3350HS000229',6,601,4,2,1,3,1,2,1,1,92638,'Used',2,14444),
    ('1GCCS1956Y8235348',6,601,7,2,1,4,1,3,7,2,87315,'Used',4,42807),
    ('WA1LKAFP1AA007546',7,702,1,1,2,4,1,4,6,2,15710,'Used',5,40542),
    ('JH4KA2650HC000268',7,702,2,1,1,3,1,4,7,2,32387,'Used',6,49828),
    ('WDBAB23A6DB369209',7,702,3,1,2,3,1,4,7,1,73307,'Used',5,48847),
    ('JH4DA1740JS012019',7,705,1,2,2,6,3,3,2,1,0,'New',5,24580),
    ('JM3TB2MA5A0235007',8,801,6,2,2,4,1,2,6,3,80765,'Used',1,19545),
    ('JF1SF63501H759113',8,802,6,3,1,1,1,2,5,1,108778,'Used',4,26902),
    ('WAUYGAFC6CN174200',9,901,5,2,2,6,3,2,3,1,0,'New',2,43562);
    
INSERT INTO OrderDetails VALUES
    ('WAUYGAFC6CN174200',1,2,'2016-01-05 00:00:00',25000),
    ('WDBAB23A6DB369209',2,3,'2018-08-16 00:00:00',41000.45),
    ('JH4DA3350HS000229',3,8,'2017-06-11 00:00:00',12123.98),
    ('1FAFP66L0WK258659',4,4,'2018-05-18 00:00:00',44087.98),
    ('5GZCZ23D13S847842',3,7,'2018-09-04 00:00:00',32343.94);
    
INSERT INTO Customer VALUES
    (1,'Bob','Jenkens','360-123-8943',2001),
    (2,'Jane','Foster','889-193-3921',2003),
    (3,'Makoto','Nijima','842-813-9499',2004),
    (4,'Pedro','Pascal','113-492-2394',2006);

    

    
