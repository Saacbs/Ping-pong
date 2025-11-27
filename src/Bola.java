import java.awt.*;
import java.util.Random;

public class Bola extends Rectangle{
    Random aleatorio;
    int velocidadeX;
    int velocidadeY;
    int velocidadeInicial = 7;

    public Bola(int x, int y, int largura, int altura){
        super(x, y, largura, altura);
        aleatorio = new Random();

        int direcaoAleatoriaX = aleatorio.nextInt(2);
        if(direcaoAleatoriaX == 0){
            direcaoAleatoriaX--;
        }
        definirVelocidadeX(direcaoAleatoriaX*velocidadeInicial);
        int direcaoAleatoriaY = aleatorio.nextInt(2);
        if(direcaoAleatoriaY == 0){
            direcaoAleatoriaY--;
        }
        definirVelocidadeY(direcaoAleatoriaY*velocidadeInicial);
    }

    public void definirVelocidadeX(int direcaoAleatoriaX){
        velocidadeX = direcaoAleatoriaX;
    }

    public void definirVelocidadeY(int direcaoAleatoriaY){
        velocidadeY = direcaoAleatoriaY;
    }

    public void mover(){
        x += velocidadeX;
        y += velocidadeY;
    }

    public void desenhar(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x, y, width, height);
    }

}
