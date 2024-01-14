package exception1;

public class NullPointerException01 {
    public static void printLength(String data) {
        int result = data.length();
        System.out.println("문자수 : " + result);
    }
    
    public static void main(String[] args) {
        System.out.println("프로그램 시작");
        printLength("This is Java");
        printLength(null);
        System.out.println("프로그램 종료");
    }
    
}
