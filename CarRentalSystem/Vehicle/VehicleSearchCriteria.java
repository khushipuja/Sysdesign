package CarRentalSystem.Vehicle;


import java.util.*;

public class VehicleSearchCriteria {

    private String make;
    private String model;
    private int year;
    private String color;
    private VehicleType type;
    private Date reservationFrom;
    private Date reservationTo;

    public VehicleSearchCriteria(String make, String model, int year, String color, VehicleType type, Date reservationFrom, Date reservationTo) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.type = type;
        this.reservationFrom = reservationFrom;
        this.reservationTo = reservationTo;
    }

    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public String getColor() {
        return color;
    }
    public VehicleType getType() {
        return type;
    }
    public Date getReservationFrom() {
        return reservationFrom;
    }
    public Date getReservationTo() {
        return reservationTo;
    }
}
