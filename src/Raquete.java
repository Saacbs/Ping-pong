import java.awt.*;
import java.awt.event.KeyEvent;

public class Raquete extends Rectangle {
    int id;
    int velocidadeY;
    int velocidade = 6;
    Color cor;

    public Raquete(int x, int y, int largura, int altura, int id, Color cor){
        super(x, y, largura, altura);
        this.id = id;
        this.cor = cor;
    }

    public void teclaPressionada(KeyEvent e){
        switch(id){
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W){
                    definirVelocidadeY(-velocidade);
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    definirVelocidadeY(velocidade);
                }
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    definirVelocidadeY(-velocidade);
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    definirVelocidadeY(velocidade);
                }
                break;
        }
    }

    public void teclaLiberada(KeyEvent e){
        switch(id){
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W | e.getKeyCode() == KeyEvent.VK_S){
                    definirVelocidadeY(0);
                }
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN){
                    definirVelocidadeY(0);
                }
                break;
        }
    }

    public void definirVelocidadeY(int velocidadeY){
        this.velocidadeY = velocidadeY;
    }

    public void mover(){
        y += velocidadeY;
        if(y<0){
            y = 0;
        }
        if(y>PainelDoJogo.ALTURA_JOGO - height){
            y = PainelDoJogo.ALTURA_JOGO - height;
        }
    }

    public void desenhar(Graphics g){
        g.setColor(cor);
        g.fillRect(x, y, width, height);
    }
}
