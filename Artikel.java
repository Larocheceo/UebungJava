
/**
 * Einfache Artikel Klasse
 *
 * @author Rochella Vofo
 * @version 0.1
 */
public class Artikel{
    private int     artikelNr;
    private int     bestand;
    private double  preis;
    private String  art;
    
    /**
     * Konstruktor der Klasse Artikel
     *
     * @param artikelNr muss 4-stellig & > 0
     * @param art darf nicht null sein
     * @param bestand >= 0
     * @param preis > 0.0
     */
    public Artikel(int artikelNr, String art, int bestand, double preis){
        pruefen(artikelNr >= 1000 && artikelNr < 10000, "Artikelnummer muss 4-stellig sein");
        this.artikelNr = artikelNr;
        setArt(art);
        setBestand(bestand);
        setPreis(preis);
    }
    
    /**
     * Konstruktor der Klasse Artikel
     *
     * @param artikelNr muss 4-stellig & > 0
     * @param art darf nicht null sein
     * @param bestand >= 0
     */
    public Artikel(int artikelNr, String art, double preis){
        this(artikelNr, art, 0, preis);
    }
    
    /**
     * pruefen: prueft die Konstruktoren Parameters
     *
     * @param bedingung: Die bedigung, die zu pruefen ist.
     * @param message: Die Fehlermeldung.
     */
    public static void pruefen(boolean bedingung, String message){
        if (!bedingung){
            throw new IllegalArgumentException(message);
        }
        
    }
    
    /**
     * Erhoehung eines Bestandes
     *
     * @param menge muss > 0 sein
     */
    public void bucheZugang(int menge){
        pruefen(menge > 0, "Die Menge muss größer als 0 sein");
        bestand = bestand + menge;
        
    }
    
    /**
     * Abbuchung eines Bestandes
     *
     * @param menge  muss > 0 sein
     */
    public void bucheAbgang(int menge){
        pruefen( bestand >= menge && menge > 0, "Die Menge ist größer als den Bestand");
        bestand = bestand - menge;
    }
    
    /**
     * Darstellung eines Artikel-Objekts als Zeichenketten.
     *
     * @return  gibt ein Artikel Objekt aus
     */
    public String toString(){
        return "Artikelnummer:"   + artikelNr     + " " +
        "Bezeichnung:"            + art           + " " +
        "Bestand:"                + bestand       + " " + 
        "Preis:"                  + preis;
    }
    
    /**
     * Ausgabe des Artikelsartes
     *
     * @return gibt den Art des Artikels
     */
    public String getArt(){
        return art;
       
    }
    
    /**
     * Ausgabe des Bestandes des Artikels
     *
     * @return gibt den Bestand des Artikels
     */
    public int getBestand(){
       return bestand;
    }
    
    /**
     *Ausgabe der Artikelnummer
     *
     * @return gibt den Artikelnummer aus
     */
    public int getArtikelNr(){
        return artikelNr;
       
    }
    
    /**
     * Veranderung des Artikelsartes
     *
     * @param art muss ein String sein
     */
    public void setArt(String art){
        pruefen( art != null && !art.isEmpty() && !art.isBlank(), "Die Bezeichnung darf nicht null oder leer sein");
        this.art = art;
       
    }
    
    /**
     * Den Preis des artikels anlegen.
     *
     * @param preis > 0.0
     */
    public void setPreis(double preis){
        pruefen( preis > 0.0, "Der Preis muss groesser als 0 sein!");
        this.preis = preis;
       
    }
    
    /**
     * Den Preis eines artikels ausgeben.
     *
     * @param preis > 0.0
     */
    public double getPreis(){
        return preis;
       
    }
    
    /**
     * Veränderung des artikelsbestandes
     *
     * @param bestand muss >= 0 sein
     */
    public void setBestand(int bestand){
        pruefen(bestand >= 0, "Der Bestand muss >= 0 sein");
        this.bestand = bestand;
    }
    
}
