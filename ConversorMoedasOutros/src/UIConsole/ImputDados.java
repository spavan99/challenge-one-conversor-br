package UIConsole;

import java.io.IOException;
import java.util.Scanner;

public class ImputDados {

	// tipo  zero nao monstra valido
	//       1 mostra valido --  padrao
	
    // INPUT DADOS NUMERO INICIAL E NUMERO FINAL
	public static String imputDados( String msg, double vrinicial, double vrfinal) {
    	String valido = "|*VALOR|**I"+ Double.toString(vrinicial)+"|**F"+ Double.toString(vrfinal)+"|";
    	String nRet = imputDados( msg, valido, 0, 0);
	    return nRet;
        	
    }
	
	// INPUT DADOS TEXTO VALIDACAO 
    public static String imputDados( String msg, String valido) {
	    String nRet = imputDados( msg, valido, 1, 0);
	    return nRet;
	}

	// INPUT DADOS TEXTO VALIDACAO CONSIDERA SOMENT MAIXCULA
    public static String imputDadosUpper( String msg, String valido) {
	    String nRet = imputDados( msg, valido, 1, 1);
	    return nRet;
	}
	
	
    // FUNCAO PRINCIPA TODOS PARAMENTOS
	public static String imputDados( String msg, String valido, int tipo, int upper) {
	 
	    // TIPO INCLUI MENSAGEM ANTES DIGITACAO  0- NAO INCLUI  1-INCLUIR 	
        // upper  somente string -- igual   zero considera conforme teclado   ---   1 somente maiscula
		
		boolean loop = true;
        boolean tpValor = false;
		double vrMinimo = 0;
        double vrMaximo = 9999999.99;
		String naux = "";
        
		// verifica valido tem expres |*VALOR| -- se tiver tratar como valor
		if( valido.contains("|*VALOR|")) {
            tpValor= true;
            int ninicio = 0;
            int nfim = 0;
	        
            //ECONTRA PRIMEIRO NUMBER |**I
            ninicio = valido.indexOf("|**I");
            //ECONTRA SEGUNDO NUMBER |**F
            nfim = valido.indexOf("|**F");
          
            // obter numero inicial
            naux = valido.substring( ninicio+ 4, nfim);
            vrMinimo = Double.parseDouble(naux);
            
            // obter numero final
            naux = valido.substring( nfim + 4,  valido.length()-1 );
            vrMaximo = Double.parseDouble(naux);
            
		}	
		Scanner sdigita = new Scanner(System.in);
		String digita = null;
					
		while(loop) {
            if( tipo == 1) {
    			System.out.println( "        >>>>>>> Itens Validos: " + valido);
            }
			System.out.print( msg+ " ");
			digita = sdigita.nextLine();
            if( tpValor) {
                // NUMERO    
            	// REPLACE TROCA VIRGULAR POR PONTOS
               digita = digita.replace("," , ".");
               if(  Double.parseDouble(digita) >= vrMinimo && Double.parseDouble(digita) <= vrMaximo   ) {
            	   loop = false;   
               }else {
     				System.out.println( "*** ERRO na digitação, valor minimo: " + vrMinimo + " e valor máximo: "  + vrMaximo );
    				System.out.println();
               }
            }else {
    			// STRING   // traforma tudo em maiscula
            	if( upper == 1) {
            		digita = digita.toUpperCase();
            	}
            	if( valido.contains("|"+digita+"|")) {
    				loop = false;
    			}else {
    				//System.out.println();
    				System.out.println( "*** ERRO na digitação, valido somente: " + valido );
    				System.out.println();
    			}
            }
		}
        return digita;
	}
	
    public static void imputWait(String msg) {
    	if( msg == "") {
    		msg = ">>>>>>   Tecler enter para continar....";
    	}
    	Scanner wait = new Scanner(System.in);
		String digWait = null;

		System.out.println();
		System.out.println( msg);
		digWait = wait.nextLine();
		
    }
	
    public static void limpaTela() {
    	String operatingSystem = System.getProperty("os.name");

    	if (operatingSystem .contains("Windows")) {
    	    try {
				Runtime.getRuntime().exec("cls");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else {
    	    try {
				Runtime.getRuntime().exec("clear");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }

    
 
    
    
    
    
}
