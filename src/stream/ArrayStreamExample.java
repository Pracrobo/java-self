package stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayStreamExample {
    public static void main(String[] args) {
        String[] strings = {"김연아", "이상화", "김연경"};
        Stream<String> strStream = Arrays.stream(strings);
        strStream.forEach(item -> System.out.print(item+","));
        System.out.println();

        int[] intArray = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(intArray);
        intStream.forEach(item -> System.out.print(item+","));
        System.out.println();


    }
}
