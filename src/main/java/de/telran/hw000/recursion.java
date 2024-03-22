package de.telran.hw000;

public class recursion {
    public static void main(String[] args) {
        System.out.println(summ(4));
    }
    public static int summ (int n){
        if (n==1) return 1;
        return summ(n-1)+n;
    }
}
