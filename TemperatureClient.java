
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TemperatureClient {
	
	boolean isNameSet;
	String name;
	
	public TemperatureClient() {
		isNameSet = false;
	}
	
	public void setName(String name) {
		if (!isNameSet) {
			this.name = name;
			isNameSet = true;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getCityTemperature(String cityName) throws RemoteException {
		String serverName = TemperatureInterface.getServerName(cityName);
		try {
			TemperatureInterface server = (TemperatureInterface) Naming.lookup(
					"//localhost/" + serverName);
			/*String serverIp = "192.168.0.97";
			int serverPort = 1099;
			Registry registry = LocateRegistry.getRegistry(serverIp, serverPort);
			TemperatureInterface server = (TemperatureInterface) registry.lookup(serverName);*/
			return server.getTemperature();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("This city is not registered in our servers.");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -237; //absolute 0
	}

}
