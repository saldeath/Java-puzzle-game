/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokobanv2;

import java.awt.Image;
import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 *
 * @author Mike
 */
public abstract class Vakje {
    
    private SpelObject spelObject;
    protected ImageIcon imgIcon;
    private HashMap<String, Vakje> buren;

    public Vakje() {
        buren = new HashMap<>();
    }
    
    public void setBuur(String richting, Vakje vakje){
        buren.put(richting, vakje);
    }
    
    public Vakje getBuur(String richting){
        return buren.get(richting);
    }

    public void setImgIcon(ImageIcon imgIcon) {
        this.imgIcon = imgIcon;
    }
    
    public void setSpelObject(SpelObject spelObject) {
        this.spelObject = spelObject;
        Vakje vorigevakje = spelObject.getVakje();
        if (vorigevakje != null) {
            vorigevakje.verwijderSpelObject();
        }
        spelObject.setVakje(this);
    }
    
    public SpelObject getSpelObject() {
        return spelObject;
    }
    
    public Image getImgIcon() {
        return imgIcon.getImage();
    }
    
    public void verwijderSpelObject(){
        spelObject = null;
    }
}
