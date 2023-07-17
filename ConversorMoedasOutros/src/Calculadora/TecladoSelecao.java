package Calculadora;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

import CalcConversorLog.MemoriaCalculo;
import CalcConversorLog.SetupCalc;
import CalcConversorLog.SetupObservador;
import Conversor.GlobalVars;
import Moeda.Moedas;
import PadraoConversor.PadraoConversor;
import Pesos.Pesos;
import UIGeral.BotaoGeral;

//public class TecladoSelecao extends JPanel implements ActionListener, SetupObservador{

public class TecladoSelecao extends JPanel implements ActionListener{

	//classe de varaivei globais quando necessario/todos 
	public GlobalVars gbl = new GlobalVars();

    private static boolean setOrigem = true;
	private PadraoConversor nobj;
    private List<String> ndadosConversao;
    
	public TecladoSelecao(PadraoConversor nobj)  {
        setBackground( gbl.CALC_COR_ESCURA);
        //SetupCalc.startCalc().adionarObservador(this);

        System.out.println(nobj.getClass());
        
		// classe inciada soomente teste receber 
		this.nobj = nobj;
        // monta a lista dados calculadora
		ndadosConversao = this.nobj._dados;
        // monta o layout da secao		
		montaLayout();
	}

/*	
	@Override
	 public void setupAlterado(String setupTitulo, PadraoConversor setupOBJ) {
	     this.nobj = setupOBJ;  
	     System.out.println("avaisado" + setupTitulo);
	  };

*/
	
	public void montaLayout() {
    	
		setLayout( new GridLayout());
        
		//---------------------------------alterar disposi�ao op�oes de conversao
		// selecao layout manual
		//SelecaoItensMANUAL(Color.BLUE);
		// selecao layout flow
		//SelecaoItensAUTO(Color.BLUE);
		// selecao layout grid   <<<<<<<< ficou melhor
		SelecaoItensGRID(gbl.CALC_COR_ESCURA);
        //---------------------------------------------------------------fim bloco
		
		
        // adicona teclado
        TecladoDigito digitar = new TecladoDigito(nobj);
        this.add(digitar);
        
    }


	//------------------------------------------------- 3 rotinas para sele�ao das convers�es
	///////  layout manual
	private void SelecaoItensMANUAL(Color cor) {

		 // pegar list com os conversores 
		JPanel panelconver = new JPanel();
		panelconver.setBackground(cor);
         // manual
		panelconver.setLayout(null);
	
	    JLabel opcaoconversao = new JLabel();
	    int inicial = 30; 
	    opcaoconversao.setForeground(Color.WHITE);
	    opcaoconversao.setText("Convers�o   DE:  >>>  PARA:");
	    opcaoconversao.setFont( new Font(gbl.TXT_FONTE, gbl.TXT_STILUS, 12) );
	    opcaoconversao.setSize(200, inicial);
	    opcaoconversao.setLocation(10, 5);
	  	panelconver.add(opcaoconversao);
	    
	    int ilin = 0;
	    int icol = 0;
	    for( int i = 0; i < ndadosConversao.size(); i++) {
	        icol = (i % 2 == 0) ? 20 : 150;
	    	BotaoGeral nbtn = new BotaoGeral( ndadosConversao.get(i), Color.GREEN);
	        nbtn.setSize(100, 40);
	        nbtn.setLocation(icol, ((ilin * 40) + 8) + inicial );
	        nbtn.addActionListener(this);
	        panelconver.add(nbtn);  
	        ilin =  icol == 150 ? ilin + 1 : ilin;
	    }
	 
	    this.add(panelconver);
   
   }

    ///////  layout automatico com flowlayto
	private void SelecaoItensAUTO(Color cor) {

		 // pegar list com os conversores 
		JPanel panelconver = new JPanel();
		panelconver.setBackground(cor);
		//nlayout = new FlowLayout(FlowLayout.CENTER, 20, 20)
		panelconver.setLayout( new FlowLayout(FlowLayout.CENTER, 20, 10));
	
	    JLabel opcaoconversao = new JLabel();
	    int inicial = 30; 
	    opcaoconversao.setForeground(Color.WHITE);
	    opcaoconversao.setText("Convers�o   DE:  >>>  PARA:");
	    opcaoconversao.setFont( new Font(gbl.TXT_FONTE, gbl.TXT_STILUS, 18) );
	    opcaoconversao.setSize(300, inicial);
	    //opcaoconversao.setLocation(10, 5);
	  	panelconver.add(opcaoconversao);
	    
	    int ilin = 0;
	    int icol = 0;
	    for( int i = 0; i < ndadosConversao.size(); i++) {
	        icol = (i % 2 == 0) ? 20 : 150;
 	    
	        JButton nbtn = new JButton( ndadosConversao.get(i));
	        //BotaoGeral nbtn = new BotaoGeral( ndadosConversao.get(i), Color.RED);
        
	        //nbtn.setSize(100, 50);
		    nbtn.setFont( new Font(gbl.TXT_FONTE, gbl.TXT_STILUS, 12) );
	        nbtn.setSize(70, 50);
	        //nbtn.setLocation(icol, ((ilin * 50) + 8) + inicial );
	        nbtn.addActionListener(this);
	        panelconver.add(nbtn);  
	        ilin =  icol == 150 ? ilin + 1 : ilin;
	    }
 
	    this.add(panelconver);
    
    }

    ///////  layout automatico com Grid
	private void SelecaoItensGRID(Color cor) {

		 // pegar list com os conversores 
		JPanel panelconver = new JPanel();
		panelconver.setBackground(cor);
		//nlayout = new gridlayou  3 colunas maximo 10 linhas
		int nlin = (ndadosConversao.size() / 3)+1;
		panelconver.setLayout( new GridLayout(nlin,3, 3, 3));
	    
	    for( int i = 0; i < ndadosConversao.size(); i++) {
	        BotaoGeral nbtn = new BotaoGeral( ndadosConversao.get(i), gbl.CALC_COR_CONT3);
		    nbtn.setFont( new Font(gbl.TXT_FONTE, gbl.TXT_STILUS, 12) );
	        nbtn.addActionListener(this);
		    panelconver.add(nbtn);  
	    }
	    this.add(panelconver);
    
    }
	//-------------------------------------------------firm da 3 rotinas

	
   // -- pega as rotinas selecionadas	
	@Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource() instanceof JButton) {
			JButton botao = (JButton) e.getSource();
			String txtbotao = botao.getText().toUpperCase();
			
            if( setOrigem ) {
            	setOrigem = false;
            	// set variaveis para calculo  // poderia 
    			SetupCalc.startCalc().processarComando(0, "", txtbotao, nobj);
            }else {
            	setOrigem = true;
               	// set variaveis para calculo
    			SetupCalc.startCalc().processarComando(1, "", txtbotao, nobj);
            }
		}
	}
	
       

	
	
	
	
	
    
}
