//MARCO FLORES
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//MARCO FLORES
package staticscene;

import java.io.*;
import java.awt.*;
import java.awt.geom.*; 
import java.awt.event.*;
import javax.swing.*;

public class StaticScene extends JFrame implements Runnable {
    static final int WINDOW_WIDTH =  1000;
    static final int WINDOW_HEIGHT = 800;
    final int XBORDER = 20;
    final int YBORDER = 20;
    final int YTITLE = 25;
    boolean animateFirstTime = true;
    int xsize = -1;
    int ysize = -1;
    int HouseX;
    int HouseY;
    int StarX;
    int StarY;
    int SunX;
    int Timecount;
    int ROT;
    int Scale;
    int Rc;
    double scaleval;
    double scaledir;
    Image image;
    Graphics2D g;

    static StaticScene frame;
    public static void main(String[] args) {
        frame = new StaticScene();
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public StaticScene() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.BUTTON1 == e.getButton()) {
                    //left button

// location of the cursor.
                    int xpos = e.getX();
                    int ypos = e.getY();

                }
                if (e.BUTTON3 == e.getButton()) {
                    //right button
                    reset();
                }
                repaint();
            }
        });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {

        repaint();
      }
    });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.VK_UP == e.getKeyCode()) {
                } else if (e.VK_DOWN == e.getKeyCode()) {
                } else if (e.VK_LEFT == e.getKeyCode()) {
                } else if (e.VK_RIGHT == e.getKeyCode()) {
                }
                repaint();
            }
        });
        init();
        start();
    }
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }



////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || xsize != getSize().width || ysize != getSize().height) {
            xsize = getSize().width;
            ysize = getSize().height;
            image = createImage(xsize, ysize);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
//fill background
        g.setColor(Color.black);
        g.fillRect(0, 0, xsize, ysize);

        
        if (animateFirstTime) 
        {
            gOld.drawImage(image, 0, 0, null);
            return;
        }
        g.setColor(Color.yellow);
        if(Timecount>=300)
        drawSun(1-SunX,1,0,1,1);
        if(Timecount<=270){
        drawStar(850+StarX,125+StarY,0+ROT,12+Scale,12+Scale);
        drawStar(234+StarX,100+StarY,0+ROT,7+Scale,7+Scale);
        drawStar(100+StarX,100+StarY,0+ROT,2+Scale,2+Scale);
        }
        if(Timecount>=560){
        drawStar(850+StarX,125+StarY,0+ROT,12+Scale,12+Scale);
        drawStar(234+StarX,100+StarY,0+ROT,7+Scale,7+Scale);
        drawStar(100+StarX,100+StarY,0+ROT,2+Scale,2+Scale);
        }
        drawRainbow(0,0,0,1+Rc,1);
        if(Timecount<=270){
        drawStar(550+StarX,625+StarY,0+ROT,5+Scale,5+Scale);
        drawStar(250+StarX,700+StarY,0+ROT,12+Scale,12+Scale);
        }
        if(Timecount>=560){
        drawStar(550+StarX,625+StarY,0+ROT,5+Scale,5+Scale);
        drawStar(250+StarX,700+StarY,0+ROT,12+Scale,12+Scale);
        }
        drawUnicorn(300+HouseX,150+HouseY,0,20,20);
        g.setColor(Color.black);
        g.fillOval(580+HouseX,270+HouseY,15,7);
        g.drawLine(600+HouseX, 330+HouseY, 620+HouseX, 350+HouseY);
        g.setColor(Color.blue);
        drawText(350+HouseX,485+HouseY,333,1,1); 
        if(Timecount>=550&&Timecount<=645){
            g.setFont(new Font("Impact",Font.PLAIN,100));
            g.drawString("Light Speed", 500,400);}
        if(Timecount>650){
            g.setFont(new Font("Impact",Font.PLAIN,100));
            g.drawString("THE END", 500,400);
                         }
        if (animateFirstTime)
        {
            gOld.drawImage(image,0,0, null);
            return;            
        }        
        gOld.drawImage(image, 0, 0, null);
    }

    ////////////////////////////////////////////////////////////////////////////
    public void drawUnicorn(int xpos,int ypos,double rot,double xscale,double yscale)
    {
        
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        g.setColor(Color.GRAY);
        int R = (int)(Math.random()*256);
        int G = (int)(Math.random()*256);
        int B = (int)(Math.random()*256);
        Color RGB = new Color(R,G,B);
        int xval2[] ={14,15,17};
        int yval2[] ={ 5, 5, -2};
        g.fillPolygon(xval2,yval2,xval2.length);
        int xval[] = {0 , 0, 1, 1, 2, 2, 1, 1, 3, 2, 2, 3, 3, 4, 4, 3, 3, 5, 6, 7, 9,11,12,14,15,15,14,14,15,16,16,15,13,16,17,17,16,16,17,18,18,17,15,15,14,13,14,16,17,17,16,15,12,11,10, 9, 8, 6, 4, 2, 1, 1, 2, 1, 0,};
        int yval[] = {25,27,28,29,29,28,27,25,24,25,27,28,29,29,28,27,25,24,22,20,19,17,16,17,19,20,20,21,21,20,19,17,15,16,18,19,19,20,20,19,18,15,14,13,11, 8, 9,10,10, 9, 7, 5, 4, 4, 6,10,12,14,15,16,18,19,22,24,25,};
        g.setColor(Color.white);
        if(Timecount>555)   
            g.setColor(RGB);
        g.fillPolygon(xval,yval,xval.length);
        int xval7[] ={ 1, 0,-1,-3,-4,-3,};
        int yval7[] ={18,19,20,22,22,20,};
        g.fillPolygon(xval7,yval7,xval7.length);
        int xval3[] ={ 1, 1, 2, 2, 1};
        int yval3[] ={28,29,29,28,28};
        g.setColor(Color.GRAY);
        g.fillPolygon(xval3,yval3,xval3.length);
        int xval4[] ={ 3, 3, 4, 4, 3};
        int yval4[] ={28,29,29,28,28};
        g.fillPolygon(xval4,yval4,xval4.length);
        int xval5[] ={15,14,14,15,15};
        int yval5[] ={20,20,21,21,20};
        g.fillPolygon(xval5,yval5,xval5.length);
        int xval6[] ={17,16,16,17,17};
        int yval6[] ={19,19,20,20,19};
        g.fillPolygon(xval6,yval6,xval6.length);
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }
      ////////////////////////////////////////////////////////////////////////////
    public void drawRainbow(int xpos,int ypos,double rot,double xscale,double yscale)
    {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        g.setColor(Color.red);
        g.fillArc(-100,150,1200,1200,0,180);
        Color Rcolor = new Color(255,128,0);
        g.setColor(Rcolor);
        g.fillArc(-100,200,1200,1200,0,180);        
        g.setColor(Color.yellow);
        g.fillArc(-100,250,1200,1200,0,180);
        g.setColor(Color.green);
        g.fillArc(-100,300,1200,1200,0,180);
        g.setColor(Color.blue);
        g.fillArc(-100,350,1200,1200,0,180);
        Color Rcolor2 = new Color(138,43,226);
        g.setColor(Rcolor2);
        g.fillArc(-100,400,1200,1200,0,180);
        Color Rcolor3 = new Color(214,18,208);
        g.setColor(Rcolor3);
        g.fillArc(-100,450,1200,1200,0,180);
        g.setColor(Color.black);
        g.fillArc(-100,500,1200,1200,0,180);
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }
        ////////////////////////////////////////////////////////////////////////////
    public void drawStar(int xpos,int ypos,double rot,double xscale,double yscale)
    {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        int R = (int)(Math.random()*256);
        int G = (int)(Math.random()*256);
        int B = (int)(Math.random()*256);
        int xval6[] ={0,1,3,1,2,0,-2,-1,-3,-1,0};
        int yval6[] ={-4,-2,-2,-1,2,0,2,-1,-2,-2,-4};
        Color RGB = new Color(R,G,B);
        g.setColor(RGB);
        g.fillPolygon(xval6,yval6,xval6.length);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }        
         ////////////////////////////////////////////////////////////////////////////
    public void drawText(int xpos,int ypos,double rot,double xscale,double yscale)
    {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );  
        
        g.setFont(new Font("Impact",Font.PLAIN,20));
        g.drawString("F-150", 0,0);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }
      ////////////////////////////////////////////////////////////////////////////
    public void drawSun(int xpos,int ypos,double rot,double xscale,double yscale)
    {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );  
        
        g.fillOval(1000, -200, 500, 500);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }     
////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = 0.045;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
/////////////////////////////////////////////////////////////////////////
    public void reset() 
    {
    Timecount=0;
    HouseX=0;
    HouseY=0;
    StarX=0;
    StarY=0;
    SunX=0;
    ROT=0;
    Scale=0;
    Rc=0;
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {
        if (animateFirstTime) {
            animateFirstTime = false;
            if (xsize != getSize().width || ysize != getSize().height) {
                xsize = getSize().width;
                ysize = getSize().height;
            }
         
            reset();
            
            
        }
        Timecount++;
        if(Timecount>0&&Timecount<20)
            HouseY++;
        if(Timecount>20&&Timecount<40)
            HouseY--;
        if(Timecount>40&&Timecount<60)
            HouseY++;
        if(Timecount>60&&Timecount<80)
            HouseY--;
        if(Timecount>80&&Timecount<100)
            HouseY++;
        if(Timecount>100&&Timecount<120)
            HouseY--;
        if(Timecount>120&&Timecount<140)
            HouseY++;
        if(Timecount>140&&Timecount<160)
            HouseY--;
        if(Timecount>160&&Timecount<180)
            HouseY++;
        if(Timecount>180&&Timecount<200)
            HouseY--;
        if(Timecount>200&&Timecount<220)
            HouseY++;
        if(Timecount>220&&Timecount<240)
            HouseY--;
        if(Timecount>240&&Timecount<260)
            HouseY++;
        if(Timecount>260&&Timecount<280)
            HouseY--;
        if(Timecount>280&&Timecount<300)
            HouseY++;
        if(Timecount>300&&Timecount<320)
            HouseY--;
        if(Timecount>320&&Timecount<340)
            HouseY++;
        if(Timecount>340&&Timecount<360)
            HouseY--;
        if(Timecount>360&&Timecount<380)
            HouseY++;
        if(Timecount>380&&Timecount<400)
            HouseY--;
        if(Timecount>400&&Timecount<420)
            HouseY++;
        if(Timecount>420&&Timecount<440)
            HouseY--;
        if(Timecount>440&&Timecount<460)
            HouseY++;
        if(Timecount>460&&Timecount<480)
            HouseY--;
        if(Timecount>480&&Timecount<500)
            HouseY++;
        if(Timecount>500&&Timecount<520)
            HouseY--;
        if(Timecount>520&&Timecount<540)
            HouseY++;
        if(Timecount>540&&Timecount<560)
            HouseY--;
        if(Timecount>560&&Timecount<580)
            HouseY++;
        if(Timecount>580&&Timecount<600)
            HouseY--;
        if(Timecount>600&&Timecount<620)
            HouseY++;
        if(Timecount>620&&Timecount<640)
            HouseY--;
        if(Timecount>640&&Timecount<660)
            HouseY++;
        if(Timecount>660&&Timecount<680)
            HouseY--;
        if(Timecount>680&&Timecount<700)
            HouseY++;      
        if(Timecount>=600)
         HouseX+=40;
        if(Timecount>549)
            SunX+=30;
        if(Timecount>300&&Timecount<500)
        SunX++;
        if(Timecount>50&&Timecount<270)
            StarX-=20;
            if(StarX<=-900)
                StarX=900;
            if(Timecount==530)
                StarX=900;
            if(Timecount>560)
            StarX-=20;
            if(StarX<=-900)
                StarX=900;
        if(Timecount>100&&Timecount<190)
            ROT-=4;
        if(Timecount>190)
            ROT-=20;
        if(Timecount>190)
            Scale++;
        if(Timecount>450)
            Scale=0;
        if(Timecount>550)
            Rc++;
    }

////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }
/////////////////////////////////////////////////////////////////////////
    public int getX(int x) {
        return (x + XBORDER);
    }

    public int getY(int y) {
        return (y + YBORDER + YTITLE);
    }

    public int getYNormal(int y) {
        return (-y + YBORDER + YTITLE + getHeight2());
    }
    
    
    public int getWidth2() {
        return (xsize - getX(0) - XBORDER);
    }

    public int getHeight2() {
        return (ysize - getY(0) - YBORDER);
    }
}