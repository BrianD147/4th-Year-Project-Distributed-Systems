package ie.gmit.sw.RMI;

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
	
	//establish a connection to the database
	protected DatabaseServiceImpl() throws RemoteException, SQLException {
		super();
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CARHIREDATABASE?useSSL=false", "root", "");
	}

	@Override
	public List<Order> read() throws RemoteException, SQLException {
		System.out.println("In read");
		stat = con.createStatement();
		
		List<Order> orderList = new ArrayList<Order>(); // List to hold all orders
		
		String selectQuery = "select * from orders ORDER BY OrderID"; // query to get all items in the table
		
		ResultSet rs = stat.executeQuery(selectQuery); // execute query
		
		// read all lines the query returns
		while(rs.next()){
			int OrderID = rs.getInt("OrderID");
			String StartDate = rs.getString("StartDate");
			String EndDate = rs.getString("EndDate");
			int CustID = rs.getInt("CustID");
			String CarReg = rs.getString("CarReg");
			
			Order o = new Order();
			//Order o = new Order(OrderID, StartDate, EndDate, CustID, CarReg);
			
			// set all variables to the order
			o.setOrderID(OrderID);
			o.setStartDate(StartDate);
			o.setEndDate(EndDate);
			o.setCust(CustID);
			o.setCarReg(CarReg);
			
			// add the order to the list
			orderList.add(o);
		}
		// return the list
		return orderList;
	}
	
	@Override
	public List<Order> write(String input) throws RemoteException, SQLException {
		System.out.println("In write");
		//System.out.println(input);
		stat = con.createStatement();
				
		// edit the input to remove unneeded substrings
		input = input.replace("startDate=", "");
		input = input.replace("endDate=", "");
		input = input.replace("custID=", "");
		input = input.replace("carReg=", "");
		
		String[] inputParts = input.split("&"); // split the string into an array, making the use of each part much easier
		
		for (int j = 0; j < inputParts.length; j++) {
			System.out.println("->> " + inputParts[j]);
		}
		
		List<Order> orderList = new ArrayList<Order>(); // List to hold all orders
		
		// write query using values from input
		String writeQuery = "INSERT INTO Orders (OrderID, StartDate, EndDate, CustID, CarReg) VALUES " + 
							"(NULL, '" + inputParts[0] + "', '" + inputParts[1] + "', " + inputParts[2] + ", '" + inputParts[3] + "');";
		
		stat.executeUpdate(writeQuery); // execute query
		
		String selectQuery = "select * from orders ORDER BY OrderID"; // query to get all items in the table
		
		ResultSet rs = stat.executeQuery(selectQuery); // execute query
		
		// read all lines the query returns
		while(rs.next()){
			int OrderID = rs.getInt("OrderID");
			String StartDate = rs.getString("StartDate");
			String EndDate = rs.getString("EndDate");
			int CustID = rs.getInt("CustID");
			String CarReg = rs.getString("CarReg");
			
			Order o = new Order();
			//Order o = new Order(OrderID, Date, CustID, CarReg);
			
			// set all variables to the order
			o.setOrderID(OrderID);
			o.setStartDate(StartDate);
			o.setEndDate(EndDate);
			o.setCust(CustID);
			o.setCarReg(CarReg);
			
			// add the order to the list
			orderList.add(o);
		}
		// return the list
		return orderList;
	}
	
	@Override
	public List<Order> update(String input) throws RemoteException, SQLException {
		System.out.println("In update");
		stat = con.createStatement();
		
		//System.out.println("Before: " + input);
		
		String[] inputParts = input.split("&"); // split the string into an array, making the use of each part much easier
		
		//System.out.println("First position: " + inputParts[0]);
		
		// edit the input to fit the query request below
		input = input.replace(inputParts[0], "");
		input = input.replace("&", "', ");
		input = input.replace("', startDate=", "startDate='");
		input = input.replace("endDate=", "endDate='");
		input = input.replace("custID=", "custID='");
		input = input.replace("carReg=", "carReg='");

		input = input + "'";
		
		input = input.replace("startDate='',", "");
		input = input.replace("endDate='',", "");
		input = input.replace("custID='',", "");
		input = input.replace("carReg=''", "");
		
		input = input.replaceAll(" ", "");
		
		if(input.endsWith(",")){
			input = input.substring(0, input.length()-1);
		}
		
		//System.out.println("After: " + input);
		
		/*
		for (int j = 0; j < inputParts.length; j++) {
			System.out.println("->> " + inputParts[j]);
		}
		*/
		
		List<Order> orderList = new ArrayList<Order>(); // List to hold all orders
		
		String updateQuery = "UPDATE Orders SET " + input + " WHERE " + inputParts[0] + ";"; //query to update table
		
		stat.executeUpdate(updateQuery); // execute query
		
		String selectQuery = "select * from orders ORDER BY OrderID"; // query to get all items in the table
		
		ResultSet rs = stat.executeQuery(selectQuery); // execute query
		
		// read all lines the query returns
		while(rs.next()){
			int OrderID = rs.getInt("OrderID");
			String StartDate = rs.getString("StartDate");
			String EndDate = rs.getString("EndDate");
			int CustID = rs.getInt("CustID");
			String CarReg = rs.getString("CarReg");
			
			Order o = new Order();
			//Order o = new Order(OrderID, Date, CustID, CarReg);
			
			// set all variables to the order
			o.setOrderID(OrderID);
			o.setStartDate(StartDate);
			o.setEndDate(EndDate);
			o.setCust(CustID);
			o.setCarReg(CarReg);
			
			// add the order to the list
			orderList.add(o);
		}
		// return the list
		return orderList;
	}

	@Override
	public List<Order> delete(String input) throws RemoteException, SQLException {
		System.out.println("In delete");
		System.out.println("->> " + input);
		stat = con.createStatement();
		
		List<Order> orderList = new ArrayList<Order>(); // List to hold all orders
		
		String deleteQuery = "DELETE FROM Orders WHERE " + input + ";"; //query to delete order from table
		
		stat.executeUpdate(deleteQuery); // execute query
		
		String selectQuery = "select * from orders ORDER BY OrderID"; // query to get all items in the table
		
		ResultSet rs = stat.executeQuery(selectQuery); // execute query
		
		// read all lines the query returns
		while(rs.next()){
			int OrderID = rs.getInt("OrderID");
			String StartDate = rs.getString("StartDate");
			String EndDate = rs.getString("EndDate");
			int CustID = rs.getInt("CustID");
			String CarReg = rs.getString("CarReg");
			
			Order o = new Order();
			//Order o = new Order(OrderID, Date, CustID, CarReg);
			
			// set all variables to the order
			o.setOrderID(OrderID);
			o.setStartDate(StartDate);
			o.setEndDate(EndDate);
			o.setCust(CustID);
			o.setCarReg(CarReg);
			
			// add the order to the list
			orderList.add(o);
		}
		// return the list
		return orderList;
	}

}
