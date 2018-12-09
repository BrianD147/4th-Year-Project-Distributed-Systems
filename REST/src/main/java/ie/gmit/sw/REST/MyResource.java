package ie.gmit.sw.REST;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.RMI.DatabaseService;
import ie.gmit.sw.model.Order;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
     /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     * @throws Exception 
     * @throws RemoteException 
     * @throws MalformedURLException 
     * @throws SQLException 
     */
	@Path("/read")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Order> getIt() throws MalformedURLException, RemoteException, Exception, SQLException {
    	DatabaseService ds;
    	ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");
    	
        return ds.read();
    }
	
	@Path("/write")
	@POST
    @Produces(MediaType.APPLICATION_XML)
    public List<Order> writeIt(String input) throws MalformedURLException, RemoteException, Exception, SQLException {
    	DatabaseService ds;
    	ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");
    	
        return ds.write(input);
    }
	
	@Path("/update")
	@GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Order> updateIt() throws MalformedURLException, RemoteException, Exception, SQLException {
    	DatabaseService ds;
    	ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");
    	
        return ds.update();
    }
	
	@Path("/delete")
	@POST
    @Produces(MediaType.APPLICATION_XML)
    public List<Order> deleteIt(String input) throws MalformedURLException, RemoteException, Exception, SQLException {
    	DatabaseService ds;
    	ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/database");
    	
        return ds.delete(input);
    }
	
}
