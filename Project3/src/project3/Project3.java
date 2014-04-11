/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project3;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
 

    
/**
 *
 * @author Eric Sullivan
 */
public class Project3 extends JFrame implements Runnable, KeyListener{
    
     private final Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
     private static final int HEIGHT = 1000;
     private static final int WIDTH = 1940;
     private GridLayout grid;
     private ArrayList<CarPanel> cars;
     private Thread gameloop;
     private int num;
     private InfoPanel info;
     private TopPanel top;
     
    public Project3(int num){
        super("CarRace");
        this.num = num;
        grid = new GridLayout(this.num+2,1);
        top = new TopPanel();
        add(top);
        setLayout(grid);
        setSize(screenSize);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        cars= new ArrayList<>();
        for(int i=0;i<num;i++){
            cars.add(new CarPanel());
            add(cars.get(i));
        }
        info = new InfoPanel(this);
        add(info);
        setVisible(true);
       // start();
    }
   public void start(){
        addKeyListener(this);
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
            if(top.begin()){
            for(int i = 0;i<num;i++){
                cars.get(i).repaint();
                if(cars.get(i).win()){
                    gameloop = null;
                    JOptionPane.showMessageDialog(null,"The Winning car is "+cars.get(i).getCar());
                }
            }
            }
        }
    }
    public ArrayList<CarPanel> getCars(){
        return cars;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("here");
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getKeyCode()==KeyEvent.VK_UP){
            info.changeCarUp();
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            info.changeCarUp();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("here");
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            info.changeCarUp();
        }
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        new Project3(numb).start();
    
    
    
}
   
}
