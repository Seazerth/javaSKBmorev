package ru.morev.education.services;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RateLimitService {

    private final ConcurrentHashMap<String, AtomicInteger> callCounts = new ConcurrentHashMap<>();

    public int incrementAndGet(String methodName) {
        return callCounts
                .computeIfAbsent(methodName, key -> new AtomicInteger(0))
                .incrementAndGet();
    }
}
