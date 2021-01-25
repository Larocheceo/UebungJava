import java.util.*;
/**
 * Dialog-Klasse mit der Klasse Lager.
 * 
 * @author Rochella Djouakeu Vofo & Joel Boergers. 
 * @version 0.1
 */
public class LagerDialog
{
    
    private static final int LEGE_AN_ARTIKEL                    = 1;
    private static final int ENTFERNE_ARTIKEL                   = 2;
    private static final int BUCHE_ZUGANG                       = 3;
    private static final int BUCHE_ABGANG                       = 4;
    private static final int AENDERE_PREIS_ALLER_ARTIKEL        = 5;
    private static final int GET_ARTIKEL                        = 6;
    private static final int GET_ARTIKEL_ANZAHL                 = 7;
    private static final int GET_LAGER_GROESSE                  = 8;
    private static final int SET_ARTIKEL_PREIS                  = 9;
    private static final int SET_ARTIKEL_PREIS_PROZENT          = 10;
    private static final int SET_ARTIKEL_BESTAND                = 11;
    //private static final int SET_ARTIKEL_ART                    = 12;
    private static final int DARSTELLEN_ALLE_ARTIKEL            = 12;
    private static final int BESTAND_LISTE                      = 13;
    private static final int ENDE                               = 14;
    
    private static final int ERSTE_KONSTRUKTOR                  = 1;
    private static final int ZWEITE_KONSTRUKTOR                 = 2;
    private static final String ART                             = "Medien";
    
    private Artikel artikel1                                    = null;
    private Lager   lager;
    
    
    Scanner input                                               = new Scanner(System.in);
    
    
    
    /**
     * Main Methode zur Durchfuehrung des Programms.
     *
     * @param args Ist ein array mit strings.
     */
    public static void main(String[] args){
        new LagerDialog().start();
    }
    
    /**
     * Methode, die die Programmsschleife enthaehlt.
     *
     */
    public void start(){
        int funktion = -1;
        lagerHerstellen();
        while (funktion != ENDE){
            try{
                funktion = einlesenFunktion();
                ausfuehrenFunktion(funktion);
            } catch (IllegalArgumentException e){
                System.out.println(e);
            } catch (InputMismatchException e){
                System.out.println(e);
                input.nextLine();
            } catch (Exception e){
                System.out.println("Ausnahme gefangen: " + e);
                e.printStackTrace(System.out);   
            }
            
        }
    
    }
    
   /**
    * Methode zum Einlesen einer Funktion.
    *
    * @return einen int, der zur entsprechenden Funktion in ausfuehrenFunktion fuehrt. 
    */
   private int einlesenFunktion(){
        System.out.println("Wählen Sie ein Ziffer, um die entsprechende Aktion durchzuführen!"                          + "\r\n"
                        + LEGE_AN_ARTIKEL               +    ": Artikel im Lager anlegen."                              + "\r\n"
                        + ENTFERNE_ARTIKEL              +    ": Artikel vom Lager entfernen."                           + "\r\n" 
                        + BUCHE_ZUGANG                  +    ": Zugang buchen."                                         + "\r\n"
                        + BUCHE_ABGANG                  +    ": Abgang Buchen."                                         + "\r\n"
                        + AENDERE_PREIS_ALLER_ARTIKEL   + ": Preise aller Artikel im Lager aendern."                    + "\r\n"
                        + GET_ARTIKEL                   + ": Artikel im Lager Darstellen."                              + "\r\n"
                        + GET_ARTIKEL_ANZAHL            + ": Anzahl aller Artikel im Lager bestimmen."                  + "\r\n"
                        + GET_LAGER_GROESSE             + ": Die Groesse des Lagers bestimmen."                         + "\r\n"
                        + SET_ARTIKEL_PREIS             + ": Der Preis eines Artikels aendern."                         + "\r\n"
                        + SET_ARTIKEL_PREIS_PROZENT     + ": Der Preis eines Artikels um einen Prozent aendern."        + "\r\n"
                        + SET_ARTIKEL_BESTAND           + ": Der Bestand eines Artikels aendern."
                        + DARSTELLEN_ALLE_ARTIKEL       + ": Lager und deren Artikel darstellen."                       +"\r\n"
                        + BESTAND_LISTE                 + ": Bestandsliste ausgeben"                                    +"\r\n"
                        
                        + ENDE                          +    ": Programm beenden."                                      + "\r\n"
                        + "-----------------------------------------------------");
                       
        return input.nextInt();
   }
   
   
    
    /**
     * Methode, die die entspreschende Methoden im Program aufruft.
     *
     * @param  einen Integer, der die Durchführung der entspreschenden Methode versusacht.
     */
    private void ausfuehrenFunktion(int funktion){
        switch (funktion){
            case LEGE_AN_ARTIKEL:
                System.out.println("Sie sollen zuerst einen Artikel registrieren!");
                input.nextLine();
                Artikel artikel = registrierenArtikel();
                lager.legeAnArtikel(artikel);
                System.out.println("Der Artikel <" + artikel + "> wurde erfolgreich im Lager angelegt.");
                System.out.println();
                break;
            case ENTFERNE_ARTIKEL:
                 lager.entferneArtikel(lesenArtikelNr());
                 System.out.println("Der Artikel wurde erfolgreich vom Lager entfernt!");
                 System.out.println();
                 break;
            case BUCHE_ZUGANG:
                 lager.bucheZugang(lesenArtikelNr(), lesenMenge());
                 System.out.println("Zugang erfolgreich gebucht.");
                 System.out.println();
                 break;
            case BUCHE_ABGANG:
                 lager.bucheAbgang(lesenArtikelNr(), lesenMenge());
                 System.out.println("Abgang erfolgreich gebucht.");
                 System.out.println();
                 break;
            case SET_ARTIKEL_BESTAND:
                 lager.setArtikelBestand(lesenArtikelNr(), lesenMenge());
                 System.out.println("Der Bestand des Artikels wurde erfolgreich geaendert.");
                 System.out.println();
                 break;     
            case AENDERE_PREIS_ALLER_ARTIKEL:
                 lager.aenderePreisAllerArtikel(lesenProzent());
                 System.out.println("Die Preise aller Artikel wurden erfolgreich geaendert!");
                 System.out.println();
                 break;
            case GET_ARTIKEL_ANZAHL:
                 System.out.println("Anzahl Artikel im Lager: " + lager.getArtikelAnzahl());
                 System.out.println();
                 break;
            case GET_LAGER_GROESSE:
                 System.out.println("Die Lagergroesse ist: " + lager.getLagerGroesse());
                 System.out.println();
                 break;
            case SET_ARTIKEL_PREIS:
                 lager.setArtikelPreis(lesenArtikelNr(), lesenPreis());
                 System.out.println("Der Preis des Artikels wurde erfolgreich geaendert.");
                 System.out.println();
                 break;
            case SET_ARTIKEL_PREIS_PROZENT:
                 lager.aendereArtikelPreis(lesenArtikelNr(), lesenProzent());
                 System.out.println("Der Preis des Artikels wurde erfolgreich geaendert.");
                 System.out.println();
                 break;
            //case SET_ARTIKEL_ART:
                 //lager.setArtikelArt(lesenArtikelNr(), lesenArt());
                 //System.out.println("Die Bezeichnung des Artikels wurde erfolgreich geaendert");
                 //System.out.println();
                 //break;
            case GET_ARTIKEL:
                 System.out.println("Geben Sie die Stelle des Artikels im Lager:");
                 int stelle = input.nextInt();
                 input.nextLine();
                 Artikel artikel_ = lager.getArtikel(stelle);
                 if (artikel_ == null){
                    System.out.println("Es gibt keinen Artikel an dieser Stelle im Lager!");
                    System.out.println();
                  }else {
                    System.out.println(artikel_);
                    System.out.println();
                 }
                 break;
            case DARSTELLEN_ALLE_ARTIKEL:
                 System.out.println(lager);
                 break;
            case BESTAND_LISTE:
                  System.out.println(lager.ausgebenBestandsListe());
                  break;
            case ENDE:
                 System.out.println("Programmende");
                 System.exit(0);
                 break;
            default:
                 System.out.println("Falsche Funktion");
                 System.out.println();
        }
    }
    
    /**
     * Lager mit eine gegebene oder standard Größe herstellen.
     *
     */
    public void lagerHerstellen(){
        System.out.println("Die Standard Lagergroesse ist 10. Wollen sie ene andere Lagergroesse benutzen? (j/n):");
        char antwort = input.nextLine().charAt(0);
        if (antwort == 'j'){
            System.out.println("Geben Sie die gewuenschte Lagergroesse:");
            int groesse = input.nextInt();
            input.nextLine();
            lager = new Lager(groesse);
            System.out.println(lager);
            System.out.println();
        } else if (antwort == 'n'){
            lager = new Lager();
            System.out.println(lager);
            System.out.println();
        } else {
            System.out.println("Falsche Angabe! Bitte wiederholen.");
            lagerHerstellen();
        }
        
        
    }
    
    
    /**
     * Der Typ von einem Artikel lesen.
     *
     * @return artikelTypNummer Die Nummer, die den Typ von dem Artikel bestimmt.
     */
    public int artikelTyplesen(){
        int artikelTypNummer;
        System.out.println("Was füer Artikel wollen Sie anlegen? Geben die die Ziffer:" + "\n" + "1: CD\n2: Video\n3: Buch");
        artikelTypNummer = input.nextInt();
        input.nextLine();
        return artikelTypNummer;
    }
    
    
    /**
     * Methode zum Registrieren eines Artikels.
     * 
     * @return  artikel1  Der registrierte Artikel.
     */
    
    public Artikel registrierenArtikel(){
        int artikelTypNummer = artikelTyplesen();
        // Angabe prüefen
        int artikelNr, bestand, anzahlTitel, spieldauer, jahr;
        String interpret, titel, autor, verlag;
        double preis;
        
        System.out.println("Nummer des Artikels: ");
        artikelNr = input.nextInt();
        input.nextLine();
        
        System.out.println("Bestand des Artikels: ");
        bestand = input.nextInt();
        input.nextLine();
        
        System.out.println("Preis des Artikels: ");     
        preis = input.nextDouble();
        input.nextLine();
        
        System.out.println("Titel: ");     
        titel = input.nextLine().trim();
        
        switch (artikelTypNummer){
            case 1:
                System.out.println("Anzahl der Titel im CD: ");
                anzahlTitel = input.nextInt();
                input.nextLine();
                System.out.println("Interpret: ");     
                interpret = input.nextLine().trim();
                artikel1 = new CD(artikelNr, bestand, preis, interpret, titel, anzahlTitel);
                break;
            case 2:
                 System.out.println("Geben sie die Spieldauer in Minuten:");
                 spieldauer = input.nextInt();
                 input.nextLine();
                 System.out.println("Geben Sie das Jahr an dem das Medium veröffentlicht wurde:");
                 jahr = input.nextInt();
                 artikel1 = new Video(artikelNr, bestand, preis, titel, spieldauer, jahr);
                 break;
            case 3: 
                System.out.println("Autor: ");     
                autor = input.nextLine().trim();
                System.out.println("Verlag: ");     
                verlag = input.nextLine().trim();
                artikel1 = new Buch(artikelNr, bestand, preis, autor,titel, verlag);
                break;
            default:
                throw new IllegalArgumentException("Die Angabe ist falsch gegeben!");
                
        }
    
        return artikel1;
    }

    /**
     * Methode zum Lesen einer Artikelnummer.
     *
     * @return die Nummer des Artikels.
     */
    public int lesenArtikelNr(){
        int artikelNr;
        System.out.println("Geben Sie die Nummer des Artikels ein: ");
        artikelNr = input.nextInt();
        input.nextLine();
        return artikelNr;
    }
    
    /**
     * Methode zum Lesen eines Betrags.
     *
     * @return der gelesene Betrag.
     */
    public int lesenMenge(){
        int menge;
        System.out.println("Geben Sie die Menge ein: ");
        menge = input.nextInt();
        input.nextLine();
        return menge;
    }
    
    /**
     * Methode zum Lesen eines Prozentsatzes.
     *
     * @return der gelesene Prozentsatz.
     */
    public double lesenProzent(){
        double prozent;
        System.out.println("Geben Sie den Prozentsatz ein: ");
        prozent = input.nextDouble();
        input.nextLine();
        return prozent;
    }
    
    /**
     * Methode zum Lesen eines Preises.
     *
     * @return der gelesene Preis.
     */
    public double lesenPreis(){
        double preis;
        System.out.println("Geben Sie den Preis ein: ");
        preis = input.nextDouble();
        input.nextLine();
        return preis;
    }
    
    /**
     *  Methode zum Lesen eine Art eines Artikels.
     *
     * @return die gelesene Art.
     */
    public String lesenArt(){
        String art;
        System.out.println("Geben Sie eine Bezeichnung ein: ");
        art = input.nextLine();
        return art;
    }
    
    
    
    /**
     * Methode zum Pruefen eines Artikels. Hier wird zuerst geprüft, ob ein artikel vorliegt, wenn man eine Methode
     * auf einen Artikel anwenden will. Wenn kein Artikel vorliegt, muss eins erzeugt werden.
     *
     */
    private void pruefenArtikel(){
        if (artikel1 == null){
            System.out.println("Registriere zuerst einen Artikel, da kein Artikel vorliegt!");
            registrierenArtikel();
        }
    }
         
}
