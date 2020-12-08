package de.gad.batchdemo.processors;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import de.gad.batchdemo.MeineDaten;
import de.gad.batchdemo.Schwein;
@Component
public class SchweinToMeineDatenProcessor implements ItemProcessor<Schwein, MeineDaten>{

	@Override
	public MeineDaten process(Schwein item) throws Exception {
		
		if("Piggy".equals(item.getFirstname())) return null;
		
		return new MeineDaten(item.getFirstname(),item.getLastname(),0L);
	}

}
