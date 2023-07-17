package Pesos;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import PadraoConversor.PadraoConversor;
import UIConsole.ImputDados;

public class Pesos extends PadraoConversor  {
		
    public PesosTipo eTipo;

    
	// contrutor	
    public Pesos() {
    	// vetor com as moedas
    	//_dados = getAllPesos();
     	_dados = getAllDisponiveis();
        // cota��o base dados internos
    	imputCotacao();
    }

    
    // METODO SOBRESCRITO CLASSA PAI PARA TER SUA ESPECIFICIDADE
    @Override
	public List<String> getAllDisponiveis() {
        List<String> lista = new ArrayList<>();
		for (PesosTipo dados : PesosTipo.values()) {
            //System.out.println(moedas.toString());
			lista.add(dados.toString().toUpperCase());                   
	     }
 		return lista;		
	}

    
    // metodos
	public static List<String> getAllPesos() {
        List<String> lista = new ArrayList<>();
		for (PesosTipo dados : PesosTipo.values()) {
            //System.out.println(moedas.toString());
			lista.add(dados.toString().toUpperCase());                   
	     }
 		return lista;		
	}
	
	public static String  getStringAllPesos() {
		String nret = "|"; 
		for (PesosTipo dados : PesosTipo.values()) {
	        nret = nret + dados + "|";
	    }
        return nret.toUpperCase();
		
	}

    // FATORES DE CONVERSAO DA UNIDADE METRICAS
	private void imputCotacao() {
 		for (PesosTipo dados : PesosTipo.values()) {
 			_cotacaodados.add(dados.getFatorConversao());
		}
	}
	
}
