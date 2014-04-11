/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author Eric Sullivan
 */
public class CarPanel extends JPanel{
    ArrayList<ImageIcon> dest;
    ImageIcon road;
    Car car; 
    int y;
    int x;
    int movement;
    Random r;
    Color c;
    public CarPanel(){
        /*GridBagLayout c = new GridBagLayout();
        this.setLayout(c);
        */
        r = new Random();
        c = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
        car = new Car();
        x =30;
        y=0;
        movement=0;
        dest = new ArrayList<>();
        dest.add(new ImageIcon("A.JPG"));
        dest.add(new ImageIcon("B.JPG"));
        dest.add(new ImageIcon("C.JPG"));
        dest.add(new ImageIcon("D.JPG"));
        road = new ImageIcon("Line.JPG");
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(c);
        g2d.fillOval(movement%this.getWidth(), this.getHeight()-this.getHeight()/2, this.getHeight()/2, this.getHeight()/2);
        increaseMove();
    }
    public void increaseMove(){
        movement+=car.calcSpeed();;
    }
    
    
}
