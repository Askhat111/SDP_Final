import java.util.ArrayList;
import java.util.List;

interface Notifier { void alert(String msg); }

class Customer implements Notifier {
    public void alert(String msg) { System.out.println("Customer: " + msg); }
}

class Kitchen implements Notifier {
    public void alert(String msg) { System.out.println("Kitchen: " + msg); }
}

class Order {
    private List<Notifier> notifiers = new ArrayList<>();
    public void subscribe(Notifier n) { notifiers.add(n); }
    public void updateStatus(String status) {
        for (Notifier n : notifiers) n.alert("Status: " + status);
    }
}
