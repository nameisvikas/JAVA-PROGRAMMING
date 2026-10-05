class TicketBooking {
    String passengerName;
    String bookingStatus;

    TicketBooking(String passengerName) {
        this.passengerName = passengerName;
        this.bookingStatus = "Confirmed";
    }

    void displayBookingDetails() {
        System.out.println("Passenger Name: " + passengerName);
        System.out.println("Booking Status: " + bookingStatus);
        System.out.println("Thread Name: " + Thread.currentThread().getName());
        System.out.println("Thread ID: " + Thread.currentThread().getId());
        System.out.println("--------------------------------");
    }
}

class BookingThread extends Thread {
    TicketBooking booking;

    BookingThread(TicketBooking booking) {
        this.booking = booking;
    }

    @Override
    public void run() {
        System.out.println("Processing booking...");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

        booking.displayBookingDetails();
    }
}

class BookingRunnable implements Runnable {
    TicketBooking booking;

    BookingRunnable(TicketBooking booking) {
        this.booking = booking;
    }

    @Override
    public void run() {
        System.out.println("Processing booking...");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

        booking.displayBookingDetails();
    }
}

public class Practicum8 {
    public static void main(String[] args) {

        TicketBooking booking1 = new TicketBooking("Rahul");
        TicketBooking booking2 = new TicketBooking("Priya");
        TicketBooking booking3 = new TicketBooking("Aman");
        TicketBooking booking4 = new TicketBooking("Neha");

        BookingThread thread1 = new BookingThread(booking1);
        BookingThread thread2 = new BookingThread(booking2);

        BookingRunnable runnable1 = new BookingRunnable(booking3);
        BookingRunnable runnable2 = new BookingRunnable(booking4);

        Thread thread3 = new Thread(runnable1);
        Thread thread4 = new Thread(runnable2);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("All passenger booking requests have been processed successfully.");
    }
}
