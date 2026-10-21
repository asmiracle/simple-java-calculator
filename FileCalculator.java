package calculator;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem 2: reads abc.txt, calculates every line, and writes the results back.
 * Example: the line "1000 / 10" becomes "1000 / 10 = 100".
 *
 * In Eclipse, abc.txt must be in the project folder (next to src), not inside src.
 */
public class FileCalculator {

    private static final Path FILE = Path.of("abc.txt");

    public static void main(String[] args) {
        if (!Files.exists(FILE)) {
            System.out.println("abc.txt not found. Put it here: " + FILE.toAbsolutePath());
            return;
        }

        Calculator calculator = new Calculator();

        try {
            List<String> lines = Files.readAllLines(FILE, StandardCharsets.UTF_8);
            List<String> results = new ArrayList<>();

            for (String line : lines) {
                line = line.replace("﻿", "");   // invisible character Notepad may add
                if (line.isBlank()) {
                    results.add(line);
                    continue;
                }

                // If the line was already calculated ("1000 / 10 = 100"), use only the left part
                String calculation = line.contains("=")
                        ? line.substring(0, line.indexOf('=')).trim()
                        : line.trim();

                String result;
                try {
                    result = Calculator.format(calculator.evaluate(calculation));
                } catch (RuntimeException e) {
                    result = "Error: " + e.getMessage();
                }

                String newLine = calculation + " = " + result;
                results.add(newLine);
                System.out.println(newLine);
            }

            Files.write(FILE, results, StandardCharsets.UTF_8);
            System.out.println("Results saved to " + FILE.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Could not read or write abc.txt: " + e.getMessage());
        }
    }
}
