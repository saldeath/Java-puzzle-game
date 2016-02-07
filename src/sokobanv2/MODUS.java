package sokobanv2;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Selouan
 */
public enum MODUS {
    
    NORMAAL,
    KINDER;
    
    private MODUS modus;

    public void setModus(MODUS modus) {
        this.modus = modus;
    }

    public MODUS getModus() {
        return modus;
    }
    
}
