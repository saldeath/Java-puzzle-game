/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokobanv2;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Mike
 */
public class Menu implements ActionListener {

    JLabel lblModus = new JLabel("Kies de modus:");
    JButton btnNormaal = new JButton("Normaal");
    JButton btnKinder = new JButton("Kinder");
    private View view;
    private MODUS modus = MODUS.NORMAAL;
    public int status = 1;

    public Menu(View view) {
        this.view = view;
        btnKinder.addActionListener(this);
        btnNormaal.addActionListener(this);
        view.add(lblModus);
        view.add(btnNormaal);
        view.add(btnKinder);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnKinder) {
            modus.setModus(MODUS.KINDER);
        } else if (src == btnNormaal) {
            modus.setModus(MODUS.NORMAAL);
        }
        if (src == btnKinder || src == btnNormaal) {
            setStatus(2);
            btnKinder.setVisible(false);
            btnNormaal.setVisible(false);
            view.repaint();
            view.toetstenbordToevoegen();
        }
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void paint(Graphics g) {
        Font fontMenu = new Font("arial", Font.BOLD, 50);
        Font fontMenuKlein = new Font("arial", Font.BOLD, 18);
        g.setFont(fontMenu);
        g.setColor(Color.red);
        g.drawString("Sokoban", 130, 100);
        g.setFont(fontMenuKlein);
        g.drawString("Speel dit spel met de pijltjestoetsen", 90, 175);
        g.drawString("Het spel bestaat uit 3 levels", 130, 200);

    }
}
