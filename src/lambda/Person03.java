package lambda;

public class Person03 {
    public void action(Calcuable01 calcuable) {
        double result = calcuable.calc(10, 4);
        System.out.println("결과 : " + result);
    }
}
