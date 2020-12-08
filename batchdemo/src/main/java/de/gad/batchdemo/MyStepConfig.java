package de.gad.batchdemo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.gad.batchdemo.processors.MeineDatenItemProcessor;
import de.gad.batchdemo.readers.MyFlatFileReader;
import de.gad.batchdemo.writers.MeineDatenWriter;

@Configuration
public class MyStepConfig {
	
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step meinStep(MyFlatFileReader reader,MeineDatenItemProcessor processor, MeineDatenWriter writer) {
		return stepBuilderFactory
				.get("meinStep")
				.<MeineDaten, MeineDaten>chunk(10)
				.reader(reader)
				.processor(processor)
				.writer(writer).build();
	}

	
	 @Bean
	   public Job meinItemChunkJob()
	   {
	      return jobBuilderFactory.get( "meinItemChunkJob" )
	              .incrementer( new RunIdIncrementer() )
	              //.listener( meinListener() )
	              .flow(     meinStep(null, null, null) )
	              .end()
	              .build();
	   }
	 
//	 @Bean
//	 public DataSource getDataSource() throws SQLException {
//		 DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
//	        //dataSourceBuilder.driverClassName("org.h2.Driver");
//	        dataSourceBuilder.url("jdbc:mysql://localhost:3306/fiducia?allowPublicKeyRetrieval=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin&zeroDateTimeBehavior=convertToNull");
//	        dataSourceBuilder.username("root");
//	        dataSourceBuilder.password("yop49JZ");
//	        return dataSourceBuilder.build();
//		}
}
