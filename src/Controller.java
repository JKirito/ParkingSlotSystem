import java.util.List;

/**
 * Controller Class Handles all the business logic for the application.
 * Acts as a layer between the Application Class and the other Classes
 * @author Arpit Singh 104167158
 * @since 2023/08/18
 * @version 1.0
 */
public class Controller {
    private CarPark carPark;

    /**
     * Construct a new Instance of the Controller Class with the specified carPark.
     * @param carPark used by the controller to perform operation on a specific carPark.
     */
    public Controller(CarPark carPark) {
        this.carPark = carPark;
    }

    public void addACarSlot(String slot) {
        try {
            ParkingSlot newSlot = new ParkingSlot(slot);
            carPark.addSlot(newSlot);
        } catch (IllegalArgumentException e) {
            System.out.println("The format of the slot entered is invalid, Please enter a valid identifier");
        }
    }

    public void deleteACarSlot(String slot) {
        carPark.deleteSlotByIdentifier(slot);
    }

    public void listAllCarSlots() {
        carPark.getAllSlotsInfo();
    }

    /**
     * Parks a Car to a specified slot in the car park.
     * @param slotID slot ID of the car park where you want to park.
     * @param registrationNumber registration number of the car to park
     * @param model model of the car to park
     * @param make make of the car to park
     * @param year year of the car to park
     */
    public void parkCar(String slotID, String registrationNumber, String model,String make, int year) {
        Car car = new Car(registrationNumber,make,model,year);
        List<ParkingSlot> allSlots = carPark.getAllSlots();
        boolean alreadyParked = false;
        // Cheking if the Car is Already parked at a parking slot
        for (ParkingSlot slot: allSlots) {
            if(slot.getParkedCar() != null  && slot.getParkedCar().getRegistrationNumber().equals(registrationNumber)){
                alreadyParked = true;
                break;
            }
        }
        if(alreadyParked) {
            // Return if the car with that registration number is already parked in the car park.
            System.out.println("Sorry, the car with that registration number is already parked in the car park");
            return;
        }
        boolean found = false;
        for(ParkingSlot slot: allSlots) {
            if(slot != null && slot.getIdentifier().equals(slotID)) {
                found = true;
                if(!slot.isOccupied()) {
                    try {
                        carPark.parkCar(car);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
            }
        }
        if(!found) {
            System.out.println("Failed to park the car, No such slot is found in the car park.");
        }

    }

    /**
     * Retrieve the car by using registration number.
     * @param registrationNumber registration number of the car you want to search.
     */
    public void findACarByRegistration(String registrationNumber) {
        carPark.findCarByRegistrationNumber(registrationNumber);
    }

    /**
     * Remove a Car by the registration number of the car.
     * @param registrationNumber Registration Number of the car to be removed
     */
    public void removeCarByRegistration(String registrationNumber) {
        try {
            Car car = carPark.removeCarByRegistration(registrationNumber);
            System.out.println("The Car with reg="+registrationNumber+" has been successfully removed");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * find the cars by their make.
     * @param make Make of the car that you want to find
     */
    public void findCarsByMake(String make) {
        carPark.findCarsByMake(make);
    }
}
