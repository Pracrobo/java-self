package collection01.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample03 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        //Member 저장
        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Spring");

        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
            if(element.equals("JSP")){
                iterator.remove();
            }
        }

        System.out.println();

        //객체 제거
        set.remove("JDBC");

        for(String element : set) {
            System.out.println(element);
        }
    }
}
