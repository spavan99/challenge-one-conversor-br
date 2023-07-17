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
import Moeda.Moedas;
import PadraoConversor.PadraoConversor;
import UIConsole.ImputDados;

public class DadosPanel extends JPanel{

	//classe de varaivei globais quando necessario/todos
	public GlobalVars gbl = new GlobalVars(); 
	
	//PadraoConversor dadosconverter = new Moedas();
	public PadraoConversor nobj; 

	JComboBox<String> origem = new JComboBox();
	JComboBox<String> destino = new JComboBox();
	
	//JTextField valor = new JTextField();
	//JTextField convertido = new JTextField();
	TextFieldSwing valor = new TextFieldSwing(16);
	TextFieldSwing convertido = new TextFieldSwing(16);

	//JLabel txtorigem = new JLabel(" Dados/Origem");
	LabelSwing txtorigem = new LabelSwing("Dados/Origem", 16, Font.BOLD);
	LabelSwing txtdestino = new LabelSwing("Convers�o", 16, Font.BOLD);
	LabelSwing txtvalor = new LabelSwing("Valor/Origem", 16, Font.BOLD);
	LabelSwing txtconvertido = new LabelSwing("Valor Convertido", 16, Font.BOLD);
	//Font fonte = new Font("Arial", Font.BOLD, 16);
	
	//JButton calcular = new JButton("Calcular");
	BotaoSwing calcular = new BotaoSwing("Calcular", gbl.COR_CONTRASTE, 18);

	// criar o layout a ser utilizado
	private GridBagLayout  layout = new GridBagLayout();
    private GridBagConstraints c = new GridBagConstraints();	

    // valor anterio
    String vrold = "";
    boolean invertercalculo = false;
    
    public DadosPanel(PadraoConversor nobj) {
        // adciona evento focus valor calculado
		convertido.addFocusListener(new FocusEventos());		
		// evento click        
		calcular.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e ) {
				setClassConversao();   
			}
		});

        // seta paramento do JPanel ativo
        this.setBackground(gbl.COR_CLARA);
        this.setForeground(gbl.COR_TXTWHITE);
		
		// classe moedas numero casas decimais
     	this.nobj = nobj;
		nobj.setnrCasasDecimal(4);
        
		// monta itens combobos
		selItensCombo(nobj);
        // colcoca o layout na pagina
		this.setLayout( layout);

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
        this.add(txtconvertido, c);
        c.gridx=1;
        c.gridwidth = 3;
        this.add(convertido, c);
        c.gridwidth = 1;

	}
	
	private void selItensCombo(PadraoConversor nobj) {
        //adciona todas destino 
        destino.addItem(">>>TODAS");
        int vezes = nobj._cotacaodados.size();
        // lista itens combobox
        List<String> nLista = nobj.getAllDisponiveis();
        for( int i = 0; i < vezes; i++) {
     		 origem.addItem(nobj._dados.get(i) );
	    	 destino.addItem(nobj._dados.get(i) );
         }
	}
	
	private void setClassConversao() {
        // calculo rotina padrao 
     	// pega moeda origem
     	String nori = String.valueOf(origem.getSelectedItem());
     	// pega moeda destino
     	String ndest = String.valueOf(destino.getSelectedItem());
		// valor digitado			
		String naux = valor.getText();
     	// inverter calculo estiver true reconfigura
		if( invertercalculo) {
        	// pega moeda origem --- pega destino
        	nori = String.valueOf(destino.getSelectedItem());
        	// pega moeda destino  -- pega origem
        	ndest = String.valueOf(origem.getSelectedItem());
            // colocar valor convetido no lugar do orinial             
        	naux = convertido.getText();
        	// set padrao inverter calcualo
     	}
		if( naux.isEmpty()) {
			JOptionPane.showMessageDialog(null, "VALOR de origme N�O pode ser ZERO!!! Tente novamente...");
        }else {
        	if( verSoNumeros(naux) ) {
        		// verifica se for todas carrega outra funcao
                if( ndest.contains(">>>TOD")) {
                    ListagemConversao();        	
                	return;
                }
        		//Double nvar = Double.parseDouble(valor.getText().replace("," , "."));
        		Double nvar = Double.parseDouble(naux.replace("," , "."));
        		// set valores na classe 
        		nobj.setDadosOrigem(nori);
        		nobj.setDadosDestino(ndest);
        		nobj.setvalorConverter( nvar);
        		// solicita classe o valores convetido
        		convertido.setText( nobj.dadosFormatadoConverter());
                // alimenta valores campos tela inversao
        		if( invertercalculo) {
        			String naux2 = new DecimalFormat("#,###.####").format(nobj.getValorFinal());
        			valor.setText(naux2);
        			convertido.setText(Double.toString(nobj.getValorConverter()));
        	   		invertercalculo = false;
        		}
        	
        	}else {
          		JOptionPane.showMessageDialog( null, "Dados Digitado Invalido tente novamente...");
        	}
        }
	}
	
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
	
    private void ListagemConversao() {
    	
    	// caracter quebra linhas
    	//  windows  ===> \r\n
    	//  UNIX, Linux ou Mac OSx = \n
    	// fazer um texte e ver sistema operaciol e colocar /// fazer depois
    	String kLin = "\r\n";

        // setar valores  possivel melhorar a logica ver depois;     	
   		nobj.setDadosOrigem(String.valueOf(origem.getSelectedItem()));
		String naux = valor.getText();
   		Double nvar = Double.parseDouble(naux.replace("," , "."));
   		nobj.setvalorConverter( nvar);
		
    	// pega listar conversoes
    	List<String> listaconversoes = nobj.getAllConversao(1);
    	
    	// tranforma a lista unida string
    	String dados = "Sistema:" + gbl.APP_NAME + kLin;
    	dados = dados + "---------------------------------------------------------------------------" + kLin;
    	dados =  dados + "Relatorio de Convers�es - TODOS" + kLin;
    	dados = dados + "---------------------------------------------------------------------------" + kLin + kLin;
        for( int i = 0; i < listaconversoes.size(); i++) {
        	dados = dados+ listaconversoes.get(i)+kLin;
        }
        // carrega tela monstra relatorio 
        RelTelaSwing.startRelatorio(dados);
    	
    }
    
    //--------------------  classes auxiliares
    // classe tratar a perda de focus
    class FocusEventos implements FocusListener{
    	public void focusGained(FocusEvent e) {
            // foco no objeto 
    		vrold = convertido.getText();
        }
        public void focusLost(FocusEvent e) {
            // perdeu o foco o ovjeto
        	String aux = convertido.getText(); 
        	if( ! aux.equals(vrold)) {
                invertercalculo = true;
        	}
            
        }
     }
    
        
  
    
}
