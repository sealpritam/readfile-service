package com.practice.readfile.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.practice.readfile.controller.ReadFileController;

@SpringBootApplication(scanBasePackages = {"com.practice"})
@EnableTransactionManagement
public class ReadFileApplication implements CommandLineRunner{

	private static int status = 1;
	
	@Value("${jobName}")
	private String jobName;
	
	@Autowired
	private ReadFileController readFileController;
	
	public static void main(String[] args) {
		SpringApplicationBuilder app = new SpringApplicationBuilder(ReadFileApplication.class);
		app.build().setWebApplicationType(WebApplicationType.NONE);
		ConfigurableApplicationContext context = app.run();
		context.close();
		System.exit(status);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ResponseEntity<String> responseEntity = readFileController.initiateJob(jobName);
		if(responseEntity.getStatusCode().equals(HttpStatus.OK))
			status=0;
	}

}
