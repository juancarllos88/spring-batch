package com.example.rotinabatch.jobs;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class ParImparJobSringBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job imprimeParImparJob(Step imprimirParImparStep) {
        return jobBuilderFactory.get("imprimeParImparJob")
                .start(imprimirParImparStep)
                //.incrementer(new RunIdIncrementer()) #rodar o job novamente com os mesmos parametros
                .build();
    }

/*
    @Bean
    public Job imprimeParImparJob() {
        return jobBuilderFactory.get("imprimeParImparJob")
                .start(imprimirParImparStep())
                //.incrementer(new RunIdIncrementer()) #rodar o job novamente com os mesmos parametros
                .build();
    }

    public Step imprimirParImparStep() {
        return stepBuilderFactory.get("imprimirParImparStep")
                .<Integer, String>chunk(2)
                .reader(contaAteDezReader())
                .processor(parOuImparProcessor())
                .writer(imprimeWriter())
                .build();
    }

    private ItemWriter<String> imprimeWriter() {
        return itens-> itens.forEach(System.out::println);
    }

    private ItemProcessor<Integer, String> parOuImparProcessor() {
        return new FunctionItemProcessor<Integer, String>(item -> {
            if(item % 2 == 0) {
                System.out.println("item " + item);
                return String.format("Item %s é par", item);
            }else{
                System.out.println("item " + item);
                return String.format("Item %s é impar", item);
            }
        });
    }

    private ItemReader<Integer> contaAteDezReader() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return new IteratorItemReader<Integer>(list.iterator());
    }

*/

}
