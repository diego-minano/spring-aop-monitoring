package net.dms.aop.monitoring;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MetricAspect {
    @Autowired
    MeterRegistry meterRegistry;

    @Around("within(net.dms.aop.service..*)")
    public Object timeRegister(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Timer timer = Timer.builder(proceedingJoinPoint.getSignature().toShortString().split("\\.")[0])
                .tag("operation", proceedingJoinPoint.getSignature().getName())
                .register(meterRegistry);

        Timer.Sample sample = Timer.start(meterRegistry);
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            sample.stop(timer);
        }
    }


}
