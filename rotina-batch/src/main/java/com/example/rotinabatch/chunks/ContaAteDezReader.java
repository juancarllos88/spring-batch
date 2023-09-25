package com.example.rotinabatch.chunks;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ContaAteDezReader implements ItemReader<Integer> {

    private final Iterator<Integer> iterator;

    public ContaAteDezReader(List<Integer> list) {
        iterator = list.iterator();
    }

    @Override
    public Integer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
         return iterator.hasNext() ? iterator.next() : null;
    }
}
