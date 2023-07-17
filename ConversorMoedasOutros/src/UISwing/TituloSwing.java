package UISwing;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import Conversor.GlobalVars;

public class TituloSwing extends JPanel {

	//classe de varaivei globais quando necessario/todos
	public GlobalVars gbl = new GlobalVars(); 
	
    private String titulo = "";
    private JLabel label;
	private Color corfundo = gbl.COR_TITULO;
	private Color cortxt = gbl.COR_TXTWHITE;
	private Color corborda = null;
	private int tamfonte = gbl.TXT_SIZE;
	private String fonte = gbl.TXT_FONTE;
    private int txtstilus = Font.PLAIN;

    // precisar setar outro parametro cria contrutor altera o valor das varaiveis
	public TituloSwing(String pmsg, Color pcorfundo) {
         this.titulo = pmsg;
         this.corfundo = pcorfundo;
	     config();
	}

	public TituloSwing(String pmsg, int ptamfonte) {
        this.titulo = pmsg;
        this.tamfonte = ptamfonte;
	     config();
	}
	
	public TituloSwing(Color pcorborda, String pmsg ) {
		this.titulo = pmsg;
		this.corborda = pcorborda;
        config();	
	}

	public TituloSwing(String pmsg) {
		this.titulo = pmsg;
        config();	
	}
	
	private void config() {
		setLayout(new BorderLayout());
		setBorder( BorderFactory.createLineBorder(this.corborda));
		setBackground(this.corfundo);

		label = new JLabel( this.titulo);
    	label.setForeground(this.cortxt);
       	label.setFont( new Font( this.fonte, this.txtstilus, this.tamfonte ));     
        label.setVerticalAlignment(JLabel.CENTER); 
        label.setHorizontalAlignment(JLabel.CENTER); 
    
    	add(label);

	}

	
	
}
