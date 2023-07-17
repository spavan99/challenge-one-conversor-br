package UICalcCoonversorSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

import Conversor.GlobalVars;
import UIGeral.BotaoGeral;


public class CalcTeclado extends JPanel {
	//classe de varaivei globais quando necessario/todos
	public GlobalVars gbl = new GlobalVars();

	private int largura;
	private int altura;
	
	//definir valores altura paineis
	private int painelativo = 50;
	private int painelcentro = 150;
	private int painelconversao = 0;
	
	public CalcTeclado(int largura, int altura)  {
		this.largura = largura;
		this.altura = altura;
		this.painelconversao = this.altura - this.painelativo - this.painelcentro;
		
		setBackground( gbl.CALC_COR_ESCURA);
        montaLayout(); 	
	}
	
	private void montaLayout() {
		// set tipo layout
		setLayout(new BorderLayout());

		// visor tipo calculo ativo com botao calcular e limpar
		CalcSet pativo = new CalcSet();
		pativo.setPreferredSize( new Dimension(largura, this.painelativo));
        this.add( pativo, BorderLayout.NORTH); 
		
		//visor valor original -- nome origem e digitar valor e mostrar
        // visro valor convertido -- nome comversar dibitar
		CalcDados pdados = new CalcDados();
		pdados.setPreferredSize( new Dimension(largura, this.painelcentro));
        this.add( pdados, BorderLayout.CENTER); 
		
		// visor selecao itebes de origem e destino
		// variar conforme tamanho
		CalcTpConversao pconversao = new CalcTpConversao();
		pconversao.setPreferredSize( new Dimension(largura, this.painelconversao));
        this.add( pconversao, BorderLayout.SOUTH); 
	
	}


}
