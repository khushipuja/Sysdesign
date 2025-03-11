package CarRentalSystem;

import CarRentalSystem.Vehicle.Vehicle;
import CarRentalSystem.Vehicle.VehicleController;
import CarRentalSystem.Vehicle.VehicleSearchCriteria;
import CarRentalSystem.payment.PaymentStrategy;
import CarRentalSystem.reservation.ReservationController;

import java.util.List;

public class CarRentalSystem {

    private static CarRentalSystem instance;
    private  ReservationController reservationController;
    private VehicleController vehicleController;

    private CarRentalSystem() {
        this.reservationController = new ReservationController();
        this.vehicleController = new VehicleController();
    }

    public static synchronized CarRentalSystem getInstance() {
        if (instance == null) {
            instance = new CarRentalSystem();
        }
        return instance;
    }

    public void searchVehicles(VehicleSearchCriteria criteria) {
        List<Vehicle> vehicleList = vehicleController.searchVehicle(criteria);
        System.out.println("FOUND " + vehicleList.size() + " vehicles");
        for(Vehicle vehicle : vehicleList) {
            System.out.println(vehicle);
        }
    }


    public void makePayment(Vehicle vehicle, PaymentStrategy paymentStrategy) {
        paymentStrategy.makePayment(vehicle.getPrice());
        vehicleController.reserveVehicle(vehicle);
    }
}
