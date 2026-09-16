package br.com.starlog.model;

import java.util.ArrayList;
import java.util.List;

import br.com.starlog.exception.CapacidadeExcedidaException;

public class ModuloCarga {
    
    //Atributos Modulo Carga
    private String codigoModulo;
    private int capacidadeMaxima;


    //Lista das Cargas por modulo
    List<Carga> cargas = new ArrayList<>();

    //Construtor Modulo Carga
    public ModuloCarga(String codigoModulo, int capacidadeMaxima)
    {

        this.codigoModulo = codigoModulo;
        this.capacidadeMaxima = capacidadeMaxima;

    }


    //Métodos Getters
    public String getCodigoModulo()
    {

        return codigoModulo;

    }


    public int getCapacidadeMaxima()
    {

        return capacidadeMaxima;

    }


    public List<Carga> getCargas()
    {

        return cargas;

    }


    //Método de adição das cargas
    public void carregarCarga(Carga carga)
    {

        if(getCapacidadeMaxima() < cargas.size())
        {

            throw new CapacidadeExcedidaException("Excessao capturada: Modulo '" + getCodigoModulo() + "' atingiu a capacidade maxima de " + getCapacidadeMaxima() + " cargas");

        }

        if(carga == null)
        {

            return;

        }

        cargas.add(carga);

        System.out.println("\nCarga " + carga.getCodigoRastreio() + " carregada no modulo com sucesso");

    }


    //Método de calculo do Valor Seguro
    public double calcularSeguroTotal()
    {

        double soma_seguro_total = cargas.stream()
                                    .mapToDouble(c -> c.getValorSeguro())
                                    .sum();

        return soma_seguro_total;

    }


    //Método de visualização das cargas por categoria
    public Long contarCargasPorCategoria(String categoria)
    {

        Long contagem = cargas.stream()
                        .filter(c -> c.getCategoria() == categoria)
                        .map(c -> c.getCategoria())
                        .count();

        return contagem;
    }


    //Método de calculo de cargas mais pesadas
    public double calcularSeguroCargasPesadas(String categoria, double pesoMinimo)
    {

        double carga_segura = cargas.stream()
                                .filter(c -> c.getPesoKg() > pesoMinimo && c.getCategoria() == categoria)
                                .mapToDouble(c -> c.getValorSeguro())
                                .sum();


        return carga_segura;
        
    }

}
