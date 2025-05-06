package ru.morev.education.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CandyMetrics {

    private final MeterRegistry meterRegistry;
    private final Map<String, Counter> counters = new ConcurrentHashMap<>();

    public CandyMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    public void recordPurchase(String candyType, int amount) {
        counters.computeIfAbsent(candyType, type ->
                Counter.builder("choco.purchases")
                        .tag("type", type)
                        .description("Count of chocolate purchases")
                        .register(meterRegistry)
        ).increment(amount);
    }
}
