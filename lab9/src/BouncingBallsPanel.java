import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

public class BouncingBallsPanel extends JPanel {
    AnimationThread a;
    Random generator = new Random();
    static class Ball{
        int bsize=10;
        int x;
        int y;
        double vx;
        double vy;
        Color color;
    }

    ArrayList<Ball> balls = new ArrayList<>();

    class AnimationThread extends Thread{
        public void run(){
            for(;;){
                for (Ball x:balls) {
                    //przesuń kulki
                    x.x=x.x+(int)x.vx;
                    x.y=x.y+(int)x.vy;
                    //wykonaj odbicia od ściany
                    if(x.x<0){
                        x.x=0;
                        x.vx=-x.vx;
                    }
                    if(x.x>getSize().width-x.bsize){
                        x.x=getSize().width-x.bsize;
                        x.vx=-x.vx;
                    }
                    if(x.y<0){
                        x.y=0;
                        x.vy=-x.vy;
                    }
                    if(x.y>getSize().height-x.bsize){
                        x.y=getSize().height-x.bsize;
                        x.vy=-x.vy;
                    }
                }

                //wywołaj repaint
                repaint();
                //uśpij
                try {
                    sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//            for(Ball x:balls){
//                for(Ball y:balls){
//                    if(x.x<=y.x){
//                        x.x=0;
//                        x.vx=-x.vx;
//                    }
//                    if(x.x>getSize().width-x.bsize){
//                        x.x=getSize().width-x.bsize;
//                        x.vx=-x.vx;
//                    }
//                    if(x.y<0){
//                        x.y=0;
//                        x.vy=-x.vy;
//                    }
//                    if(x.y>getSize().height-x.bsize){
//                        x.y=getSize().height-x.bsize;
//                        x.vy=-x.vy;
//                    }
//                }
//            }
        }
    }

    BouncingBallsPanel(){
        setBorder(BorderFactory.createStrokeBorder(new BasicStroke(3.0f)));
    }
    public void paint(Graphics g){
        for(Ball x:balls){
            g.setColor(x.color);
            g.fillOval(x.x,x.y,x.bsize,x.bsize);
        }

    }
    void onStart(){
        setOpaque(false);
        a=new AnimationThread();
        a.start();
        System.out.println("Start or resume animation thread");
    }

    void onStop(){
        a.stop();
        System.out.println("Suspend animation thread");
    }

    void onPlus(){
        System.out.println("Add a ball");
        Ball a=new Ball();
        a.x=1;
        a.y=1;
        a.vx=generator.nextDouble()*5+4;
        a.vy=generator.nextDouble()*5+4;
        a.color=new Color(generator.nextInt(256)+256*generator.nextInt(256)+256*256*generator.nextInt(256));
        balls.add(a);
    }

    void onMinus(){
        System.out.println("Remove a ball");
        if(balls.size()>0){
            balls.remove(0);
        }
    }
}