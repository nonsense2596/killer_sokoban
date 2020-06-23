/**
 * A palyan talalhato Hole lyuk objektumok osztalya. Feladatuk, hogy amennyiben
 * valami rakerul, az megszunik, eltunik a lyukban.
 * @author Gergo
 */
public class Hole extends Field {

	 /**Character kerult a lyuk-ra, amire az meghal
     * @param	c	A Character ami a lyuk-ra kerult.
     */
    public void action( Character c ) {
        removeThing(c);
        TurnManager.killPlayer(c);
    }

    /**Box kerult a lyuk-ra, amire az megszunik
     * @param	b	A Box ami a lyuk-ra kerult.
     */
    public void action( Box b ) {
        removeThing(b);
    }

    /** Feluldefinialt java.Object toString metodus, a teszteles parancssoros kiiratasahoz kell.
     * @return	"H" karakterrel ter vissza, mint [H]ole.
     */
	@Override
	public String toString(){
		return "H";				
	}
	
	/** Meghivja a GraphicsMain megfelelo (egyezo parameteru) Init fuggvenyet
     *  amely ezutan kirajzolja.
     *  @param	gm	GraphicsMain parameterkent atadva, meglegyen hivva annak az Init fuggvenye.
     */
	@Override
	public void callInit(Graphics gm) {
		gm.Init(this);
	}
}
