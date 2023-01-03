# Introduction
This project is a demo about the usage of Spring AOP to provide cross-cutting functionalities.
In this example, I´ll be adding metrics to the service layout. 

# How does it work
## AOP
Add the starter for AOP.
```
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

The aspect in this example is implemented in the class net.dms.aop.monitoring.MetricAspect.
In this case, I´m using the @Around, because to measure the time of a method to run we need to intercept
the execution before and after. Otherwise, we should use the aspect that better fit to the case of use, like Before or After.

## Metrics
Enable actuator to provide the endpoint for scrapping the metrics by Prometheus:
```
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Add the selected metric registry implementation, in this case, micrometer-registry-prometheus:
```
<dependency>
   <groupId>io.micrometer</groupId>
   <artifactId>micrometer-registry-prometheus</artifactId>
   <scope>runtime</scope>
</dependency>
```

Prometheus endpoint and metrics export need to be enabled in application.properties:
```
management.endpoint.prometheus.enabled=true
management.metrics.export.prometheus.enabled=true
management.endpoints.web.exposure.include=prometheus
```

## Prometheus
Prometheus is run with docker, see docker/docker-compose.yml. 
The configuration of Prometheus to scrape the metrics can be found in docker/prometheus/prometheus.yml

# Run the demo
1. Start Prometheus:
cd docker
docker-compose up
2. Run the application:
mvn spring-boot:run
3. Run the scripts to provide some data:
```bash
cd scripts
./test-get.sh
./test-save.sh
```
4. Check the metrics in Prometheus:
[Prometeus local](http://localhost:9090/graph?g0.expr=rate(FarmService_seconds_sum%5B1m%5D)%2Frate(FarmService_seconds_count%5B1m%5D)&g0.tab=0&g0.stacked=0&g0.show_exemplars=0&g0.range_input=1h)

![](C:\diego\workspace\spring-aop-monitoring\doc\prometheus.png)

# References
https://docs.spring.io/spring-framework/docs/2.5.5/reference/aop.html
