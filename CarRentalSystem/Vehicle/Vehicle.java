package CarRentalSystem.Vehicle;

import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Getter
@Setter
public abstract class Vehicle {

    private int id;
    private String make;
    private String model;
    private int year;
    private Status status;
    private VehicleType vehicleType;
    private List<Date> reservedDates;
    private double price;

    public Vehicle(String make, String model, int year, VehicleType vehicleType,double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.vehicleType = vehicleType;
        this.reservedDates = new ArrayList<>();
        this.price = price;
        this.id = UUID.randomUUID().hashCode();
    }

    public void addReservedDate(Date date) {
        this.reservedDates.add(date);
    }

    public boolean isAvailable(Date date1,Date date2) {
        if (date1.after(date2)) {
            return false; // Invalid range
        }

        for (Date bookedDate : reservedDates) {
            if (!(bookedDate.after(date1) && !bookedDate.before(date2))) {
                return true; // Found a booked date in the range
            }
        }
        return false;
    }
}
