import java.awt.*;
import java.awt.geom.AffineTransform;

public class Branch implements XmasShape {
    int x;
    int y;
    double scale;
    Color lineColor;
    Color fillColor;
    Branch(int x,int y ,double scale,Color color){
        this.x=x;
        this.y=y;
        this.scale=scale;
        this.lineColor=color;
        this.fillColor=color;
    }
    @Override
    public void render(Graphics2D g2d) {
        g2d.setPaint(fillColor);
        AffineTransform mat = g2d.getTransform();
        // przesuń początek układu
        g2d.translate(100,100);
        // zastosuj skalowanie
        g2d.scale(.2,.2);
        // narysuj linie
        for(int i=0;i<12;i++){
            g2d.drawLine(5,0,0,5);
            g2d.translate(10,-2);
        }
        g2d.rotate(Math.PI);
        g2d.translate(2,-10);
        for(int i=0;i<12;i++){
            g2d.drawLine(0,0,5,5);
            g2d.translate(10,-2);
        }
        //oddtwórz poprzednie ustawienia transformacji układu współrzędnych
        g2d.setTransform(mat);
    }

    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x,y);
        g2d.scale(scale,scale);
    }
}