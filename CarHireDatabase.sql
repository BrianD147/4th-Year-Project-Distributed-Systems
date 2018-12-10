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
VALUES (1, "09-12-2018", "11-12-2018", 0143, "02-G-123"), 
       (2, "10-05-2019", "11-05-2019", 3825, "05-LS-542"), 
	   (3, "13-07-2019", "16-07-2019", 7583, "08-G-7492"),
	   (4, "10-04-2019", "11-04-2019", 8463, "07-M-93"),
	   (5, "09-12-2018", "12-12-2018", 0563, "06-T-746"),
	   (6, "14-11-2018", "18-11-2018", 8365, "09-LS-394"),
	   (7, "25-12-2018", "27-12-2018", 2947, "05-M-1493"),
	   (8, "23-03-2019", "26-03-2019", 4957, "08-T-275"),
	   (9, "15-09-2019", "16-09-2019", 2946, "06-D-965"),
	   (10, "03-01-2019", "07-01-2019", 1937, "09-LS-1374");
	   
SELECT * FROM Orders;