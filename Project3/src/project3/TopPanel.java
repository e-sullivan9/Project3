/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Eric Sullivan
 */
public class TopPanel extends JPanel implements ActionListener{
    JButton start;
    JLabel title;
    JLabel timer;
    private Project3 p;
    
    public TopPanel(Project3 p){
        this.p=p;
        start = new JButton("Start");
        title = new JLabel("",JLabel.CENTER);
        timer = new JLabel("00:00",JLabel.CENTER);
        setLayout(new GridLayout(1,3));
        add(start);
        add(title);
        add(timer);
        start.addActionListener(this);
    }
     public void actionPerformed(ActionEvent e){
         if(e.getSource()==start){
             p.start();
         }
     }
}
