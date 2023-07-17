package Calculadora;

import javax.swing.JFrame;

import Conversor.GlobalVars;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class StartCalc extends JFrame {

	//classe de varaivei globais quando necessario/todos
	public GlobalVars gbl = new GlobalVars(); 

	// controla instancia de abertura da classe
	public static StartCalc instance = null;
 
    public static StartCalc getInstance() {
        if (instance == null)
            instance = new StartCalc();
        return instance;
    }

	// contrutor
	private StartCalc() {
		startAPP();
	}
	
	private void startAPP() {
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	
		//ocultar a barra superios
		//this.setUndecorated(true);
		this.setSize(300,350);
		// centraliza tela para funcionar tem atribuir setSize antes		
		this.setLocationRelativeTo(null);
		this.setTitle( gbl.APP_NAME);
	    // possibilita aumentar e diminuir false --> fixa
	    this.setResizable(false);
	    
		montaLayout();		
        this.setVisible(true);

	}	
	
	
	private void montaLayout() {

		// set tipo layout
		setLayout(new BorderLayout());

		TituloCalc titulo = new TituloCalc(gbl.APP_NAME, 20);
		titulo.setPreferredSize( new Dimension(300, 50));
        this.add( titulo, BorderLayout.NORTH); 

		// criar dados
        MetodoCalc metodocalc = new MetodoCalc();
		metodocalc.setPreferredSize( new Dimension(300, 300));
        this.add( metodocalc, BorderLayout.CENTER); 

        // faz todos itens caibam na tela readequando maior ou memor
		// sempre usar no final de todos o laytou  // JFRAME
        this.pack();

        /*
		
     */
	}
}

