package de.telran.game001;

public class Adult extends Participant{
    public Adult(String name, int age, CreditCard card) {
        super(name, age, card);
    }
}

class TeenAger extends Participant {

    public TeenAger(String name, int age, CreditCard card) {
        super(name, age, card);
    }
}

class Pupil extends Participant {

    public Pupil(String name, int age, CreditCard card) {
        super(name, age, card);
    }
}
