/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project3;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Adds Start and Pause Button, Timer and Title to the GUI.
 * @author Eric Sullivan
 */
public class TopPanel extends JPanel implements ActionListener{
    private JButton start;
    private JLabel title;
    private JLabel timer;
    private boolean b;
    private long time;
    
    // Constructor creates init time, Start and title.
    public TopPanel(){
        time = System.currentTimeMillis();
        b = false;
        start = new JButton("Start");
        title = new JLabel("RACECARZ",JLabel.CENTER);
        title.setFont(new Font("Serif",Font.ITALIC,42));
        timer = new JLabel("Time in Seconds: "+(System.currentTimeMillis()-time),JLabel.CENTER);
        setLayout(new GridLayout(1,3));
        add(start);
        add(title);
        add(timer);
        start.addActionListener(this);
        start.setFocusable(false);
    }
    // Gives the Thread loop a pause effect
    public boolean begin(){
        return b;
    }
    // returns current time
    public String getTime(){
        return timer.getText();
    }
    //resets time
    public void setTime(){
        timer.setText("Time in Seconds: "+(System.currentTimeMillis()-time)/1000);
    }
    @Override
     public void actionPerformed(ActionEvent e){
         if(e.getSource()==start){
             if(b){
                 b=false;
                 start.setText("Start");
             }
             else{
             b=true;
             start.setText("Pause");
             }
         }
     }
}
