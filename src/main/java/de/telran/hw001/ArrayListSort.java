package de.telran.hw001;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListSort {
    public static void main(String[] args) {
        ArrayList<String> people = new ArrayList<String>();
        // добавим в список ряд элементов
        people.add("Tom");
        people.add("Alice");
        people.add("Kate");
        people.add("Sam");
        people.add(1, "Bob"); // добавляем элемент по индексу 1

        //System.out.println(people.get(1));// получаем 2-й объект
        people.set(1, "Robert"); // установка нового значения для 2-го объекта

        System.out.printf("ArrayList has %d elements \n", people.size());

        Collections.sort(people); // СОРТИРУЕМ
        for(String person : people){
            System.out.println(person);
        }

        // проверяем наличие элемента
        if(people.contains("Tom")){
            System.out.println("ArrayList contains Tom");
        }
    }
}


//// пример кода, который добавляет элемент в конец массива:
//
//// Исходный массив
//        int[] arr = {1, 2, 3};
//
//// Создаем новый массив с длиной на 1 больше исходного массива
//        int[] newArr = new int[arr.length + 1];
//
//// Копируем все элементы из исходного массива в новый массив
//        for (int i = 0; i < arr.length; i++) {
//        newArr[i] = arr[i];
//        }
//
//// Добавляем новый элемент в конец нового массива
//        newArr[newArr.length - 1] = 4;
//
//// Используем новый массив вместо старого массива
//        arr = newArr; // [1, 2, 3, 4]