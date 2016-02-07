/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokobanv2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Mike
 */
public class Toetsenbord implements Besturing, KeyListener {

    private View view;

    Toetsenbord(View view) {
        this.view = view;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        if (keycode == KeyEvent.VK_UP) {
            gaOmhoog();
        }
        if (keycode == KeyEvent.VK_RIGHT) {
            gaRechts();
        }
        if (keycode == KeyEvent.VK_DOWN) {
            gaBeneden();
        }
        if (keycode == KeyEvent.VK_LEFT) {
            gaLinks();
        }
        if (keycode == KeyEvent.VK_R) {
            resetLevel();

        }
        view.getVeld().checkLevel();
        view.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void gaOmhoog() {
        view.getVeld().getSpeler().bewegen("Boven");
        view.getVeld().getSpeler().setKijkrichting(1);
    }

    @Override
    public void gaRechts() {
        view.getVeld().getSpeler().bewegen("Rechts");
        view.getVeld().getSpeler().setKijkrichting(2);
    }

    @Override
    public void gaBeneden() {
        view.getVeld().getSpeler().bewegen("Beneden");
        view.getVeld().getSpeler().setKijkrichting(3);
    }

    @Override
    public void gaLinks() {
        view.getVeld().getSpeler().bewegen("Links");
        view.getVeld().getSpeler().setKijkrichting(4);
    }

    @Override
    public void resetLevel() {
        view.getVeld().speelVeldVullen();
        view.getVeld().getSpeler().setKijkrichting(2);
        view.getVeld().getSpeler().setStappen(0);
    }
}
