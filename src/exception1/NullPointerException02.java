package exception1;

public class NullPointerException02 {
    public static void printLength(String data) {
        try {
            int result = data.length();
            System.out.println("문자수 : " + result);
        }catch(NullPointerException e){
          //  System.out.println(e.getMessage());  // 예외의 발생 이유 리턴
          //  System.out.println(e.toString());  // 예외의 종류 리턴
            e.printStackTrace();               // 예외가 발생한 지점 추적한 내용 출력
        }finally {
            System.out.println("마무리 실행");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("프로그램 시작");
        printLength("This is Java");
        printLength(null);
        System.out.println("프로그램 종료");
    }
    
}
