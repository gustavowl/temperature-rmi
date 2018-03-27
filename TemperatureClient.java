
import java.net.MalformedURLException;
import java.rmi.*;

public class TemperatureClient {
	
	public TemperatureClient() {
		
	}
	
	public double getCityTemperature(String cityName, String scale, String ipAddress) throws RemoteException {
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
	
	public static void main (String[] args) throws RemoteException {
		if (args.length >= 2 && args.length <= 3) {
			System.setProperty("java.security.policy", "file:./policy.policy");
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new SecurityManager());
			}
			
			String ipAddr = "localhost";
			
			if (args.length == 3) {
				ipAddr = args[2];
			}
			
			TemperatureClient client = new TemperatureClient();
			
			System.out.println("Temperature is " + client.getCityTemperature(args[0], args[1], ipAddr) + args[1]);	
		}
		else {
			System.out.println("Invalid number of args");
		}
		
	}

}
