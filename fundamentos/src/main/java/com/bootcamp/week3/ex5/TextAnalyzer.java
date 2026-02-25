package com.bootcamp.week3.ex5;

import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class TextAnalyzer {

    private final List<String> lines;

    public TextAnalyzer(List<String> lines) {
        this.lines = lines;
    }

    // Divide cada línea en palabras
    private Stream<String> words() {
        return lines.stream()
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .filter(w -> !w.isEmpty());
    }

    // Limpia palabras (solo letras) y las convierte a minúsculas
    private Stream<String> cleanWords() {
        return words()
                .map(w -> w.replaceAll("[^a-zA-Z]", ""))
                .filter(w -> !w.isEmpty())
                .map(String::toLowerCase);
    }

    // Total de palabras (sin limpiar)
    public long wordCount() {
        return words().count();
    }

    // Palabras únicas limpias
    public Set<String> uniqueWords() {
        return cleanWords().collect(toSet());
    }

    // Top N palabras más frecuentes
    public List<Map.Entry<String, Long>> topN(int n) {
        return cleanWords()
                .collect(groupingBy(
                        w -> w,
                        counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .collect(toList());
    }

    // Longitud promedio de palabras limpias
    public double averageWordLength() {
        return cleanWords()
                .mapToInt(String::length)
                .average()
                .orElse(0.0);
    }

    // Agrupar palabras únicas por primera letra
    public Map<Character, List<String>> wordsByFirstLetter() {
        return cleanWords()
                .distinct()
                .collect(groupingBy(w -> w.charAt(0)));
    }
}