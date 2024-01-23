package de.telran.myexeptions;

public class NoValidRangeAge  extends RuntimeException {
    public NoValidRangeAge(String message) {
        super(message);
    }
}
