package com.practice.readfile.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.readfile.domain.SampleFileDetail;
import com.practice.readfile.service.SampleFileReadService;
import com.practice.readfile.util.BatchFileReader;

@Service
public class SampleFileReadServiceImpl implements SampleFileReadService{
	
	private static final Logger logger = LoggerFactory.getLogger(SampleFileReadServiceImpl.class);
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private BatchFileReader<SampleFileDetail> fileReader;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@Override
	public void readAndSendData() throws Exception{
		logger.info("Within readAndSendData method in SampleFileReadServiceImpl class...");
		String configFile = environment.getProperty("sample.fileread.configFile");
		String dataFile = environment.getProperty("sample.fileread.dataFile");
		String streamName = environment.getProperty("sample.fileread.streamName");
		List<SampleFileDetail> dataList = new ArrayList<>();
		
		Map<String, String> configMap = new HashMap<>();
		configMap.put("CONFIG_FILE", configFile);
		configMap.put("DATA_FILE", dataFile);
		configMap.put("STREAM_NAME", streamName);
		
		dataList = fileReader.readDelimitedFile(configMap);
		
		String data = objectMapper.writeValueAsString(dataList);
		
		
		
	}

}
