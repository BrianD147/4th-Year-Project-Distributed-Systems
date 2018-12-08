Create DATABASE CARHIREDATABASE;
use CARHIREDATABASE;

CREATE TABLE IF NOT EXISTS Orders (
	OrderID int NOT NULL AUTO_INCREMENT,
	Date DATE Not Null,
	CustID int Not Null,
	CarReg varchar(12),
	PRIMARY KEY (OrderID)
);

INSERT INTO Orders (OrderID, Date, CustID, CarReg)
VALUES (1, CURDATE(), 11, "02-G-123"), 
       (2, CURDATE(), 21, "02-G-125"), 
	   (3, CURDATE(), 31, "02-G-124");
	   
SELECT * FROM Orders;