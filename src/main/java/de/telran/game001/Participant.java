package de.telran.game001;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Participant {
    private String name;
    private int age;
    private CreditCard card;

    public Participant(String name, int age, CreditCard card) {
        this.name = name;
        this.age = age;
        this.card = card;
    }


    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}
