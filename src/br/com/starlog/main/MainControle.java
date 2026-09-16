package br.com.starlog.main;

import java.util.HashSet;

import br.com.starlog.exception.CapacidadeExcedidaException;
import br.com.starlog.model.BaseLancamento;
import br.com.starlog.model.Carga;
import br.com.starlog.model.ModuloCarga;

public class MainControle {
    
    public static void main(String[] args)
    {

        //P01: Cargas, toString
        Carga c1 = new Carga("ORB-101-SP", "CRIOGENICA", 2.5, 450.00);
        Carga c2 = new Carga("ORB-102-RJ", "PADRAO", 8.0, 120.00);
        Carga c3 = new Carga("ORB-103-MG", "CRIOGENICA", 12.0, 850.00);
        Carga c4 = new Carga("ORB-104-PR", "BIOLOGICA", 15.0, 300.00);

        System.out.println(c1.toString() + c2.toString() + c3.toString() + c4.toString());


        //P02: Modulo, Base Lançamento
        ModuloCarga modulo = new ModuloCarga("MOD-ALFA-01", 3);

        BaseLancamento base = new BaseLancamento();

        base.cadastraModulo(modulo);


        //P03: Cargas adicionadas no Modulo
        modulo.carregarCarga(c1);
        modulo.carregarCarga(c2);
        modulo.carregarCarga(c3);


        //P04: Try e Catch
        try {

            modulo.carregarCarga(c4);

        }
        
        catch (CapacidadeExcedidaException error){

            System.out.println(error);
            
        }


        //P05: Buscando Modulo
        base.buscarModulo("MOD-ALFA-01");


        //P06: Calculando Seguro Total
        System.out.println("\nSeguro total do modulo: R$ " + modulo.calcularSeguroTotal());


        //P07: Localizar cargas por categoria
        System.out.println("\nCargas CRIOGENICA: " + modulo.contarCargasPorCategoria("CRIOGENICA"));


        //P08: Calcular por cargas pesadas
        System.out.println("\nSeguro de cargas criticas (CRIOGENICA > 5KG): R$ " + modulo.calcularSeguroCargasPesadas("CRIOGENICA", 5));


        //P09: Tamanho do manifesto
        HashSet<Carga> manifesto = new HashSet<>();

        Carga c5 = new Carga("ORB-101-SP", "CRIOGENICA", 9.0, 990.00);
        
        manifesto.add(c1);
        manifesto.add(c2);
        manifesto.add(c5);

        System.out.println("\nTamanho do manifesto:\n(HashSet) " + manifesto.size());

        try {

            Carga c6 = new Carga("", "PADRAO", 1.0, 50.00);

            manifesto.add(c6);

        }

        catch(IllegalArgumentException error) {

            System.out.println(error);

        }

    }
    
}
