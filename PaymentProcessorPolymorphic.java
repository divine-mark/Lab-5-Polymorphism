interface Payment {
    void process();
}

class CardPayment implements Payment {
    private final String cardNumber;
    CardPayment(String cardNumber) { this.cardNumber = cardNumber; }

    @Override
    public void process() {
        System.out.println("Charging card " + cardNumber);
    }
}

class MobileMoneyPayment implements Payment {
    private final String phoneNumber;
    MobileMoneyPayment(String phoneNumber) { this.phoneNumber = phoneNumber; }

    @Override
    public void process() {
        System.out.println("Charging mobile money " + phoneNumber);
    }
}

public class PaymentProcessorPolymorphic {

    // EXPLAIN: no instanceof, no knowledge of concrete types
    public void pay(Payment p) {
        p.process();
    }

    public static void main(String[] args) {
        PaymentProcessorPolymorphic p = new PaymentProcessorPolymorphic();
        p.pay(new CardPayment("4111-1111-1111-1111"));
        p.pay(new MobileMoneyPayment("+263771234567"));
    }
}