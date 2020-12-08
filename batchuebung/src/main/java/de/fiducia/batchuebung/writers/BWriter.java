package de.fiducia.batchuebung.writers;

import java.util.List;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import de.fiducia.batchuebung.B;

@Component
@StepScope
public class BWriter implements ItemWriter<B> {

	@Override
	public void write(List<? extends B> items) throws Exception {
		items.forEach(System.out::println);
		
	}

}
