package de.telran.hw0013Mockito2;

public interface TransactionRepository {
    /**
     * Обрабатывает транзакцию с указанной суммой.
     * @param amount сумма транзакции.
     * @return true, если транзакция успешно обработана, иначе false.
     */
    boolean processTransaction(double amount);
}
