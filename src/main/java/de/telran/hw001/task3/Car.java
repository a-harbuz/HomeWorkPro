package de.telran.hw001.task3;
//import java.util.ArrayList;
//import java.util.List;
import java.util.*;

public class Car implements Comparable<Car> {
    private int manufactureYear;
    private String model;
    private int maxSpeed;

    public int getManufactureYear() {
        return manufactureYear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufactureYear=" + manufactureYear +
                ", model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    public Car(int manufactureYear, String model, int maxSpeed) {
        this.manufactureYear = manufactureYear;
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public int compareTo(Car o) {
        return this.getManufactureYear() - o.getManufactureYear();
        //return 0;
    }
    //...геттеры, сеттеры, toString()

}


class Main {

    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();

        Car ferrari = new Car(1990, "Ferrari 360 Spider", 310);
        Car lambo = new Car(2012, "Lamborghini Gallardo", 290);
        Car bugatti = new Car(2010, "Bugatti Veyron", 350);

        cars.add(ferrari);
        cars.add(bugatti);
        cars.add(lambo);

        //ошибка компилятора!
        Collections.sort(cars);
        System.out.println(cars);
    }
}