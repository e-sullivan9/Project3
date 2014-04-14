/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
 

    
/**
 * The JFrame of the Gui.
 * @author Eric Sullivan
 */
public class Project3 extends JFrame implements Runnable, KeyListener{
    
     private final Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
     private GridLayout grid;
     private ArrayList<CarPanel> cars;
     private Thread gameloop;
     private int num;
     private TopPanel top;
     private Color c;
     private JLabel info;
     private int i;
     
     // constructor takes the number of cars the user want and creates the screen.
    public Project3(int num){
        super("CarRace");
        this.num = num;
        c = this.getBackground();
        grid = new GridLayout(this.num+2,1);
        top = new TopPanel();
        add(top);
        setLayout(grid);
        setSize(screenSize);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        cars= new ArrayList<>();
        for(int j=0;j<num;j++){
            cars.add(new CarPanel());
            add(cars.get(j));
        }
        i = 0;
        info = new JLabel(cars.get(i).getCar().toString(),JLabel.CENTER);
        info.setFont(new Font("Serif",Font.BOLD,16));
        cars.get(i).setBackground(Color.YELLOW);
        add(info);
        setVisible(true);
    }
    // starts the Thread and adds keyListener.
   public void start(){
        this.addKeyListener(this);
        this.setFocusable(true);
        gameloop = new Thread(this);
        gameloop.start();
    }
   //runs the Thread loop and paints the carPanels. also increases timer and checks for winners and paints JOptionPane with the winner's info
    public void run(){
        while(gameloop==Thread.currentThread()){
            try{
                Thread.sleep(5);
            }
            catch(InterruptedException e){
                e.getMessage();
            }
            if(top.begin()){
                top.setTime();
            for(int i = 0;i<num;i++){
                cars.get(i).setPaintable(true);
                cars.get(i).repaint();
                if(cars.get(i).finished()&&cars.get(i).win()){
                    JOptionPane.showMessageDialog(null,"PLACE: "+ cars.get(i).getCar().getPlace()+"\n"+cars.get(i).getCar()+ "\n In "+top.getTime()+" Seconds");
                    cars.get(i).getCar().incPlace();
                }
            }
            }
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        for(int j =0;j<0;j++){
        cars.get(j).setPaintable(false);
        }
       if(e.getKeyCode()==KeyEvent.VK_UP){
           cars.get(i).setBackground(c);
           if(i==0){
               i=cars.get(i).getCar().getNumOfCars()-1;
        }
        else{
              i-=1;
        }
        info.setText(""+cars.get(i).getCar().toString());
        cars.get(i).setBackground(Color.YELLOW);
        }
       if(e.getKeyCode()==KeyEvent.VK_DOWN){
           for(int j =0;j<0;j++){
            cars.get(j).setPaintable(false);
           }
           cars.get(i).setBackground(c);
         if(i==cars.get(i).getCar().getNumOfCars()-1){
               i=0;
        }
        else{
              i+=1;
        }
        info.setText(""+cars.get(i).getCar().toString());
        cars.get(i).setBackground(Color.YELLOW);
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
        //Scanner scan = new Scanner(System.in);
        int numb=0;
        while(numb<2||numb>6) {
        String number = JOptionPane.showInputDialog(null, "How many cars? 2-6");
        //System.out.println(number);
        numb = Integer.parseInt(number);
        }
        //System.out.print(numb);
        //int numb = scan.nextInt();
        new Project3(numb).start();
    
    
    
}
   
}
