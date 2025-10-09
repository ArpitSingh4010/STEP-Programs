interface Notifier {
void send(String message);
}
public class Service {
public void triggerAlert() {
// TODO: Create Notifier instance using anonymous inner class and send an alert
 Notifier notifier = new Notifier() {
	 @Override
	 public void send(String message) {
		 System.out.println("ALERT: " + message);
	 }
 };

 notifier.send("Service threshold breached. Please investigate.");
}
public static void main(String[] args) {
new Service().triggerAlert();
}
}