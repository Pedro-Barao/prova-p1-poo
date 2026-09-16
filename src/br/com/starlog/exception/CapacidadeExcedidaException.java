package br.com.starlog.exception;

import java.io.IOError;

public class CapacidadeExcedidaException extends IllegalArgumentException {
    
    //Construtor para mostrar resposta do sistema em erros de Try e Catch
    public CapacidadeExcedidaException(String mensagem) throws IOError
    {

        super();

    }

}
