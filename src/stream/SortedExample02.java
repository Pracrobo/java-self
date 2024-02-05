package stream;

import java.util.ArrayList;
import java.util.List;

public class SortedExample02 {
    public static void main(String[] args) {
        List<Student> studentList  = new ArrayList<>();
        studentList.add(new Student("홍길동", 30));
        studentList.add(new Student("유미란", 20));
        studentList.add(new Student("신용권", 10));



        studentList.stream().sorted((s1, s2) -> Integer.compare(s1.getScore(), s2.getScore())).forEach(s-> System.out.println(s.getName() +":" + s.getScore()));
        System.out.println();
        studentList.stream().sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore())).forEach(s-> System.out.println(s.getName() +":" + s.getScore()));
    }
}
