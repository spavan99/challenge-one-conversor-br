
package UICalcCoonversorSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import javax.swing.border.Border;

import Conversor.GlobalVars;
import UISwing.TituloSwing;
import UISwing.appMenuSwing;

public class CalcStart extends JFrame {
	
	//classe de varaivei globais quando necessario/todos
	public GlobalVars gbl = new GlobalVars(); 
	
	// contrutor
	public CalcStart() {
		startApp();
	}
	
	private void startApp() {

		System.out.println("calculadora conversor em contrucao");
	
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		//ocultar a barra superios
		this.setUndecorated(false);
		this.setLocationRelativeTo(null);
		//String ntit = GlobalVars.appTitulo;
		this.setTitle( gbl.APP_NAME);
	    this.setSize(720,500);
	    this.setResizable(false);
	    
	    //borda
	    //this.setBorder( BorderFactory.createLineBorder(Color.BLACK));
	    getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.RED));
	    //DropShadowBorder b = new DropShadowBorder(Color.BLACK, 0, 10, 0.2f, 10, true, true, true, true);
	    //this.getRootPane().setBorder(b);
    
	    montaLayout();		
        this.setVisible(true);

	}



	private void montaLayout() {

		// set tipo layout
		setLayout(new BorderLayout());

        //painel esquerda  teclado 
		CalcTeclado teclado = new CalcTeclado(550,500);
		teclado.setPreferredSize( new Dimension(550, 500));
        this.add( teclado, BorderLayout.WEST); 

		// painel direta conversore
        CalcConversores conversor = new CalcConversores();
		conversor.setPreferredSize( new Dimension(150, 500));
        this.add( conversor, BorderLayout.EAST); 
		
	}

	
}
