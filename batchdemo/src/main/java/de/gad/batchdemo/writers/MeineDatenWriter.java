package de.gad.batchdemo.writers;

import java.util.List;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import de.gad.batchdemo.MeineDaten;


@Component
@StepScope
public class MeineDatenWriter implements ItemWriter<MeineDaten> {

	@Override
	public void write(List<? extends MeineDaten> items) throws Exception {
		System.out.println(items);
		
	}
	

	
}
