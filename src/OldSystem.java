public class OldSystem { void oldPay(int cents) { System.out.println("Paid: " + cents + " cents"); } }

interface NewPayment { void pay(double dollars); }

class SystemAdapter implements NewPayment {
    private OldSystem old;
    public SystemAdapter(OldSystem old) { this.old = old; }
    public void pay(double dollars) { old.oldPay((int)(dollars * 100)); }
}
