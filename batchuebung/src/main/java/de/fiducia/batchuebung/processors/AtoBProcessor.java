package de.fiducia.batchuebung.processors;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import de.fiducia.batchuebung.A;
import de.fiducia.batchuebung.B;

@Component

public class AtoBProcessor implements ItemProcessor<A, B> {

	@Override
	public B process(A item) throws Exception {
		
		return new B(item.getA(), item.getB());
	}

}
