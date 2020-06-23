/**A trap elemet kepviselo grafikus osztaly
 * @author Gergo
 */
import javax.swing.ImageIcon;

public class gTrap implements Drawable{
	
	/** A gTrap kiskepe ha inaktiv. */
	private ImageIcon nfield= new ImageIcon("NormalField1.png");
	
	/** A gTrap kiskepe ha aktiv. */
	private ImageIcon hole= new ImageIcon("Lyuk30.png");
	
	/** A gTrap altal megjelenitett Trap referenciaja */
	protected Trap trap;

	/** Parameteres konstruktor ami beallitja a tagvaltozot a parameterre.
     *  @param t 	A tagvaltozonak beallitando parameter
     */
	gTrap(Trap t){
		trap = t;
	}
	
	/** Visszaadja a trap-nek megfelelo ImageIcon-t.
     *  @return	Trap-nek megfelelo ImageIcon.
     */
	@Override
	public ImageIcon Draw() {
		if(trap.isOpen()) {
			return hole;
		}
		else return nfield;
	}
	
	/** Visszaadja megegyezik e a tagvaltozo a parameterben kapottal
     *  @return	mindenkepp false, rajzoljuk ki mindig, valtozhat az allapota
     */
	@Override
	public boolean Compare(Visitable v) {
		return false;
	}
	
	/** Visszaadja megegyezik e a tagvaltozo a parameterben kapottal
     *  @return	mindig false, sosem lehet collidable visitable
     */
	@Override
	public boolean Compare(Collidable c) {
		return false;
	}
	
}
