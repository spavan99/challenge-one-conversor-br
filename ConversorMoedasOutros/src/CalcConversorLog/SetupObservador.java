package CalcConversorLog;

import PadraoConversor.PadraoConversor;

@FunctionalInterface
public interface SetupObservador {

	// titulo tipo conversor setado
	// classe do setup  // geral // passar especfica habilitada
	// setupOrigem    dolar para
	// setupFinal     euto
	
//	void valorAlterado(String setupTitulo, PadraoConversor setupOBJ, String setupOrigem, String setupDestino);

	void setupAlterado(int posicao, String setupTitulo, String dePara, PadraoConversor setupOBJ);

	
}
