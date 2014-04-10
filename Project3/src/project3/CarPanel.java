/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Eric Sullivan
 */
public class CarPanel extends JPanel{
    ArrayList<ImageIcon> dest;
    ImageIcon road;
    //Car car; 
    int y;
    int x;
    int movement;
    public CarPanel(/*Car car*/){
        /*GridBagLayout c = new GridBagLayout();
        this.setLayout(c);
        */
        x =30;
        y=0;
        movement=1;
        dest = new ArrayList<>();
        dest.add(new ImageIcon("A.JPG"));
        dest.add(new ImageIcon("B.JPG"));
        dest.add(new ImageIcon("C.JPG"));
        dest.add(new ImageIcon("D.JPG"));
        road = new ImageIcon("Line.JPG");
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        System.out.println("im here");
        //repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(movement%this.getWidth(), this.getHeight()-50, 50, 50);
        movement++;
    }
    public void increaseMove(){
        movement++;
    }
    
    
}
