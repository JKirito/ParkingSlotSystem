import java.time.LocalDateTime;

/**
 *  Represents a parking slot with a unique identifier and the ability to hold a car.
 *  @author Arpit Singh 104167158
 *  @since 2023/08/18
 *  @version 1.0
 */
public class ParkingSlot {

    // Unique identifier for the parking slot, e.g., "D001","E127".
    private  String identifier;

    // Car parked in the slot; null if no car is parked
    private Car parkedCar;

    /**
     * Constructs a new instance of the ParkingSlot class with the specified identifier.
     *
     * @param identifier the unique identifier of the parking slot; expected to match the pattern [A-Z]\d{3}
     * @throws IllegalArgumentException if the provided identifier doesn't match the expected format
     */
    public ParkingSlot(String identifier) {
        if(!isValidIdentifier(identifier)) {
            throw new IllegalArgumentException("Invalid parking slot identifier format");
        }
        this.identifier = identifier;
        this.parkedCar = null;
        System.out.println("A new Parking slot has been added with identifier="+identifier);
    }

    /**
     * Validates the parking slot identifier format.
     * Valid Format for the Slot is 1 Capital Letter and 3 Digits e.g., "D001"
     *
     * @param identifier the identifier to validate
     * @return true if the identifier matches the expected format, false otherwise
     */
    private boolean isValidIdentifier(String identifier) {
        return identifier.matches("[A-Z]\\d{3}");
    }

    /**
     * Parks a car in the slot.
     *
     * @param car the car to park
     * @throws IllegalStateException if there's already a car parked in the slot
     */
    public void parkCar(Car car) {
        if (parkedCar != null) {
            throw new IllegalStateException("Parking slot is already occupied");
        }
        if (car.isParked()) {
            throw new IllegalStateException("Car is Already Parked. Please remove the car to park again.");
        }
        parkedCar = car;
        LocalDateTime time = LocalDateTime.now();
        car.setParkedTime(time);
        System.out.println("The Car has been parked Successfully at "+ car.getFormattedDateTime());
    }

    /**
     * Removes the car from the slot.
     *
     * @return the removed car
     * @throws IllegalStateException if there's no car parked in the slot
     */
    public Car removeCar() {
        if (parkedCar == null) {
            throw new IllegalStateException("Parking slot is empty");
        }
        Car removedCar = parkedCar;
        removedCar.setParked(false);
        parkedCar = null;
        return removedCar;
    }

    /**
     * Checks if the slot is occupied.
     *
     * @return true if a car is parked, false otherwise
     */
    public boolean isOccupied() {
        return parkedCar != null;
    }

    /**
     * Getter for identifier
     * @return identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Get the current car parked in the parking slot.
     * @return Car current car parked in the parking slot.
     */
    public Car getParkedCar() {
        return parkedCar;
    }
}
