/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project3;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Eric Sullivan
 */
public class Route {
    
    ImageIcon letter;
    int distance;
    
    
    public Route(ImageIcon letter, int distance){
        this.letter = letter;
        this.distance = distance;
    }
    public ImageIcon getLetter() {
        return letter;
    }
    public void setLetter(ImageIcon letter) {
        this.letter = letter;
    }
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public Image getImage(){
        return letter.getImage();
    }
        
}

