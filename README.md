# Compile Server Side

```
Terminal1$ javac -cp gson-2.6.2.jar:json-simple-1.1.jar:weatherlibraryjava.jar TemperatureInterface.java *Server*.java

Terminal2$ rmiregistry

Terminal1$ java -cp .:gson-2.6.2.jar:json-simple-1.1.jar:weatherlibraryjava.jar -Djava.rmi.server.hostname="IP.AD.DR.ES" TemperatureServer
```
Note: 2 terminals are needed. Check names before the "$"

# Compile Client Side
```
Terminal3$ javac TemperatureInterface.java *Client*.java
Terminal3$ java ClientMain <arg1> <arg2>
```
<arg1> is the City name, e.g. Natal, Fortaleza, London
<arg2> is the Temperature scale(?) "C" for Celsius or "F" for fahrenheit
Note: remember to update the server IP address accodingly (TemperatureClient.java:30)
