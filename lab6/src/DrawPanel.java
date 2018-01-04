import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel {
    List<XmasShape> shapes = new ArrayList<>();
    public DrawPanel(){
        setBackground(new Color(0,0,0));
        //shapes.add(new Bubble(100,100,.2,Color.red));
        shapes.add(new Branch(100,100,4,Color.green));
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(XmasShape s:shapes){
            s.draw((Graphics2D)g);
        }
    }
}