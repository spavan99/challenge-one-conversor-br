package UIConsole;

import java.util.List;

import Moeda.Moedas;

public class appMoedaConsole {
	
    public void startMoeda() {

    	//moeda
    	Moedas moeda = new Moedas();
        moeda.setnrCasasDecimal(4);
    	
    	String nMoedas = Moedas.getStringAllMoedasDisponiveis();
    	// solicita a moeda
		System.out.println( "");
		System.out.println( "");
		System.out.println( "------------------------------------------");
		System.out.println( "App  <<<  CONVERSO DE MOEDAS DO DIA  >>>");
		System.out.println( "------------------------------------------");
		System.out.println( "");
	    //moeda.moedaOrigem = ImputDados.imputDados( "Infome a moeda de Origem:", nMoedas);
		moeda.setDadosOrigem( ImputDados.imputDadosUpper( "Infome a moeda de Origem:", nMoedas));
	
		System.out.println( "");
		moeda.setDadosDestino(ImputDados.imputDadosUpper( "Infome a moeda a ser Convertida/Destino:", "|TODAS"+nMoedas));

		System.out.println( "");
	    moeda.setvalorConverter( Double.parseDouble(ImputDados.imputDados( "Valor/Qtde de " + 
		                         moeda.getDadosOrigem() + " para converter:", 0.0, 9999999.99)));
	    
	    //System.out.println( "");
		//System.out.println( "Data da conversao: ");
/*        
		System.out.println( "");
	    System.out.println("Valor convertido de: " + moeda.getDadosOrigem() + " para: " +
		                    moeda.getDadosDestino() +" e IGUAL A >>>> : "+ moeda.dadosFormatadoConverter() + 
		                    " " + moeda.getDadosDestino());
*/	    
	    
        if( moeda.getDadosDestino().equals("TODAS")) {
        	List<String> lista = moeda.getAllConversao(1);
        	System.out.println();
           	System.out.println("Listagem de Convers�o Moedas");
           	System.out.println();
                   	
            for( int i = 0; i < lista.size(); i++ ) {
                System.out.println( lista.get(i));            	
            }
 
        }else {
    	    System.out.println( "");
    	    System.out.println("Valor convertido de: " + moeda.getDadosOrigem() + " para: " +
    		                    moeda.getDadosDestino() +" e IGUAL A >>>> : "+ moeda.dadosFormatadoConverter() + 
    		                    " " + moeda.getDadosDestino());
        	
        }


    
	    ImputDados.imputWait("");
	    
    }


}
