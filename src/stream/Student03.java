package stream;

public class Student03 implements Comparable<Student03> {
    private String name;
    private int score;

    public Student03(String name, int score) {
        this.name = name;
        this.score  = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Student03 o) {
        return Integer.compare(score, o.score);
    }
}
