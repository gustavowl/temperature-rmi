import com.weatherlibraryjava.*;
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.*;

public class TemperatureServer extends UnicastRemoteObject implements TemperatureInterface {

    private static final String KEY = "1e88145a18b241f68b7150325182603";
    private Repository r;

    public TemperatureServer() throws RemoteException {
        this.r = new Repository();
    }


    @Override
    public double getTemperature(String city, String scale) throws RemoteException {
		if(scale.toLowerCase().matches("c")){
			try {
				return r.GetWeatherData(KEY, RequestBlocks.GetBy.Metar.CityName, 
						city.trim().toLowerCase().replace(' ', '_')).getCurrent().getTempC();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return -273.15;
		}
		else {
			try {
				return r.GetWeatherData(KEY, RequestBlocks.GetBy.Metar.CityName, 
						city.trim().toLowerCase().replace(' ', '_')).getCurrent().getTempF();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return -459.67;
		}
    }

    public static void main (String args[]) throws MalformedURLException, AlreadyBoundException {

        /*System.setProperty("java.security.policy", "file:///tmp/test.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }*/

        try {
            TemperatureServer ts = new TemperatureServer();
            //System.setProperty("java.rmi.server.hostname", "192.168.0.97");
            Naming.rebind("TemperatureServer", ts);
            ServerMain.printRmiObject("TemperatureServer");
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}