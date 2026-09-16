package br.com.starlog.model;

public class Carga {
    
    //Atributos da carga
    private String codigoRastreio;
    private String categoria;
    private double pesoKg;
    private double valorSeguro;

    //Construtor da carga
    public Carga(String codigoRastreio, String categoria, double pesoKg, double valorSeguro)
    {

        if(codigoRastreio == null || codigoRastreio.trim().isEmpty())
        {

            throw new IllegalArgumentException("\nCodigo de rastreio de carga nao pode ser nulo ou vazio");

        }

        this.codigoRastreio = codigoRastreio;
        this.categoria = categoria;
        this.pesoKg = pesoKg;
        this.valorSeguro = valorSeguro;

    }


    //Getters e Setters
    public String getCodigoRastreio()
    {

        return codigoRastreio;

    }
    //NÃO TEM SETTER ^^^


    public String getCategoria()
    {

        return categoria;

    }

    public void setCategoria(String categoria)
    {

        this.categoria = categoria;

    }


    public double getPesoKg()
    {

        return pesoKg;

    }

    public void setPesoKg(double pesoKg)
    {

        this.pesoKg = pesoKg;

    }


    public double getValorSeguro()
    {

        return valorSeguro;

    }

    public void setValorSeguro(double valorSeguro)
    {

        this.valorSeguro = valorSeguro;

    }


    //Método to String
    @Override
    public String toString()
    {

        return "\nCarga: " + getCodigoRastreio() + ", Categoria: " + getCategoria() + ", Peso (Kg): " + getPesoKg() + ", Valor Seguro: R$ " + getValorSeguro();
    
    }

    //Método Equals
    @Override
    public boolean equals(Object objeto)
    {

        if(objeto == null)
        {

            return false;

        }

        else
        {

            return this.getCodigoRastreio() == ((Carga) objeto).getCodigoRastreio();

        }

    }


    //Processo de transformação do código de rastreio em hash code
    public int hashCode()
    {

        return codigoRastreio.hashCode();

    }

}
