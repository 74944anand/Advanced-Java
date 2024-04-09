package main;
import java.util.Scanner;

	public class Pascals {
	    
	    public static int factorial(int n) {
	        if (n == 0) {
	            return 1;
	        }
	        int fact = 1;
	        for (int i = 1; i <= n; i++) {
	            fact *= i;
	        }
	        return fact;
	    }

	    public static int pascalsTriangleNumber(int row, int column) {
	        if (column > row) {
	            return -1; // Invalid input: column should be less than or equal to row
	        }
	        return factorial(row) / (factorial(column) * factorial(row - column));
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the row number: ");
	        int row = scanner.nextInt();
	        System.out.print("Enter the column number: ");
	        int column = scanner.nextInt();

	        int number = pascalsTriangleNumber(row, column);
	        if (number != -1) {
	            System.out.println("The number at row " + row + " and column " + column + " in Pascal's triangle is: " + number);
	        } else {
	            System.out.println("Invalid input: column should be less than or equal to row.");
	        }
	        scanner.close();
	    }
	

}
