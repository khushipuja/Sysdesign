package AirlineManagementSystem;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class BookingSystemManager {

    private static BookingSystemManager bookingSystemManager;
    HashMap<String, Bookings> bookingsList;
    private AtomicInteger bookingCounter = new AtomicInteger(0);
    ReentrantLock lock = new ReentrantLock();

    private BookingSystemManager() {
        bookingsList  = new HashMap();
    }

    // Singleton Design Pattern
    public static synchronized BookingSystemManager getInstance() {
        if(bookingSystemManager == null){
            bookingSystemManager = new BookingSystemManager();
        }
        return bookingSystemManager;
    }

    public int generateBookingNumber(){
        int id = bookingCounter.incrementAndGet();
        return id;
    }

    public void showBookings(){
        for(Bookings bookings : bookingsList.values()){
            System.out.println(bookings);
        }
    }


    public void createBooking(Flight flight, Passenger passenger, Seat seat,double price) {
        String bookingNumber = String.valueOf(generateBookingNumber());

        try{
            lock.lock();
            bookingsList.put(bookingNumber,new Bookings(bookingNumber,null,new Date(),100.90));
        }catch(Exception e){
            System.out.println(e);
        }finally {
            lock.unlock();
        }

    }
}
