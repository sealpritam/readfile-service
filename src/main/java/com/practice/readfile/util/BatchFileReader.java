package com.practice.readfile.util;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.beanio.BeanReader;
import org.beanio.StreamFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.practice.readfile.domain.BaseRecord;
import com.practice.readfile.domain.Footer;
import com.practice.readfile.domain.Header;
import com.practice.readfile.domain.PoolHeader;

@Component
public class BatchFileReader<T extends BaseRecord> {
	
	private static final Logger logger = LoggerFactory.getLogger(BatchFileReader.class);
	
	public List<T> readFile(Map<String, String> configMap, Class<T> t, List<T> oPH) throws IOException{
		
		BeanReader in = null;
		Object record = null;
		boolean sod = true;
		List<T> tList = new ArrayList<>();
		T t1 = null;
		int count = -1;
		
		StreamFactory factory = StreamFactory.newInstance();
		Path res1 = Paths.get(configMap.get("CONFIG_FILE"));
		factory.load(res1.toFile());
		Path res = Paths.get(configMap.get("DATA_FILE"));
		try {
			in = factory.createReader(configMap.get("STREAM_NAME"), res.toFile());
			
			while((record = in.read()) != null) {
				
				if(sod) {
					t1= t.newInstance();
				}
				if("HEADER".equalsIgnoreCase(in.getRecordName())) {
					Header header = (Header)record;
					t1.setHeader(header);
					sod = false;
				}else if("FOOTER".equalsIgnoreCase(in.getRecordName())) {
					Footer footer = (Footer)record;
					t1.setFooter(footer);
					sod = true;
					tList.add(t1);
					count = -1;
				}else if ("POOL_HEADER".equalsIgnoreCase(in.getRecordName())) {
					Method getMethod = t1.getClass().getMethod("getPoolHeader");
					List<PoolHeader> list = (List)getMethod.invoke(t1);
					list.add((PoolHeader)record);
					count++;
				}
			}
		}catch(Exception exception){
			logger.error("Exception in BatchFileReader... {}", exception.getMessage() );
		}
		
		return tList;
	}
	
	
	public List<T> readDelimitedFile(Map<String, String> configMap){
		BeanReader in = null;
		T record = null;
		List<T> tList = new ArrayList<>();
		StreamFactory streamFactory = StreamFactory.newInstance();
		Path res1 = Paths.get(configMap.get("CONFIG_FILE"));
		streamFactory.load(res1.toFile());
		Path res = Paths.get(configMap.get("DATA_FILE"));
		try {
			in = streamFactory.createReader(configMap.get("STREAM_NAME"), res.toFile());
			while((record = (T)in.read()) != null) {
				tList.add(record);
			}
		}finally {
			if(in != null) {
				in.close();
			}
		}
		return tList;
	}
	
	

}
