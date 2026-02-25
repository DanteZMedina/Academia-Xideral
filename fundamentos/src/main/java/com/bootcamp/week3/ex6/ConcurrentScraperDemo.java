package com.bootcamp.week3.ex6;

import java.util.List;

public class ConcurrentScraperDemo {

    public static void main(String[] args) {

        ConcurrentScraper scraper = new ConcurrentScraper(4);

        List<String> urls = List.of(
                "example.com",
                "google.com",
                "github.com",
                "stackoverflow.com"
        );

        System.out.println("=== Fetch All (paralelo) ===");

        long start = System.currentTimeMillis();

        List<PageResult> results = scraper.fetchAll(urls);

        long elapsed = System.currentTimeMillis() - start;

        scraper.printReport(results);

        System.out.printf("Tiempo total (paralelo): %dms%n", elapsed);

        System.out.println("\n=== Fetch con Timeout (500ms) ===");

        List<PageResult> resultsTimeout =
                scraper.fetchWithTimeout(urls, 500);

        scraper.printReport(resultsTimeout);

        scraper.shutdown();
    }
}