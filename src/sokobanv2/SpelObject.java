/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokobanv2;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Mike
 */
public abstract class SpelObject {

    protected Vakje vakje;
    protected ImageIcon imgIcon;

    public Image getImgIcon() {
        return imgIcon.getImage();
    }

    public void setVakje(Vakje vakje) {
        this.vakje = vakje;
    }

    public Vakje getVakje() {
        return vakje;
    }
}
