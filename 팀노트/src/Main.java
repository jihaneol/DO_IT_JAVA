package 팀노트.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] croa = {"c=","c-","dz=","d-","lj","nj","s=","z="};

        for(String cro : croa){
            if(s.contains(cro)){
                s = s.replace(cro,"@");
            }
        }
        System.out.println(s);
        System.out.println(s.length());

    }

}
