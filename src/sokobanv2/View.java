/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokobanv2;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Mike
 */
public class View extends JPanel {

    private SpeelVeld speelVeld = new SpeelVeld();
    public Menu menu = new Menu(this);
    public int modus = 1;
    private Toetsenbord toetsenbord;

    public View() {
        setFocusable(true);
    }

    public void toetstenbordToevoegen() {
        toetsenbord = new Toetsenbord(this);
        this.addKeyListener(toetsenbord);
    }

    public SpeelVeld getVeld() {
        return speelVeld;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        menu.paint(g);
        setBackground(Color.ORANGE);
        if (menu.getStatus() != 1) {
            for (int x = 0; x < speelVeld.getVakje().length; x++) {
                for (int y = 0; y < speelVeld.getVakje().length; y++) {
                    if (speelVeld.getVakje()[x][y].getSpelObject() != null) {
                        g.drawImage(speelVeld.getVakje()[x][y].getImgIcon(), x * 30, y * 30, null);
                        g.drawImage(speelVeld.getVakje()[x][y].getSpelObject().getImgIcon(), x * 30, y * 30, null);
                    } else {
                        g.drawImage(speelVeld.getVakje()[x][y].getImgIcon(), x * 30, y * 30, null);
                    }
                }
            }
        }
    }

    public Menu getMenu() {
        return menu;
    }

    public int getModus() {
        return modus;
    }
}