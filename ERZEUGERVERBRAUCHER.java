
/**
 * Rahmenklasse f&uuml;r das Erzeuger-Verbraucher-Problem.
 * 
 * @author Albert Wiedemann
 * @version 1.0
 */
class ERZEUGERVERBRAUCHER
{
    private VERBRAUCHER verbraucher;
    private ERZEUGER erzeuger;
    private SPEICHER speicher;
    
    /**
     * Constructor for objects of class ERZEUGERVERBRAUCHER
     */
    ERZEUGERVERBRAUCHER()
    {
        speicher = new SPEICHER ();
        erzeuger = new ERZEUGER (1000, speicher);
        verbraucher = new VERBRAUCHER (1000, speicher);
        erzeuger. start ();
        verbraucher. start ();
    }
    
    public static void main (String [] args)
    {
        new ERZEUGERVERBRAUCHER ();
    }
}
