import java.util.Scanner;

class Payment {

    void makePayment(double amount) {
        System.out.println("Payment Amount = " + amount);
    }

    void makePayment(double amount, String transactionId) {
        System.out.println("Amount = " + amount);
        System.out.println("Transaction ID = " + transactionId);
    }
}

class CreditCardPayment extends Payment {

    void makePayment(double amount) {
        System.out.println("Credit Card Payment");
        System.out.println("Amount = " + amount);
    }

    void makePayment(double amount, String transactionId) {
        System.out.println("Payment Amount = " + amount);
        System.out.println("Transaction ID = " + transactionId);
    }
}

class UPIPayment extends Payment {

    void makePayment(double amount) {
        System.out.println("UPI Payment");
        System.out.println("Amount = " + amount);
    }
}

class NetBankingPayment extends Payment {

    void makePayment(double amount) {
        System.out.println("Net Banking Payment");
        System.out.println("Amount = " + amount);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double creditAmount = sc.nextDouble();
        double paymentAmount = sc.nextDouble();
        String transactionId = sc.next();
        double upiAmount = sc.nextDouble();
        double netBankingAmount = sc.nextDouble();

        Payment payment;

        payment = new CreditCardPayment();
        payment.makePayment(creditAmount);
        payment.makePayment(paymentAmount, transactionId);

        payment = new UPIPayment();
        payment.makePayment(upiAmount);

        payment = new NetBankingPayment();
        payment.makePayment(netBankingAmount);

        sc.close();
    }
}
