package com.example.mission.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*@ComponentScan({"com.example.mission.scheduler.auth.service",
	"com.example.mission.scheduler.service","com.example.mission.scheduler.config"})
@EntityScan({"com.example.mission.scheduler.auth.domain","com.example.mission.scheduler.domain"})*/
public class SchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerApplication.class, args);
	}
}
