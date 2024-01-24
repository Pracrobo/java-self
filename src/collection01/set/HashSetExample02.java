package collection01.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample02 {
    public static void main(String[] args) {
        Set<Member> set = new HashSet<Member>();

        //Member 저장
        set.add(new Member("홍길동", 30));
        set.add(new Member("홍길동", 30));

        System.out.println("총 객체의 수: "+set.size());
    }
}
