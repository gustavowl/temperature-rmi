
import java.rmi.*;

public interface TemperatureInterface extends Remote {
	
	public static boolean isCityRegistered(String cityName) throws RemoteException {
		return true;
	}
	
	public static String getServerName(String cityName) throws RemoteException {
		return "Temperature_" + cityName.trim().toLowerCase().replace(' ', '_');
	}
	
	public double getTemperature(String city, String scale) throws RemoteException;
	
	//public String getName() throws RemoteException;
}
