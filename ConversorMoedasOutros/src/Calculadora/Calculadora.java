package Calculadora;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JFrame;
import Conversor.GlobalVars;
import PadraoConversor.PadraoConversor;

public class Calculadora extends JFrame {

	//classe de varaivei globais quando necessario/todos
	public GlobalVars gbl = new GlobalVars(); 
    private String ntitulo = gbl.APP_NAME;
    private PadraoConversor nobj;
    //////////////////////////////////////////////////////////////////////
	/*  desabilitado ver necessario usar
	// controla instancia de abertura da classe
	//public static Calculadora instance = null;
	public static Calculadora instance = null;

	//  pegear a clasee criano nova intacia nobj 
	
    public static Calculadora getInstance() {
        if (instance == null) {
        	instance = new Calculadora();
        }
        return instance;
    }
    
    // contrutor
	private Calculadora() {
		startAPP();
	}
    *//////////////////////////////////////////

	public Calculadora(String titulo, PadraoConversor nobj) {
        this.ntitulo = titulo;
		this.nobj = nobj;
		startAPP();
	}
    
    
    public Calculadora(PadraoConversor nobj) {
        this.nobj = nobj;
		startAPP();
	}

    
    public Calculadora(String titulo) {
        this.ntitulo = titulo;
		startAPP();
	}
	// contrutor
	public Calculadora() {
		startAPP();
	}
	
	private void startAPP() {
		// volta tela anterior sem item abaixo
		//this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		//ocultar a barra superios
		//this.setUndecorated(true);
		this.setSize(550,500);
		// centraliza tela para funcionar tem atribuir setSize antes		
		this.setLocationRelativeTo(null);
		this.setTitle( this.ntitulo);
	    // possibilita aumentar e diminuir false --> fixa
	    this.setResizable(false);
		montaLayout();		
        this.setVisible(true);

	}	
	
	private void montaLayout() {

		// set tipo layout
		setLayout(new BorderLayout());

		// display titulo superio
		DisplayTitulo displaytit = new DisplayTitulo(this.ntitulo, this.nobj);
		displaytit.setPreferredSize( new Dimension(550, 50));
        this.add( displaytit, BorderLayout.NORTH); 

        //visor valor original -- nome origem e digitar valor e mostrar
        // visro valor convertido -- nome comversar dibitar
		DisplayInfo displayinfo = new DisplayInfo();
		displayinfo.setPreferredSize( new Dimension(550, 110));
        this.add( displayinfo, BorderLayout.CENTER); 
		
		// visor selecao itebes de origem e destino
		// variar conforme tamanho
		TecladoSelecao tecladoselecao = new TecladoSelecao(this.nobj);
		tecladoselecao.setPreferredSize( new Dimension(550, 340));
        this.add( tecladoselecao, BorderLayout.SOUTH); 
        // ajustar tela
        this.pack();

        
	}
}

