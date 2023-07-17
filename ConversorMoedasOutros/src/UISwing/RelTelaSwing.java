
//--------------------------------------------------
//
//fazer
//   resolver o problema fun�ao retorna list<string>    jtable necessita
//   de objet [][]
//
//
///---------------------------------------------------------

package UISwing;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

import Conversor.GlobalVars;
import PadraoConversor.PadraoConversor;
 

public class RelTelaSwing {

//    JLabel rotulo;
    private JTextArea area;
//    private String conteudo = "";  
   
    
    //incia a classer
    public static void startRelatorio( String dados){
    	// Cria formulario
        JFrame formulario = new JFrame("Relatorio");
        //formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formulario.setSize(600,500);       
		formulario.setLocationRelativeTo(null);
 
        // Cria nova instancia da classe
        RelTelaSwing texto = new RelTelaSwing();
        // adiciona painel ao formulario
        formulario.setContentPane(texto.CriaPainel(dados));
                 
        // Compacta componetes no formulario e mostra
        // formulario.pack();
        formulario.setVisible(true);
    }
    
    // Cria painel
    public Container CriaPainel(String conteudo) {
 
    	area = new JTextArea(conteudo);
        //area.setFont(new Font("Serif", Font.BOLD, 12));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setEditable(false);
         
        // Cria barra de rolagem e adiciona a area de texto
        JScrollPane scrooll = new JScrollPane(area);
         
        // Adiciona valores as propriedades da barra de rolagem
        // Barra vertical
        scrooll.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        // Tamanho da barra
        scrooll.setPreferredSize(new Dimension(150, 150));
         
        // Borda com titulo
        scrooll.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder(">>> CONVERS�ES."),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                                scrooll.getBorder()));
         
         
        // Cria o painel
        JPanel painel = new  JPanel();
 
        // Cria um layout para os componentes
        painel.setLayout(new BoxLayout(painel,BoxLayout.PAGE_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
         
        // Alinha componentes
        area.setAlignmentX(Component.CENTER_ALIGNMENT);
         
        // Adiciona a barra de rolagem pois a area de texto
        // est� j� foi adiciona dentro dela logo acima.
        painel.add(scrooll);
        painel.add(Box.createVerticalStrut(5));
                     
        // Retorna o painel
        return painel;
    }   
	
}	

 