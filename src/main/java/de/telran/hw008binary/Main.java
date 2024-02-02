package de.telran.hw008binary;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] x = {1,2,1,3,2,3,5};
        //System.out.println(getSingle(x));

//        System.out.println("5=> " + countOne(5)); // 0b 0000 0101
//        System.out.println("7=> " + countOne(7)); // 0b 0000 0111
//        System.out.println("23=> " + countOne(23)); // 0b 0001 0111
//        System.out.println(0b10010111+"=> " + countOne(0b10010111)); // 0b 1001 0111
//        System.out.println(0b11111111+"=> " + countOne(0b11111111));
        find();
    }
    public static int getSingle(int[] array) {
        //[1 2 1 3 2 3 5]
        int xor = 0;
        for (int x : array) {
            xor ^= x;
        }
        return xor;
    }
    //25 - 00001101

    public static int countOne(int num){
        int count=0;
        int bit=1;
        for (int i = 0; i < 8; i++) {
            if ((num & bit)!=0) count++;
            bit*=2;
        }
        return count;
    }

    //poisk mesta
    public static int findPlace(int n, int max) {
        int count=0;
        int x=n;
        while (x<max){
            x=x+2;
            count++;
        }
        x=n-2;
        while (x>0){
            count++;
            x=x-2;
        }
        return count;
    }

    public static void find() {
        //23 - otvet 12
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 23; i++) {
            list.add(findPlace(i, 23));
        }
        System.out.println(list);
    }
    //Задача на логику про стулья и бармена, где каждый клиент должен сидеть максимально далеко от другого,
}
