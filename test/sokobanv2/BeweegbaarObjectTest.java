/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sokobanv2;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Selouan
 */
public class BeweegbaarObjectTest {

    private Vakje spelerVakje, muurLinksVakje, vrijOnderVakje, doosBovenVakje, doosRechtsVakje, vrijRechtsVakje, muurBovenVakje;
    private MagazijnMedewerker speler;
    private Doos doosBoven, doosRechts;
    private Muur muurLinks, muurBoven;

    public BeweegbaarObjectTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {

        speler = new MagazijnMedewerker(2);

        spelerVakje = new NormaleVakje();
        muurLinksVakje = new NormaleVakje();
        vrijOnderVakje = new NormaleVakje();
        doosBovenVakje = new NormaleVakje();
        doosRechtsVakje = new NormaleVakje();
        vrijRechtsVakje = new NormaleVakje();
        muurBovenVakje = new NormaleVakje();

        doosBoven = new Doos();
        doosRechts = new Doos();

        muurLinks = new Muur();
        muurBoven = new Muur();
        
        spelerVakje.setBuur("Boven", doosBovenVakje);
        spelerVakje.setBuur("Links", muurLinksVakje);
        spelerVakje.setBuur("Beneden", vrijOnderVakje);
        spelerVakje.setBuur("Rechts", doosRechtsVakje);

        doosBovenVakje.setBuur("Boven", muurBovenVakje);

        doosRechtsVakje.setBuur("Rechts", vrijRechtsVakje);

        spelerVakje.setSpelObject(speler);
        doosBovenVakje.setSpelObject(doosBoven);
        muurLinksVakje.setSpelObject(muurLinks);
        doosRechtsVakje.setSpelObject(doosRechts);
        muurBovenVakje.setSpelObject(muurBoven);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testBewegenBeneden() {
        speler.bewegen("Beneden");

        assertNull(spelerVakje.getSpelObject());
        assertEquals(speler, vrijOnderVakje.getSpelObject());
    }

    @Test
    public void testBewegenLinks() {
        speler.bewegen("Links");

        assertEquals(speler, spelerVakje.getSpelObject());
        assertEquals(muurLinks, muurLinksVakje.getSpelObject());
    }

    @Test
    public void testBewegenRechts() {
        doosRechts.bewegen("Rechts");
        speler.bewegen("Rechts");
        
        assertNull(spelerVakje.getSpelObject());
        assertEquals(doosRechts, vrijRechtsVakje.getSpelObject());
        assertEquals(speler, doosRechtsVakje.getSpelObject());

    }

    @Test
    public void testBewegenBoven() {
        
        speler.bewegen("Boven");
       //doosBoven.bewegen("Boven");
        

        assertEquals(speler, spelerVakje.getSpelObject());
        assertEquals(doosBoven, doosBovenVakje.getSpelObject());
        assertEquals(muurBoven, muurBovenVakje.getSpelObject());
        
    }
}
