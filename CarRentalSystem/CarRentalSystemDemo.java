package CarRentalSystem;

import CarRentalSystem.Vehicle.Car;
import CarRentalSystem.Vehicle.Vehicle;
import CarRentalSystem.Vehicle.VehicleSearchCriteria;
import CarRentalSystem.Vehicle.VehicleType;

import java.util.Date;

public class CarRentalSystemDemo {

    public static void main(String[] args) {

        Car v1  = new Car("2a","199",2020, VehicleType.CAR,100.80);
        Car v2  = new Car("a3","159",2020, VehicleType.CAR,1300.80);
        Car v3  = new Car("a3","159",2020, VehicleType.CAR,1030.80);

        Date d1 = new Date();
        Date d2 = new Date(new Date().getTime() + 5000);


        VehicleSearchCriteria vehicleSearchCriteria = new VehicleSearchCriteria("2a","199",2020,"black", VehicleType.CAR,d1,d2);
        CarRentalSystem carRentalSystem = CarRentalSystem.getInstance();
        carRentalSystem.searchVehicles(vehicleSearchCriteria);
    }
}
