package Metricas;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import PadraoConversor.PadraoConversor;
import UIConsole.ImputDados;

public class Metricas extends PadraoConversor  {
		
    // contrutor	
    public Metricas() {
    	// vetor com as moedas
    	//_dados = getAllMetricas();
      	_dados = getAllDisponiveis();
        // cota��o base dados internos
    	imputCotacao();
    }

    // METODO SOBRESCRITO CLASSA PAI PARA TER SUA ESPECIFICIDADE
    @Override
	public  List<String> getAllDisponiveis() {
        List<String> lista = new ArrayList<>();
		for (MetricasTipo dados : MetricasTipo.values()) {
            //System.out.println(moedas.toString());
			lista.add(dados.toString().toUpperCase());                   
	     }
 		return lista;		
	}

    
    // metodos
	public static List<String> getAllMetricas() {
        List<String> lista = new ArrayList<>();
		for (MetricasTipo dados : MetricasTipo.values()) {
            //System.out.println(moedas.toString());
			lista.add(dados.toString().toUpperCase());                   
	     }
 		return lista;		
	}
	
	public static String  getStringAllMetricas() {
		String nret = "|"; 
		for (MetricasTipo dados : MetricasTipo.values()) {
	        nret = nret + dados + "|";
	    }
        return nret.toUpperCase();
		
	}

    // FATORES DE CONVERSAO DA UNIDADE METRICAS
	private void imputCotacao() {
 		for (MetricasTipo dados : MetricasTipo.values()) {
 			_cotacaodados.add(dados.getFatorConversao());
		}
	}


	
	
}
