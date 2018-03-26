
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.*;

public class TemperatureServer extends UnicastRemoteObject implements TemperatureInterface {
	
	String serverName;

	public TemperatureServer() throws RemoteException {
		this("Natal");
	}
	
	public TemperatureServer(String cityName) throws RemoteException {
		super();
		serverName = TemperatureInterface.getServerName(cityName);
	}

	@Override
	public int getTemperature() throws RemoteException {
		// TODO Auto-generated method stub
		return 73;
	}
	
	/*public String getServerName() {
		return serverName;
	}*/
	
	public static void main (String args[]) throws MalformedURLException, AlreadyBoundException {
		
		/*System.setProperty("java.security.policy", "file:///tmp/test.policy");
		
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}*/
		
		try {
			TemperatureServer ts = new TemperatureServer(ServerMain.readCityName());
			System.setProperty("java.rmi.server.hostname", "192.168.0.97");
			Naming.rebind(ts.serverName, ts);
			ServerMain.printRmiObject(ts.serverName);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getName() throws RemoteException {
		return serverName;
	}

}
