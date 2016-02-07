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
public class Doos extends BeweegbaarObject {

    @Override
    public Image getImgIcon() {
        if (this.getVakje() instanceof NormaleVakje) {

            this.imgIcon = new ImageIcon("src/images/package.png");

        } else {

            this.imgIcon = new ImageIcon("src/images/package_done.png");

        }
        return this.imgIcon.getImage();
    }
}
