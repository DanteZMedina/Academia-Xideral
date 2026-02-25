package com.bootcamp.week3.ex5;

import java.util.List;
import java.util.Map;

public class TextAnalyzerDemo {

    public static void main(String[] args) {

        List<String> text = List.of(
                "Java is a powerful programming language",
                "Java streams make data processing elegant",
                "Lambdas and streams are the heart of modern Java"
        );

        TextAnalyzer analyzer = new TextAnalyzer(text);

        System.out.println("=== Estadisticas de Texto ===");
        System.out.println("Total palabras: " + analyzer.wordCount());
        System.out.println("Palabras unicas: " + analyzer.uniqueWords().size());
        System.out.printf("Longitud promedio: %.2f%n",
                analyzer.averageWordLength());

        System.out.println("\n=== Top 5 Palabras ===");
        analyzer.topN(5).forEach(e ->
                System.out.printf(" '%s': %d veces%n",
                        e.getKey(),
                        e.getValue()
                )
        );

        System.out.println("\n=== Palabras por Letra ===");
        analyzer.wordsByFirstLetter()
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e ->
                        System.out.printf(" %c: %s%n",
                                e.getKey(),
                                e.getValue()
                        )
                );
    }
}