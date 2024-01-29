package collection03;

import java.util.TreeSet;

public class ComparableExample {
    public static void main(String[] args) {
        TreeSet<Person> treeSet = new TreeSet<Person>();

        treeSet.add(new Person("홍길동", 45));
        treeSet.add(new Person("김자바", 25));
        treeSet.add(new Person("박지원", 31));


        //객체 가져오기
         for(Person person: treeSet) {
             System.out.println(person.name +":" + person.age);
         }
    }
}
