import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PainelDoJogo extends JPanel implements Runnable {
    static final int LARGURA_JOGO = 1000;
    static final int ALTURA_JOGO = (int)(LARGURA_JOGO* (0.555));
    static final Dimension TAMANHO_TELA = new Dimension(LARGURA_JOGO, ALTURA_JOGO);

    Thread threadDoJogo;
    Image imagem;
    Graphics graficos;
    Raquete raquete1, raquete2;
    Bola bola;
    private Image imagemFundo;
    Placar placar;
    
    private String nomeP1, nomeP2; 

    
    public PainelDoJogo(String nomeP1, String nomeP2){
        this.nomeP1 = nomeP1; 
        this.nomeP2 = nomeP2; 

        this.setFocusable(true);
        this.addKeyListener(new AdaptadorDeTeclado());
        this.setPreferredSize(TAMANHO_TELA);

        carregarImagemFundo();
        novaRaquete();
        novaBola();
        carregarFonte();
        
       
        placar = new Placar(LARGURA_JOGO, ALTURA_JOGO, fontePlacar, nomeP1, nomeP2); 

        threadDoJogo = new Thread(this);
        threadDoJogo.start();
    }


    public void novaBola(){
        bola = new Bola((LARGURA_JOGO/2) - (20/2), (ALTURA_JOGO/2) - (20/2), 20, 20); 
    }

    public void novaRaquete(){
        raquete1 = new Raquete(0, (ALTURA_JOGO/2) - (100/2), 20, 100, 1, Color.red);
        raquete2 = new Raquete(LARGURA_JOGO - 20, (ALTURA_JOGO/2) - (100/2), 20, 100, 2, Color.blue);
    }
    
    public void mover(){
        raquete1.mover();
        raquete2.mover();
        bola.mover();
    }
    
    public void verificarColisao(){
        
        if(bola.y <= 0 || bola.y >= ALTURA_JOGO - bola.height){
            bola.velocidadeY = -bola.velocidadeY;
        }

        
        if(bola.intersects(raquete1) && bola.velocidadeX < 0){
            bola.velocidadeX = -bola.velocidadeX;
        }
        if(bola.intersects(raquete2) && bola.velocidadeX > 0){
            bola.velocidadeX = -bola.velocidadeX;
        }

       
        if(bola.x <= 0){
            placar.jogador2++;
            if(placar.jogador1 < 6 && placar.jogador2 < 6){
                novaBola();
                novaRaquete(); 
            } else {
                verificarVitoria();
            }
        }

        
        if(bola.x >= LARGURA_JOGO - bola.width){
            placar.jogador1++;
            if(placar.jogador1 < 6 && placar.jogador2 < 6){
                novaBola();
                novaRaquete(); 
            } else {
                verificarVitoria();
            }
        }
    }


    public void verificarVitoria(){
        if(placar.jogador1 >= 6 || placar.jogador2 >= 6){ 
            exibirMenuVitoria();
        }
    }

    public void exibirMenuVitoria(){
        String nomeVencedor = (placar.jogador1 >= 6) ? nomeP1 : nomeP2;
        String vitoria = nomeVencedor + " VENCEU!"; 
        JOptionPane.showMessageDialog(this, vitoria, "Fim De Jogo", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    
    @Override
    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000/amountOfTicks;
        double delta = 0;

        while(threadDoJogo != null){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            if(delta >= 1){
                mover();
                verificarColisao();
                repaint();
                delta--;
            }
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        if(imagemFundo != null){
            g.drawImage(imagemFundo, 0, 0, LARGURA_JOGO, ALTURA_JOGO, this);
        } else{
            g.setColor(Color.black);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        desenhar(g);
    }

    public void desenhar(Graphics g){
        raquete1.desenhar(g);
        raquete2.desenhar(g);
        bola.desenhar(g);
        placar.desenhar(g);
    }

    public class AdaptadorDeTeclado extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            raquete1.teclaPressionada(e);
            raquete2.teclaPressionada(e);
        }

        @Override
        public void keyReleased(KeyEvent e){
            raquete1.teclaLiberada(e);
            raquete2.teclaLiberada(e);
        }
    }

    private Font fontePlacar;

    private void carregarFonte(){
        try{
            
            fontePlacar = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/recursos/PressStart2P-Regular.ttf"));
            fontePlacar = fontePlacar.deriveFont(Font.BOLD, 40f);
        } catch(Exception e){
          
            fontePlacar = new Font("Consolas", Font.BOLD, 40);
        }
    }

    private void carregarImagemFundo(){
        try{
           
            imagemFundo = ImageIO.read(getClass().getResourceAsStream("/recursos/pingpong.png"));
        } catch(Exception e){
            
            try {
                 imagemFundo = ImageIO.read(new File("pingpong.png"));
            } catch (IOException e2) {
                 imagemFundo = null;
            }
        }
    }
}