
/**
 * Klasse zur Verwaltung von Artikeln in einem Lager. Erweiterung der Klasse Artikel
 * 
 * @author Rochella Djouakeu Vofo &  Joel Boergers
 * @version 0.1
 */
public class Lager
{
    private static final int     MAX_ANZ_ARTIKEL = 10;
    private              int     lagerGroesse;
    private          Artikel[]   artikelTab;
    
     /**
     * Konstruktor der Klasse Lager.
     *
     * @param lagerGroesse Die Anzahl an Artikeln, die man im Lager(Artikel-Array) einlagen kann.
     */
     public Lager(int lagerGroesse){
       this.lagerGroesse = lagerGroesse;
       this.artikelTab = new Artikel[lagerGroesse];
     }
    
     /**
     * Konstruktor der Klasse Lager ohne parameter. Die Anzahl an anzulegenen Artikeln beträgt 10.
     *
     */
     public Lager(){
       this(MAX_ANZ_ARTIKEL);
     }
   
     
    /**
    * Methode zur Einfuegung eines vorher angelegten Artikel-Objektes in das Artikel-Array im Lager.
    *
    * @param artikel Das einzulegene Artikel.
    */
    public void legeAnArtikel(Artikel artikel){
       pruefen(getArtikelAnzahl() < lagerGroesse, "Der Lager ist voll, kein Artikel kann im Lager angelegt werden!");
       pruefen (!findeArtikel(artikel.getArtikelNr()), "Ein Artikel mit gleicher Nummer ist schon im Lager vorhanden");
       for(int i = 0; i < artikelTab.length; i++){
           if(artikelTab[i] == null){
              artikelTab[i] = artikel; //Keine Pruefung, da Artikel ist beim Anlegen geprueft.
              break;
            }
        }
    
    }
   
    /**
    * Methode zum Entfernen eines Artikels.
    * 
    * @param artikelNr Die ArtikelNummer des zu entfernenden Artikels.
    */
    public void entferneArtikel(int artikelNr){
       pruefen(artikelNr >= 1000 && artikelNr < 10000, "Artikelnummer muss 4-stellig sein"); //Stop falls AtikelNr nicht gueltig ist.
       pruefen(findeArtikel(artikelNr), "Der zu loeschenden Artikel existiert im Lager nicht!");
       int anzahlArtikel = getArtikelAnzahl(), j = 0;
       
       for(int i = 0; i < artikelTab.length; i++){
           if(artikelTab[i].getArtikelNr() == artikelNr){
               for( j = i; j < anzahlArtikel-1; j++){
                    artikelTab[j] = artikelTab[j + 1 ];     
               }
               artikelTab[j] = null;
               break;
            }
        }
       
    }
    
    /**
     * Methoden zum Finden eines Artikels im Lager.
     *
     * @param artikelNr Die ArtikelNummer des zu findenden Artikels.
     * @return true falls gefunden und false falls nicht gefunden. 
     */
    public boolean findeArtikel(int artikelNr){
        if (artikelTab[0] == null){                           // Es heißt denn, der Lager ist leer.
            return false; 
       }
        try {
            for (int i = 0; i < lagerGroesse; i++){
                if(artikelTab[i].getArtikelNr() == artikelNr){
                    return true;
                }
            }
        } catch (NullPointerException e){
            return false;
            
        }
        return false;
    }
    
    /**
     * Methode zur Buchung einer Zugang von Artikel.
     *
     * @param artikelNr Nummer des Artikels.
     * @param menge Muss > 0 sein.
     */
    public void bucheZugang(int artikelNr, int menge){
       pruefen(artikelNr >= 1000 && artikelNr < 10000, "Artikelnummer muss 4-stellig sein"); //Stop falls AtikelNr nicht gueltig ist.
       pruefen(menge > 0, "Die Menge muss größer als 0 sein");                             // Nicht unsonst in der Schleife gelangen.
       pruefen(findeArtikel(artikelNr), "Dieser Artikel existiert im Lager nicht!");
       for(int i = 0; i < artikelTab.length; i++){
            if(artikelTab[i].getArtikelNr() == artikelNr){
                  artikelTab[i].bucheZugang(menge);
                  break;
            }
       }
    }
    
    /**
     * Methode zur Buchung einer Abgang. 
     *
     * @param artikelNr Nummer des Artikels.
     * @param menge Muss > 0 sein
     */
    public void bucheAbgang(int artikelNr, int menge){
       pruefen(artikelNr >= 1000 && artikelNr < 10000, "Artikelnummer muss 4-stellig sein");
       pruefen(menge > 0, "Die Menge muss größer als 0 sein");
       pruefen(findeArtikel(artikelNr), "Dieser Artikel existiert im Lager nicht!");
       for(int i = 0; i < artikelTab.length; i++){
            if(artikelTab[i].getArtikelNr() == artikelNr){
              artikelTab[i].bucheAbgang(menge);
              break;
            }
       }
    }


    /**
     * Methode zur Aenderung der Preise aller Artikeln im Lager.
     *
     * @param prozent muss >= -100.0 
     */
    void aenderePreisAllerArtikel(double prozent){
        pruefen(prozent > - 100.0, "Sie können den Preis nicht um mehr als 100 Prozent vermindern, sonst wird der Preis 0.0 sein!");
        for(int i = 0; i < artikelTab.length; i++){
           if (artikelTab[i] == null){
               break;
            }
           double preis = artikelTab[i].getPreis();
           artikelTab[i].setPreis(preis + ((preis * prozent)/100));
        }
    }

    /**
    * Ausgabe eines Artikels.
    * 
    *
    * @param index Stelle des Artikels im Lager.
    * @return Artikel fall der Artikel gefunden war und null falls nicht gefunden.
    */
    public Artikel getArtikel(int index){
       pruefen( index >= 0, "Der index muss groesser oder gleich 0 sein");
       pruefen( index < artikelTab.length, "Der index soll kleiner als die Anzahl an Artikeln im Lager! sein");
       
       for(int i = 0; i < artikelTab.length; i++){
           if(i == index){
               return artikelTab[i];
            }
        }
       return null;
       
     }

    /**
     * Darstellung eines Lager-Objekts als Zeichenketten.
     *
     * @return die erzeugte Zeichenkette.
     */
    public String toString(){
        return "Lagergroesse: "     + lagerGroesse +"\r\n" +
                "Artikel im Lager: "  + getArtikelAnzahl();
                
        
     }

    /**
     * Ausgabe der Anzahl an Artikel im Lager. 
     *
     * @return die Anzahl an Artikel, die im Lager vorhanden sind.
     */
    public int getArtikelAnzahl(){
       int anzArtikel = 0;
       for(int i = 0; i < artikelTab.length; i++){
           if(artikelTab[i] != null){
               anzArtikel += 1;
            } else {
                break;
            }
        }
       return anzArtikel;
    }

    /**
     * Ausgabe Der Anzahl der Artikel, die ins Lager gelegt werden können.
     *
     * @return die Lagergroesse.
     */
    public int getLagerGroesse(){
       return lagerGroesse;
    }
    
    /**
     * Bestand eines Artikels aendern.
     *
     * @param artikel Das zu aendernde Artikel.
     * @param menge Der aktuelle Bestand des Artikels.
     */
    public void setArtikelBestand(int artikelNr, int menge){
        pruefen(findeArtikel(artikelNr), "Kein Artikel mit der gegebenen Nummer existiert im Lager!");
        gebeArtikel(artikelNr).setBestand(menge);
    }
    
    /**
     * Preis eines Artikels aendern.
     *
     * @param artikel Das zu aendernde Artikel.
     * @param preis Der aktuelle Preis des Artikels.
     */
    public void setArtikelPreis(int artikelNr, double preis){
        pruefen(findeArtikel(artikelNr), "Kein Artikel mit der gegebenen Nummer existiert im Lager!");
        gebeArtikel(artikelNr).setPreis(preis);
    }
    
    
    /**
     * Art eines Artikels aendern.
     *
     * @param artikel Das zu aendernde Artikel.
     * @param art Die aktuelle Art des Artikels.
     */
    public void setArtikelArt(int artikelNr, String art){
        pruefen(findeArtikel(artikelNr), "Kein Artikel mit der gegebenen Nummer existiert im Lager!");
        gebeArtikel(artikelNr).setArt(art);    
    }
    
    /**
     * Ausgabe eines Artikels mit artikelNr als input.
     *
     * @param artikelNr Die Nummer des artikels.
     * @return Der Artikel mit alle eigenschaften.
     */
    public Artikel gebeArtikel(int artikelNr){
        for(int i = 0; i< artikelTab.length; i++){
            if (artikelTab[i].getArtikelNr() == artikelNr){
                return artikelTab[i];
            }
        }
        return null;
    }
    
    
    /**
     * Methode zum Pruefen einer Bedingung.
     *
     * @param bedingung Die Bedingung, die zu pruefen ist.
     * @param message Die Fehlermeldung, die auszuwerfen ist, falls die Bedingung nicht stimmt.
     */
    public static void pruefen(boolean bedingung, String message){
        if (!bedingung){
            throw new IllegalArgumentException(message);
        }
        
    }
}
