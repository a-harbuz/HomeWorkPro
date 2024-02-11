package de.telran.hw0013Mockito2;

public class SimpleNotificationService implements NotificationService {

    @Override
    public void sendPaymentNotification(String message) {
        System.out.println("Notification sent: " + message);
    }
}