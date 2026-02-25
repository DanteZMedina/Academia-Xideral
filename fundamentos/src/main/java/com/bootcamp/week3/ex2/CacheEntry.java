package com.bootcamp.week3.ex2;

public record CacheEntry<V>(V value, long expiresAt) {

    public boolean isExpired() {
        return System.currentTimeMillis() > expiresAt;
    }
}