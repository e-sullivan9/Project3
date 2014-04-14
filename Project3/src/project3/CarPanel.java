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
 * CarPanel Adds the car and track to the JFrame.
 * @author Eric Sullivan
 */
public class CarPanel extends JPanel{
    private Car car; 
    private int movement;
    private Random r;
    private Color c;
    public static int scrollX;
    private boolean p;
    private boolean fin;
    private Venue ven;
    private ArrayList<Route> route;
    
    /*
    constructor gets route and creats a Car and adds.
    */
    public CarPanel(){
        ven = new Venue();
        route = ven.getRoutes();
        p = false;
        fin = true;
        scrollX=0;
        r = new Random();
        c = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
        car = new Car();
        movement=0;
        setBorder(BorderFactory.createLineBorder(c));
    }
    /*
    paints the track and the cars then moves then cars with there speed. also checks for a winner and has scrolling on the x axis.
    */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(p&&!win()){
        increaseMove();
        p=false;
        }
        g2d.setColor(Color.BLACK);
        g2d.drawImage(route.get(0).getImage(), 0-scrollX, 10, null);
        g2d.drawImage(route.get(1).getImage(), route.get(0).getDistance()-scrollX, 10, null);
        g2d.drawImage(route.get(2).getImage(), route.get(0).getDistance()+route.get(1).getDistance()-scrollX, 10, null);
        g2d.drawImage(route.get(3).getImage(), ven.getTotalDistance()-route.get(2).getDistance()-scrollX-50, 10, null);
        g2d.fillRect(0-scrollX, this.getHeight()-this.getHeight()/2-10, ven.getTotalDistance()-route.get(2).getDistance(), 10);
        g2d.setColor(c);
        g2d.fillOval(movement-scrollX, this.getHeight()-this.getHeight()/2, this.getHeight()/2, this.getHeight()/2);
        if(movement>this.getWidth()+scrollX-this.getHeight()/2-100){
            scrollX+=car.calcSpeed()/2;
        }
        if(!fin){
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Serif", Font.ITALIC,50));
            g2d.drawString(""+car.getInitPlace(), ven.getTotalDistance()-route.get(2).getDistance()-scrollX+5, this.getHeight()-this.getHeight()/2);
        }
    }
    // increments the x varible of the car.
    public void increaseMove(){
        movement+=car.calcSpeed()/2;
    }
    //if the car is at the end of the track returns a true.
    public boolean win(){
        if(movement-scrollX>=ven.getTotalDistance()-route.get(2).getDistance()-scrollX-this.getHeight()/2){
            fin = false;
            return true;
            
        }
        else{
            return false;
        }
    }
    //sees if the car is already finished its course.
    public boolean finished(){
        return fin;
    }
    // getter for the car.
    public Car getCar(){
        return car;
    }
    // if true car is movable if false car stands still.
    public void setPaintable(boolean p){
        this.p=p;
    }
}
