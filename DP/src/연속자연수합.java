package DP.src;
import java.util.*;

// 빅O(n)
public class 연속자연수합{
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
       int n = sc.nextInt();
       // 투 포인터 사용
       int cnt =1, sum=1,start=1,end=1;
       
       while(end!=n) {
    	   
		   if(sum==n) {
			   cnt++;
			   end++;
			   sum+=end;
		   }else if (sum<n) {
			   end++;
			   sum+=end;
		   }else {
				sum-=start;
				start++;
			}
    	   
       }
       System.out.print(cnt);
        
    }
}