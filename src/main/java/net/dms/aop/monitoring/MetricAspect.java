package net.dms.aop.monitoring;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class MetricAspect {

    @Around("within(net.dms.aop.service..*)")
    public Object registerPerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            log.info("-->intercepted by AOP");
            return proceedingJoinPoint.proceed();
        } finally {
            log.info("-->work done");
        }
    }
}
