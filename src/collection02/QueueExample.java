package collection02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Message> messageQueue = new LinkedList<>();

        //메세지넣기
        messageQueue.offer(new Message("sendMail", "홍길동"));
        messageQueue.offer(new Message("sendInstargram", "신용권"));
        messageQueue.offer(new Message("sendKakaotalk", "이자바"));

        while(!messageQueue.isEmpty()){
            Message message = messageQueue.poll();
            switch (message.command) {
                case "sendMail":
                    System.out.println(message.to + "님에게 메세지를 보냅니다.");
                    break;
                case "sendInstargram":
                    System.out.println(message.to + "님에게 인스타를 보냅니다.");
                    break;
                case "sendKakaotalk":
                    System.out.println(message.to + "님에게 카카오톡을 보냅니다.");
                    break;
            }
        }
    }
}
