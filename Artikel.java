
/**
 * Einfache Artikel Klasse.
 *
 * @author  Rochella Vofo && Boergers Joel.
 * @version 0.1
 */
public abstract class  Artikel extends Lager{
    private int     artikelNr;
    private int     bestand;
    private double  preis;
    private String  art;
    private String titel;
    
    /**
     * Konstruktor der Klasse Artikel
     *
     * @param artikelNr muss 4-stellig & > 0
     * @param art darf nicht null sein
     * @param bestand >= 0
     * @param preis > 0.0
     */
    public Artikel(int artikelNr, String art, int bestand, double preis, String titel){
        pruefen(artikelNr >= 1000 && artikelNr < 10000, "Artikelnummer muss 4-stellig sein");
        this.artikelNr = artikelNr;
        setArt(art);
        setTitel(titel);
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
    public Artikel(int artikelNr, String art, double preis, String titel){
        this(artikelNr, art, 0, preis, titel);
    }
    
    /**
     * Eine Bedingung prüfen.
     *
     * @param bedingung die bedigung, die zu pruefen ist.
     * @param message die Fehlermeldung.
    
    public static void pruefen(boolean bedingung, String message){
        if (!bedingung){
            throw new IllegalArgumentException(message);
        }
        
    }
     */
    
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
     * Darstellung eines Artikels als zeichenkette.
     *
     * @return Der Rückgabewert
     */
    public abstract String toString();
    
    /**
     * Ausgabe der Beschreibung des Artikels.
     *
     * @return Gibt den Art des Artikels
     */
    public abstract String getBeschreibung();
    
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
     * Der Titel eines Artikels ändern.
     *
     * @param titel Der Titel des Artikels.
     */
    public void setTitel(String titel){
        pruefen( art != null && !art.isEmpty() && !art.isBlank(), "Der Titel darf nicht null oder leer sein");
        this.titel = titel;
       
    }
    
    /**
     * Titel eines Artikels ausgeben.
     *
     * @return Der Rückgabewert
     */
    public String getTitel(){
        return this.titel;
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
    
    /**
     * Art eines Artikels ausgeben.
     *
     * @return Die Art des Artikels.
     */
    public String getArtikelArt(){
         return art;
     }
    
    
    
    
}
