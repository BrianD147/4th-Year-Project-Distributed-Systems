Create DATABASE CARHIREDATABASE;
use CARHIREDATABASE;

CREATE TABLE IF NOT EXISTS Orders (
	OrderID int NOT NULL AUTO_INCREMENT,
	StartDate varchar(12) NOT NULL,
	EndDate varchar(12) NOT NULL,
	CustID int NOT NULL,
	CarReg varchar(12),
	PRIMARY KEY (OrderID)
);

INSERT INTO Orders (OrderID, StartDate, EndDate, CustID, CarReg)
VALUES (1, "09-12-1018", "09-12-1018", 11, "02-G-123"), 
       (2, "09-12-1018", "09-12-1018", 21, "02-G-125"), 
	   (3, "09-12-1018", "09-12-1018", 31, "02-G-124");
	   
SELECT * FROM Orders;