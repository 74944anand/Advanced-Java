package main;

import java.util.ArrayList;

public class Testcode {
	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        
        ArrayList<Integer> newArr= new ArrayList<>();
        for(int i=0;i<arr.length;i++){
        	int sum=0;
        	System.out.println("inside first loop");
            for(int j=i;j<arr.length;j++){
            	System.out.println("inside first loop");
                   if(sum<=s){
                        if(sum==s){
                        	System.out.println("Sum==s");
                            newArr.add(i+1);
                            newArr.add(j);
                            break;
                        }else{
                        	System.out.println("adding j to sum");
                             sum+=arr[j];
                        }
                     }else{
                    	 System.out.println("breaking");
                       break;  
                     }
                   
                 }
            }
        System.out.println("returning");
        return newArr;
    }
	
	public static void main(String[] args) {
		int []arr = {1,2,3,7,5};
		int n=5;
		int s=12;
		System.out.println(subarraySum(arr, n, s));
		
	}
	
}
