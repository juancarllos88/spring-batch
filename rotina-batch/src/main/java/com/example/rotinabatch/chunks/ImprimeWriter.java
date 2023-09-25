package com.example.rotinabatch.chunks;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class ImprimeWriter implements ItemWriter<String> {


    @Override
    public void write(List<? extends String> itens) throws Exception {
        itens.forEach(System.out::println);
    }
}
