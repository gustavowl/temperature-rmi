
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ServerMain {
	
	public static void main (String args[]) throws RemoteException, MalformedURLException, AlreadyBoundException {
		Scanner scan = new Scanner(System.in);
		System.out.print("Type name of the City for this server: ");
		String cityName = scan.nextLine();
		
		while (! TemperatureInterface.isCityRegistered(cityName)) {
			System.out.println("Invalid City Name, please try again.");
			System.out.print("Type name of the City for this server: ");
			cityName = scan.nextLine();
		}
		scan.close();
		
		//valid city entered. Bind object to rmi
		try {
			TemperatureInterface server = new TemperatureServer(cityName);
			TemperatureInterface stub = (TemperatureInterface) UnicastRemoteObject.exportObject(server, 0);
			Registry registry = LocateRegistry.getRegistry(1099);
			//Naming.bind(server.getServerName(), server);
			registry.rebind(stub.getName(), stub);
			System.out.println("RMI Object name: " + stub.getName());
		}
		catch (RemoteException e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}

}
