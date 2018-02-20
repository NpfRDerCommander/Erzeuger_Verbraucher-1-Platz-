
/**
 * Verwaltet den Zwischenspeicher.
 * In deiser Version mit 10 Plätzen
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class SPEICHER
{
    /** Gibt an, wie viele Pl&auml;tze belegt sind */
    private int anzahlbelegt;
    /** Die eventuell vorhandene Kiste */
    private KISTE [] plaetze;
    
    /**
     * Besetzt die Attribute vor
     */
    SPEICHER()
    {
        anzahlbelegt = 0;
        plaetze = new KISTE [10];
        for (int i = 0; i < plaetze. length; i++)
        {
            plaetze [i] = null;
        }
    }
    
    /**
     * Versucht, eine Kiste abzulegen und wartet gegebenenfalls.
     * @param kiste die abzulegende Kiste
     */
    synchronized void Ablegen (KISTE kiste)
    {
        while (anzahlbelegt >= plaetze. length)
        {
            try
            {
                wait ();
            }
            catch (Exception e)
            {
            }
        }
        plaetze [anzahlbelegt] = kiste;
        anzahlbelegt += 1;
        notify ();
    }
    
    /**
     * Versucht, eine Kiste zu holen und wartet gegebenenfalls.
     * @return die geholte Kiste
     */
    synchronized KISTE Holen ()
    {
        KISTE k;
        while (anzahlbelegt == 0)
        {
            try
            {
                wait ();
            }
            catch (Exception e)
            {
            }
        }
        anzahlbelegt -= 1;
        k = plaetze [0];
        for (int i = 0; i < anzahlbelegt; i++)
        {
            plaetze [i] = plaetze [i + 1];
        }
        plaetze [anzahlbelegt] = null;
        notify ();
        return k;
    }
}
