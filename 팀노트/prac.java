package 팀노트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prac {
    public static void main(String[] str) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        int num = Integer.valueOf(br.readLine());
        System.out.println(data.charAt(num-1));
    }

}
