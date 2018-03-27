
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
	
	public double getCityTemperature(String cityName, String scale, String ipAddress) throws RemoteException {
		String serverName = TemperatureInterface.getServerName(cityName);
		try {
			TemperatureInterface server = (TemperatureInterface) Naming.lookup(
					"//" + ipAddress + "/TemperatureServer");
			return server.getTemperature(cityName, scale);
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
