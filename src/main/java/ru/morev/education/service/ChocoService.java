package ru.morev.education.service;

import org.springframework.stereotype.Service;
import ru.morev.education.metrics.CandyMetrics;

@Service
public class ChocoService {

    private final CandyMetrics candyMetrics;

    public ChocoService(CandyMetrics candyMetrics) {
        this.candyMetrics = candyMetrics;
    }

    public void buyChocolate(String type, int amount) {
        candyMetrics.recordPurchase(type, amount);
    }
}
