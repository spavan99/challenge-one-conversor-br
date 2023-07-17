package UICalcCoonversorSwing;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import CalcConversorLog.MemoriaCalculo;
import CalcConversorLog.SetupCalc;
import Conversor.GlobalVars;
import IMC.IMC;
import Metricas.Metricas;
import Moeda.Moedas;
import Pesos.Pesos;
import UIGeral.BotaoGeral;
import UISwing.appDadosSwing;
import UISwing.tabela;

public class CalcConversores extends JPanel implements ActionListener {
	//classe de varaivei globais quando necessario/todos
	public GlobalVars gbl = new GlobalVars();

	public CalcConversores()  {
		setBackground( gbl.CALC_COR_ESCURA);
		
		//cria botoes conversore
		setLayout( new GridLayout(5,1));
        // adciona botoes
		adcionaItensMenu( "Exit", gbl.CALC_COR_CONT1MAIS);
		adcionaItensMenu( "Moedas", gbl.CALC_COR_CONT1);
		adcionaItensMenu( "IMC", gbl.CALC_COR_CONT1);
		adcionaItensMenu( "Medidas", gbl.CALC_COR_CONT1);
		adcionaItensMenu( "Pesos", gbl.CALC_COR_CONT1);
		
	}

    public void adcionaItensMenu(String msg, Color cor) {
    	BotaoGeral botao = new BotaoGeral( msg, cor, 15);
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
                Moedas moeda = new Moedas();
				SetupCalc.startCalc().processarComando(3, "MOEDAS", "MOEDAS", moeda); 
				//MemoriaCalculo.startMemo().processarComando(txtbotao);

               // cmoedas = new Moedas(); 
				//appDadosSwing moedas = new appDadosSwing( cmoedas, "Conversor de Moedas" );
			}else if( txtbotao.contains("MEDIDA")) {
                Metricas metrica =  new Metricas();
				SetupCalc.startCalc().processarComando(3, "MEDIDAS", "MEDIDAS", metrica); 
			}else if( txtbotao.contains("PESO")) {
                Pesos peso = new Pesos();
				SetupCalc.startCalc().processarComando(3, "PESOS", "PESOS", peso); 
			}else if( txtbotao.contains("IMC")) {
				IMC imc = new IMC();
                //SetupCalc.startCalc().processarComando("IMC", imc); 
			}else {
				//JOptionPane.showMessageDialog(null, ">>>>>>>  Sair..");
				System.exit(0);
			}
		}
	}
}

