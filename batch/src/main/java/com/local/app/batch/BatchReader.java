package com.local.app.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.local.app.data.Evidence;
import com.local.app.data.EvidenceDetail;


public class BatchReader implements Tasklet {
	
	private static final Logger log = LoggerFactory.getLogger(BatchReader.class);
	
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception 
    {
		 log.debug("reader start..");
		 
		 Evidence evidence =null;
		 EvidenceDetail evidenceDetail=null;
		 
		 evidence  = new Evidence("John", "John","1","1") ;
		 evidenceDetail = new EvidenceDetail(evidence, "KEY1", "VALUE1");
		 evidence.addEvidenceDetails(evidenceDetail);
		 evidenceDetail = new EvidenceDetail(evidence, "KEY12", "VALUE12");
		 evidence.addEvidenceDetails(evidenceDetail);
		 evidenceDetail = new EvidenceDetail(evidence, "KEY13", "VALUE13");
		 evidence.addEvidenceDetails(evidenceDetail);
		 BatchConfiguration.store.add(evidence);
	     evidence = new Evidence("Jack", "Jack","2","2") ;
	     evidenceDetail = new EvidenceDetail(evidence, "KEY1", "VALUE1");	
	     evidence.addEvidenceDetails(evidenceDetail);
	     BatchConfiguration.store.add(evidence);
	     evidence = new Evidence("Jacob", "Jacob","3","3") ;
	     evidenceDetail = new EvidenceDetail(evidence, "KEY1", "VALUE1");
	     evidence.addEvidenceDetails(evidenceDetail);
	     BatchConfiguration.store.add(evidence);
	  
	     
		 
	
	      
	      
 
        // ... your code
         
	      log.debug("reader end..");
        return RepeatStatus.FINISHED;
    }    

}
