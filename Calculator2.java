package calculator;

import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
//class Path;
public class Calculator2 {

	public static void main(String[] args) throws IOException {
		Path file = Path.of("abc.txt");
		List<String> lines = Files.readAllLines(file);
		List<String>results = new ArrayList<>();
		
		for(String line : lines) {
			line = line.trim();
			
			 if (line.isEmpty()) {
	                continue;                               
	            }
	            if (line.contains("=")) {                   
	                line = line.substring(0, line.indexOf("=")).trim();
	            }

			String[] parts = line.split(" ");
			double a = Double.parseDouble(parts[0]);
			String operator = parts[1];
			double b = Double.parseDouble(parts[2]);
			String answer;                              
            switch (operator) {
                case "+" -> answer = format(a + b);
                case "-" -> answer = format(a - b);
                case "*" -> answer = format(a * b);
                case "/" -> {
                    if (b == 0) {
                        answer = "Cannot divide by 0";
                    } else {
                        answer = format(a / b);
                    }
                }
                default -> answer = "Unknown operator";
            }

            String newLine = line + " = " + answer;      
            System.out.println(newLine);
            results.add(newLine);
            Files.write(file, results); }  
//            System.out.println("");
            }
            static String format(double value) {
                if (value == (long) value) {
                    return "" + (long) value;
                }
                return "" + value;
            
	}
	}




