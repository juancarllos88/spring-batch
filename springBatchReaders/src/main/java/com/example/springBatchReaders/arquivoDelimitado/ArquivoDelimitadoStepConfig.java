package com.example.springBatchReaders.arquivoDelimitado;

import com.example.springBatchReaders.arquivoLarguraFixa.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoDelimitadoStepConfig {


    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step lerArquivoDelimitadoStep(ItemReader<Cliente> leituraArquivoDelimitadoReader,
                                          ItemWriter<Cliente> leituraArquivoLarguraFixaWriter) {

        return stepBuilderFactory.get("arquivoDelimitadoStep")
                .<Cliente, Cliente>chunk(1)
                .reader(leituraArquivoDelimitadoReader)
                .writer(leituraArquivoLarguraFixaWriter)
                .build();
    }
}
