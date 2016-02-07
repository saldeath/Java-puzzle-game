/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokobanv2;

/**
 *
 * @author Mike
 */
public abstract class BeweegbaarObject extends SpelObject {

    public int stappen = 0;
    private MODUS modus = MODUS.NORMAAL;

    public void bewegen(String richting) {
        Vakje volgendevakje = vakje.getBuur(richting);

        if (volgendevakje.getSpelObject() instanceof BeweegbaarObject) {
            if (modus.getModus().equals(MODUS.KINDER)) {
                BeweegbaarObject b = (BeweegbaarObject) volgendevakje.getSpelObject();
                b.bewegen(richting);
            } else {
                if (volgendevakje.getBuur(richting).getSpelObject() == null) {
                    volgendevakje.getBuur(richting).setSpelObject(volgendevakje.getSpelObject());
                }
            }
        }

        if (volgendevakje.getSpelObject() == null) {
            volgendevakje.setSpelObject(this);
            stappen++;

        }
    }
}