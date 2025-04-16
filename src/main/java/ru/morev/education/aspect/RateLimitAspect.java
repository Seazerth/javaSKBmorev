package ru.morev.education.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.morev.education.config.RateLimitConfig;
import ru.morev.education.services.RateLimitService;
import ru.morev.education.exception.RateLimitExceededException;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class RateLimitAspect {

    private final RateLimitService rateLimitService;
    private final RateLimitConfig rateLimitConfig;

    @Around("execution(* ru.morev.education.controller..*(..))")
    public Object checkRateLimit(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().toShortString();
        int count = rateLimitService.incrementAndGet(methodName);

        log.info("Метод {} вызван {} раз", methodName, count);

        if (count > rateLimitConfig.getMaxRequests()) {
            log.warn("Метод {} превышает лимит", methodName);
            throw new RateLimitExceededException("Превышен лимит вызовов API");
        }



        return pjp.proceed();
    }
}
