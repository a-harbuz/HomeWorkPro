package de.telran.hw0013Mockito2;

public interface NotificationService {
    /**
     * Отправляет уведомление с заданным сообщением.
     * @param message Сообщение, которое необходимо отправить.
     */
    void sendPaymentNotification(String message);
}

