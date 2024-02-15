package ioStream;

import java.io.*;

public class FileCopyExample {
    public static void main(String[] args) throws Exception {
        String originalFileName = "D:/Test/test.jpg";
        String targetFileName = "D:/Test/test1.jpg";

        InputStream is = new FileInputStream(originalFileName);
        OutputStream os = new FileOutputStream(targetFileName);


        is.transferTo(os);  //Java 9부터 transferTo메소드로 간편하게 대체 가 가능하다.

/*      byte[] data = new byte[1024];
        while(true) {
            int num = is.read(data);
            if(num == -1) break;
            os.write(data, 0, num);
        }
*/
        os.flush();
        os.close();
        is.close();
        System.out.println("복사가 잘 되었습니다.");
    }
}
