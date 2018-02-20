
/**
 * Beschreibt den Verbraucher.
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */

import java. util. Random;

class VERBRAUCHER extends Thread
{
    /** Die mittlere Einlagerzeit pro Kiste */
    private int zeit;
    /** Der Zwischenspeicher */
    private SPEICHER speicher;
    /** Zufallsgenerator f&uuml;r die Einlagerzeit. */
    private Random ran;
    
    /**
     * Legt die mittlere Einlagerzeit fest
     * @param z die Einlagerzeit
     * @param s der Zwischenspeicher
     */
    VERBRAUCHER (int z, SPEICHER s)
    {
        zeit = z;
        speicher = s;
        ran = new Random ();
    }
    
    /**
     * Die Arbeitsmethode des Threads.
     */
    public void run ()
    {
        while (true)
        {
            Einlagern (speicher. Holen ());
        }
    }
    
    /**
     * Lagert Kisten in der gegebenen Zeit.
     */
    void Einlagern (KISTE kiste)
    {
        long akt, ende;
        akt = System. currentTimeMillis ();
        ende = akt + zeit / 2 + ran. nextInt (zeit);
        while (akt < ende)
        {
            try
            {
                wait (ende - akt);
            }
            catch (Exception e)
            {
            }
            akt = System. currentTimeMillis ();
        }
        System. out. println ("Kiste Nummer " + kiste. KistennummerGeben () + " eingelagert.");
    }
}
