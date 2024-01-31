package lambda;

public class MethodReferenceExample {
    public static void main(String[] args) {
        Person04 person = new Person04();

        person.action(Computer::staticMethod) ;
        Computer com = new Computer();
        person.action(com :: instanceMethod);
    }
}
