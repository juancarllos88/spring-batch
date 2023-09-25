package com.example.rotinabatch.jobs;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.CompositeJobParametersValidator;
import org.springframework.batch.core.job.DefaultJobParametersValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@EnableBatchProcessing
@Configuration
public class OlaJobSpringBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

//    @Bean
//    public Job imprimeOlaJob(Step imprimirOlaStep) {
//        return jobBuilderFactory.get("imprimeOlaJob")
//                .start(imprimirOlaStep)
//                //.incrementer(new RunIdIncrementer()) #rodar o job novamente com os mesmos parametros
//                //.validator(compositeValidator())
//                .build();
//    }



}
