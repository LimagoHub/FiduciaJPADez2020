package de.fiducia.batchuebung.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.fiducia.batchuebung.A;
import de.fiducia.batchuebung.B;
import de.fiducia.batchuebung.processors.AtoBProcessor;
import de.fiducia.batchuebung.readers.AItemReader;
import de.fiducia.batchuebung.tasklets.FirstTasklet;
import de.fiducia.batchuebung.tasklets.SecondTasklet;
import de.fiducia.batchuebung.tasklets.ThirdTasklet;
import de.fiducia.batchuebung.writers.BWriter;

@Configuration
public class MyJobConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	
	
	@Bean
	public List<A> getAs() {
		return Arrays.asList(new A("a","b"),new A("a","b"),new A("a","b"),new A("a","b"));
	}

	@Bean
	public Step chunkStep(AItemReader reader, AtoBProcessor processor, BWriter writer) {
		return 
				stepBuilderFactory
				.get("chunkStep")
				.<A,B>chunk(10)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build()
				;
	}
	
	@Bean
	public Step firstStep(FirstTasklet tasklet) {
		return stepBuilderFactory.get("firstStep").tasklet(tasklet).build();
	}

	@Bean
	public Step secondStep(SecondTasklet tasklet) {
		return stepBuilderFactory.get("secondStep").tasklet(tasklet).build();
	}

	@Bean
	public Step thirdStep(ThirdTasklet tasklet) {
		return stepBuilderFactory.get("thirdStep").tasklet(tasklet).build();
	}

	@Bean
	public Job meinItemChunkJob() {
		return jobBuilderFactory.get("meinItemChunkJob").incrementer(new RunIdIncrementer())
				.start(firstStep(null))
				.next(secondStep(null))
				.next(thirdStep(null))
				.next(chunkStep(null, null, null))
				// .end()
				.build();
	}

}
