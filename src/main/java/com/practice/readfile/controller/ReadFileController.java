package com.practice.readfile.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.practice.readfile.domain.JobType;
import com.practice.readfile.service.SampleFileReadService;

@Controller
public class ReadFileController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReadFileController.class);
	
	@Autowired
	private SampleFileReadService sampleFileReadService;
	
	public ResponseEntity<String> initiateJob(String jobName){
		logger.info("Within initiateJob method in ReadFileController class... jobName :: {}", jobName);
		try {
			if(JobType.valueOf(jobName) == JobType.SAMPLE_FILE_READ)
				sampleFileReadService.readAndSendData();
			return new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception exception) {
			exception.printStackTrace();
			logger.error(exception.getMessage());
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
