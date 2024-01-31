package lambda;

public class LambdaExample {
    public static void main(String[] args) {
        action((x, y) -> {
            int result1 = x + y;
            System.out.println("result1: " + result1);
        });

        action((x, y) -> {
            int result2 = x - y;
            System.out.println("result2: " + result2);
        });
    }

    public static void action(Calcuable00 calculable) {
        int x = 10;
        int y = 4;
        calculable.calculate(x, y);
    }
}
