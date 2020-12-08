package de.fiducia.batchuebung;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class BatchuebungApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchuebungApplication.class, args);
	}

}
