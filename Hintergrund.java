
/**
 * Write a description of class Hintergrund here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;
import javax.imageio.ImageIO;
public class Hintergrund extends JFrame

{

    public Hintergrund(){    
        JPanel hintergrund = new JPanel(){

                @Override
                protected void paintComponent(Graphics g){

                    super.paintComponent(g);
                    //Spielbrett
                    try
                    {
                        Image bg = ImageIO.read(getClass().getResource("./spielbrett.png"));
                        bg = bg.getScaledInstance(1000, 1000, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bg,0,0,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    //Braun 1
                    try
                    {
                        Image bag = ImageIO.read(getClass().getResource("./brown 1.JPG"));
                        bag = bag.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bag,1020,0,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    
                    //Braun 1
                    try
                    {
                        Image bag = ImageIO.read(getClass().getResource("./brown 2.JPG"));
                        bag = bag.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bag,1020,50,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    
                    //teal 1
                    try
                    {
                        Image bag = ImageIO.read(getClass().getResource("./teal 1.JPG"));
                        bag = bag.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bag,1180,0,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    
                    //teal 2
                    
                    //teal 1
                    try
                    {
                        Image bag = ImageIO.read(getClass().getResource("./teal 2.JPG"));
                        bag = bag.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bag,1180,50,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    
                    //teal 3
                    try
                    {
                        Image bag = ImageIO.read(getClass().getResource("./teal 3.JPG"));
                        bag = bag.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bag,1180,100,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    
                    //purple 1
                    try
                    {
                        Image bag = ImageIO.read(getClass().getResource("./purple 1.JPG"));
                        bag = bag.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bag,1020,150,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    
                    //purple 2
                    try
                    {
                        Image bag = ImageIO.read(getClass().getResource("./purple 2.JPG"));
                        bag = bag.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bag,1020,200,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    
                    //purple 3
                    try
                    {
                        Image bag = ImageIO.read(getClass().getResource("./purple 3.JPG"));
                        bag = bag.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bag,1020,250,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    
                    //orange 1
                    try
                    {
                        Image bag = ImageIO.read(getClass().getResource("./orange 1.JPG"));
                        bag = bag.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bag,1180 ,200,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    
                    //orange 2
                    try
                    {
                        Image bag = ImageIO.read(getClass().getResource("./orange 2.JPG"));
                        bag = bag.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bag,1180 ,250,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    
                    //orange 3
                    try
                    {
                        Image bag = ImageIO.read(getClass().getResource("./orange 3.JPG"));
                        bag = bag.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bag,1180 ,300,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    
                    //red 1
                    try
                    {
                        Image bag = ImageIO.read(getClass().getResource("./red 1.JPG"));
                        bag = bag.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bag,1020,350,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    
                    //red 2
                    try
                    {
                        Image bag = ImageIO.read(getClass().getResource("./red 2.JPG"));
                        bag = bag.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bag,1020,400,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    
                    //red 3
                    try
                    {
                        Image bag = ImageIO.read(getClass().getResource("./red 3.JPG"));
                        bag = bag.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bag,1020,450,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    
                    //yellow 1
                    try
                    {
                        Image bag = ImageIO.read(getClass().getResource("./yellow 1.JPG"));
                        bag = bag.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bag,1180 ,400,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    
                    //yellow 2
                    try
                    {
                        Image bag = ImageIO.read(getClass().getResource("./yellow 2.JPG"));
                        bag = bag.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bag,1180 ,450,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    
                    //yellow 3
                    try
                    {
                        Image bag = ImageIO.read(getClass().getResource("./yellow 3.JPG"));
                        bag = bag.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bag,1180 ,500,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    
                    //green 1
                    try
                    {
                        Image bag = ImageIO.read(getClass().getResource("./green 1.JPG"));
                        bag = bag.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bag,1020,550,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    
                    //green 2
                    try
                    {
                        Image bag = ImageIO.read(getClass().getResource("./green 2.JPG"));
                        bag = bag.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bag,1020,600,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    
                    //green 3
                    try
                    {
                        Image bag = ImageIO.read(getClass().getResource("./green 3.JPG"));
                        bag = bag.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bag,1020,650,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    
                    //blue 1
                    try
                    {
                        Image bag = ImageIO.read(getClass().getResource("./blue 1.JPG"));
                        bag = bag.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bag,1180 ,650,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    
                    //blue 2
                    try
                    {
                        Image bag = ImageIO.read(getClass().getResource("./blue 1.JPG"));
                        bag = bag.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                        g.drawImage(bag,1180 ,700,this);
                    }
                    catch (java.io.IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                };
            };
            this.setLayout(null);
            hintergrund.setLocation(5,5);
            hintergrund.setSize(1500,1500);
            this.add(hintergrund);
            
            this.setSize(800,800);
            this.setVisible(true);
    }
}

