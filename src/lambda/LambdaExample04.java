package lambda;

import static java.lang.Double.sum;

public class LambdaExample04 {
    public static void main(String[] args) {
        Person03 person = new Person03();

        person.action((x, y) -> {
            double result = x + y;
            return result;
        });

        person.action((x, y) -> (x + y));
        person.action((x, y) -> sum(x, y));
    }
    public static double sum(double x, double y) {
        return (x + y);
    }
}


