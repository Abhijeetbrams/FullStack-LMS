package com.FullStackApp.LMS.LMSSpring.React.Firebase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAspectJAutoProxy
@ComponentScan({"com.Controller"})
@EntityScan("com.POJO")
@EnableJpaRepositories("com.Repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
