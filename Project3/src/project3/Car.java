package project3;


/**
 * Created by Calvin Wong on 4/5/14.
 */
import java.util.Random;

public class Car {

    private int initCar;
    private int engineType;
    private int tireType;
    private int carWeight;
    private static int numOfCars = 0;
    private int carSpeed;
    Random rand = new Random();

    // constructor to randomize car object
    public Car() {

        this.numOfCars++; // add number of cars
        this.initCar = numOfCars - 1; //  start car index - 1
        this.engineType = rand.nextInt(5) + 1; // random engine type from 1 to 5
        this.tireType = rand.nextInt(3) + 1; // random tire type from 1 to 3
        this.carWeight = rand.nextInt(2001) + 2000; // random weight from 2000 to 4000 lbs
        this.carSpeed = calcSpeed();
    }

    public Car(int engineT, int tireT, int carW) {

        this.numOfCars++;
        this.initCar = numOfCars - 1;
        this.engineType = engineT;
        this.tireType = tireT;
        this.carWeight = carW;
    }

    // setters
    public void setInitCar(int start) {
        this.initCar = start;
    }

    public void setEngineType(int engine) {
        this.engineType = engine;
    }

    public void setTireType(int tire) {
        this.tireType = tire;
    }

    public void setCarWeight(int weight) {
        this.carWeight = weight;
    }

    public void setCarSpeed(int speed) {
        this.carSpeed = speed;
    }

    // getters
    public int getNumOfCars() {
        return numOfCars;
    }

    public int getInitCar() {
        return initCar;
    }

    public int getEngineType() {
        return engineType;
    }

    public int getTireType() {
        return tireType;
    }

    public int getCarWeight() {
        return carWeight;
    }

    public int getCarSpeed() {
        return carSpeed;
    }

    // calculates speed
    public int calcSpeed() {

        int speed = (((getEngineType() + getTireType() + rand.nextInt(11)-1) * 2000) / getCarWeight());
        return speed;
    }

    // override equals
    public boolean equals(Car obj2) {

        boolean status;

        if (getNumOfCars() == obj2.getNumOfCars() && getCarSpeed() == obj2.getCarSpeed() &&
                getCarWeight() == obj2.getCarWeight() && getTireType() == obj2.getTireType() &&
                getEngineType() == obj2.getEngineType() && getInitCar() == obj2.getInitCar())
            status = true;
        else
            status = false;
        return status;
    }

    // just random engine type, colors, tire types, and car brands
    private String[] engineTypes = {"4-Cylinder", "V-6 Turbo", "V-8", "V-8 SuperCharged", "V-12"};
    private String[] tireTypes = {"Economy", "Performance", "Race"};
    private String[] carColor = {"Frozen Grey", "Midnight Blue", "LimeRock Orange", "Tsukuba Red", "Karussel White",
            "Nordschleife Gray", "Bathurst Black", "Iridium Silver ", "British Racing Green"};
    private String[] carModel = {"Ferrari Enzo", "McLaren F1", "Bugatti Veyron", "Honda NSX", "BMW M5",
            "Mercedes C63 AMG", "Hennessy Venom GT", "Lotus Exige"};

    // override toString
    public String toString() {

        String engine = engineTypes[rand.nextInt(engineTypes.length)];
        String tire = tireTypes[rand.nextInt(tireTypes.length)];
        String color = carColor[rand.nextInt(carColor.length)];
        String brand = carModel[rand.nextInt(carModel.length)];

        return "RACECAR # " + (getInitCar() + 1) + "\nCar Make: " + brand + "\nCar Color: " + color + "\nEngine Type: " + engine + "\nTire Type: " + tire +
                "\nCar Weight: " + getCarWeight() + " LBS\nCar Speed: " + getCarSpeed() + " MPH\n";
    }
} // end of class



