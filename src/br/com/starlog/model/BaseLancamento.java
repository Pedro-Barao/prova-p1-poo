package br.com.starlog.model;

import java.util.HashMap;
import java.util.Map;

public class BaseLancamento {
    
    //Map de registro dos modulos nas bases de lançamento
    private Map<String, ModuloCarga> modulos = new HashMap<>();
    
    //Construtor nulo "vazio"
    public BaseLancamento() { }


    //Método Getter do Map
    public Map<String, ModuloCarga> getModulos()
    {

        return modulos;

    }


    //Cadastro dos modulos no Map
    public void cadastraModulo(ModuloCarga modulo)
    {

        if(modulo == null)
        {

            System.out.println("\nModulo Invalido");

            return;

        }

        modulos.put(modulo.getCodigoModulo(), modulo);

        System.out.println("\nModulo " + modulo.getCodigoModulo() + " cadastrado na base com capacidade de " + modulo.getCapacidadeMaxima() + " cargas");

    }


    //Método de busca dos modulos no map
    public ModuloCarga buscarModulo(String codigoModulo)
    {

        if(modulos.containsKey(codigoModulo))
        {

            System.out.println("\nModulo localizado na base: " + codigoModulo);

            return modulos.get(codigoModulo);

        }

        System.out.println("\nCodigo de modulo nao encontrado");
        
        return null;

    }


}
