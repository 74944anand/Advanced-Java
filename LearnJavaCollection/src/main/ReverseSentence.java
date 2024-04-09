package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ReverseSentence {

	interface Human {
		final int data=0;
		static int count=4;
		public void run();	
	}
	
	abstract class Books {
		final int type=1;
		int pageNo=2;
		public void count() {
			System.out.println(type);
		}
		abstract void doSomething ();
	}
	
	public static void main(String[] args) {
		
		
		int []	nums = new int[] {1,2,2,3,1,4,2};
		Arrays.sort(nums);
		int [] newArr= new int [nums.length];
        
		System.arraycopy(nums, 0, newArr, 0, nums.length);
		
		for(int i:newArr) {
			System.out.println(i);
		}
		
		String s= "Hello";
		int i=0;
		while(i<s.length()) {
			System.out.println(s.charAt(i));
			i++;
		}
        System.out.println(newArr);
	}
}
