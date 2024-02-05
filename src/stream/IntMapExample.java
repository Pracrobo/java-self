package stream;

import java.util.Arrays;
import java.util.stream.IntStream;



public class IntMapExample {
    public static void main(String[] args) {
        int[] intArray = {1, 2,3,4,5};
        IntStream intStream = Arrays.stream(intArray);
        intStream.asDoubleStream().forEach(i -> System.out.println((double) i));
        System.out.println();
        intStream = Arrays.stream(intArray);
        intStream.boxed().forEach(obj -> System.out.println(obj.intValue()));
    }
}
