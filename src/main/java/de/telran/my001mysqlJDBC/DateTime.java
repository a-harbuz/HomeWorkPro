package de.telran.my001mysqlJDBC;

import java.time.LocalDate;
import java.time.ZoneId;

public class DateTime {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Сегодня = " + today);
        //2024-02-14

        ZoneId timezone = ZoneId.of("Asia/Shanghai");
        today = LocalDate.now(timezone);
        System.out.println("Сейчас в Шанхае = " + today);
        System.out.println("" + today.getYear());
        System.out.println("" + today.getMonth());
        System.out.println("" + today.getDayOfWeek()); //DayOfWeek

        System.out.println("" + today.minusYears(2).plusDays(5));

    }
}
