package Calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import CalcConversorLog.MemoriaCalculo;
import CalcConversorLog.MemoriaObservador;
import CalcConversorLog.SetupCalc;
import CalcConversorLog.SetupObservador;
import Conversor.GlobalVars;
import PadraoConversor.PadraoConversor;
import UIGeral.BotaoGeral;

public class DisplayInfo  extends JPanel implements SetupObservador, MemoriaObservador{
	
	private enum display{
		DISPLAY_ORIGEM, DISPLAY_DESTINO;
	}
	//classe de varaivei globais quando necessario/todos
	public GlobalVars gbl = new GlobalVars();

	// criar poder acessa
 	private JTextField valorOriginal = new JTextField(25);
 	private JTextField valorDestino = new JTextField(25);

    private JLabel txtTit;
    private JLabel txt1Conver;
    private JLabel txt2Conver;
    public display displayPosicao;
 	
	
	public DisplayInfo()  {
        // registra observadores que tem interese
		SetupCalc.startCalc().adionarObservador(this);
		MemoriaCalculo.startMemo().adionarObservador(this);
		
		
		setBackground(gbl.CALC_COR_ESCURA);
		//setBackground( gbl.CALC_COR_CLARA);
		montaLayout();
		
	}

	 // sobreescrever metodo do observador
	 // observador do dados
	  @Override
	   public void setupAlterado(int posicao, String setupTitulo, String dePara, PadraoConversor setupOBJ) {
          if( posicao == 0) {
        	  txt1Conver.setText(dePara);
          }else if(posicao == 1){
        	  txt2Conver.setText(dePara);
          }
	  };

      // observador do teclado  	  
	  @Override
	  public void valorAlterado(int acao, String novoValor, String valorCalculado) {
          valorOriginal.setText(novoValor);
          valorDestino.setText(valorCalculado);
		  /*
		  if( acao == 0) {
			  valorOriginal.setText(novoValor);
		  }else if (acao == 1) {
			  valorDestino.setText(novoValor);
		  }
		  */
	  }

    public void montaLayout() {
    	
		// set tipo layout
		setLayout( new GridLayout(1,2));
       // adciona botoes
		adcionaItensMenu( "Origem", "Selecione", gbl.CALC_COR_CLARA, display.DISPLAY_ORIGEM );
		adcionaItensMenu(  "Destino", "Selecione", gbl.CALC_COR_ESCURA, display.DISPLAY_DESTINO);
    }

    public void adcionaItensMenu(String msg, String dados, Color cor, display visor) {
    	
    	this.displayPosicao = visor;
 
        JPanel panel = new JPanel();
        panel.setBackground(cor);
        panel.setLayout(null);
       // panel.setLayout(new FlowLayout());
   
        // texto origem comfigurando
        txtTit = new JLabel();
        txtTit.setForeground(Color.WHITE);
        txtTit.setText(msg);
        txtTit.setFont( new Font(gbl.TXT_FONTE, gbl.TXT_STILUS, 20) );
        txtTit.setSize(200, 30);
        if( display.DISPLAY_ORIGEM == visor ) {
        	txtTit.setLocation(10, 3);
        }else {
        	//txtTit.setLocation(180, 3);
           	txtTit.setLocation(10, 3);
            
        }
    	panel.add(txtTit);
 
        if( display.DISPLAY_ORIGEM == visor ) {
        	txt1Conver = new JLabel();
        	txt1Conver.setForeground(Color.WHITE);
            txt1Conver.setText(dados);
            txt1Conver.setFont( new Font(gbl.TXT_FONTE, gbl.TXT_STILUS, 20) );
            txt1Conver.setSize(200, 30);
           	//txt1Conver.setLocation( 180, 30);
         	txt1Conver.setLocation( 30, 30);
           	panel.add(txt1Conver);
        }else {
        	txt2Conver = new JLabel();
            txt2Conver.setForeground(Color.WHITE);
            txt2Conver.setText(dados);
            txt2Conver.setFont( new Font(gbl.TXT_FONTE, gbl.TXT_STILUS, 20) );
            txt2Conver.setSize(200, 30);
           	txt2Conver.setLocation( 30, 30);
            panel.add(txt2Conver);
        }
 
    	/*
    	txtConver = new JLabel();
        txtConver.setForeground(Color.WHITE);
        txtConver.setText(dados);
        txtConver.setFont( new Font(gbl.TXT_FONTE, gbl.TXT_STILUS, 20) );
        txtConver.setSize(200, 30);
        if( display.DISPLAY_ORIGEM == visor ) {
        	txtConver.setLocation( 180, 30);
        }else {
        	txtConver.setLocation( 30, 30);
        }
        panel.add(txtConver);
        */

        if( visor == display.DISPLAY_ORIGEM) {
           	valorOriginal.setText(MemoriaCalculo.startMemo().getTXTvrOrigem());
         	valorOriginal.setFont( new Font(gbl.TXT_FONTE, gbl.TXT_STILUS, 25) );
         	valorOriginal.setEditable(false);
         	valorOriginal.setSize(200, 30);
        	valorOriginal.setLocation(35, 65);
        	valorOriginal.setHorizontalAlignment(JTextField.RIGHT);
        	valorOriginal.setText(MemoriaCalculo.startMemo().getTXTvrOrigem());
        	panel.add(valorOriginal);
        }else {
        	//tenha muda setText  --- nao tenha ser atulizado memoriacalculo e sim setuocacl ver
           	valorDestino.setText(MemoriaCalculo.startMemo().getTXTvrOrigem());
           	valorDestino.setFont( new Font(gbl.TXT_FONTE, gbl.TXT_STILUS, 25) );
         	valorDestino.setEditable(false);
         	valorDestino.setSize(200, 30);
        	valorDestino.setLocation(35, 65);
        	valorDestino.setHorizontalAlignment(JTextField.RIGHT);
        	valorDestino.setText(MemoriaCalculo.startMemo().getTXTvrDestino());
        	panel.add(valorDestino);
        }
      	this.add(panel);

    }


}





