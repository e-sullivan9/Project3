/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project3;

import java.awt.Color;
import java.awt.Font;
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
    private ArrayList<ImageIcon> dest;
    private Car car; 
    private int movement;
    private Random r;
    private Color c;
    public static int scrollX;
    private int maxDest;
    private boolean p;
    private boolean fin;
    Venue ven;
    
    public CarPanel(){
        ven = new Venue();
        p = false;
        fin = true;
        scrollX=0;
        r = new Random();
        c = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
        car = new Car();
        maxDest = /*car.getTotalDistance()*/5000;
        movement=0;
        dest = new ArrayList<>();
        dest.add(new ImageIcon("A.JPG"));
        dest.add(new ImageIcon("B.JPG"));
        dest.add(new ImageIcon("C.JPG"));
        dest.add(new ImageIcon("D.JPG"));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        ArrayList<Route> route = ven.getRoute();
        if(p&&!win()){
        increaseMove();
        p=false;
        }
        g2d.setColor(Color.BLACK);
        g2d.drawImage(route.get(0).getImage(), route.get(0).getDistance()-scrollX, 10, null);
        g2d.drawImage(route.get(1).getImage(), route.get(0).getDistance()+route.get(1).getDistance()-scrollX, 10, null);
        g2d.drawImage(route.get(2).getImage(), route.get(0).getDistance()+route.get(1).getDistance()+route.get(2).getDistance()-scrollX, 10, null);
        g2d.drawImage(route.get(3).getImage(), route.get(0).getDistance()+route.get(1).getDistance()+route.get(2).getDistance()+route.get(3).getDistance()-scrollX-50, 10, null);
        g2d.fillRect(0-scrollX, this.getHeight()-this.getHeight()/2-10, maxDest, 10);
        g2d.setColor(c);
        g2d.fillOval(movement-scrollX, this.getHeight()-this.getHeight()/2, this.getHeight()/2, this.getHeight()/2);
        if(movement>this.getWidth()+scrollX-this.getHeight()/2-100){
            scrollX+=car.calcSpeed()/2;
        }
        if(!fin){
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Serif", Font.ITALIC,50));
            g2d.drawString(""+car.getInitPlace(), maxDest-scrollX+5, this.getHeight()-this.getHeight()/2);
        }
    }
    public void increaseMove(){
        movement+=car.calcSpeed()/2;
    }
    public boolean win(){
        if(movement-scrollX>=maxDest-scrollX-this.getHeight()/2){
            fin = false;
            return true;
            
        }
        else{
            return false;
        }
    }
    public boolean finished(){
        return fin;
    }
    public Car getCar(){
        return car;
    }
    public void setPaintable(boolean p){
        this.p=p;
    }
}
