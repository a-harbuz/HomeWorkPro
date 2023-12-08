package de.telran.hw000;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7,8,-5,-7,8,22,99,15,16,4,5};
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        for (int x = 0; x < 3; x++) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i]<min1) min1 = arr[i];
                if (arr[i]<min2 && arr[i]>min1) min2 = arr[i];
                if (arr[i]<min3 && arr[i]>min1 && arr[i]>min2) min3 = arr[i];
            }
        }

        System.out.println("Второй минимальный элемент = " + min2);
        System.out.println("Третий минимальный элемент = " + min3);
    }
}


// найти второй и третий по минимальности элемент в массиве.
// (без исп.сортировки)