/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokobanv2;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Mike
 */
public final class SpeelVeld {

    private final int rowAndCol = 16;
    private Vakje[][] vakje = new Vakje[rowAndCol][rowAndCol];
    private LevelManager levelManager;
    private MagazijnMedewerker speler;
    private ArrayList<EindPuntVakje> eindVakCollectie;
    
    public SpeelVeld() {
        levelManager = new LevelManager();
        speler = new MagazijnMedewerker(2);
        speelVeldVullen();
    }

    public MagazijnMedewerker getSpeler() {
        return speler;
    }

    public Vakje[][] getVakje() {
        return vakje;
    }

    public void speelVeldVullen() {
        eindVakCollectie = new ArrayList();
        String level[][] = levelManager.getHuidigeMap();
        if (levelManager.getHuidigeMap() == null) {
            spelControle();
        } else {
            for (int i = 0; i < vakje.length; i++) {
                for (int j = 0; j < vakje.length; j++) {
                    if (level[i][j].equals("E")) {
                        vakje[i][j] = new EindPuntVakje();
                        eindVakCollectie.add((EindPuntVakje) vakje[i][j]);
                    } else {
                        vakje[i][j] = new NormaleVakje();
                        switch (level[i][j]) {
                            case "M":
                                vakje[i][j].setSpelObject(new Muur());
                                break;
                            case "S":
                                vakje[i][j].setSpelObject(speler);
                                break;
                            case "D":
                                vakje[i][j].setSpelObject(new Doos());
                                break;
                            case "R":
                                vakje[i][j].setImgIcon(new ImageIcon("src/images/space.png"));
                                break;
                        }
                    }
                }
            }

            for (int x = 0; x < rowAndCol; x++) {
                for (int y = 0; y < rowAndCol; y++) {
                    if (x > 0) {
                        vakje[x][y].setBuur("Links", vakje[x - 1][y]);
                    }
                    if (y > 0) {
                        vakje[x][y].setBuur("Boven", vakje[x][y - 1]);
                    }
                    if (x < rowAndCol - 1 && x < rowAndCol) {
                        vakje[x][y].setBuur("Rechts", vakje[x + 1][y]);
                    }

                    if (y < rowAndCol - 1 && y < rowAndCol) {
                        vakje[x][y].setBuur("Beneden", vakje[x][y + 1]);
                    }
                }
            }
        }
    }
    
    private void spelControle(){
        Object[] options = {"Opnieuw", "Stop"};
            int uitgespeeldOptie = JOptionPane.showOptionDialog(null, "Gefeliciteerd, je hebt het spel uitgespeeld! \nKlik op Opnieuw om nog een keer te spelen of klik op Stop om het spel te stoppen.",  "Gefeliciteerd", 
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (uitgespeeldOptie == 0){
                levelManager.setLevel(0);
                levelManager.levelVeranderen();
                levelManager.getHuidigeMap();
                speelVeldVullen();
            } else {
                System.exit(0);
            }
    }
    
    private boolean checkEindVak() {

        for (EindPuntVakje eindVak : eindVakCollectie) {
            if (!(eindVak.getSpelObject() instanceof Doos)) {
                return false;
            }
        }
        return true;
    }

    public void checkLevel() {
        boolean flag = checkEindVak();
        if (flag == true) {
            levelVoltooid();
            speler.setStappen(0);

            levelManager.levelVeranderen();
            speelVeldVullen();
        }

    }

    private void levelVoltooid() {
        String[] options = {"OK"};
            JOptionPane.showOptionDialog(null, "Gefeliciteerd, je hebt het level voltooid in " + speler.getStappen() + " stappen.", "Gefeliciteerd", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }
    
    
}


//    private void testSpeelVeld() {
//        for (int i = 0; i < rowAndCol; i++) {
//            for (int j = 0; j < rowAndCol; j++) {
//                if (vakje[i][j].getSpelObject() != null) {
//                    System.out.print("x");
//                } else {
//                    System.out.print("q");
//                }
//            }
//            System.out.println("");
//        }
//    }

