package com.local.app.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.local.app.data.Evidence;
import com.local.app.data.EvidenceDetail;

@SpringBootApplication
@EnableJpaRepositories("com.local.app.*")
@ComponentScan(basePackages = { "com.local.app.*" })
@EntityScan("com.local.app.*")   
public class BatchApplication {
	
	  @Autowired
	    JobLauncher jobLauncher;
	     
	  @Autowired
	    Job job;
	
	private static final Logger log = LoggerFactory.getLogger(BatchApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}
	
	
	 @Bean
	 public CommandLineRunner demo(EvidenceRepository repository1 ,EvidenceDetailRepository repository2) {
	    return (args) -> {
	    	
	    	JobParameters params = new JobParametersBuilder()
                    .addString("JobID", String.valueOf(System.currentTimeMillis()))
                    .toJobParameters();
	    	jobLauncher.run(job, params);
	    	/*
	      // save a few customers
	      Evidence evidence1 = new Evidence("Jack", "Bauer","1","1") ;
	      Evidence evidence2 = new Evidence("Jack", "Bauer","2","2") ;
	      Evidence evidence3 = new Evidence("Jack", "Bauer","3","3") ;
	      Evidence evidence4 = new Evidence("Jack", "Bauer","4","4") ;
	      Evidence evidence5 = new Evidence("Jack", "Bauer","5","5") ;
	      
	      repository1.save(evidence1);
	      repository1.save(evidence2);
	      repository1.save(evidence3);
	      repository1.save(evidence4);
	      repository1.save(evidence5);
	      
	      repository2.save(new EvidenceDetail(evidence1, "KEY1", "VALUE2"));
	      repository2.save(new EvidenceDetail(evidence2, "KEY2", "VALUE2"));
	      repository2.save(new EvidenceDetail(evidence3, "KEY3", "VALUE3"));
	      repository2.save(new EvidenceDetail(evidence4, "KEY4", "VALUE4"));
	      repository2.save(new EvidenceDetail(evidence5, "KEY5", "VALUE5"));
	      
	 

	      // fetch all customers
	      log.info("Customers found with findAll():");
	      log.info("-------------------------------");
	      for (Evidence evidence : repository1.findAll()) {
	        log.info(evidence.toString());
	      }
	      log.info("");

	      log.info("");
	      */
	    };
	  }
	 
	

}
