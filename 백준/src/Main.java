import java.util.*;

public class Main{
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        int[] ans = new int[7];
        ans[a]++;
        ans[b]++;
        ans[c]++;
        int max = 0;
        int num = 0;
        for(int i=1; i<7; i++) {
        	if(ans[i]!=0) {
        		max = Math.max(max, i);
        		num = Math.max(num, ans[i]);
        	}
        }
        if(num==1) {
        	System.out.println(max*100);
        }else if(num==2) {
        	if(a==b) {
        		System.out.println(1000+(a*100));
        	}else if(a==c) {
        		System.out.println(1000+(a*100));
        	}else {
        		System.out.println(1000+(c*100));
        	}
        }else {
        	System.out.println(10000+(max*1000));
        }
    }	
}