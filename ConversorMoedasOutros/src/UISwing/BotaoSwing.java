package UISwing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import Conversor.GlobalVars;
		
		
public class BotaoSwing extends JButton {
	
	//classe de varaivei globais quando necessario/todos
	public GlobalVars gbl = new GlobalVars(); 

	private String padmsg = "";
	private Color corfundo = gbl.COR_CLARA;
	private Color cortxt = gbl.COR_TXTWHITE;
	private int tamfonte = gbl.TXT_SIZE;
	private String fonte = gbl.TXT_FONTE;
	
	public BotaoSwing(String msg, Color corfundo, Color cortxt, int tamfonte, String fonte) {
           this.padmsg = msg == null ? this.padmsg : msg;
           this.corfundo =  corfundo == null ? this.corfundo : corfundo;
           this.cortxt =  cortxt == null ? this.cortxt : cortxt;
           this.tamfonte = tamfonte == 0 ? this.tamfonte : tamfonte;
           this.fonte = fonte == null ? this.fonte : fonte;
           config();		
	}
	
	public BotaoSwing(String pmsg, Color pcorfundo) {
 		this.padmsg = pmsg;
 		this.corfundo = pcorfundo;
 		config();
	}	

	public BotaoSwing(String pmsg, Color pcorfundo, int tamfonte) {
 		this.padmsg = pmsg;
 		this.corfundo = pcorfundo;
 		this.tamfonte = tamfonte;
 		config();
	}
	public BotaoSwing(String pmsg) {
        //this( pmsg, corfundo, cortxt, tamfonte, fonte);
		// chamar  o contrutor principal
		this.padmsg = pmsg;
        config();
	}	

	public BotaoSwing() {
       // this( padmsg, corfundo, cortxt, tamfonte, fonte);
	   config();
	}	

	// metodo
	private void config() {
		 this.setText(padmsg);
	     this.setFont( new Font( fonte, Font.PLAIN, tamfonte ));     
		 this.setOpaque(true);
		 if( corfundo != null ) {
    		 this.setBackground(corfundo);
         }
         this.setForeground( cortxt);
		 this.setBorder( BorderFactory.createLineBorder(Color.BLACK));
	}

	// set os paramentro
	public void setCorFundo(Color npar) {
       	this.corfundo = npar;	
	}

	public void setTamFonte(int  npar) {
       	this.tamfonte = npar;	
	}
	
	
	
}
