package hw006Streams;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 20, 3, 4, 1, 1, 5, 6, 7, 8);
        List<String> strList = Arrays.asList("AAAAAAAAAA", "BSJKDHKD", "asdasdasd","ewdwcdfwe");
        //System.out.println(filterByLength(strList,10));
        //filterByLength(strList,10);
    }

    //Фильтрация списка строк по длине.
//    public static List<String> filterByLength(List<String> input, int length) {
//        return input.stream()
//                .filter(x->x.length() == length)
//                .toList();
//    }
    public static void filterByLength1(List<String> input, int length) {
        input.stream()
                .filter(x->x.length() == length)
                .forEach(System.out::println);
    }

}
