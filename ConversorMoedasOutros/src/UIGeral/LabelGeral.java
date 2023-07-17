package UIGeral;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import Conversor.GlobalVars;

public class LabelGeral extends JLabel {

	//classe de varaivei globais quando necessario/todos
	public GlobalVars gbl = new GlobalVars(); 

	private String padmsg = "";
//	private Color corfundo = gbl.COR_CLARA;
	private Color corfundo = null;
	private Color cortxt = gbl.COR_TXTWHITE;
	private int tamfonte = gbl.TXT_SIZE;
	private String fonte = gbl.TXT_FONTE;
    private Color corborda = null;
    private int txtstilus = Font.PLAIN;
    
    // criar contrutores comforme seta paramentos --- pensar outro modo
    public LabelGeral() {
		   config();
	}	

	public LabelGeral( String pmsg) {
		this.padmsg = pmsg;   
		config();
	}	

	public LabelGeral(String pmsg, Color pcorfundo) {
 		this.padmsg = pmsg;
 		this.corfundo = pcorfundo;
 		config();
	}

	public LabelGeral(Color pcortxt, String pmsg) {
 		this.padmsg = pmsg;
 		this.cortxt = pcortxt;
 		config();
	}

	public LabelGeral(String pmsg, int ptamfonte) {
 		this.padmsg = pmsg;
 		this.tamfonte = ptamfonte;
 		config();
	}

	public LabelGeral(String pmsg, int ptamfonte, int ptxtstilus) {
 		this.padmsg = pmsg;
 		this.tamfonte = ptamfonte;
 		this.txtstilus = ptxtstilus;
 		config();
	}

	public LabelGeral( int ptamfonte) {
 		this.tamfonte = ptamfonte;
 		config();
	}

	public LabelGeral(String pmsg, Color pcorfundo, int ptamfonte) {
 		this.padmsg = pmsg;
 		this.corfundo = pcorfundo;
 		this.tamfonte = ptamfonte;
 		config();
	}

	
	
	// metodo
	private void config() {
		 this.setText(this.padmsg);
	     this.setFont( new Font( this.fonte, this.txtstilus, this.tamfonte ));     
	     this.setOpaque(true);
    	 this.setBackground(this.corfundo);
	     this.setForeground( this.cortxt);
		 if( this.corborda != null) {
		     this.setBorder( BorderFactory.createLineBorder(this.corborda));
		 }
	}

	
}
