
/**
 * Klasse zur Verwaltung von Artikeln in einem Lager. Erweiterung der Klasse Artikel
 * 
 * @author Rochella Djouakeu Vofo & Boergers Joel 
 * @version 0.1
 */
public class Lager
{
    private static final int     MAX_ANZ_ARTIKEL = 10;
    private              int     lagerGroesse;
    private          Artikel[]   artikelTab;
    
    public Lager(int lagerGroesse){
       this.lagerGroesse = lagerGroesse;
       this.artikelTab = new Artikel[lagerGroesse];
     }
    
    public Lager(){
       this(MAX_ANZ_ARTIKEL);
     }
   
    public Artikel legeArtikel(int artikelNr, String art, int bestand, double preis){
       pruefen(!findeArtikel(artikelNr), "Ein Artikel mit selber ArtikelNr existiert bereit im Lager!");
       pruefen(getArtikelAnzahl() < lagerGroesse, "Der Lager ist voll, kein Artikel kann angelegt werden!");
       
       Artikel artikel =  new Artikel(artikelNr, art, bestand, preis);
       return artikel;
     }
    
    /**
    * Methode legeAnArtikel
    * Prüfen, ober Lager noch nicht voll ist
    * Prüfen, ob Artikel gültig
    * prüfen, ob artikelNr noch nicht vorhanden ist.
    * Fehlermeldung, fall Lager voll ist.
    *
    * @param artikel Ein Parameter
    */
    public void legeAnArtikel(Artikel artikel){
       pruefen(getArtikelAnzahl() < lagerGroesse, "Der Lager ist voll, kein Artikel kann im Lager angelegt werden!");
       for(int i = 0; i < artikelTab.length; i++){
           if(artikelTab[i] == null){
              artikelTab[i] = artikel; 
              break;
            }
        }
    
    }
   
    /**
    * Methode entferneArtikel
    * prüfen, ob artikel vorhanden ist.
    * check ob artikel nummer gültig ist;
    *
    * @param artikelNr Ein Parameter
    */
    public void entferneArtikel(int artikelNr){
       pruefen(artikelNr >= 1000 && artikelNr < 10000, "Artikelnummer muss 4-stellig sein"); //Stop falls AtikelNr nicht gueltig ist.
       pruefen(findeArtikel(artikelNr), "Der zu loeschenden Artikel existiert im Lager nicht!");
       for(int i = 0; i < artikelTab.length; i++){
           if(findeArtikel(artikelNr)){
              artikelTab[i] = artikelTab[lagerGroesse -1 ];
              artikelTab[lagerGroesse - 1] = null;
            }
        }
    }
    
    public boolean findeArtikel(int artikelNr){
        for (int i = 0; i < lagerGroesse; i++){
            if(artikelTab[i].getArtikelNr() == artikelNr){
            return true;
        }
        }
        return false;
    }
    
    /**
     * Methode zur Buchung einer Zugang von Artikel.
     *
     * @param artikelNr Ein Parameter
     * @param menge Ein Parameter
     */
    public void bucheZugang(int artikelNr, int menge){
       pruefen(artikelNr >= 1000 && artikelNr < 10000, "Artikelnummer muss 4-stellig sein"); //Stop falls AtikelNr nicht gueltig ist.
       pruefen(menge > 0, "Die Menge muss größer als 0 sein");                             // Nicht unsonst in der Schleife gelangen.
       for(int i = 0; i < artikelTab.length; i++){
            if(artikelTab[i].getArtikelNr() == artikelNr){
                  artikelTab[i].bucheZugang(menge);                                          
            }
       }
    }
    
    public void bucheAbgang(int artikelNr, int menge){
       pruefen(artikelNr >= 1000 && artikelNr < 10000, "Artikelnummer muss 4-stellig sein");
       pruefen(menge > 0, "Die Menge muss größer als 0 sein");
       for(int i = 0; i < artikelTab.length; i++){
            if(artikelTab[i].getArtikelNr() == artikelNr){
              artikelTab[i].bucheAbgang(menge);
            }
       }
    }


    void aenderePreisAllerArtikel(double prozent){
        pruefen(prozent > - 100.0, "Sie können den Preis um mehr bis 100Prozent nicht vermindern, sonst wird der Preis 0 sein!");
        for(int i = 0; i < artikelTab.length; i++){
           if (artikelTab[i] == null){
               break;
            }
           double preis = artikelTab[i].getPreis();
           artikelTab[i].setPreis(preis + ((preis * prozent)/100));
        }
    }

    /**
    * Methode getArtikel
    * index prüefen
    *
    * @param index Ein Parameter
    * @return Der Rückgabewert
    */
    public Artikel getArtikel(int index){
       pruefen( index >= 0, "Der index muss groesser oder gleich 0 sein");
       pruefen( index < artikelTab.length, "Der index soll kleiner als die Anzahl an Artikeln im Lager! sein");
       
       for(int i = 0; i < artikelTab.length; i++){
           if(i == index){
               return artikelTab[1];
            }
        }
       return null;
     }

    public String toString(){
        return "Lagergroesse: "     + lagerGroesse +"\r\n" +
                "Artikel im Lager"  + getArtikelAnzahl();
                
        
     }

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

    public int getLagerGroesse(){
       return lagerGroesse;
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
}
