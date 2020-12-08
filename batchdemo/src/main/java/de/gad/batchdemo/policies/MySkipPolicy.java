package de.gad.batchdemo.policies;

import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.batch.item.file.FlatFileParseException;

public class MySkipPolicy implements SkipPolicy {

	@Override
	public boolean shouldSkip(Throwable t, int skipCount) throws SkipLimitExceededException {
		
		if(t instanceof FlatFileParseException && skipCount < 1) {
			System.out.println(skipCount);
			return true;
		}
		
		return false;
	}

}
