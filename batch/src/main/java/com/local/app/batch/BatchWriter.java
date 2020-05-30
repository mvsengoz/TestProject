package com.local.app.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class BatchWriter implements Tasklet {
	
	@Autowired
	EvidenceDetailRepository evidenceDetailRepository ;
	@Autowired
	EvidenceRepository evidenceRepository ;
	
	private static final Logger log = LoggerFactory.getLogger(BatchWriter.class);
	
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception 
    {
        log.debug("writer start..");
       
        BatchConfiguration.store.forEach(evidenceDetail -> evidenceRepository.save(evidenceDetail));
         
        log.debug("writer done..");
        return RepeatStatus.FINISHED;
    }  

}
