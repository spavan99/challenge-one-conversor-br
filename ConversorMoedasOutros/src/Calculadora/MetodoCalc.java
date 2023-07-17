package Calculadora;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import CalcConversorLog.SetupCalc;
import Conversor.GlobalVars;
import IMC.IMC;
import Moeda.Moedas;
import Metricas.Metricas;
import PadraoConversor.PadraoConversor;
import Pesos.Pesos;
import UIGeral.BotaoGeral;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import java.awt.GridLayout;



public class MetodoCalc extends JPanel implements ActionListener{

	//classe de varaivei globais quando necessario/todos
	public GlobalVars gbl = new GlobalVars();
	
    // crio instancia das classses
	private Moedas cmoedas;	
    private Metricas cmetrica; 
    private Pesos cpeso;
	private IMC cimc;
	
	//ActionListener
	public MetodoCalc() {
		//setBackground(Color.RED);
		
		// cria botoes para acessar menu
		setLayout( new GridLayout(2,2));
        // adciona botoes
		adcionaItensMenu( "Moedas", gbl.CALC_COR_CLARA);
		adcionaItensMenu( "Exit", gbl.CALC_COR_CONT2);
		adcionaItensMenu( "Medidas", gbl.CALC_COR_CLARA);
		adcionaItensMenu( "Pesos", gbl.CALC_COR_CLARA);
		
	}
		
    public void adcionaItensMenu(String msg, Color cor) {
    	BotaoGeral botao = new BotaoGeral( msg, cor, 25);
        //botao.setTamFonte(25);
        botao.addActionListener(this);
    	this.add(botao);
    	
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource() instanceof JButton) {
			JButton botao = (JButton) e.getSource();
			
			String txtbotao = botao.getText().toUpperCase();
			if( txtbotao.contains("MOEDA")){
  				Moedas moeda = new Moedas(true);
  				
				Calculadora calc = new Calculadora( "Moedas", moeda);
			}else if( txtbotao.contains("MEDIDA")) {
				Metricas metrica = new Metricas();
				Calculadora calc = new Calculadora( "Medidas",  metrica);
			}else if( txtbotao.contains("PESO")) {
				Pesos peso = new Pesos();
				Calculadora calc = new Calculadora( "Pesos",  peso);
			}else if( txtbotao.contains("EXIT")) {
				// utilizado no futuro para atualizar taxa moeda na internet
				JOptionPane.showMessageDialog(null, "Uma pena que j� vai embora....");
                System.exit(0);
			}else {
				JOptionPane.showMessageDialog(null, ">>>>>>>  Sele�ao Invalida..botao..");
			}
			
		}
	}
	

}
