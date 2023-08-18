import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        if(!slot.isOccupied()) {
            slots.remove(slot);
            System.out.println("Parking slot "+ slot.getIdentifier() + " removed successfully");
        } else {
            System.out.println("Failed to remove parking slot "+ slot.getIdentifier());
        }
    }

    /**
     * Deleting a parking slot from the car park using the parking slot identifier
     * @param identifier parking slot identifier to delete
     */
    public void deleteSlotByIdentifier(String identifier) {
        boolean completed = false;
        for (ParkingSlot slot: slots) {
            if(slot.getIdentifier().equals(identifier) && !slot.isOccupied()) {
                slots.remove(slot);
                System.out.println("Parking slot "+ slot.getIdentifier() + " removed successfully");
                completed = true;
                break;
            }
        }
        if(!completed) {
            System.out.println("Failed to remove parking slot "+ identifier);
        }
    }

    /**
     * Provides a list of parking slots in the car park.
     * @return a list of parking slots.
     */
    public List<ParkingSlot> getAllSlots() {
        return slots;
    }

    /**
     * Provides a list of registered parking slot identifiers
     * @return  a list of registered parking slot identifiers
     */
    public Object[] getAllSlotsIdentifiers() {
        List<String> identifiers = new ArrayList<>();
        for (ParkingSlot slot: slots) {
            identifiers.add(slot.getIdentifier());
        }
        return identifiers.toArray();
    }

    /**
     * Provides all the Parking Slots information in a well formatted way
     */
    public void getAllSlotsInfo() {
        for(ParkingSlot slot: slots) {
            if(slot.isOccupied()) {
                Car car = slot.getParkedCar();
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime parkedTime = car.getParkedTime();
                Duration duration = Duration.between(parkedTime,now);
                System.out.println("SlotID "+slot.getIdentifier()+" is occupied with reg:"+car.getRegistrationNumber()+" ,make:- "+car.getMake()+", parking time:- "+duration.toHoursPart()+"hours "+duration.toMinutesPart()+"minutes "+duration.toSecondsPart()+"seconds");
            } else {
                System.out.println("SlotID "+slot.getIdentifier()+" is not occupied");
            }
        }
    }

    /**
     * Parks a car in the first available parking slot.
     *
     * @param car the car to park
     * @return true if the car was successfully parked, false otherwise
     */
    public boolean parkCar(Car car) {
        for (ParkingSlot slot: slots) {
            if(!slot.isOccupied() && !car.isParked()) {
                slot.parkCar(car);
                car.setParked(true);
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
     * @param make the car's make to search for.
     */
    public void findCarsByMake(String make) {
//        List<Car> makeCars = new ArrayList<>();
        boolean found = false;
        for(ParkingSlot slot: slots) {
            if(slot.getParkedCar() != null && slot.getParkedCar().getMake().equals(make)) {
//                makeCars.add(slot.getParkedCar());
                Car car = slot.getParkedCar();
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime parkedTime = car.getParkedTime();
                Duration duration = Duration.between(parkedTime,now);
                System.out.println("SlotID "+slot.getIdentifier()+": reg="+car.getRegistrationNumber()+" ,"+car.getMake()+" ,"+car.getModel()+" ,"+car.getYear()+" , Parked time: "+duration.toHoursPart()+"hours "+duration.toMinutesPart()+"minutes "+duration.toSecondsPart()+"seconds");
                found = true;
            }
        }
        if(!found) {
            System.out.println("The model ("+make+") is not found!");
        }
    }

    /**
     * Retrieve the parked car and its parking slot number from the car park.
     * @param registrationNumber car's registration number for searching the car park.
     */
    public void findCarByRegistrationNumber(String registrationNumber) {
        boolean completed = false;
        for (ParkingSlot slot: slots) {
            if(slot != null && slot.getParkedCar() != null && slot.getParkedCar().getRegistrationNumber().equals(registrationNumber)) {
                System.out.println("The car with reg="+slot.getParkedCar().getRegistrationNumber()+" is parked on the slot="+slot.getIdentifier());
                completed = true;
                break;
            }
        }
        if(!completed) {
            System.out.println("There is no car parked with reg="+registrationNumber);
        }
    }

//    public void findCarsByMake(String make) {
//
//    }
}
