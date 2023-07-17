package Calculadora;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CalcConversorLog.MemoriaCalculo;
import CalcConversorLog.SetupCalc;
import CalcConversorLog.SetupObservador;
import Conversor.GlobalVars;
import PadraoConversor.PadraoConversor;
import UIGeral.BotaoGeral;
import UIGeral.LabelGeral;

public class DisplayTitulo extends JPanel implements ActionListener, SetupObservador {
	
	//classe de varaivei globais quando necessario/todos
	public GlobalVars gbl = new GlobalVars();

	private String tituloativo = ".";
// 	private JLabel setConversorTXT = new  JLabel();
 	private LabelGeral setConversorTXT = new  LabelGeral();
 	
 	private PadraoConversor nobj;

 	// botao de calcular
 	private BotaoGeral btnCalcular;
    // botao de clear
 	private BotaoGeral btnClear;

	public DisplayTitulo(String titulo, PadraoConversor setupOBJ)  {
         this.tituloativo = titulo;
         this.nobj = setupOBJ;
		// adiconar obsevador
        SetupCalc.startCalc().adionarObservador(this);
		this.setBackground( gbl.COR_TITULO);
		montaLayout();
	}

   // sobrescrever a rotina observador para este programa  
   @Override
   public void setupAlterado(int posicao, String setupTitulo, String dePara, PadraoConversor setupOBJ) {
  	   // nao precisa deste observador tirar depois
	   // setConversorTXT.setText(setupTitulo);
   
   };
	

   public void CalcSetTitulo( String titulo) {
		this.tituloativo =titulo;
	}
	
    public void montaLayout() {

    	setLayout(null);
    	//FlowLayout layout = new FlowLayout(); // cria FlowLayout
        //setLayout( layout ); // configura o layout de frame
    	
        // titulo conversos setado
    	setConversorTXT.setForeground(gbl.COR_TXTWHITE);
    	setConversorTXT.setText("Converter: "+ this.tituloativo.toUpperCase());
    	setConversorTXT.setSize(300, 30);
    	setConversorTXT.setLocation(10, 3);
    	setConversorTXT.setFont( new Font(gbl.TXT_FONTE, gbl.TXT_STILUS, 23) );
    	this.add(setConversorTXT);
    	//nTitulo.setTitle(this.tituloativo);
    	
        // botal de ac/clleat
        btnClear = new BotaoGeral( "AC", gbl.CALC_COR_CONT1);
        btnClear.setSize( 55, 35);
        btnClear.setLocation(327, 5);
        btnClear.addActionListener(this);
        this.add(btnClear);
     	
    	// botal de caluclar
        btnCalcular = new BotaoGeral( "Calcular", gbl.CALC_COR_CONT1);
        btnCalcular.setSize( 130, 35);
        btnCalcular.setLocation(385, 5);
        btnCalcular.addActionListener(this);
        this.add(btnCalcular);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
        //botao clear		
        if( e.getSource() == btnClear){
        	MemoriaCalculo.startMemo().processarComando("AC", this.nobj);
        }
	       
        //botao calcular		
        if( e.getSource() == btnCalcular){
          	MemoriaCalculo.startMemo().processarComando("CALCULAR", this.nobj);
        }
	
	}
    
}