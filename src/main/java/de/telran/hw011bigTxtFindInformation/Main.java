package de.telran.hw011bigTxtFindInformation;

import de.telran.hw009serializeBook.Book;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\JAVA\\HomeWorkPro\\src\\main\\java\\de\\telran\\hw011bigTxtFindInformation\\BigText.txt";
        Set<String> listWords = new TreeSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.lines()
                    .map(str -> str.split(" "))
                    //убрать .,Tab?»:!
                    .forEach(s->{
                        Collections.addAll(listWords, s);

                    });
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Collections.sort(listWords);
        listWords.forEach(System.out::println);
        System.out.println("Всего уник.слов: ");
        System.out.println(listWords.stream().count());

    }
}

//                        for (String w: s) {
//                                //System.out.println(w);
//                                //if (!listWords.contains(w)) listWords.add(w);
//                                listWords.add(w);
//                                }