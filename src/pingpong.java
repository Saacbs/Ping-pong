import javax.swing.SwingUtilities;

public class pingpong {
    public static void main(String[] args){
        
        SwingUtilities.invokeLater(() -> {
            
            new TelaNomeJogadores(); 
        });
    }
}