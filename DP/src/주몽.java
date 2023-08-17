package DP.src;
import java.util.*;
import java.io.*;

public class 주몽{
    public static void main(String[] args) throws IOException{
       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.valueOf(bf.readLine());
       int m = Integer.valueOf(bf.readLine());
       int[] data=new int[n];
       int answer=0;
       StringTokenizer st = new StringTokenizer(bf.readLine());
       
       for(int i =0; i<n;i++) {
    	   data[i]=Integer.parseInt(st.nextToken());
       }
       //O(nlongn)
       Arrays.sort(data);
       // start_index , end_index
       int i=0, j=data.length-1;
       while(i<j) {
    	   if(data[i]+data[j]>m) {
    		   j--;
    	   }
    	   else if(data[i]+data[j]<m){
    		   i++;
    	   }
    	   else {
    		   i++;
    		   answer++;
    		   j--;
    	   }
    	   
       }
       System.out.println(answer);
       bf.close();
    }
}