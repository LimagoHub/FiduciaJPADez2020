package de.gad.batchdemo.processors;

import java.util.Arrays;

import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.stereotype.Component;

import de.gad.batchdemo.MeineDaten;
import de.gad.batchdemo.Schwein;


@Component
public class MultiProcessor extends CompositeItemProcessor<Schwein, MeineDaten> {
	
	
	
	public MultiProcessor(SchweinToMeineDatenProcessor schweinToMeineDatenProcessor,MeineDatenItemProcessor meineDatenItemProcessor) {
		
		setDelegates(Arrays.asList(schweinToMeineDatenProcessor, meineDatenItemProcessor));
	}
	
	

}
