package de.telran.hw010RegularAndStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Taski {
    public static Map<String,String> map = createStructure();
    public static void main(String[] args) {
        //System.out.println(map);
        //System.out.println(createSpecialMap());

        //System.out.println(numTlf());
        System.out.println(avgLenghtName());
    }
    public static Map<String, String> createStructure(){
        String path="C:\\JAVA\\HomeWorkPro\\src\\main\\java\\de\\telran\\hw010RegularAndStream\\1.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            //reader.lines().forEach(System.out::println);
            return reader.lines().collect(Collectors.toMap(
                    el->el.split(" - ")[0],
                    el2->el2.split(" - ")[1]
            ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //return null;
    }
//    - Метод для создания мапы, где ключ - первая буква имени, а значение - количество таких имен
    public static Map<String, Long> createSpecialMap(){
                return map.values().stream()
                .collect(Collectors.groupingBy(x->x.substring(0,1), Collectors.counting()));
    }
// - Метод для нахождения самой часто встречающейся первой буквы в именах
    public static Map.Entry<String, Long> characterMax(){
        //map<tlf,Names>
        return map.values().stream()
                .collect(Collectors.groupingBy(x->x.substring(0,1), Collectors.counting())).entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .orElse(null);
    }

// - Метод для создания списка номеров телефонов, где каждый номер преобразован в числовой формат
public static List<Integer> numTlf(){
    //map<tlf,Names>
    return map.keySet().stream()
            .map(t->{
                t=t.replace("001-","1")
                        .replace("04","4")
                        .replace("+","").replace("-","")
                        .replace("x","").replace("(","")
                        .replace(")","").replace(".","");
                //System.out.println(t);
                //return Integer.parseInt(String.valueOf(new BigInteger(t)));
                return Integer.parseInt("0");
            })
            .toList();
    //return null;
}
// - Метод для группировки имен по длине имени
    public static Map<Integer, List<String>> groupNameLength(){
        //map<tlf,Names>
        return map.values().stream()
                .collect(Collectors.groupingBy(String::length));
    }

// - Метод для поиска уникальных фамилий
    public static List<String> uniqFamili(){
        //map<tlf,Names>
        return map.values().stream()
                .map(el->el.split(" ")[1])
                .distinct()
                .sorted(Comparator.naturalOrder())
                .toList();
    }
// - Метод для создания списка имен, отсортированного в обратном алфавитном порядке
    public static List<String> uniqNameSort(){
        //map<tlf,Names>
        return map.values().stream()
                .map(el->el.split(" ")[0])
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();
    }

// - Метод для преобразования данных в формат имя=номер
    public static List<Map.Entry<String, String>> nameNum(){
        //map<tlf,Names>
        return map.entrySet().stream()
                .map(entry -> Map.entry(entry.getValue(), entry.getKey()))
                .collect(Collectors.toList());
    }
// - Метод для расчета средней длины имени
    public static Map<String,Double> avgLenghtName(){
        return map.values().stream()
                .collect(Collectors.groupingBy(
                        str -> str,
                        Collectors.averagingInt(String::length)));
    }
// - Метод для создания карты, где ключ - номер телефона, а значение - имя
// - Метод для поиска контактов с максимальной и минимальной длиной имени
}
