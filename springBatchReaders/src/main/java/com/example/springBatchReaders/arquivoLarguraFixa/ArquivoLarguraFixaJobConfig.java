package com.example.springBatchReaders.arquivoLarguraFixa;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class ArquivoLarguraFixaJobConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job  arquivoLarguraFixaJob(Step lerArquivoLarguraFixaStep){
        return jobBuilderFactory.get("arquivoLarguraFixaJob")
                .start(lerArquivoLarguraFixaStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }

}

