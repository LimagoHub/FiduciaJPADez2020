package de.gad.batchdemo.readers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import de.gad.batchdemo.Schwein;


@Component
public class MyReader implements ItemReader<Schwein>{
	private final Iterator<Schwein> it;
	public MyReader() {
		List<Schwein> schweine = Arrays.asList(new Schwein("Piggy","Pig"), new Schwein("Rudi","Rüssel"));
		it = schweine.iterator();
	}

	@Override
	public Schwein read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if(it.hasNext())
			return it.next();
		else
			return null;
	}

}
