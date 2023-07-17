package UISwing;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;
import java.awt.Font;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Conversor.GlobalVars;
import IMC.IMC;
import Moeda.Moedas;
import PadraoConversor.PadraoConversor;
import UIConsole.ImputDados;

public class IMCPanel extends JPanel{

	//classe de varaivei globais quando necessario/todos
	public GlobalVars gbl = new GlobalVars(); 
	
	//PadraoConversor dadosconverter = new Moedas();
	public IMC nobj; 


	TextFieldSwing origem = new TextFieldSwing(16);
	TextFieldSwing destino = new TextFieldSwing(16);
	TextFieldSwing valor = new TextFieldSwing(16);
	TextFieldSwing analise = new TextFieldSwing(16);

	//JLabel txtorigem = new JLabel(" Dados/Origem");
	LabelSwing txtorigem = new LabelSwing("Altura em metros", 16, Font.BOLD);
	LabelSwing txtdestino = new LabelSwing("Peso em Kgs", 16, Font.BOLD);
	LabelSwing txtvalor = new LabelSwing("IMC", 16, Font.BOLD);
	LabelSwing txtanalise = new LabelSwing("Analise", 16, Font.BOLD);
	
	//JButton calcular = new JButton("Calcular");
	BotaoSwing calcular = new BotaoSwing("Calcular", gbl.COR_CONTRASTE, 18);

	// criar o layout a ser utilizado
	private GridBagLayout  layout = new GridBagLayout();
    private GridBagConstraints c = new GridBagConstraints();	

    public IMCPanel(IMC nobj) {

    	calcular.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e ) {
                System.out.println("calcualo a relizar");
                // pega peso e altura
                Double npeso = retDoubleValor(origem.getText());
                Double naltura = retDoubleValor(destino.getText());
                if( (npeso > 0.0) && (naltura )>0.0 ) {
                	nobj.setAltura(npeso);	
                	nobj.setPeso(naltura);
                	valor.setText(nobj.imcCalcularFormatado());
                    analise.setText(nobj.analiseIMC());                	
                }else {
    				JOptionPane.showMessageDialog(null, "Peso ou Altura invalidos");
                }
			}
		});

        // seta paramento do JPanel ativo
        this.setBackground(gbl.COR_CLARA);
        this.setForeground(gbl.COR_TXTWHITE);
		
		// classe moedas numero casas decimais
     	this.nobj = nobj;
//		nobj.setnrCasasDecimal(4);
        // colcoca o layout na pagina
		this.setLayout( layout);

		// setando alguns paramento dos campos
		valor.setEnabled(false);
		analise.setEnabled(false);;
		
		
		// tela cadastro
		telaCadastro();
	}
	
	private void telaCadastro() {
		// nao funcionou distancia interna elementos
		//c.ipadx = 25;
        //c.ipady = 55;
        
        c.weightx = 1;
        c.weighty = 1;
        // distancia entre elementos top, direita, rodape, esqueda
        c.insets = new Insets(3,2,3,2);
        c.fill = GridBagConstraints.BOTH;
        // 1 linha tela
        c.gridy=0;  // linha
        c.gridx=0;  // coluna
        c.gridwidth = 1;
        this.add(txtorigem, c);
        c.gridx=1;
        this.add(origem, c);
        c.gridx=2;
        this.add(txtdestino, c);
        c.gridx=3;        
        this.add(destino, c);
        // 2 linha da pela
        c.gridy=1;
        c.gridx=0;
        this.add(txtvalor, c);
        c.gridx=1;
        this.add(valor, c);
        c.gridx=2;
        c.gridwidth = 2;
        this.add(calcular, c);
        c.gridwidth = 1;
        //  3 linha da tela
        c.gridy=2;
        c.gridx=0;
       // c.gridwidth = 2;
        this.add(txtanalise, c);
        c.gridx=1;
        c.gridwidth = 3;
        this.add(analise, c);
        c.gridwidth = 1;

	}

    // valida somente e numeros
	private boolean verSoNumeros(String averificar) {
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
	
    // valida string se for possivel de converte converte ou retorna zero 
	private Double retDoubleValor( String nvalor) {
    	double nret = 0;
    	if( ! nvalor.isEmpty()) {
    		if( verSoNumeros( nvalor)) {
    			nret = Double.parseDouble(nvalor.replace("," , "."));
    		}else {
    			//se qur dar uma mensagel   		
    		}
    	}
    	return nret;
    }
    
}
