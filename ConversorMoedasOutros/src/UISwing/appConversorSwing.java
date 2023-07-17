package UISwing;

import javax.swing.JFrame;

import Conversor.GlobalVars;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;

//import java.awt.*;
//import javax.swing.*;

public class appConversorSwing extends JFrame {

	//classe de varaivei globais quando necessario/todos
	public GlobalVars gbl = new GlobalVars(); 
	
	// contrutor
	public appConversorSwing() {
		startApp();
	}
	
	private void startApp() {
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		//ocultar a barra superios
		//this.setUndecorated(true);
	    this.setSize(300,350);
		this.setLocationRelativeTo(null);
		//String ntit = GlobalVars.appTitulo;
		this.setTitle( gbl.APP_NAME);
	    this.setResizable(false);
		
	    montaLayout();		
        this.setVisible(true);

		//Painel meuPainel = new Painel();
	    //janela.add(meuPainel);

	}	
	
	
	private void montaLayout() {

		// set tipo layout
		setLayout(new BorderLayout());

		TituloSwing titulo = new TituloSwing(gbl.APP_NAME, 20);
		titulo.setPreferredSize( new Dimension(300, 50));
        this.add( titulo, BorderLayout.NORTH); 

		// criar dados
        appMenuSwing menu = new appMenuSwing();
		menu.setPreferredSize( new Dimension(300, 300));
        this.add( menu, BorderLayout.CENTER); 
		
	}
}

