package UIConsole;

import java.util.List;

import Metricas.Metricas;

public class appMetricaConsole {
	
    public void startMetrica() {

    	//moeda
    	Metricas metrica = new Metricas();
        metrica.setnrCasasDecimal(4);
    	
    	String nMetricas = metrica.getStringAllMetricas(); 
    	
    	// solicita a moeda
		System.out.println( "");
		System.out.println( "");
		System.out.println( "------------------------------------------");
		System.out.println( "App  <<<  CONVERSO DE UNIDADE METRICAS  >>>");
		System.out.println( "------------------------------------------");
		System.out.println( "");
		metrica.setDadosOrigem( ImputDados.imputDadosUpper( "Infome a metrica de Origem:", nMetricas));
	
		System.out.println( "");
		metrica.setDadosDestino(ImputDados.imputDadosUpper( "Infome a metrica a ser Convertida/Destino:", "|TODAS"+nMetricas));

		System.out.println( "");
	    metrica.setvalorConverter( Double.parseDouble(ImputDados.imputDados( "Valor/Qtde de " + 
		                         metrica.getDadosOrigem() + " para converter:", 0.0, 9999999.99)));
	    
        if( metrica.getDadosDestino().equals("TODAS")) {
        	List<String> lista = metrica.getAllConversao(1);
        	System.out.println();
           	System.out.println("Listagem de Conversão Metrica");
           	System.out.println();
                   	
            for( int i = 0; i < lista.size(); i++ ) {
                System.out.println( lista.get(i));            	
            }
 
        }else {
    	    System.out.println( "");
    	    System.out.println("Valor convertido de: " + metrica.getDadosOrigem() + " para: " +
    		                    metrica.getDadosDestino() +" e IGUAL A >>>> : "+ metrica.dadosFormatadoConverter() + 
    		                    " " + metrica.getDadosDestino());
        	
        }

    
	    ImputDados.imputWait("");
	    
    }


}
