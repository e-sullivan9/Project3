/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project3;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Eric Sullivan
 */
public class InfoPanel extends JPanel{
    JLabel name;
    Project3 p;
    int i;
    
    public InfoPanel(Project3 p){
        int i =0;
        this.p=p;
        name = new JLabel(""+p.getCars().get(i).getCar().toString());
        add(name);
    }
    public void changeCarUp(){
        i-=1%p.getCars().get(i).getCar().getNumOfCars();
        name.setText(""+p.getCars().get(i).getCar().toString());
    }
    
}
