
import java.net.MalformedURLException;
import java.rmi.*;

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
			TemperatureInterface server = (TemperatureInterface) Naming.lookup(serverName);
			return server.getTemperature();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("This city is not registered in our servers.");
		}
		return -237; //absolute 0
	}

}
