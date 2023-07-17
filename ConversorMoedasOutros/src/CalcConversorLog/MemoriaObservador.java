package CalcConversorLog;

@FunctionalInterface
public interface MemoriaObservador {

//	void valorAlterado(String novoValor);
	void valorAlterado(int acao, String novoValor, String calculoValor);
	
}
