package com.practice.readfile.domain;

import java.util.HashMap;

public enum JobType {
	
	SAMPLE_FILE_READ("SAMPLE_FILE_READ"),
	UNKNOWN_ENUM("UNKNOWN_ENUM");
	
	private final String value;
	private static HashMap<String, JobType> values = new HashMap<>();
	
	JobType(String value) {
		this.value= value;
	}
	
	static {
		for(JobType jobType : JobType.values()) {
			values.put(jobType.value, jobType);
		}
	}
	
	public JobType getJobType(String value) {
		JobType jobType = values.get(value);
		if(jobType == null)
			jobType = UNKNOWN_ENUM;
		return jobType;
	}
}
