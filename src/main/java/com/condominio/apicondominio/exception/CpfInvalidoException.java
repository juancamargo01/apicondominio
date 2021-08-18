package com.condominio.apicondominio.exception;



public class CpfInvalidoException extends RuntimeException{

    public CpfInvalidoException() {
        super("cpf inválido ou não informado");
    }
}
