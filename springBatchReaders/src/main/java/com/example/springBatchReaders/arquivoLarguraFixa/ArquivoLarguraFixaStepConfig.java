package com.example.springBatchReaders.arquivoLarguraFixa;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ArquivoLarguraFixaStepConfig {


    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step lerArquivoLarguraFixaStep(ItemReader<Cliente> leituraArquivoLarguraFixaReader,
                                          ItemWriter<Cliente> leituraArquivoLarguraFixaWriter) {

        return stepBuilderFactory.get("arquivoLarguraFixaStep")
                .<Cliente, Cliente>chunk(4)
                .reader(leituraArquivoLarguraFixaReader)
                .writer(leituraArquivoLarguraFixaWriter)
                .build();
    }
}
