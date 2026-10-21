package calculator;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
    	
    	 	Scanner scanner = new Scanner(System.in);
    	 	System.out.println("Enter first number");
    	 	double a = scanner.nextDouble();
    	 	
    	 	System.out.println("Enter the operator");
    	 	String operator = scanner.next();
    	 	
    	 	System.out.println("Enter the second number");
    	 	double b = scanner.nextDouble();
    	 	
    	 	double c ;
    	 	
    	 	switch(operator) {
    	 	case "+" -> c = a + b;
    	 	case "-" -> c = a - b;
    	 	case "*" -> c = a * b;
    	 	case "/" ->{
    	 		if( b == 0) {
		    	 			System.out.println("Cannot devide by 0");
		    	 			scanner.close();
		    	 			return;
		    	 			}	
    	 		c = a / b;
    	 		}
    	 	
    	 		default ->{
				    	 System.out.println("I don't know this operator" + " : " +  operator);
				    	 scanner.close();
    	 				return;
    	 				}
    	 	}
    	 	System.out.println(c);
    	 	scanner.close();
    	 	}
   }
//  That's all.
    
  
