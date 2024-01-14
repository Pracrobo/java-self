package exception1;

public class ThrowsExample02 {
    public static void main(String[] args) throws Exception{ //JVM이 예외처리 하는 것
            findClass();
    }

    public static void findClass() throws ClassNotFoundException{
        Class.forName("java.lang.String2");
    }
}
