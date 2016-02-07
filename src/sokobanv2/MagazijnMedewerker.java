/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokobanv2;

import javax.swing.ImageIcon;

/**
 *
 * @author Mike
 */
public class MagazijnMedewerker extends BeweegbaarObject {

    private int kijkRichting;
   

    public MagazijnMedewerker(int kijkrichting) {
        this.kijkRichting = kijkrichting;
        kijken();
    }

    private void kijken() {
        switch (kijkRichting) {
            case 1:
                this.imgIcon = new ImageIcon("src/images/soko_up.png");
                break;
            case 2:
                this.imgIcon = new ImageIcon("src/images/soko_right.png");
                break;
            case 3:
                this.imgIcon = new ImageIcon("src/images/soko_down.png");
                break;
            case 4:
                this.imgIcon = new ImageIcon("src/images/soko_left.png");
                break;
            case 5:
                this.imgIcon = new ImageIcon("src/images/soko_goal_up.png");
                break;
        }
    }

    public void setKijkrichting(int kijkrichting) {
        this.kijkRichting = kijkrichting;
        kijken();
    }

    public int getKijkrichting() {
        return kijkRichting;
    }

    public int getStappen() {
        return stappen;
    }

    public void setStappen(int stappen) {
        this.stappen = stappen;
    }
}
