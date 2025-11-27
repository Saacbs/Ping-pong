import java.awt.*;

public class Poderes {
    private int x, y;
    private final int LARGURA = 30;
    private final int ALTURA = 30;

    private TipoPoder tipo;

    private long duracao;

    public enum TipoPoder{
        RAQUETE_GIGANTE,
        BOLA_LENTA,
        BOLA_RAPIDA
    }

    public Poderes(int x, int y, TipoPoder tipo, long duracao){
        this.x = x;
        this.y = y;
        this.tipo = tipo;
        this.duracao = duracao;
    }

    public void desenhar(Graphics g){
        switch (tipo){
            case RAQUETE_GIGANTE:
                g.setColor(Color.MAGENTA);
                break;
            case BOLA_LENTA:
                g.setColor(Color.CYAN);
                break;
            case BOLA_RAPIDA:
                g.setColor(Color.YELLOW);
                break;
        }
        g.fillOval(x, y, LARGURA, ALTURA);
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, LARGURA, ALTURA);
    }

    public TipoPoder getTipo(){
        return tipo;
    }

    public long getDuracao(){
        return duracao;
    }
}
