package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {
    public static void main(String[] args) {
        List<Student04> totalList = Arrays.asList(new Student04("홍길동", "남", 92), new Student04("김수영", "야", 97),new Student04("감자바", "남", 95),new  Student04("오해영", "여", 93));

        List<Student04> maleList = totalList.stream().filter(s-> s.getSex().equals("남")).toList();

        maleList.stream().forEach(s -> System.out.println(s.getName()));
        System.out.println();

        Map<String, Integer> map = totalList.stream().collect(Collectors.toMap(s -> s.getName(), s-> s.getScore()));

        System.out.println(map);
    }
}
