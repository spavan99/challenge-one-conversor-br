package CalcConversorLog;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Calculadora.DisplayInfo;
import MetodoGeral.MetodoGeral;
import PadraoConversor.PadraoConversor;

public class SetupCalc {

	 
	// observador do setar origens e destino e o calculo    
	//  evento ocorre no teclado  --->   dispara setupcalc avias ---> display  este faz a acao e o processo de calculo
	// utilizada para todos o eventos do teclado
	
	// tem uma unica instancia aberta
	private static final SetupCalc instancia = new SetupCalc();
	
	private String setupTitulo = "";
//	private String setupOrigem = "";
//	private String setupDestino = "";
	private PadraoConversor setupObj;
	
	private final List<SetupObservador> observadores = new ArrayList<>();
	
	public static SetupCalc startCalc() {
		return instancia;
	}

	
	public void adionarObservador( SetupObservador observador) {
	    observadores.add(observador);	
	}
	
    public String processarComando(int tipo, String titulo, String dePara, PadraoConversor setupOBJ) {
   	
    	// tipo  -->  0 painel da direita  /dados origem
    	//            1 painela da esquerda // dadis destino
        //            2 -zera classe os campos origem e convertido 
    	//            3 calcular   recebe valor campo dePara

        String nret = "";
    	setupTitulo = titulo;
        // processa dadso necessario
        if( tipo == 0) {  // origem
        	setupOBJ.setDadosOrigem(dePara);

        }else if( tipo == 1) {  // destino
        	setupOBJ.setDadosDestino(dePara);

        }else if( tipo == 2) {
        	setupOBJ.setvalorFinal(0.0);
    		setupOBJ.setvalorConverter(0.0);
        	
        }else if( tipo == 3) {
          	//convertido.setText( nobj.dadosFormatadoConverter());
        	double naux = MetodoGeral.vrDinheiroValido(dePara);
         	if( naux > 0 ) {
         		 setupOBJ.setvalorConverter(naux);
         		 nret = setupOBJ.dadosFormatadoConverter();
         	}else {
         		 JOptionPane.showMessageDialog(null, "Valor incorreto ou zerado");
         	}
        
        }

    	// avisa as demais rotinas sobre o evento;
      	observadores.forEach( o -> o.setupAlterado(tipo, titulo, dePara, setupOBJ));

        return nret;      	
    }

    
	
}

