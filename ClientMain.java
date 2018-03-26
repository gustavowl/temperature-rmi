
import java.rmi.RemoteException;
import java.util.Scanner;

public class ClientMain {
	
	static TemperatureClient client;
	static Scanner scan = new Scanner(System.in);
	
	static void getTemperatureOfCity() throws RemoteException {
		System.out.print("Type City name: ");
		
		scan.nextLine(); //FIXME: arranjo tecnico
		
		String cityName = scan.nextLine();
		System.out.println("Temperature is " + client.getCityTemperature(cityName) + " Celsius");
	}
	
	static public boolean executeOption(int option) throws RemoteException {
		switch (option) {
			case 0:
				System.out.println("Goodbye, cruel World!!!");
				return false;
				
			case 1:
				getTemperatureOfCity();
				break;
				
			case 2:
				System.out.println("Do sumthin else");
				break;
				
			default:
				System.out.println("Invalid option!");
				break;
		}
		System.out.println("------------------------------");
		return true;
	}
	
	static public void printOptions() {
		System.out.println("0 - Quit");
		System.out.println("1 - Get temperature of a City");
		System.out.print("Choose your option: ");
	}
	
	public static void main (String[] args) throws RemoteException {
		System.setProperty("java.security.policy", "file:./policy.policy");
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		client = new TemperatureClient();
		
		//System.out.println("Type client name: ");
		client.setName("localhost");
		
		int option = 0;
		
		do {
			printOptions();
			option = scan.nextInt();
		} while (executeOption(option));
		//scan.close();
	}

}
