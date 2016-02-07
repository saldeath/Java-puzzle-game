/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokobanv2;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Mike
 */
public class Sokobanv2 {

    private static JFrame sokobanFrame;
    private static View view;
    private static final int HEIGHT = 509;
    private static final int WIDTH = 486;
    private static ImageIcon img = new ImageIcon("src/images/soko_right.png");

    public static void main(String[] args) {

        sokobanFrame = new JFrame();
        view = new View();
        sokobanFrame.add(view);


        sokobanFrame.setTitle("Sokoban");
        sokobanFrame.setVisible(true);
        sokobanFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sokobanFrame.setResizable(false);
        sokobanFrame.setSize(WIDTH, HEIGHT);
        sokobanFrame.setLocationRelativeTo(null);
        sokobanFrame.setIconImage(img.getImage());
    }
}
