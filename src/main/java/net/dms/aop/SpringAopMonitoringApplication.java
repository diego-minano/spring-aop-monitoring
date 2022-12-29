package net.dms.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringAopMonitoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAopMonitoringApplication.class, args);
	}

}
