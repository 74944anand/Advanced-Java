package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

	class Student implements Comparable<Student> {
		int rollno;
		String name;
		int age;

		Student(int rollno, String name, int age) {
			this.rollno = rollno;
			this.name = name;
			this.age = age;
		}

		public int getRollno() {
			return rollno;
		}

		public void setRollno(int rollno) {
			this.rollno = rollno;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
 
		@Override
		public int compareTo(Student o) {
			if(rollno==o.rollno) {
				return 0;
			}
			else if(rollno>o.rollno) {
				return 1;
			}
			else {
				return -1;
			}
		}

	public static void main(String[] args) {
		 ArrayList<Student> al=new ArrayList<Student>();    
		  al.add(new Student(101,"Vijay",23));    
		  al.add(new Student(106,"Ajay",27));    
		  al.add(new Student(105,"Jai",21));
		  
		  Comparator<Student> cm2= Comparator.comparing(Student::getAge);
		  Comparator<Student> cm1=Comparator.comparing(Student::getName);  
		   Collections.sort(al,cm1);  
		   System.out.println("Sorting by Name");  
		   for(Student st: al){
		     System.out.println(st.rollno+" "+st.name+" "+st.age);  
		     }
		   Collections.sort(al, cm2);
		   System.out.println("Sorting by Age");  
		   for(Student st: al){  
		     System.out.println(st.rollno+" "+st.name+" "+st.age);  
		     }
		   
		   Collections.sort(al);
		   for(Student st:al){  
			   System.out.println(st.rollno+" "+st.name+" "+st.age);  
			   } 
	}

	
}
