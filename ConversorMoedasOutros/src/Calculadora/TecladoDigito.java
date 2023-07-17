package Calculadora;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import CalcConversorLog.MemoriaCalculo;
import Conversor.GlobalVars;
import Metricas.Metricas;
import Moeda.Moedas;
import PadraoConversor.PadraoConversor;
import Pesos.Pesos;
import UIGeral.BotaoGeral;
import UISwing.appDadosSwing;
import UISwing.tabela;

public class TecladoDigito extends JPanel implements ActionListener {

	//classe de varaivei globais quando necessario/todos
	public GlobalVars gbl = new GlobalVars();
	
	// tirar
	private static final TecladoDigito instancia = new TecladoDigito();
    private PadraoConversor nobj;

	public TecladoDigito() {
        //TecladoDigito(null);
		montaTeclado(Color.BLUE);
    }

	public TecladoDigito(PadraoConversor nobj) {
        this.nobj = nobj;
		montaTeclado(Color.BLUE);
    }
	
	//tirar	
	public static TecladoDigito start() {
	    return instancia;	
	}
	
	
//	private void montaTeclado(Color cor) {

	public void montaTeclado(Color cor) {
		//System.out.println("teclado.....");
		JPanel teclado = new JPanel();
	    teclado.setBackground(cor);
	    
		//this.setBackground(Color.RED);
	    GridBagLayout  tecladoConversao = new GridBagLayout();
	    GridBagConstraints c = new GridBagConstraints();		
	    //teclado.setLayout( tecladoConversao);
	    setLayout( tecladoConversao);
    
	    c.weightx = 1;
	    c.weighty = 1;
	    c.fill = GridBagConstraints.BOTH;

	    // linha 1 
	    c.gridwidth = 1;
	    adcionaBtnTec( "AC", gbl.CALC_COR_CLARA, c, 0, 0);
	    c.gridwidth = 2;
	    adcionaBtnTec( "CALCULAR", gbl.COR_CONTRASTE, c, 1, 0);
	    
	    // LINHA 2
	    c.gridwidth = 1;
	    adcionaBtnTec( "7", gbl.CALC_COR_CLARA, c, 0, 1);
	    adcionaBtnTec( "8", gbl.CALC_COR_CLARA, c, 1, 1);
	    adcionaBtnTec( "9", gbl.CALC_COR_CLARA, c, 2, 1);
	    
	    // LINHA 3
	    adcionaBtnTec( "4", gbl.CALC_COR_CLARA, c, 0, 2);
	    adcionaBtnTec( "5", gbl.CALC_COR_CLARA, c, 1, 2);
	    adcionaBtnTec( "6", gbl.CALC_COR_CLARA, c, 2, 2);
	
	    // LINHA 4
	    adcionaBtnTec( "1", gbl.CALC_COR_CLARA, c, 0, 3);
	    adcionaBtnTec( "2", gbl.CALC_COR_CLARA, c, 1, 3);
	    adcionaBtnTec( "3", gbl.CALC_COR_CLARA, c, 2, 3);
	
	    // LINHA 5
	    c.gridwidth = 2;
	    adcionaBtnTec( "0", gbl.CALC_COR_CLARA, c, 0, 4);
	    c.gridwidth = 1;
	    adcionaBtnTec( ",", gbl.COR_CONTRASTE, c, 2, 4);
	
		this.add(teclado);
		
	}
	
	private void adcionaBtnTec(String txtTecla, Color cor, GridBagConstraints c, int x, int y) {
	    // adcionar botao
	    c.gridy= y;  // linha
	    c.gridx= x;  // coluna
	    BotaoGeral btn = new BotaoGeral( txtTecla, cor);
        btn.addActionListener(this);
	    add( btn, c);
    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource() instanceof BotaoGeral) {
			BotaoGeral botao = (BotaoGeral) e.getSource();
			String txtbotao = botao.getText();
            if( nobj == null) {
            	MemoriaCalculo.startMemo().processarComando(txtbotao);
            	System.out.println("sem objetos");
            }else {
            	MemoriaCalculo.startMemo().processarComando(txtbotao, nobj);
            }
			
			
		}
  	}	



}
