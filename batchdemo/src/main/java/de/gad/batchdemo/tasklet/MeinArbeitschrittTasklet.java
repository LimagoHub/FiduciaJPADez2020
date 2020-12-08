package de.gad.batchdemo.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;


@Component
public class MeinArbeitschrittTasklet implements Tasklet {

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
            System.out.println( "Hallo " );
            System.out.println(chunkContext.getStepContext().getJobParameters().get("ID"));
            return RepeatStatus.FINISHED;
      
	
	}

}
