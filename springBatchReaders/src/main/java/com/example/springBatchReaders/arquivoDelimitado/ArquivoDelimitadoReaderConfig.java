package com.example.springBatchReaders.arquivoDelimitado;

import com.example.springBatchReaders.arquivoLarguraFixa.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ArquivoDelimitadoReaderConfig {

    @StepScope
    @Bean
    public FlatFileItemReader<Cliente> leituraArquivoDelimitadoReader(@Value("#{jobParameters['delimitado']}") Resource path) {
        return new FlatFileItemReaderBuilder<Cliente>()
                .name("ArquivoDelimitadoReader")
                .resource(path)
                .delimited()
                .names(new String[]{"nome", "sobrenome", "idade", "email"})
                .targetType(Cliente.class)
                .build();
    }
}
