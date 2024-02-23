package ioStream03;

import java.io.BufferedReader;
import java.io.FileReader;


public class ReadLineExample {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("src/ioStream03/ReadLineExample.java")); //보조 스트림 연결
        int lineNo = 1;
        while(true) {
            String str = br.readLine();
            if(str == null) break;
            System.out.println(lineNo + "\t" + str);
            lineNo++;
        }
        br.close();
    }
}
