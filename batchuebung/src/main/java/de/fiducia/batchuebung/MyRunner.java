package de.fiducia.batchuebung;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

	 @Autowired private JobLauncher jobLauncher;
	 @Autowired private Job job;
	
	@Override
	public void run(String... args) throws Exception {
		Map<String, JobParameter> map = new HashMap<>();
		map.put("Date",new JobParameter(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant())));
		JobExecution run = jobLauncher.run( job, new JobParameters(map) );
		System.out.println(run.getExitStatus());

	}

}
