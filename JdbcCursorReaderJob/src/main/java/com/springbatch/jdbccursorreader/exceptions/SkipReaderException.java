package com.springbatch.jdbccursorreader.exceptions;

public class SkipReaderException extends RuntimeException{
    public SkipReaderException(String erro) {
        super(erro);
    }
}
