/**
 * Represents a car with specific attributes such as registration number, make, model, and year of manufacturing.
 */
public class Car {
    // Car's registration number
    private String registrationNumber;
    // Car's make (e.g., Toyota, Ford, etc.)
    private String make;
    // Car's specific model (e.g., Camry, Mustang, etc.)
    private String model;
    // The year the car was manufactured
    private int year;

    /**
     * Constructs a new instance of the Car class with the specified attributes.
     *
     * @param registrationNumber the registration number of the car; expected to be unique for each car
     * @param make the brand or manufacturer of the car
     * @param model the specific model name of the car
     * @param year the year the car was manufactured
     */
    public Car(String registrationNumber, String make, String model, int year) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    /**
     * Gets the registration of the car
     * @return The current registration of the car
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Sets the registration of the car
     * The registration number should be of the following format:
     * A capital letter followed by a four-digit number (e.g., "T1234").
     * @param registrationNumber the new registration number for the car.
     * @throws IllegalArgumentException if provided registration number does not match the above criteria
     */
    public void setRegistrationNumber(String registrationNumber) {
        if(!isValidRegistrationNumber(registrationNumber)) {
            throw new IllegalArgumentException("Invalid Registration Number Format");
        }
        this.registrationNumber = registrationNumber;
     }

     /**
      * Retrieve the make of the car.
      * @return the current make of the car.
      */
     public String getMake() {
        return make;
     }

     /**
      * Sets the make of the Car.
      * @param make the new make of the car.
      */
     public void setMake(String make) {
        this.make = make;
     }

    /**
     * Retrieve the model of the Car
     * @return model of the car
     */
     public String getModel() {
        return model;
     }

    /**
     * Sets the new model of the car.
     * @param model the new model of the car.
     */
     public void setModel(String model) {
        this.model = model;
     }

    /**
     * Returns the manufacturing year of the car.
     * @return the manufacturing year of the car.
     */
     public int getYear() {
        return year;
     }

    /**
     * Sets the year the car was manufactured.
     * @param year the manufacturing year of the car.
     */
     public void setYear(int year) {
        this.year = year;
     }

    /**
     * Checks if the Registration number provided is in valid format or not.
     * The format for the registration number is: A Capital Letter followed by 4 Digits Number.
     * @param registrationNumber registration number to be checked.
     * @return Boolean, true if valid registration number else false.
     */
    private boolean isValidRegistrationNumber(String registrationNumber) {
        // Ensures the registration number matches the format: A Capital Letter followed by 4 Digits Number.
        return registrationNumber.matches("[A-Z]\\d{4}");
    }
}
