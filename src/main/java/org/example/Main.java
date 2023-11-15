package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> listOfNumbers = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        int evenNumbersDoubledSum = listOfNumbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number*2)
                .sorted()
                .reduce(0,(x,y) -> x+y);
        System.out.println(evenNumbersDoubledSum);
        listOfNumbers.stream()
                .filter(number -> number % 2 ==0)
                .map(number -> number *2)
                .sorted()
                .forEach(System.out::println);
        List<Integer> sortedEvenNumberList =
                listOfNumbers.stream()
                        .filter(number->number %2 ==0)
                        .sorted()
                        .collect(Collectors.toList());
        System.out.println(sortedEvenNumberList);
        try {
            /*Files.write(Path.of("C:\\Users\\Thorsten Thomann\\IdeaProjects" +
                    "\\ffm-java-23-2-streamaufgabe\\src\\main\\java\\org\\example" +
                    "\\students.csv"), Files.lines(Path.of("C:\\Users\\Thorsten Thomann\\IdeaProjects" +
                    "\\ffm-java-23-2-streamaufgabe\\src\\main\\java\\org\\example" +
                    "\\students.csv"))
                    .filter(line->!line.contains("ID"))
                    .filter(line->!line.isBlank())
                    .sorted()
                    .collect(Collectors.toList()));*/
            Files.lines(Path.of("C:\\Users\\Thorsten Thomann\\IdeaProjects" +
                    "\\ffm-java-23-2-streamaufgabe\\src\\main\\java\\org\\example" +
                    "\\students.csv"))
                    .map(s -> s.split(","))
                    .map(strings -> new Student(strings[1],strings[2],Integer.parseInt(strings[3])))
                    .forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}