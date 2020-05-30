package com.local.app.batch;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.local.app.data.Evidence;
import com.local.app.data.EvidenceDetail;



@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	protected static ArrayList<Evidence> store = new ArrayList<Evidence>();
	
	@Autowired
	private JobBuilderFactory jobs;
	 
	@Autowired
	private StepBuilderFactory steps;
	
	@Autowired
	EvidenceDetailRepository repository2 ;
	
	@Autowired
	BatchWriter batchWriter ;
	

     
    @Bean
    public Step stepRead(){
        return steps.get("stepRead")
                .tasklet(new BatchReader())
                .build();
    }   
    
    @Bean
    public Step stepWrite(){
        return steps.get("stepWrite")
                .tasklet(batchWriter)
                .build();
    }   
       
    @Bean
    public Job executeJob(){
    	   return jobs.get("executeJob")
                   .incrementer(new RunIdIncrementer())
                   .start(stepRead())
                   .next(stepWrite())
                   .build();
    }

}
