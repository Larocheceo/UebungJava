import java.lang.*;
/**
 * Beschreiben Sie hier die Klasse Buch.
 * 
 * @author Rochella Vofo && Joel Boergers
 * @version 0.1
 */
public class Buch extends Artikel{
    private String autor, verlag;
    private static final String ART = "Medien";
    
   
   public Buch(int artikelNr, int bestand, double preis, String autor, String titel, String verlag){
       super(artikelNr, ART, bestand, preis, titel);
       setAutor(autor);
       setVerlag(verlag);
       
    }
    
   
   /**
    * Die Beschreibung eines Buchs ausgeben.
    *
    * @return Die Beschreibung eines Buchs.
    */
   public String getBeschreibung(){
       return autor + ": " + getTitel();
    }
   
   /**
    * Dasstellung eines Buch als Zeichenkette.
    *
    * @return Das Buch als Zeichenkette.
    */
   public String toString(){
       return "Artikelnummer:"   + super.getArtikelNr()     + " " +
        "Bezeichnung:"           + super.getArtikelArt()    + " " +
        "Type:"                  + "Buch"                   + " " +
        "Bestand:"               + super.getBestand()       + " " + 
        "Preis:"                 + super.getPreis()         + " " +
        "Autor:"                 + autor                    + " " +
        "Titel:"                 + getTitel()               + " " +
        "Verlag:"                + verlag;
        
    
    }
   
   /**
    * Der Autor eines Buchs ausgeben.
    *
    * @return Der Autor des Buchs.
    */
   public String getAutor(){
       return this.autor;
   }
   
   /**
    * Der Verlag eines Buch ausgeben.
    *
    * @return Der Verlag des Buches.
    */
   public String getVerlag(){
    return this.verlag;
    }
   
   /**
    * Der Verlag eines Buches ändern.
    *
    * @param verlag Der Verlag des Buches.
    */
   public void setVerlag(String verlag){
    super.pruefen( verlag != null && !verlag.isEmpty() && !verlag.isBlank(), "Der Verlag darf nicht null oder leer sein");
    this.verlag = verlag;
    }
    
   /**
    * Der Autor des Buchs darstellen.
    *
    * @param autor Der Autor des Buches.
    */
   public void setAutor(String autor){
       super.pruefen( autor!= null && !autor.isEmpty() && !autor.isBlank(), "Der Autor darf nicht null oder leer sein");
       this.autor = autor;
   }
    
}
