package de.telran.hw004;

import java.math.BigDecimal;
import java.util.ArrayList;
public class Handler {
    public static BigDecimal sumBalances(Account[] accounts) {
        //Считает общую сумму балансов для массива счетов.
        BigDecimal a = BigDecimal.valueOf(0);
        for (int i = 0; i < accounts.length; i++) {
            a = a.add(accounts[i].getBalance());
        }
        return a;
    }

    public static Account[] findAccountsByCurrency(Account[] accounts, Currency currency){
        //Возвращает все счета, имеющие определённую валюту.
        Account[] acc = new Account[accounts.length]; // лучше исп ArrayList
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getCurrency() == currency){
                acc[i] = accounts[i];
            }
        }
        return acc;
    }

    public static boolean hasDebitAccounts(Empl employee){
        // Описание: Определяет, есть ли у сотрудника дебетовые счета.
        Account[] accounts = employee.getAccount();
        for (int j = 0; j < accounts.length; j++) {
            if (accounts[j].getDebit()) {
                return true;
            }
        }
        return false;
    }

    //4) Описание: Возвращает список сотрудников, у которых гражданство соответствует заданной стране.
    public static Empl[] getEmployeesByCountry(Empl[] employees, Country country){
        ArrayList<Empl> tmpEmpl = new ArrayList<>();
        for (int i = 0; i < employees.length; i++) {
            Account[] accounts = employees[i].getAccount();

            for (int j = 0; j < accounts.length; j++) {
                if (accounts[j].getCountry()==country){
                    tmpEmpl.add(employees[i]);
                    //System.out.println(employees[i].getName());
                }
            }

        }

        // Convert ArrayList<Empl> to Empl[]
        Empl[] empReturn = new Empl[tmpEmpl.size()];
        for (int i = 0; i < tmpEmpl.size(); i++) {
            empReturn[i] = tmpEmpl.get(i);
        }
        return empReturn;
    }
    //5) Описание: Возвращает счета, баланс которых выше определённой суммы.
    public Account[] filterAccountsByBalance(Account[] accounts, BigDecimal minBalance){
        ArrayList<Account> tmpAccount = new ArrayList<>();
        for (int i = 0; i < accounts.length; i++) {
            // Сравнение BigDecimal
            if (accounts[i].getBalance() > minBalance){
                tmpAccount.add(accounts[i]);
            }
        }

        Account[] accReturn = new Account[tmpAccount.size()];
        for (int i = 0; i < tmpAccount.size(); i++) {
            accReturn[i] = tmpAccount.get(i);
        }
        return accReturn;

    }

    /**
     * Подсчёт суммы балансов
     * Описание: Считает общую сумму балансов для массива счетов.
     * Сигнатура: public BigDecimal sumBalances(Account[] accounts)
     *
     * Поиск счетов по валюте
     * Описание: Возвращает все счета, имеющие определённую валюту.
     * Сигнатура: public Account[] findAccountsByCurrency(Account[] accounts, Currency currency)
     *
     * Проверка наличия дебетовых счетов
     * Описание: Определяет, есть ли у сотрудника дебетовые счета.
     * Сигнатура: public boolean hasDebitAccounts(Empl employee)
     *
     * Список сотрудников банка по стране
     *4) Описание: Возвращает список сотрудников, у которых гражданство соответствует заданной стране.
     * Сигнатура: public Empl[] getEmployeesByCountry(Empl[] employees, Country country)
     *
     * Фильтрация счетов по балансу
     *5) Описание: Возвращает счета, баланс которых выше определённой суммы.
     * Сигнатура: public Account[] filterAccountsByBalance(Account[] accounts, BigDecimal minBalance)
     *
     * Конвертация суммы счетов в другую валюту
     *6) Описание: Конвертирует баланс каждого счёта в массиве в заданную валюту по заданному курсу.
     * Сигнатура: public BigDecimal[] convertAccountBalances(Account[] accounts, Currency toCurrency, BigDecimal rate)
     * Подсчёт количества счетов по типу
     *
     *7) Описание: Считает количество дебетовых и кредитных счетов в массиве счетов.
     * Сигнатура: public int[] countAccountTypes(Account[] accounts)
     * Сортировка сотрудников по общему балансу
     *
     *8) Описание: Сортирует массив сотрудников по общему балансу их счетов в порядке убывания.
     * Сигнатура: public Empl[] sortEmployeesByTotalBalance(Empl[] employees)
     * Определение наиболее распространенной валюты среди счетов
     *
     *9) Описание: Определяет валюту, которая встречается чаще всего среди всех счетов.
     * Сигнатура: public Currency findMostCommonCurrency(Account[] accounts)
     *
     *10) Перевод средств между счетами одного сотрудника
     * Описание: Выполняет перевод средств между счетами в пределах списка счетов одного сотрудника.
     * Сигнатура: public boolean transferBetweenAccounts(Account[] accounts, int fromIndex, int toIndex, BigDecimal amount)
     * Подсчет среднего баланса счетов по каждому отделению
     *
     *11) Описание: Рассчитывает средний баланс счетов для каждого отделения банка.
     * Сигнатура: public BigDecimal[] averageBalancePerBranch(Branch[] branches)
     * Определение отделения с наибольшим количеством сотрудников-иностранцев
     *
     *12) Описание: Находит отделение с максимальным числом сотрудников не из страны, где расположен банк.
     * Сигнатура: public Branch findBranchWithMostForeignEmployees(Branch[] branches, Country bankCountry)
     * Генерация отчета о счетах с низким балансом
     *
     *13) Описание: Создает список счетов, баланс которых ниже определенной суммы.
     * Сигнатура: public Account[] reportLowBalanceAccounts(Account[] accounts, BigDecimal threshold)
     * Создание карты сотрудников по гражданству
     *
     *14) Описание: Считает суммарный баланс счетов по всем отделениям банка.
     * Сигнатура: public BigDecimal calculateTotalBalanceForBank(Branch[] branches)
     * Определение сотрудника с наибольшим количеством счетов
     *
     *15) Описание: Находит сотрудника с наибольшим количеством открытых счетов.
     * Сигнатура: public Empl findEmployeeWithMostAccounts(Empl[] employees)
     * Анализ распределения типов валют среди всех счетов
     *
     *16) Описание: Идентифицирует сотрудников, которые управляют счетами в более чем одной валюте.
     * Сигнатура: public Empl[] findMultiCurrencyAccountManagers(Empl[] employees)
     *
     *17) Описание: Для каждой валюты находит счет с максимальным балансом.
     * Сигнатура: public Account[] findMaxBalanceAccountsForCurrencies(Account[] accounts)
     *
     *18) Описание: Проверяет все счета всех сотрудников на предмет дублирования номеров счетов.
     * Сигнатура: public boolean hasDuplicateAccounts(Empl[] employees)
     *
     *19) Описание: Возвращает сотрудников, у которых количество счетов попадает в заданный диапазон.
     * Сигнатура: public Empl[] findEmployeesByAccountCount(Empl[] employees, int min, int max)
     *
     *20) Описание: Вычисляет среднее количество счетов на сотрудника в каждом отделении банка.
     * Сигнатура: public Map<Branch, Double> calculateAverageAccountsPerEmployee(Branch[] branches)
     *
     *21) Описание: Проверяет, используется ли заданная валюта хотя бы на одном счету среди сотрудников.
     * Сигнатура: public boolean isCurrencyUsedByEmployees(Empl[] employees, Currency currency)
     *
     *22) Описание: Возвращает сотрудников, у которых количество счетов попадает в заданный диапазон.
     * Сигнатура: public Empl[] findEmployeesByAccountCount(Empl[] employees, int min, int max)
     */
}
