package exception1.account;

public class InsufficientException extends Exception { // 일반예외 참조

    public InsufficientException() {
    }
    public InsufficientException(String message) {
        super(message); // 뿌모 생성자 매개값을 넘겨주는데 : 공통 메서드인 getMessage()의 리턴값으로 사용하기 위함

    }


}
