
/**
 * Beschreiben Sie hier die Klasse Video.
 * 
 * @author Rochella Djouakeu Vofo && Boergers Joel.
 * @version 0.1
 */
public class Video extends Artikel
{
    private int spieldauer, jahr;
    private static final String ART = "Medien";
    
    
    /**
     * Konstruktor der Klasse Video.
     *
     * @param artikelNr Die Nummer des Videos.
     * @param bestand Der Bestand des Videos.
     * @param preis Der Preis des Videos.
     * @param titel Der Titel eines Videos.
     * @param spieldauer Die Spieldauer des Videos.
     * @param jahr Das Jahr an dem das Video veröffentlicht wurde.
     */
    public Video(int artikelNr, int bestand, double preis, String titel, int spieldauer, int jahr){
        super(artikelNr, ART, bestand, preis, titel);
        setSpieldauer(spieldauer);
        setJahr(jahr);
    
    }
    
    /**
     * Beschreibung des Videos ausgeben.
     *
     * @return Die Beschreibung des Artikels.
     */
    public String getBeschreibung(){
       return super.getTitel();
    }
    
   /**
    * Darstellung des Videos als Zeichenkette.
    *
    * @return Die Darstellung eines Videos als Zeichenkette.
    */
   public String toString(){
       return "Artikelnummer:"   + super.getArtikelNr()     + " " +
        "Bezeichnung:"           + super.getArtikelArt()    + " " +
        "Type:"                  + "Video"                  + " " +
        "Bestand:"               + super.getBestand()       + " " + 
        "Preis:"                 + super.getPreis()         + " " +
        "Titel:"                 + super.getTitel()                    + " " +
        "Spieldauer:"            + spieldauer               + " " +
        "Jahr:"                  + jahr;
        
    
    }
    
   /**
    * Spieldauer des Video ändern.
    *
    * @param spieldauer Die Spieldauer des Videos.
    */
   public void setSpieldauer(int spieldauer){
       pruefen( spieldauer > 0, "Die Spieldauer muss positiv sein!");
       this.spieldauer = spieldauer;
    }
    
   /**
    * Das Jahr eines Video ändern.
    *
    * @param jahr Das Jahr des Video.
    */
   public void setJahr(int jahr){
       pruefen( jahr > 999 && jahr < 10000, "Das Jahr muss 4-stellig sein!");
       this.jahr = jahr;
    }
   
   /**
    * Das Jahr an dem das Video veröffentlich wurde, ausgeben.
    *
    * @return Das Jahr.
    */
   public int getJahr(){
    return this.jahr;
    }
    
   /**
    * Die spieldauer eine Videos ausgeben.
    *
    * @return Die Spieldauer des Videos.
    */
   public int getSpieldauer(){
    return this.spieldauer;
    }
   
}
