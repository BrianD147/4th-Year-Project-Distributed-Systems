package ie.gmit.sw.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import ie.gmit.sw.model.Order;

public interface DatabaseService extends Remote {
	
	public List<Order> read() throws RemoteException, SQLException;

}
