package stream;

import java.util.Arrays;
import java.util.List;

public class StreamPipeLineExample {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(new Student("홍길동", 10), new Student("기성용", 20), new Student("손흥민", 30));

        double avg = list.stream().mapToInt(student -> student.getScore()).average().getAsDouble();

        System.out.println("평균 점수 : " + avg);
    }
}
