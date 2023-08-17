package DP.src;
import java.util.*;
import java.io.*;


public class 좋은수{
    public static void main(String[] args) throws IOException{
       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.valueOf(bf.readLine());
       StringTokenizer st = new StringTokenizer(bf.readLine());
       int[] data=new int[n];
       
       for(int i =0; i<n;i++) {
    	   data[i]=Integer.parseInt(st.nextToken());
       }
       
       Arrays.sort(data);
       int answer=0;
       
       // 좋은수 찾기
       for(int k =0; k<n;k++) {
    	   int find = data[k];
    	   //start,end
    	   int i=0,j=data.length-1;
    	   //투 포인터
    	   while(i<j) {
    		   if(data[i]+data[j]==find) {
    			   //찾는 수의 인덱스가 아니면 좋은수 
    			   if(i !=k && j!=k) {
    				   answer++;
    				   break;
    			   }
    			   else if(i==k) 	i++;
    		       else if(j==k) 	j--;
    		   }   
    		   else if(data[i]+data[j]<find)  i++; 
    		   else j--;
    	   }
       }
       System.out.println(answer);
    }
}