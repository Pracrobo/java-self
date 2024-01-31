package lambda;

public class MethodReferenceExample02 {
    public static void main(String[] args) {
        Person05 person = new Person05();
        person.ordering(String :: compareToIgnoreCase);
    }
}
