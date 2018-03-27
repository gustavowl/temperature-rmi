# Compile Server Side

`
Terminal1$ javac TemperatureInterface.java *Server*.java

Terminal2$ rmiregistry

Terminal1$ java -Djava.rmi.server.hostname="IP.AD.DR.ES" TemperatureServer
`

# Compile Client Side
`
Terminal3$ javac TemperatureInterface.java *Client*.java
Terminal3$ java ClientMain
`
Note: remember to update the server IP address accodingly (TemperatureClient.java:30)
