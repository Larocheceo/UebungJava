
/**
 * Testklasse fuer die Klasse Artikel
 *
 * @author Rochella Vofo
 * @version 0.1
 */
public class ArtikelTest{

    public static void main(String[] args){

        //Artikel artikel1 = new Artikel(Integer.parseInt(args[0]), args[1],Integer.parseInt(args[2])); // String in Integer Konvertieren
        Artikel artikel1 = new Artikel(1243, "Kaffemaschine", 10);
        Artikel artikel2 = new Artikel(1245, "Computer");
        artikel1.bucheZugang(10);
        artikel1.bucheAbgang(5);

        System.out.println(artikel1.getArt());
        System.out.println(artikel1.getBestand());
        System.out.println(artikel1.getArtikelNr());  
        artikel1.setArt(""); //Setmethode testen
        System.out.println(artikel1.getArt());
        System.out.println(artikel1.toString());

    }

}
