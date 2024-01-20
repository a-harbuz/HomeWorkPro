package de.telran.team001;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Participant {
    private String name;
    private int age;

    public Participant(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
//    public static void tst() {
//        Participant part1 = new Participant("Vasya", 25);
//    }

}
