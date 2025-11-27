import javax.swing.*;
import java.awt.*;


public class TelaNomeJogadores extends JFrame {
    private JTextField txtPlayer1;
    private JTextField txtPlayer2;
    private JButton btnStart;

    public TelaNomeJogadores() {
        super("PingPong - Nomes dos Jogadores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(8, 8, 8, 8);
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        add(new JLabel("Nome do Player 1 (W / S):"), c);
        c.gridx = 1;
        txtPlayer1 = new JTextField("Player 1", 12);
        add(txtPlayer1, c);

        c.gridx = 0;
        c.gridy = 1;
        add(new JLabel("Nome do Player 2 (Setas):"), c);
        c.gridx = 1;
        txtPlayer2 = new JTextField("Player 2", 12);
        add(txtPlayer2, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        btnStart = new JButton("Começar Jogo");
        add(btnStart, c);

        btnStart.addActionListener(e -> {
            String n1 = txtPlayer1.getText().trim();
            String n2 = txtPlayer2.getText().trim();
            
            if (n1.isEmpty() || n2.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha os dois nomes.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            
            new JanelaDoJogo(n1, n2);
            this.dispose(); 
        });

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        
        setVisible(true); 
    }
}