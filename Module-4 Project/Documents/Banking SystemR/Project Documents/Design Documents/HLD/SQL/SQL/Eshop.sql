--drop constraints

ALTER TABLE Order_Details DROP CONSTRAINT pkck CASCADE;
ALTER TABLE Order_Details DROP CONSTRAINT fk_Order_Details_productId CASCADE;
ALTER TABLE Order_Details DROP CONSTRAINT fk_Order_Details_customerId CASCADE;
ALTER TABLE Order_Details DROP CONSTRAINT nn_Order_Details_date CASCADE;
ALTER TABLE Order_Details DROP CONSTRAINT nn_Order_Details_status CASCADE;
ALTER TABLE Order_Details DROP CONSTRAINT nn_Order_Details_quantity CASCADE;
ALTER TABLE Order_Details DROP CONSTRAINT nn_Order_Details_total_price CASCADE;

ALTER TABLE Customer DROP CONSTRAINT fk_customer_User_Details_Id CASCADE;
ALTER TABLE Customer DROP CONSTRAINT nn_customer_Name CASCADE;
ALTER TABLE Customer DROP CONSTRAINT nn_customer_City CASCADE;
ALTER TABLE Customer DROP CONSTRAINT nn_customer_email CASCADE;
ALTER TABLE Customer DROP CONSTRAINT nn_customer_mobile CASCADE;

ALTER TABLE Product_Image DROP CONSTRAINT fk_productImage_productId CASCADE;
ALTER TABLE Product_Image DROP CONSTRAINT nn_productImage_Image CASCADE;

ALTER TABLE Product DROP CONSTRAINT pk_product_productId CASCADE;
ALTER TABLE Product DROP CONSTRAINT nn_product_productName CASCADE;
ALTER TABLE Product DROP CONSTRAINT nn_product_productDescription CASCADE;
ALTER TABLE Product DROP CONSTRAINT fk_product_productSubCategory CASCADE;
ALTER TABLE Product DROP CONSTRAINT nn_product_price CASCADE;
ALTER TABLE Product DROP CONSTRAINT nn_product_quantity CASCADE;

ALTER TABLE Sub_Category DROP CONSTRAINT pk_subCategory_Name CASCADE;
ALTER TABLE Sub_Category DROP CONSTRAINT fk_category_categoryName CASCADE;

ALTER TABLE Category DROP CONSTRAINT pk_category_categoryName CASCADE;

ALTER TABLE User_Details_Team1 DROP CONSTRAINT pk_User_Details_Id CASCADE;
ALTER TABLE User_Details_Team1 DROP CONSTRAINT nn_User_Details_password CASCADE;
ALTER TABLE User_Details_Team1 DROP CONSTRAINT nn_User_Details_role CASCADE;


--drop tables

DROP TABLE Order_Details;
DROP TABLE Customer;
DROP TABLE User_Details_Team1;
DROP TABLE Product_Image;
DROP TABLE Product;
DROP TABLE Sub_Category;
DROP TABLE Category;



--drop sequences

DROP SEQUENCE Product_Id_Sequence;
DROP SEQUENCE  Order_Details_Id_Sequence;



--Create tables

CREATE TABLE User_Details_Team1
(
	User_Id VARCHAR2(10) CONSTRAINT pk_User_Details_Id PRIMARY KEY,
	password VARCHAR2(20) CONSTRAINT nn_User_Details_password NOT NULL,
	role VARCHAR2(20) CONSTRAINT nn_User_Details_role  NOT NULL
);


CREATE TABLE Category
(
	Category_Name VARCHAR2(30)  CONSTRAINT pk_category_categoryName PRIMARY KEY
);


CREATE TABLE Sub_Category
(
	sub_category_name VARCHAR2(50) CONSTRAINT pk_subCategory_Name PRIMARY KEY,
	category_name VARCHAR2(30)  CONSTRAINT fk_category_categoryName REFERENCES CATEGORY(category_name)
);


CREATE TABLE Product
(
	product_id  VARCHAR2(10) CONSTRAINT pk_product_productId PRIMARY KEY,
	product_name  VARCHAR2(50) CONSTRAINT nn_product_productName NOT NULL,
	product_description VARCHAR2(100)  CONSTRAINT nn_product_productDescription NOT NULL,
	product_sub_category VARCHAR2(50) CONSTRAINT fk_product_productSubCategory REFERENCES  SUB_CATEGORY		(sub_category_name),
	product_price Decimal(8,2) CONSTRAINT nn_product_price NOT NULL,
	quantity NUMBER CONSTRAINT nn_product_quantity NOT NULL	
);


CREATE TABLE Product_Image
(
	product_id VARCHAR2(10) CONSTRAINT fk_productImage_productId REFERENCES PRODUCT(product_id),
	image VARCHAR2(50)  CONSTRAINT nn_productImage_Image NOT NULL
);


CREATE TABLE Customer
(
	customer_id VARCHAR2(10) CONSTRAINT fk_customer_User_Details_Id REFERENCES User_Details_Team1(User_Id),
	customer_name VARCHAR2(30) CONSTRAINT nn_customer_Name NOT NULL,
	customer_city VARCHAR2(30) CONSTRAINT nn_customer_City NOT NULL,
	customer_email VARCHAR2(30) CONSTRAINT nn_customer_email NOT NULL,
	customer_mobile VARCHAR2(10) CONSTRAINT nn_customer_mobile NOT NULL
);


CREATE TABLE Order_Details
(
	Order_id VARCHAR2(20),
	product_id VARCHAR2(20) CONSTRAINT fk_Order_Details_productId REFERENCES PRODUCT(product_id),
	customer_id VARCHAR2(10) CONSTRAINT fk_Order_Details_customerId REFERENCES User_Details_Team1(User_Id),
	Order_date DATE CONSTRAINT nn_Order_Details_date NOT NULL,
	Order_status VARCHAR2(20) CONSTRAINT nn_Order_Details_status NOT NULL,
	total_price Decimal(8,2) CONSTRAINT nn_Order_Details_total_price NOT NULL,
	quantity NUMBER CONSTRAINT nn_Order_Details_quantity NOT NULL,	
	constraint pkck  PRIMARY KEY(Order_id,product_id)
);




--Create sequences
CREATE SEQUENCE Product_Id_Sequence
START WITH 29
INCREMENT BY 1
NOCACHE 
NOCYCLE;

CREATE SEQUENCE Order_Details_Id_Sequence
START WITH 1
INCREMENT BY 1
NOCACHE 
NOCYCLE;

--Insert statements

INSERT INTO User_Details_Team1 VALUES('mrunalee','mrunalee','admin');
INSERT INTO User_Details_Team1 VALUES('amit','amit','sales manager');
INSERT INTO User_Details_Team1 VALUES('shrikant','shrikant','customer');


INSERT INTO category VALUES('PHONES');
INSERT INTO category VALUES('COMPUTERS');
INSERT INTO category VALUES('ENTERTAINMENT');
INSERT INTO category VALUES('HOME APPLIANCES');
INSERT INTO category VALUES('CAMERAS');



INSERT INTO sub_category VALUES('Android','PHONES');
INSERT INTO sub_category VALUES('Symbian Classic Phone','PHONES');
INSERT INTO sub_category VALUES('Windows','PHONES');
INSERT INTO sub_category VALUES('Desktop','COMPUTERS');
INSERT INTO sub_category VALUES('Laptop','COMPUTERS');
INSERT INTO sub_category VALUES('DVD Player','ENTERTAINMENT');
INSERT INTO sub_category VALUES('LCD TV','ENTERTAINMENT');
INSERT INTO sub_category VALUES('LED TV','ENTERTAINMENT');
INSERT INTO sub_category VALUES('Air Conditioner','HOME APPLIANCES');
INSERT INTO sub_category VALUES('Refrigerator','HOME APPLIANCES');
INSERT INTO sub_category VALUES('Washing Machine','HOME APPLIANCES');
INSERT INTO sub_category VALUES('Camcorder','CAMERAS');
INSERT INTO sub_category VALUES('Digital Camera','CAMERAS');
INSERT INTO sub_category VALUES('SLR','CAMERAS');


--PHONES
INSERT INTO product VALUES('1','Micromax-canvas','New Micromax Canvas Turbo A250-White-13MP-Dual sim 1.5 GHz','Android',10000.00,10);
INSERT INTO product_image VALUES('1', '/Eshop/images/Micromax-canvas.jpg');

INSERT INTO product VALUES('2','Samsung-Galaxy','Samsung-Galaxy S3 suparfone Android 8MP camera','Android',32000.00,10);
INSERT INTO product_image VALUES(2, '/Eshop/images/Samsung-Galaxy.jpg');

INSERT INTO product VALUES('3','Blackberry-Curve','Blackberry-Curve symbian classic phone Z30 wit VAT invoice','Symbian Classic Phone',40950.00,10);
INSERT INTO product_image VALUES(3, '/Eshop/images/Blackberry-Curve.jpg');

INSERT INTO product VALUES('4','Blackberry-Symbian-Phone','Genuine brand New Blackberry Q10 16GB 1.5GHz dual core 8MP,3.1" Display','Symbian Classic Phone',44545.00,10);
INSERT INTO product_image VALUES(4, '/Eshop/images/Blackberry-Symbian-Phone.jpg');

INSERT INTO product VALUES('5','Nokia-lumia-520','Nokia-lumia-620 WINDOWS 8 Dual core 1GHZ Processor','Windows',11000.00,10);
INSERT INTO product_image VALUES('5', '/Eshop/images/Nokia-lumia-520.jpg');

INSERT INTO product VALUES('6','Nokia-lumia-620','Nokia-lumia-520 4" WINDOWS 8 Dual core 1GHZ Processor 5MP WiFi 3G Phone','Windows',8692.00,10);
INSERT INTO product_image VALUES('6', '/Eshop/images/Nokia-lumia-620.jpg');

--DESKTOP
INSERT INTO product VALUES('7','Lenevo-Desktop','Lenevo C440 Essential Desktop #rd Generation Win8 4GB RAM,500GB HDD','Desktop',49823.00,3);
INSERT INTO product_image VALUES('7', '/Eshop/images/Lenevo-Desktop.jpg');

INSERT INTO product VALUES('8','HP-Desktop','HP Elite 8100 CMT core 13/2GB DDR3/500GB','Desktop',32999.00,3);
INSERT INTO product_image VALUES('8', '/Eshop/images/HP-Desktop.jpg');

INSERT INTO product VALUES('9','Dell-vostro-notebook','Dell Inspiron 3421 Core i3,3rd Generation 6GB RAM 500GB HDD 14"','Laptop',29122.00,4);
INSERT INTO product_image VALUES('9', '/Eshop/images/Dell-vostro-notebook.jpg');

INSERT INTO product VALUES('10','HP-pavilion-notebook','HP 1000-1411TX Laptop,core i5 3rd Generation 500GB,HDD 4GB RAM 1GB Graphics','Laptop',49823.00,3);
INSERT INTO product_image VALUES('10', '/Eshop/images/HP-pavilion-notebook.jpg');

--ENTERTAINMENT
INSERT INTO product VALUES('11','Philips-DVD-player','New Philips DVP3608 DVD Player with USB+5.1output+mp3+jpeg','DVD Player',2485.00,4);
INSERT INTO product_image VALUES('11', '/Eshop/images/Philips-DVD-player.jpg');

INSERT INTO product VALUES('12','Sony-DVD-player','New Sony DVD-SR 370 with Pen-Drive/USB support@ Best Price..!!','DVD Player',5200.00,4);
INSERT INTO product_image VALUES('12','/Eshop/images/Sony-DVD-player.jpg');

INSERT INTO product VALUES('13','Samsung-LCD TV','Samsung 32" inch LCD TV Internet HD LAN Smart IPS Panel','LCD TV',25999.00,5);
INSERT INTO product_image VALUES('13', '/Eshop/images/Samsung-LCD TV.jpg');

INSERT INTO product VALUES('14','Videocon-LCD TV','Videocon 32"LCD TV INCH HD,USB,Full LED Remote IPS','LCD TV',5799.00,4);
INSERT INTO product_image VALUES('14', '/Eshop/images/Videocon-LCD TV.jpg');

INSERT INTO product VALUES('15','Samsung-LED TV','Samsung 32" inch LED TV-Full HD 32D500 series 5','LED TV',25799.00,5);
INSERT INTO product_image VALUES('15', '/Eshop/images/Samsung-LED TV.jpg');

INSERT INTO product VALUES('16','LG-LED TV','LG LED 16A 15.6"(16")HD Ready LED TV USB ,HDMI PORT','LED TV',36000.00,3);
INSERT INTO product_image VALUES('16', '/Eshop/images/LG-LED TV.jpg');

--HOME APPLIANCES

INSERT INTO product VALUES('17','Voltas-AC','Voltas-AC 1.57Ton Excellent Cooling AC','Air Conditioner',14999.00,6);
INSERT INTO product_image VALUES('17', '/Eshop/images/Voltas-AC.jpg');

INSERT INTO product VALUES('18','Electrolux-AC','Electrolux-AC split AC 1ton-12BTU-High Performance','Air Conditioner',15450.00,5);
INSERT INTO product_image VALUES('18', '/Eshop/images/Electrolux-AC.jpg');

INSERT INTO product VALUES('19','Videocon-Refrigerator','Videocon-Refrigerator 190Litres Color-White','Refrigerator',20000.00,4);
INSERT INTO product_image VALUES('19', '/Eshop/images/Videocon-Refrigerator.jpg');

INSERT INTO product VALUES('20','LG-Refrigerator','LG-Refrigerator 277Litres Color-Red','Refrigerator',26000.00,3);
INSERT INTO product_image VALUES('20', '/Eshop/images/LG-Refrigerator.jpg');

INSERT INTO product VALUES('21','Samsung-Washing Machine','LG LED 16A 15.6"(16")HD Ready LED TV USB ,HDMI PORT','Washing Machine',22000.00,3);
INSERT INTO product_image VALUES('21','/Eshop/images/Samsung-Washing Machine.jpg');

INSERT INTO product VALUES('22','LG-Washing Machine','LG-Washing Machine 6Kg Fully Automatic','Washing Machine',18500.00,3);
INSERT INTO product_image VALUES('22','/Eshop/images/LG-Washing Machine.jpg');

--CAMERAS
INSERT INTO product VALUES('23','Sony Camcorder','Sony HDR Camcorder-Full HD 32 X 200M HandyCam CX200E','Camcorder',16499.00,3);
INSERT INTO product_image VALUES('23', '/Eshop/images/Sony Camcorder.jpg');

INSERT INTO product VALUES('24','Panasonic Camcorder','Panasonic 3D Camcorder-HC-V720 Full HD 1920 X 1080M Stunning Video Quality','Camcorder',20500.00,2);
INSERT INTO product_image VALUES('24', '/Eshop/images/Panasonic Camcorder.jpg');

INSERT INTO product VALUES('25','Sony-cybershot','Sony Cybershot-shot DSC-H200 20.1 Megapixels Digital camera Black','Digital Camera',10696.00,3);
INSERT INTO product_image VALUES('25', '/Eshop/images/Sony-cybershot.jpg');

INSERT INTO product VALUES('26','Nikon-coolpix','Nikon cool pix S3500 20.1MP Digital Camera+4GB Card','Digital Camera',6350.00,2);
INSERT INTO product_image VALUES('26', '/Eshop/images/Nikon-coolpix.jpg');

insert into product values('27','Canon-SLR','Canon EOS 70D SLR Black,with kit EF-5 18-55mm IS S7M','SLR',72803.00,1);
INSERT INTO product_image VALUES('27', '/Eshop/images/Canon-SLR.jpg');

INSERT INTO product VALUES('28','Nikon-SLR','Nikon D3200 VR kit(18-55mm)24.2 Megapixels Digital SLR Camera-Black','SLR',29980.00,3);
INSERT INTO product_image VALUES('28', '/Eshop/images/Nikon-SLR.jpg');


INSERT INTO Order_Details VALUES(Order_Details_Id_Sequence.NEXTVAL,'23','mrunalee','19-Dec-2013','Pending',16499.00,1);
INSERT INTO Order_Details VALUES(Order_Details_Id_Sequence.NEXTVAL,'24','mrunalee','17-Dec-2013','Pending',20500.00,2);
INSERT INTO Order_Details VALUES(Order_Details_Id_Sequence.NEXTVAL,'22','amit','19-Dec-2013','Pending',18500.00,1);

commit;

