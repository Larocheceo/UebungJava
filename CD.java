
/**
 * Klasse zur Erzeugung und zur Verwaltung eines CD Objektes.
 * 
 * @author Rochella Djouakeu Vofo && Joel Boergers
 * @version 0.1
 * 
 * 
 */
public class CD extends Artikel
{
    private String interpret;
    private int anzahlTitel;
    private final static String ART = "Medien";
    
    /**
     * Konstruktor der Klasse CD.
     *
     * @param artikelNr Nummer des CDs
     * @param bestand Bestand des CDs
     * @param preis Preis des CDs
     * @param interpret Interpret des CDs
     * @param titel Titel des CDs
     * @param anzahlTitel Anzahl an Titeln im CD.
     */
    public CD(int artikelNr, int bestand, double preis, String interpret, String titel, int anzahlTitel){
        super(artikelNr, ART, bestand, preis, titel);
        setInterpret(interpret);
        setAnzahlTitel(anzahlTitel);
    }
    
   /**
    * Beschreibung eines CDs ausgeben.
    *
    * @return Die Beschreibung als Zeichenkette.
    */
   public String getBeschreibung(){
       return interpret + ": " + getTitel();
    }
    
   /**
    * Darstellung eines CDs als zeichenkette.
    *
    * @return Der dargestellte CD.
    */
   public String toString(){
       return "Artikelnummer:"   + super.getArtikelNr()     + " " +
        "Bezeichnung:"           + super.getArtikelArt()    + " " +
        "Type:"                  + "CD"                     + " " +
        "Bestand:"               + super.getBestand()       + " " + 
        "Preis:"                 + super.getPreis()         + " " +
        "interpret:"             + interpret                + " " +
        "Titel:"                 + getTitel()               + " " +
        "anzahlTitel:"           + anzahlTitel;
        
    
    }
    
   /**
    * Interpret eines CDs ausgeben.
    *
    * @return Der Interpret eines CDs.
    */
   public String getInterpret(){
       return this.interpret;
    }
    
   /**
    * Anzahl an Titel in einem CD ausgeben. 
    *
    * @return Die Anzahl an Titel in einem CD.
    */
   public int getAnzahlTitel(){
       return this.anzahlTitel;
    }
    
   /**
    * MAnzahl an Titel in einem CD ändern.
    *
    * @param anzahlTitel Die neue Anzahl an Titeln.
    */
   public void setAnzahlTitel(int anzahlTitel){
       pruefen( anzahlTitel > 0, "Dies Anzahl an titel muss groesser als 0 sein!");
       this.anzahlTitel = anzahlTitel;
    }
    
   /**
    * Interpret eines CDs ändern.
    *
    * @param interpret Der Interpret.
    */
   public void setInterpret(String interpret){
       pruefen( interpret != null && !interpret.isEmpty() && !interpret.isBlank(), "Der Interpret darf nicht null oder leer sein");
       this.interpret = interpret;
    }
}
