package de.fiducia.batchuebung.readers;

import java.util.Iterator;
import java.util.List;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import de.fiducia.batchuebung.A;
@Component
@StepScope
public class AItemReader implements ItemReader<A> {
	
	public final Iterator<A> it ;
	
	public AItemReader(List<A> alist) {
		it = alist.iterator();
	}

	@Override
	public A read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

		if(it.hasNext())
			return it.next();
		return null;
	}

}
