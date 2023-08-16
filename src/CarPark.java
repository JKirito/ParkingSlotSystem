import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a car park responsible for maintaining and managing parking slots.
 */
public class CarPark {
    // List of parking slots in the car park.
    private List<ParkingSlot> slots;

    public CarPark() {
        slots = new ArrayList<>();
    }

    /**
     * Adds a new parking slot to the car park.
     * @param slot the parking slot to add.
     */
    public void addSlot(ParkingSlot slot) {
        slots.add(slot);
    }

    /**
     * Deleting a parking slot from the car park.
     * @param slot the parking slot to delete.
     */
    public void deleteSlot(ParkingSlot slot) {
        slots.remove(slot);
    }

    /**
     * Provides a list of parking slots in the car park.
     * @return a list of parking slots.
     */
    public List<ParkingSlot> getAllSlots() {
        return slots;
    }

    /**
     * Parks a car in the first available parking slot.
     *
     * @param car the car to park
     * @return true if the car was successfully parked, false otherwise
     */
    public boolean parkCar(Car car) {
        for (ParkingSlot slot: slots) {
            if(!slot.isOccupied()) {
                slot.parkCar(car);
                return true;
            }
        }
        return false;
    }

    /**
     * Finds and removes a car by its registration number.
     *
     * @param registrationNumber the registration number of the car to remove
     * @return the removed car, or null if not found
     */
    public Car removeCarByRegistration(String registrationNumber) {
        for (ParkingSlot slot: slots) {
            Car car = slot.getParkedCar();
            if(car != null && car.getRegistrationNumber().equals(registrationNumber)) {
                return slot.removeCar();
            }
        }
        return null;
    }

    /**
     * Finds cars by their make.
     *
     * @param make the make to search for
     * @return a list of cars with the specified make
     */
    public List<Car> findCarsByMake(String make) {
        return slots.stream()
                .map(ParkingSlot::getParkedCar)
                .filter(car -> car != null && car.getMake().equals(make))
                .collect(Collectors.toList());
    }
}
