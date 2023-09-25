package com.example.rotinabatch.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class imprimirOlaTasklet implements Tasklet {

    @StepScope
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        String name = (String)chunkContext.getStepContext().getJobParameters(). get("name");
        System.out.println(String.format("Ola %s", name));
        return RepeatStatus.FINISHED;
    }

//    @StepScope
//    @Bean
//    public void print(@Value("#{jobParameters['name']}") String nome) {
//        System.out.println(String.format("Ola %s", nome));
//    }
}
