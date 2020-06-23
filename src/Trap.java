/**
 * Csapda objektum, ha a Trap-hez linkelt Switch kapcsolon Box talalhato, akkor
 * a csapda nyitva all, Hole-kent viselkedik, ellenkezo esetben NormalField-kent.
 * @author Peter
 *
 */
public class Trap extends Field {
	
	/** Nyitott vagy csukott allapotban van-e a csapda */
    private boolean opened;

    /**A Trap letrehozasakor kikapcsolt allapotban van, mivel alapbol nem teszunk Box-ot Switch-re
     */
    public Trap() {
        opened = false;
    }

    /**Ha az adott Trap-hez linkelt Switch-re Box-ot tolunk, akkor az invertalja a linkelt Trap
     * nyitottsagi allapotat. Ha nyitva volt, akkor bezarodik; ha csukva volt, akkor kinyilik.
     */
    public void switchTrapState() {
        opened = !opened;
    }

    /**Ha Box kerul a Trap-re, es a Trap nyitott allapotban van (opened), akkor a ra 
     * kerulo Box megsemmisul, nullozva annak referenciajat, leszedve azt a palyarol.
     * @param	b	A Trap-re kerulo Box referenciaja.
     */
    public void action( Box b ) {
        if ( opened ) {
            removeThing(b);
        }
    }

    /**Ha Character kerul a Trap-re, es a Trap nyitott allapotban van (opened), akkor a ra 
     * kerulo Character megsemmisul, meghivva a TurnManager killPlayer metodusat,
     * nullazva annak idejet, leszedve azt a palyarol.
     * @param	c	A Trap-re kerulo Character referenciaja.
     */
    public void action( Character c ) {
        if ( opened ) {
            removeThing(c);
            TurnManager.killPlayer(c);
        }
    }

    /** Feluldefinialt java.Object toString metodus, a teszteles parancssoros kiiratasahoz kell.
     * @return	"T" karakterrel ter vissza, mint [T]rap.
     */
	public String toString(){
		return "T";				
	}
	
	/** Meghivja a GraphicsMain megfelelo (egyezo parameteru) Init fuggvenyet
     *  amely ezutan kirajzolja.
     *  @param	gm	GraphicsMain parameterkent atadva, meglegyen hivva annak az Init fuggvenye.
     */
	@Override
	public void callInit(Graphics gm) {
		gm.Init(this);
	}
	
	/** Visszaadja a csapda allapotat nyitva van-e.
     *  @return	Ha a csapda nyitott allapotban van, igazzal ter vissza.
     */
	public boolean isOpen() {
		return opened;
	}
}
