import java.util.*;
/**
 * Dialog klasse fuer Klasse Artikel
 * 
 * @author Rochella Djouakeu Vofo / Joel Boergers
 * @version 0.1
 */
public class ArtikelDialog{
    private static final int ERSTE_KONSTRUKTOR              = 1;
    private static final int ZWEITE_KONSTRUKTOR             = 2;
    private static final int REGISTRIEREN                   = 1;
    private static final int BUCHE_ZUGANG                   = 2;
    private static final int BUCHE_ABGANG                   = 3;
    private static final int SET_ART                        = 4;
    private static final int SET_BESTAND                    = 5;
    private static final int ENDE                           = 6;
    private Artikel artikel1                                = null;
    Scanner input                                           = new Scanner(System.in);
    
    /**
     * Main Methode zur Durchfuehrung des Programms.
     *
     * @param args ist ein array mit strings.
     */
    public static void main(String[] args){
        new ArtikelDialog().start();
    }
    
    /**
     * Methode, die die Programmsschleife enthaehlt.
     *
     */
    public void start(){
        int funktion = -1;
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
    * @return Der Rückgabewert ist ein int, der zur entsprechenden Funktion in ausfuehrenFunktion fuehrt. 
    */
   private int einlesenFunktion(){
        System.out.println("Wählen Sie ein Ziffer, um die entsprechende Aktion durchzuführen!" + "\r\n"
                        + REGISTRIEREN +    ": Artikel registrieren"    + "\r\n"
                        + BUCHE_ZUGANG +    ": Zugang buchen"           + "\r\n" 
                        + BUCHE_ABGANG +    ": Abgang buchen"           + "\r\n"
                        + SET_ART      +    ": Bezeichnung ändern"      + "\r\n"
                        + SET_BESTAND  +    ": Bestand ändern"          + "\r\n"
                        + ENDE         +    ": Programm beenden");
                       
        return input.nextInt();                    
   }
    
    /**
     * Methode, die entspreschende Methoden im Program aufruft.
     *
     * @param funktion ist ein Integer, der die Durchführung der entspreschenden Methode versusacht.
     */
    private void ausfuehrenFunktion(int funktion){
        if (funktion == REGISTRIEREN){
           
           registrierenArtikel(waehlenKonstruktor());
           
            
        } else if (funktion == BUCHE_ZUGANG){
           pruefenArtikel();
           artikel1.bucheZugang(lesenBetrag());
            
        } else if (funktion == BUCHE_ABGANG){
            pruefenArtikel();
            artikel1.bucheAbgang(lesenBetrag());
            
        } else if (funktion == SET_ART){
            pruefenArtikel();
            artikel1.setArt(lesenArt());
            
        } else if (funktion == SET_BESTAND){
            pruefenArtikel();
            artikel1.setBestand(lesenBetrag());
  
        } else if (funktion == ENDE){
            System.out.println("Programmende");
            System.exit(0);
        } else {
            System.out.println("Falsche Funktion");
        }
        System.out.println(artikel1);
    }
    
    /**
     * Methode zum Registrieren eines Artikels.
     *
     * @param konstruktorNr ist 1 oder 2.
     *      Falls 1, wird der Konstruktor mit 3 Parametern benutzt, um den Artikel zu erzeugen.
     *      Falls 2, wird der Konstruktor mit 2 Parametern benutzt, um den Artikel zu erzeugen.
     * @return Gibt einen Artikel zurück.
     */
    public Artikel registrierenArtikel(int konstruktorNr){
        int artikelNr;
        int bestand;
        double preis;
        String art;
        
        System.out.println("Nummer des Artikels: ");
        artikelNr = input.nextInt();
        input.nextLine();
        
        System.out.println("Art des Artikels: ");
        art = input.nextLine().trim();
        

        System.out.println("Preis des Artikels: ");
        preis = input.nextDouble();
        input.nextLine();
        
        if (konstruktorNr == ERSTE_KONSTRUKTOR){
            System.out.println("Bestand des Artikels: ");
            bestand = input.nextInt();
            input.nextLine();
            artikel1 = new Artikel(artikelNr, art, bestand, preis);
        } else {
            artikel1 = new Artikel(artikelNr, art, preis);
        }
      
        return artikel1;
         
    }
    
    /**
     * Methode zum Lesen einen Betrags, falls man Artikel registrien will, einen Zugang oder abgang buchen will.
     *
     * @return betrag ist ein Integer.
     */
    public int lesenBetrag(){
        int betrag;
        System.out.println("Geben Sie den Betrag ein: ");
        betrag = input.nextInt();
        input.nextLine();
        return betrag;
    }
    
    /**
     *  Methode zum Lesen eine Art, falls man Artikel registrien will oder eine Bezeichnung ändern will.
     *
     * @return art: String
     */
    public String lesenArt(){
        String art;
        input.nextLine();
        System.out.println("Geben Sie eine Bezeichnung ein: ");
        art = input.nextLine();
        return art;
    }
    
    /**
     * Methode zum Pruefen eines Artikels. Hier wird zuerst geprüft, ob ein artikel vorliegt, wenn man eine Methode
     * auf einen Artikel anwenden will. Wenn kein Artikel vorliegt, muss eins erzeugt werden.
     *
     */
    public void pruefenArtikel(){
        if (artikel1 == null){
            System.out.println("Registriere zuerst einen Artikel, da kein Artikel vorliegt!");
            registrierenArtikel(waehlenKonstruktor());
        }
    }

    /**
     * Methode zur Bestimmung mit welchem Konstruktor man einen Artikel anlegen will.
     *
     * @return konstruktor ist ein Integer.
     *      Falls 1, wird der Konstruktor mit 3 Parametern benutzt, um den Artikel zu erzeugen.
     *      Falls 2, wird der Konstruktor mit 2 Parametern benutzt, um den Artikel zu erzeugen.
     */
    public int waehlenKonstruktor(){
       int konstruktor;
       System.out.println("Wählen Sie einen Konstruktor ein!"   +"\r\n"
                            + ERSTE_KONSTRUKTOR                 + ": Konstruktor mit vier Paramatern"   + "\r\n" 
                            + ZWEITE_KONSTRUKTOR                + ": Konstruktor mit drei Parametern");
       konstruktor = input.nextInt();
       Artikel.pruefen(konstruktor == ERSTE_KONSTRUKTOR || konstruktor == ZWEITE_KONSTRUKTOR,
                       "Die eingegebene Ziffer ist falsch!");
       
       return konstruktor;
    }
    
}
