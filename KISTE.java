
/**
 * Dummy-Klasse, stellt die gef&uuml;llte Kiste dar.
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class KISTE
{

    /** Laufende Nummer der Kiste */
    private int nummer;
    
    /**
     * Legt die Kistennummer fest
     */
    KISTE(int nummer)
    {
        this. nummer = nummer;
    }
    
    /**
     * Meldet die Nummer der Kiste
     */
    int KistennummerGeben ()
    {
        return nummer;
    }
}
