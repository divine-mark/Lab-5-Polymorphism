class CardPayment {
    private final String cardNumber;
    CardPayment(String cardNumber) { this.cardNumber = cardNumber; }
    String getCardNumber() { return cardNumber; }
}

class MobileMoneyPayment {
    private final String phoneNumber;
    MobileMoneyPayment(String phoneNumber) { this.phoneNumber = phoneNumber; }
    String getPhoneNumber() { return phoneNumber; }
}

public class PaymentProcessor {

    // centralised logic, but must know every payment type
    public void pay(Object payment) {
        if (payment instanceof CardPayment c) {
            System.out.println("Charging card " + c.getCardNumber());
        } else if (payment instanceof MobileMoneyPayment m) {
            System.out.println("Charging mobile money " + m.getPhoneNumber());
        } else {
            throw new IllegalArgumentException("Unknown payment type");
        }
    }

    public static void main(String[] args) {
        PaymentProcessor p = new PaymentProcessor();
        p.pay(new CardPayment("4111-1111-1111-1111"));
        p.pay(new MobileMoneyPayment("+263771234567"));
    }
}