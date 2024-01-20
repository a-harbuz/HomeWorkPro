package de.telran.myexeptions;

public class ParameterAIsMustBeNotFiveException extends RuntimeException {
    public ParameterAIsMustBeNotFiveException(String message) {
        //Constructor
        super(message);
    }

    public void ParameterAIsMustBeNotNull(String message) {
        //super(message);
        System.out.println("tst");
    }
}
