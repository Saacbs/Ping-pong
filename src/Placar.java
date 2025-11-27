
import java.awt.*;
public class Placar {
    static int LARGURA_JOGO;
    static int ALTURA_JOGO;
    int jogador1;
    int jogador2;
    
    private String nomeJogador1;
    private String nomeJogador2;
    
    private Font fonte;
    private Font fonteNome; 

    
    public Placar(int larguraJogo, int alturaJogo, Font fonte, String nome1, String nome2){
        Placar.LARGURA_JOGO = larguraJogo;
        Placar.ALTURA_JOGO = alturaJogo;
        jogador1 = 0;
        jogador2 = 0;
        this.fonte = fonte;
        this.nomeJogador1 = nome1;
        this.nomeJogador2 = nome2;
        
        this.fonteNome = fonte.deriveFont(Font.BOLD, 20f); 
    }

    public void desenhar(Graphics g){
        g.setColor(Color.white);
        
       
        g.drawLine(LARGURA_JOGO/2,0,LARGURA_JOGO/2,ALTURA_JOGO);
        
       
        g.setFont(fonteNome);
        
       
        int larguraNome1 = g.getFontMetrics().stringWidth(nomeJogador1);
        g.drawString(nomeJogador1, (LARGURA_JOGO/4) - (larguraNome1/2), 30);
        
        
        int larguraNome2 = g.getFontMetrics().stringWidth(nomeJogador2);
        g.drawString(nomeJogador2, (LARGURA_JOGO*3/4) - (larguraNome2/2), 30);
        
        
        g.setFont(fonte);
       
        g.drawString(String.valueOf(jogador1),(LARGURA_JOGO/2)-85,80); 
        g.drawString(String.valueOf(jogador2),(LARGURA_JOGO/2)+55,80);
    }
}