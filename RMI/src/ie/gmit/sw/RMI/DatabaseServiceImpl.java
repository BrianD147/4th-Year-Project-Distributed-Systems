package ie.gmit.sw.RMI;

import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import ie.gmit.sw.model.Order;

public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService {

	private static final long serialVersionUID = 1L;
	private Connection con;
	private Statement stat;

	protected DatabaseServiceImpl() throws RemoteException, SQLException {
		super();
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CARHIREDATABASE?useSSL=false", "root", "");
	}

	@Override
	public List<Order> read() throws RemoteException, SQLException {
		System.out.println("In read");
		stat = con.createStatement();
		
		List<Order> carList = new ArrayList<Order>();
		
		String selectQuery = "select * from orders ORDER BY OrderID";
		
		ResultSet rs = stat.executeQuery(selectQuery);
		
		while(rs.next()){
			int OrderID = rs.getInt("OrderID");
			Date StartDate = rs.getDate("StartDate");
			Date EndDate = rs.getDate("EndDate");
			int CustID = rs.getInt("CustID");
			String CarReg = rs.getString("CarReg");
			
			Order o = new Order();
			//Order o = new Order(OrderID, StartDate, EndDate, CustID, CarReg);
			
			o.setOrderID(OrderID);
			o.setStartDate(StartDate);
			o.setEndDate(EndDate);
			o.setCust(CustID);
			o.setCarReg(CarReg);
			
			carList.add(o);
		}
		return carList;
	}
	
	@Override
	public List<Order> write() throws RemoteException, SQLException {
		System.out.println("In write");
		stat = con.createStatement();
		
		List<Order> carList = new ArrayList<Order>();
		
		String writeQuery = "INSERT INTO Orders (OrderID, StartDate, EndDate, CustID, CarReg) VALUES " + 
							"(4, CURDATE(), CURDATE(), 41, '02-G-126');";
		
		stat.executeUpdate(writeQuery);
		
		String selectQuery = "select * from orders ORDER BY OrderID";
		
		ResultSet rs = stat.executeQuery(selectQuery);
		
		while(rs.next()){
			int OrderID = rs.getInt("OrderID");
			Date StartDate = rs.getDate("StartDate");
			Date EndDate = rs.getDate("EndDate");
			int CustID = rs.getInt("CustID");
			String CarReg = rs.getString("CarReg");
			
			Order o = new Order();
			//Order o = new Order(OrderID, Date, CustID, CarReg);
			
			o.setOrderID(OrderID);
			o.setStartDate(StartDate);
			o.setEndDate(EndDate);
			o.setCust(CustID);
			o.setCarReg(CarReg);
			
			carList.add(o);
		}
		
		return carList;
	}

	@Override
	public List<Order> delete() throws RemoteException, SQLException {
		System.out.println("In write");
		stat = con.createStatement();
		
		List<Order> carList = new ArrayList<Order>();
		
		String deleteQuery = "DELETE FROM Orders WHERE OrderID = 3;";
		
		stat.executeUpdate(deleteQuery);
		
		String selectQuery = "select * from orders ORDER BY OrderID";
		
		ResultSet rs = stat.executeQuery(selectQuery);
		
		while(rs.next()){
			int OrderID = rs.getInt("OrderID");
			Date StartDate = rs.getDate("StartDate");
			Date EndDate = rs.getDate("EndDate");
			int CustID = rs.getInt("CustID");
			String CarReg = rs.getString("CarReg");
			
			Order o = new Order();
			//Order o = new Order(OrderID, Date, CustID, CarReg);
			
			o.setOrderID(OrderID);
			o.setStartDate(StartDate);
			o.setEndDate(EndDate);
			o.setCust(CustID);
			o.setCarReg(CarReg);
			
			carList.add(o);
		}
		
		return carList;
	}

}
