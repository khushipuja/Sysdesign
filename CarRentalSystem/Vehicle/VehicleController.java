package CarRentalSystem.Vehicle;

import CarRentalSystem.reservation.ReservationStatus;

import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class VehicleController {
    Set<Vehicle> vehicles;
    public VehicleController() {
        vehicles = new HashSet<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public boolean isValid(Vehicle vehicle,VehicleSearchCriteria criteria) {
        if(criteria.getType() != null && criteria.getType().equals(vehicle.getVehicleType())) {
            return vehicle.isAvailable(criteria.getReservationFrom(),criteria.getReservationTo());
        }
        return false;
    }

    public List<Vehicle> searchVehicle(VehicleSearchCriteria criteria) {
      List<Vehicle> vehicles = new ArrayList<>();
      for(Vehicle vehicle : vehicles) {
          if(isValid(vehicle , criteria)){
              vehicles.add(vehicle);
          }
      }
      return vehicles;
    }

    public void reserveVehicle(Vehicle vehicle) {
        for(Vehicle vehicle1 : vehicles) {
            if(vehicle1.getId() == vehicle.getId()) {
                vehicle1.setStatus(Status.BLOCKED);
                return;
            }
        }
    }
}
