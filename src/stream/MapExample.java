package stream;

import java.util.Arrays;
import java.util.List;

public class MapExample {
    public static void main(String[] args) {
        List<Student02> studentList = Arrays.asList(new Student02("홍길동", 85), new Student02("홍길동", 92), new Student02("홍길동", 87));
        studentList.stream().mapToInt(s-> s.getScore()).forEach(score -> System.out.println(score));
    }
}
