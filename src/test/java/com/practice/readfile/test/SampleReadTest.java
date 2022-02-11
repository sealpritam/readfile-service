package com.practice.readfile.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.practice.readfile.web.ReadFileApplication;

@SpringBootTest({"jobName=SAMPLE_FILE_READ"})
@ContextConfiguration(classes = {ReadFileApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SampleReadTest {
	
	@Test
	public void testRun() {
		System.out.println("TEST CASE RUNNING");
	}

}
