package de.telran.hw0013Mockito2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {
    @Mock
    SimpleNotificationService notificationService;
    @Mock
    SimpleTransactionRepository transactionRepository;

    @InjectMocks
    PaymentService paymentService; //включает уже заМокированные обьекты

    @Test
    void makePaymentTest() {
        Mockito.when(transactionRepository.processTransaction(Mockito.anyDouble())).thenReturn(true);
        Assertions.assertTrue(paymentService.makePayment(Mockito.anyDouble()));

        //paymentService.makePayment(Mockito.anyDouble());
        Mockito.verify(transactionRepository).processTransaction(Mockito.anyDouble());
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());

    }

    @Test
    void refundPaymentTest() {
        Mockito.when(transactionRepository.processTransaction(-Mockito.anyDouble())).thenReturn(true);

        paymentService.makePayment(Mockito.anyDouble());
        Mockito.verify(transactionRepository).processTransaction(Mockito.anyDouble());
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());

        //Mockito.verifyNoInteractions();
    }

    @Test
    void adjustPaymentTest() {
        //test1
        Mockito.when(transactionRepository.processTransaction(Mockito.anyDouble())).thenReturn(true).thenReturn(true);
        //paymentService.adjustPayment(Mockito.anyDouble(),Mockito.anyDouble());
        paymentService.adjustPayment(0.1,0.2);

        Mockito.verify(transactionRepository,Mockito.times(2)).processTransaction(Mockito.anyDouble());
        Mockito.verify(notificationService,Mockito.times(2)).sendPaymentNotification(Mockito.anyString());
    }
    @Test
    void adjustPaymentRefundResultTest() {
        //test2
        Mockito.when(transactionRepository.processTransaction(Mockito.anyDouble())).thenReturn(false);
        paymentService.adjustPayment(0.1,0.2);
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }

    @Test
    void verifyPaymentTest() {
        boolean result = paymentService.verifyPayment(Mockito.anyDouble());
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }

    @Test
    void cancelPaymentRefundTest() {
        Mockito.when(transactionRepository.processTransaction(Mockito.anyDouble())).thenReturn(true);
        paymentService.cancelPayment(Mockito.anyDouble());
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }
    @Test
    void cancelPaymentNotRefundTest() {
        Mockito.when(transactionRepository.processTransaction(Mockito.anyDouble())).thenReturn(false);
        paymentService.cancelPayment(Mockito.anyDouble());
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }

    @Test
    void freezeTransactionTest() {
        paymentService.freezeTransaction(Mockito.anyDouble());
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }

    @Test
    void unfreezeTransactionTest() {
        paymentService.unfreezeTransaction(Mockito.anyDouble());
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }

    @Test
    void schedulePaymentTest() {
        boolean actualResult = paymentService.schedulePayment(0.1,"date");
        Assertions.assertEquals(true, actualResult);
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }

    @Test
    void confirmPaymentTest() {
        paymentService.confirmPayment(Mockito.anyDouble());
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }

    @Test
    void declinePaymentTest() {
        paymentService.declinePayment(Mockito.anyDouble());
        Mockito.verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }
}
