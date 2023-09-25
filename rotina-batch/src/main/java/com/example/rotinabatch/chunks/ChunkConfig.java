package com.example.rotinabatch.chunks;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ChunkConfig {

    @Bean
    public ItemWriter<String> imprimeWriter() {
        return new ImprimeWriter();
    }
    @Bean
    public ItemProcessor<Integer, String> parOuImparProcessor() {
        return new ParOuImparProcessor();
    }
    @Bean
    public ItemReader<Integer> contaAteDezReader() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return new ContaAteDezReader(list);
    }


}
