import java.awt.*;

public class Bubble implements XmasShape {
    int x;
    int y;
    double scale;
    Color lineColor;
    Color fillColor;
    Bubble(int x,int y ,double scale,Color color){
        this.x=x;
        this.y=y;
        this.scale=scale;
        this.lineColor=color;
        this.fillColor=color;
    }
    @Override
    public void render(Graphics2D g2d) {
        g2d.setPaint(fillColor);
        g2d.fillOval(0,0,100,100);
        g2d.setPaint(lineColor);
        g2d.drawOval(0,0,100,100);
    }

    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x,y);
        g2d.scale(scale,scale);
    }
}
