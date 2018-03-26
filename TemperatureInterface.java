
import java.rmi.*;

public interface TemperatureInterface extends Remote {
	
	public static boolean isCityRegistered(String cityName) throws RemoteException {
		return true;
	}
	
	public static String getServerName(String cityName) throws RemoteException {
		return "Temperature/" + cityName.trim().toLowerCase().replace(' ', '_');
	}
	
	public int getTemperature() throws RemoteException;
}
