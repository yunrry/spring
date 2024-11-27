package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamEx {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java", "Stream", "API");

//        list.stream().forEach(System.out::println);

        list.stream()
                .filter(s -> s.startsWith("J"))
                .forEach(System.out::println); // Java

        list.stream()
                .map(String::toUpperCase) //.map( s -> s.toUpperCase() )
                .forEach(System.out::println);

        // 리스트의 문자열 길이의 합 계산
        int totalLength = list.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("list 문자의 전체 길이: " + totalLength);
    }
}
