package de.telran.hw005Enum;

public class Main {

//Задача: Размеры одежды
//        Создайте перечисление (enum) для представления размеров одежды (XS, S, M, L, XL).
//        Напишите метод, который принимает на вход размер и возвращает true,
//        если размер существует в перечислении, и false в противном случае.
//        Используйте цикл и метод values() для проверки.

    public static void main(String[] args) {
        System.out.println(WearSize.isSize("M"));
        System.out.println(WearSize.isSize("X"));

    }


}
