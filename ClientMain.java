
import java.rmi.RemoteException;

public class ClientMain {
	
	static TemperatureClient client;
	
	public static void main (String[] args) throws RemoteException {
		System.setProperty("java.security.policy", "file:./policy.policy");
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		client = new TemperatureClient();
		
		//System.out.println("Type client name: ");
		client.setName("localhost");
		
		System.out.println("Temperature is " + client.getCityTemperature(args[0], args[1], args[2]) + args[1]);
	}

}
