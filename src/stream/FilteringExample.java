package stream;

import java.util.Arrays;
import java.util.List;

public class FilteringExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("이강인","손흥민", "황희찬", "조규성", "이영우");
        list.stream().distinct().forEach(n -> System.out.println(n));
        System.out.println();

        list.stream().filter(n -> n.startsWith("손")).forEach(n -> System.out.println(n));
        System.out.println();

        list.stream().distinct().filter(n ->n.startsWith("이")).forEach(n -> System.out.println(n));
    }
}
