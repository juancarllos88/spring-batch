package com.example.rotinabatch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImprimirOlaStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step imprimirOlaStep(Tasklet imprimirOlaTasklet) {
        return stepBuilderFactory.get("imprimirOlaStep")
                .tasklet(imprimirOlaTasklet).build();
    }
}
