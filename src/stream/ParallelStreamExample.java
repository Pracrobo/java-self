package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<String> list  = Arrays.asList("홍길동", "기성용" , "손흥민", "구자철", "이청용");

        /*list.add("홍길동");
        list.add("신용권");
        list.add("감자바");
        list.add("람다식");
        list.add("스트림");
*/

        Stream<String> parallelStream = list.parallelStream(); //  병렬스트림 얻기
        parallelStream.forEach(name -> {
            System.out.println(name +":"  + Thread.currentThread().getName());
        });
    }
}
