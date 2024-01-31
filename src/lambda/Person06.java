package lambda;

import javax.xml.namespace.QName;

public class Person06 {
    public Member getMember1(Creatable01 creatable) {
        String id = "winter";
        Member member = creatable.create(id);
        return member;
    }

    public Member getMember2(Creatable02 creatable) {
        String id = "winter";
        String name = "겨울";
        Member member = creatable.create(id, name);
        return member;
    }
}
