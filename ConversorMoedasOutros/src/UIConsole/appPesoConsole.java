package UIConsole;

import java.util.List;

import Pesos.Pesos;

public class appPesoConsole {
	
    public void startPeso() {

    	//moeda
    	Pesos peso = new Pesos();
        peso.setnrCasasDecimal(4);
    	
    	String nPeso = peso.getStringAllPesos(); 
    	
    	// solicita a moeda
		System.out.println( "");
		System.out.println( "");
		System.out.println( "------------------------------------------");
		System.out.println( "App  <<<  CONVERSO DE UNIDADE PESOS   >>>");
		System.out.println( "------------------------------------------");
		System.out.println( "");
		peso.setDadosOrigem( ImputDados.imputDadosUpper( "Infome a peso de Origem:", nPeso));
	
		System.out.println( "");
		peso.setDadosDestino(ImputDados.imputDadosUpper( "Infome a peso a ser Convertida/Destino:", "|TODAS"+nPeso));

		System.out.println( "");
	    peso.setvalorConverter( Double.parseDouble(ImputDados.imputDados( "Valor/Qtde de " + 
		                         peso.getDadosOrigem() + " para converter:", 0.0, 9999999.99)));
	    
        if( peso.getDadosDestino().equals("TODAS")) {
        	List<String> lista = peso.getAllConversao(1);
        	System.out.println();
           	System.out.println("Listagem de Convers�o Pesos");
           	System.out.println();
                   	
            for( int i = 0; i < lista.size(); i++ ) {
                System.out.println( lista.get(i));            	
            }
 
        }else {
    	    System.out.println( "");
    	    System.out.println("Valor convertido de: " + peso.getDadosOrigem() + " para: " +
    		                    peso.getDadosDestino() +" e IGUAL A >>>> : "+ peso.dadosFormatadoConverter() + 
    		                    " " + peso.getDadosDestino());
        	
        }

    
	    ImputDados.imputWait("");
	    
    }


}
