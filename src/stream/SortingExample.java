package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingExample {
    public static void main(String[] args) {
        List<Student03> studentList  = new ArrayList<>();
        studentList.add(new Student03("김영한", 30));
        studentList.add(new Student03("호돌맨", 10));
        studentList.add(new Student03("향로", 20));

        // 점수로 오름차순
        studentList.stream().sorted().forEach(s -> System.out.println(s.getName() + ":" + s.getScore()));
        System.out.println();
        // 점수로 내림차순
        studentList.stream().sorted(Comparator.reverseOrder()).forEach(s-> System.out.println(s.getName() + ":"  + s.getScore()));
    }
}
