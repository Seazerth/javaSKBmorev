package ru.morev.education.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RequestMetricsFilter implements Filter {

    private final MeterRegistry meterRegistry;

    public RequestMetricsFilter(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String uri = httpRequest.getRequestURI();

        Timer.Sample sample = Timer.start(meterRegistry);
        try {
            chain.doFilter(request, response);
        } finally {
            sample.stop(Timer.builder("http.server.requests.custom")
                    .tag("uri", uri)
                    .description("Custom HTTP request timer")
                    .register(meterRegistry));
        }
    }
}
