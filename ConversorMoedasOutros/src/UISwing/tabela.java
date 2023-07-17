// exemplo de tabela adptar para uso no aplicativo

package UISwing;

import java.awt.Container;
import java.awt.Dimension;
 
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
 
 
public class tabela
{
    // Declara componentes  
    JTable tabela;
     
    // Declara Array e Matriz
    String colunas[] =  { "Album", "Artista",  "Musica", "Ano", "VideoClip" };
     
    Object  dados [][] =        
    {           
        {"Nevermind", "Nirvana", "Smell Like Teen Spirit", new Integer(1991), new Boolean (true)},
        {"Ten", "Pearl Jam", "Jeremy", new Integer(1991), new Boolean (true)},
        {"Facelift", "Alice in Chains", "Man in the Box", new Integer(1990), new Boolean (true)},
        {"Badmotorfinger", "SoundGarden", "Outshined", new Integer(1991), new Boolean (true)},
        {"Sweet Oblivion", "Screaming Trees", "Nearly I Lost You", new Integer(1993), new Boolean (true)},
        {"Core", "Stone Temple Pilots", "Plush", new Integer(1992), new Boolean (true)},
             
    };
     
    
    public Container criaPainel()
    {
        // Cria painel
        JPanel painel = new JPanel();
         
        // Define Layout
        painel.setLayout(new BoxLayout(painel, BoxLayout.PAGE_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        painel.setOpaque(true);
         
        // Cria tabela
        tabela = new JTable(dados, colunas);        
         
        // Modifica ultima coluna
        JCheckBox box = new JCheckBox();
        TableColumn videoclip = tabela.getColumnModel().getColumn(4);
        videoclip.setCellEditor(new DefaultCellEditor(box));
         
        tabela.setPreferredScrollableViewportSize(new Dimension(600, 50));
         
         
        // Cria barra de rolagem
        JScrollPane barra = new JScrollPane(tabela);
             
        // Adiciona barra ao painel
        painel.add(barra);
         
        return painel;
         
    }
     
    public void criaGUI()
    {
        // Cria formulario
        JFrame formulario = new JFrame("DA - Tabela - JTable");
        //formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        // Instancia classe 
        tabela tab = new tabela();
        formulario.setContentPane(tab.criaPainel());
         
        formulario.setSize(500, 300);
        formulario.setVisible(true);
    }
 
 /*
    public static void main(String[] args) {
         
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
             
            @Override
            public void run() {
                 
                // Cria GUI
                criaGUI();
                 
            }
        });
 
    }
 */
    
}