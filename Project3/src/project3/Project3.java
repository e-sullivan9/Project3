/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project3;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
 

    
/**
 *
 * @author Eric Sullivan
 */
public class Project3 extends JFrame implements Runnable{
    
     private Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
     private static final int HEIGHT = 1000;
     private static final int WIDTH = 1940;
     GridLayout grid;
     ArrayList<CarPanel> cars;
     Thread gameloop;
     int num;
     
    public Project3(int num){
        super("CarRace");
        this.num = num;
       // this.setBackground(Color.WHITE);
        grid = new GridLayout(this.num+1,1);
        setLayout(grid);
        setSize(screenSize);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new TopPanel(this));
        cars= new ArrayList<CarPanel>();
        for(int i=0;i<num;i++){
            System.out.println(i);
            cars.add(new CarPanel());
            add(cars.get(i));
        }
        setVisible(true);
       //start();
    }
   public void start(){
        gameloop = new Thread(this);
        gameloop.start();
    }
    public void run(){
        while(gameloop==Thread.currentThread()){
            try{
                Thread.sleep(5);
            }
            catch(InterruptedException e){
                e.getMessage();
            }
            for(int i = 0;i<num;i++){
                cars.get(i).repaint();
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String number = JOptionPane.showInputDialog(null, "How many cars?");
        //System.out.println(number);
        int numb = Integer.parseInt(number);
        //System.out.print(numb);
        //int numb = scan.nextInt();
        new Project3(numb);
    
    
    
}
}
