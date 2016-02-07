/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokobanv2;

/**
 *
 * @author Mike
 */
public final class LevelManager {
    // V = Vloer, M = Muur, S = Speler, D = Doos, E = Eindvakje, R = Ruimte

    private int level = 0;
    private String huidigeMap[][];
    private String map1[][] = new String[][]{
        {"R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "M", "M", "M", "M", "M", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "M", "S", "V", "V", "M", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "M", "V", "M", "V", "M", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "M", "V", "D", "V", "M", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "M", "V", "M", "E", "M", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "M", "V", "V", "V", "M", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "M", "V", "M", "V", "M", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "M", "V", "D", "V", "M", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "M", "E", "V", "V", "M", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "M", "M", "M", "M", "M", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R"}};
    private String map2[][] = new String[][]{
        {"R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "M", "M", "M", "M", "M", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "M", "V", "V", "V", "M", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "M", "M", "V", "V", "V", "M", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "M", "V", "D", "D", "V", "M", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "M", "V", "V", "E", "M", "M", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "M", "M", "D", "E", "M", "R", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "M", "E", "S", "M", "R", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "M", "M", "M", "M", "R", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R"}};
    private String map3[][] = new String[][]{
        {"R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "M", "M", "M", "M", "M", "M", "M", "M", "M", "R", "R", "R"},
        {"R", "R", "R", "R", "M", "E", "V", "V", "V", "V", "V", "E", "M", "R", "R", "R"},
        {"R", "R", "R", "R", "M", "V", "M", "M", "V", "M", "M", "V", "M", "R", "R", "R"},
        {"R", "R", "R", "R", "M", "V", "M", "V", "D", "V", "M", "V", "M", "R", "R", "R"},
        {"R", "R", "R", "R", "M", "V", "V", "D", "S", "D", "V", "V", "M", "R", "R", "R"},
        {"R", "R", "R", "R", "M", "V", "M", "V", "V", "V", "M", "V", "M", "R", "R", "R"},
        {"R", "R", "R", "R", "M", "V", "M", "M", "V", "M", "M", "V", "M", "R", "R", "R"},
        {"R", "R", "R", "R", "M", "E", "V", "V", "V", "V", "V", "V", "M", "R", "R", "R"},
        {"R", "R", "R", "R", "M", "M", "M", "M", "M", "M", "M", "M", "M", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R"},
        {"R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R"}};

    public LevelManager() {
        levelVeranderen();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String[][] getHuidigeMap() {
        return huidigeMap;
    }

    public void levelVeranderen() {
        level++;
        if (level == 1) {
            huidigeMap = map1;
        } else if (level == 2) {
            huidigeMap = map2;
        } else if (level == 3) {
            huidigeMap = map3;
        } else {
            huidigeMap = null;
        }
    }
}
