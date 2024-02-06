package de.telran.testing001;

public class Taski1 {
//    Сложение (add): Принимает два числа и возвращает их сумму.
    public int additional(int a, int b) {
        return a+b;
    }

    public int subtract(int a, int b) {
        return a-b;
    }

    public int multiply(int a, int b) {
        if (a==0 || b==0) return 0;
        return a*b;
    }

    public int divide(int a, int b) {
        if (b==0) throw new ArithmeticException();
        return a/b;
    }

    public double power(double base, int power) {
        if (power==0) return 1;
        double result=1.0;
        for (int i = 0; i < power; i++) {
            result = result*base;
        }
        return result;
    }

    public int factorial(int n) {
        if (n<0) throw new ArithmeticException();
        if (n==0 || n==1) return 1;
        int result=1;
        for (int i = 2; i <= n; i++) {
            result*=i;
        }
        return result;
    }

    public double absolute(double number) {
        if (number<0) return -number;
        else return number;
    }

    public double sqrt(int number) {
        if (number==0) return 0;
        if (number==1) return 1;
        double epsilon = 1e-15; // Точность
        double x = number; // Начальное приближение
        while (absolute(x - number / x) > epsilon * x) {
            x = (x + number / x) / 2;
        }
        return x;
    }

    public double logarithm(double base, double number) {
        if (base <= 0) {
            throw new IllegalArgumentException("Аргумент должен быть положительным числом");
        }
        if (base == 1) {
            return 0;
        }

        // Находим логарифм
        double result = 0;
        while (number >= base) {
            number /= base;
            result++;
        }

        // Если x стал меньше базы, то приближаемся к решению
        double fraction = number - 1; // Остаток
        double power = 1; // Степень базы
        double term = fraction; // Текущий член ряда
        int sign = 1; // Знак члена ряда
        while (Math.abs(term) > 1e-10) { // Задаем точность вычисления
            power *= fraction; // Увеличиваем степень базы
            term = sign * power / (double) ++result; // Вычисляем следующий член ряда
            sign = -sign; // Меняем знак следующего члена
            result += term; // Добавляем член к результату
        }

        return result;
    }

    public double sin(double connerRadian) {
        //double x = Math.PI / 4; // угол, для которого нужно вычислить синус
        int n = 10; // количество членов ряда Маклорена

        double result = 0;
        for (int i = 0; i < n; i++) {
            result += power(-1, i) * power(connerRadian, 2 * i + 1) / factorial(2 * i + 1);
        }
        return result;

    }

//            Вычитание (subtract): Принимает два числа и возвращает результат их вычитания.
//    Умн
//    ожение (multiply): Принимает два числа и возвращает их произведение.
//            Деление (divide): Принимает два числа и возвращает результат деления первого на второе. Необходимо обработать случай деления на ноль.
//    Возведение в степень (power): Принимает основание и показатель степени, возвращает результат возведения числа в степень.
//    Факториал (factorial): Принимает число и возвращает его факториал. Должна быть обработка отрицательных чисел.
//            Модуль числа (absolute): Принимает число и возвращает его абсолютное значение.
//            Квадратный корень (sqrt): Принимает число и возвращает квадратный корень числа. Необходимо учесть обработку отрицательных чисел.
//            Логарифм (logarithm): Принимает основание логарифма и число, для которого необходимо вычислить логарифм.
//            Синус (sin): Принимает угол в радианах и возвращает его синус.
}

