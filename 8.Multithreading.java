class TicketBooking {
    String passengerName;
    String bookingStatus;

    TicketBooking(String passengerName) {
        this.passengerName = passengerName;
        this.bookingStatus = (passengerName == null || passengerName.trim().isEmpty()) ? "Failed (Invalid)" : "Confirmed";
    }

    void displayBookingDetails() {
        System.out.println("Passenger: " + passengerName +
                           " | Status: " + bookingStatus +
                           " | Thread Name: " + Thread.currentThread().getName() +
                           " | Thread ID: " + Thread.currentThread().getId());
    }
}

class BookingThread extends Thread {
    TicketBooking booking;

    BookingThread(TicketBooking booking) {
        this.booking = booking;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
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
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
        booking.displayBookingDetails();
    }
}

public class RailwayReservation {
    public static void main(String[] args) {
        TicketBooking tb1 = new TicketBooking("Rahul");
        TicketBooking tb2 = new TicketBooking("Priya");
        TicketBooking tb3 = new TicketBooking("Aman");
        TicketBooking tb4 = new TicketBooking("Neha");
        
        TicketBooking tb5 = new TicketBooking(""); 

        BookingThread t1 = new BookingThread(tb1);
        t1.setName(tb1.passengerName + "-Thread");

        BookingThread t2 = new BookingThread(tb2);
        t2.setName(tb2.passengerName + "-Thread");

        Thread t3 = new Thread(new BookingRunnable(tb3));
        t3.setName(tb3.passengerName + "-Runnable");

        Thread t4 = new Thread(new BookingRunnable(tb4));
        t4.setName(tb4.passengerName + "-Runnable");
        
        Thread t5 = new Thread(new BookingRunnable(tb5));
        t5.setName("Unknown-Runnable");

        System.out.println("\n--- Concurrent Booking Process Started ---");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("\nAll passenger booking requests have been processed successfully.");
    }
}
