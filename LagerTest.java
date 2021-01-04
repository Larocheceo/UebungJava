import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse LagerTest. Diese Klasse dient dazu, alle die geschriebenen Methoden in der Klasse Lager, zu testen.
 *
 * @author  Rochella Vofo & Joel Boergers.
 * @version 0.1
 */
public class LagerTest
{   
    private Lager lager = new Lager();
    private Artikel artikel = new Artikel(1234, "Schuhe", 0, 20.0);
    private Artikel artikel1 = new Artikel(1245, "Guertel", 10, 50.0);
    private Artikel artikel2 = new Artikel(1897, "Rucksack", 30.0);
    
    private final static double EPSILON = 0.000001;
    
    
    
    @Test
    public void test_legeAnArtikel(){
        Artikel artikelZumTesten = new Artikel(1234, "Schuhe", 0, 20.0);
        lager.legeAnArtikel(artikelZumTesten);
        assertEquals(true, lager.getArtikel(0) != null);        // Fuer void Methoden testen wir Sideeffects.
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_legeAnArtikel_mit_zwei_artikeln_mit_gleichen_nummer(){
        Artikel artikelZumTesten = new Artikel(1234, "Schuhe", 0, 20.0);
        lager.legeAnArtikel(artikelZumTesten);
        lager.legeAnArtikel(artikel);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_entferneArtikel_das_nicht_existiert(){  
        lager.entferneArtikel(1245);
    }
    
    @Test
    public void test_entferneArtikel_das_existiert(){
        lager.legeAnArtikel(artikel);
        lager.entferneArtikel(1234);
        assertEquals(true, lager.getArtikel(0) == null);   // Wir testen die Sideeffects.
    }
    
    @Test
    public void test_findeArtikel_das_existiert_im_lager(){
        lager.legeAnArtikel(artikel);
        assertEquals(true, lager.findeArtikel(1234));
        
    }
    
    @Test
    public void test_findeArtikel_das_nicht_existiert_im_lager(){
        assertEquals(false, lager.findeArtikel(1234));
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_bucheZugang_mit_artikel_das_nicht_existiert_im_lager(){
        lager.bucheZugang(2356, 1784);
    }
    
    @Test
    public void test_bucheZugang_mit_artikel_das_existiert_im_lager(){
        lager.legeAnArtikel(artikel);
        lager.bucheZugang(1234, 20);
        assertEquals(20, lager.getArtikel(0).getBestand());
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_bucheAbgang_mit_artikel_das_nicht_existiert_im_lager(){
        lager.bucheAbgang(2356, 1784);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_bucheAbgang_mit_artikel_das_existiert_im_lager_mit_uerbeschrittenen_menge(){
        lager.legeAnArtikel(artikel);
        lager.bucheAbgang(1234, 20);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_bucheAbgang_mit_artikel_das_existiert_im_lager_mit_angemessenen_menge(){
        lager.legeAnArtikel(artikel);
        lager.bucheAbgang(1234, 20);
        assertEquals(20, lager.getArtikel(0).getBestand());   
    }
    
    @Test
    public void test_aenderePreisAllerArtikel(){
        lager.legeAnArtikel(artikel);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.aenderePreisAllerArtikel(20);
        assertEquals(24.0, lager.getArtikel(0).getPreis(), EPSILON);
        assertEquals(60.0, lager.getArtikel(1).getPreis(), EPSILON);
        assertEquals(36.0, lager.getArtikel(2).getPreis(), EPSILON);
           
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_aenderePreisAllerArtikel_mit_minus_150_prozent(){
        lager.legeAnArtikel(artikel);
        lager.legeAnArtikel(artikel1);
        lager.legeAnArtikel(artikel2);
        lager.aenderePreisAllerArtikel(-150);
        
           
    }
    
    @Test
    public void test_getArtikel(){
        lager.legeAnArtikel(artikel);
        assertEquals(artikel, lager.getArtikel(0));
        assertEquals(null, lager.getArtikel(2));      
    }
    
    @Test
    public void test_getArtikelAnzahl_mit_0_artikel_im_lager_erwartet_0(){
        assertEquals(0, lager.getArtikelAnzahl());      
    }
    
    @Test
    public void test_getArtikelAnzahl_mit_2_artikel_im_lager_erwartet_2(){
       lager.legeAnArtikel(artikel);
       lager.legeAnArtikel(artikel1);
       assertEquals(2, lager.getArtikelAnzahl());      
    }
   
    /**
     * Konstruktor fuer die Test-Klasse LagerTest
     */
    public LagerTest()
    {
    }

    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @Before
    public void setUp()
    {
        
    }

    /**
     * Gibt das Testgerüst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @After
    public void tearDown()
    {
    }
}
