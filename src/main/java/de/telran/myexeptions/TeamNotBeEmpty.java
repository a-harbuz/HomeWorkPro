package de.telran.myexeptions;

public class TeamNotBeEmpty extends RuntimeException {
    public TeamNotBeEmpty (String message) {
        //Constructor
        super(message);
        System.out.println("Привет....");
    }

    public void tst() {
        //super(message);
        System.out.println("tst");
    }
}
