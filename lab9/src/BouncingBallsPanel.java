import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

public class BouncingBallsPanel extends JPanel {

    static class Ball{
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
                    if(x.x<=0){
                        x.x=-x.x;
                        x.vx=-x.vx;
                    }
                    if(x.x>=getSize().width){
                        x.x=getSize().width*2-x.x;
                        x.vx=-x.vx;
                    }
                    if(x.y<=0){
                        x.y=-x.y;
                        x.vy=-x.vy;
                    }
                    if(x.y>=getSize().height){
                        x.y=getSize().height*2-x.y;
                        x.vy=-x.vy;
                    }
                }

                //wywołaj repaint
                repaint();
                //uśpij
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    BouncingBallsPanel(){
        setBorder(BorderFactory.createStrokeBorder(new BasicStroke(3.0f)));
    }
    public void paint(Graphics g){
        for(Ball x:balls){
            g.setColor(x.color);
            g.fillOval(
                    x.x
                            -
                            B
                    ALL_SIZE,
                    (int)ballY
                            -
                            BALL_SIZE,
                    2*BALL_SIZE, 2*BALL_SIZE);
        }

    }
    void onStart(){
        AnimationThread.run();
        System.out.println("Start or resume animation thread");
    }

    void onStop(){
        System.out.println("Suspend animation thread");
    }

    void onPlus(){
        System.out.println("Add a ball");
        Ball a=new Ball();
        a.x=1;
        a.y=1;
        Random generator = new Random();
        a.vx=generator.nextDouble()*10;
        a.vy=generator.nextDouble()*10;
        a.color=new Color(generator.nextInt(256)+256*generator.nextInt(256)+256*256*generator.nextInt(256));
        balls.add(a);
    }

    void onMinus(){
        System.out.println("Remove a ball");
        if(balls.size()>1){
            balls.remove(0);
        }
    }
}