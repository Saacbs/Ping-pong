import javax.swing.*;

public class JanelaDoJogo extends JFrame {
    PainelDoJogo painel;
    
    public JanelaDoJogo(String nome1, String nome2){ 
       
        painel = new PainelDoJogo(nome1, nome2); 
        this.add(painel);
        this.setTitle("Ping Pong");
        this.setResizable(false);
        this.setBackground(java.awt.Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}