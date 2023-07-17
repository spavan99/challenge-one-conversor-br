package MetodoGeral;

public class MetodoGeral {


	   public static double vrDinheiroValido( String valor) {
           // nao valido dinheiro retorna -1  ou zero ou maior
		   double nret = -1;
	    	if( ! valor.isEmpty()) {
	    		if(MetodoGeral.verSoNumeros(valor)) {
	    			nret = Double.parseDouble(valor.replace("," , "."));
	    		}
	    	}	
	        return nret;	
	   }
	
	   // retorna se uma string somente tem numeros e vigurla 
	   public static boolean verSoNumeros(String averificar) {
	    	boolean nret = true;
	    	for( int i = 0;  i < averificar.length(); i++) {
	    		char c =averificar.charAt(i);
	      	    if (  ('0' <= c && c <= '9') || (',' == c || c == '.')) {
	               // e numero ou ponto  ou virgula
	      	    }else {
	    	    	nret = false;
	    	    	break;
	    	    }
	    	}
	    	return nret;
	    }
   
	
	
	
}
