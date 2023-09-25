package com.example.rotinabatch.chunks;


import org.springframework.batch.item.ItemProcessor;

public class ParOuImparProcessor implements ItemProcessor<Integer, String> {


    @Override
    public String process(Integer item) throws Exception {
        if(item % 2 == 0) {
            System.out.println("item " + item);
            return String.format("Item %s é par", item);
        }else{
            System.out.println("item " + item);
            return String.format("Item %s é impar", item);
        }
    }
}
