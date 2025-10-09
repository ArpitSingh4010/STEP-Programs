class AppConfig {
private String appName;
// Optional static member accessible from static nested class
static String PLATFORM = "Java";

public AppConfig(String appName) {
this.appName = appName;
}
 static class NetworkConfig {
private String host;
private int port;
// TODO: Display network config with optional access to app static members
public NetworkConfig(String host, int port) {
this.host = host;
this.port = port;
}

public void display() {
System.out.println("NetworkConfig -> host: " + host + ", port: " + port +
" (Platform: " + AppConfig.PLATFORM + ")");
}

@Override
public String toString() {
return "NetworkConfig[host=" + host + ", port=" + port + "]";
}
}
}
public class AppConfigurator {
public static void main(String[] args) {
// Create instance of NetworkConfig, print details
AppConfig.NetworkConfig net = new AppConfig.NetworkConfig("localhost", 8080);
System.out.println(net);
net.display();
}
}